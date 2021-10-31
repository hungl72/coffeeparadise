<%@page import="models.Management"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Item"%>
<%@page import="java.util.Map"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <div class="container" id="main">
        <section class="tm-section tm-section-margin-bottom-0 row">
          <div class="container">
            <h2 class="text-center">Quản lý đơn hàng</h2>
          </div>
          <table class="table table-bordered">
	          <thead>
	              <tr>
	                <th>Mã hóa đơn</th>
	                <th>Danh sách đơn hàng</th>
	                <th>Số lượng</th>
	                <th>Tổng tiền ($)</th>
	                <th>Ngày mua</th>
	                <th>Thời gian</th>
	                <th>Trạng thái</th>
	                <th>Hủy đơn</th>
	              </tr>
	            </thead>
	            <tbody id="management">
	            	
	            </tbody>
          </table>
          <%--
          <table class="table table-bordered">
            <thead>
              <tr>
                <th>Mã hóa đơn</th>
                <th>Danh sách đơn hàng</th>
                <th>Số lượng</th>
                <th>Tổng tiền ($)</th>
                <th>Ngày mua</th>
                <th>Thời gian</th>
                <th>Trạng thái</th>
                <th>Hủy đơn</th>
              </tr>
            </thead>
            <tbody>
            <%
            	if(request.getAttribute("listOrder") != null){
            		ArrayList<Management> listOrder = (ArrayList<Management>)request.getAttribute("listOrder");
            		for(Management m : listOrder){
			%>
              <tr>
                <td><%=m.getBill_id()%></td>
                <td><%=m.getList_product()%></td>
                <td><%=m.getAmount()%></td>
                <td><%=m.getMoney()%></td>
                <td><%=m.getDate()%></td>
                <td><%=m.getDate()%></td>
                <%
                	if(m.getState() == 1 ){
                %>
                <td><a href="javascript:void(0)" style="pointer-events: none;cursor: default;"><button class="btn btn-success">Đã thanh toán</button></a></td>
                <td></td>
                <%}else if(m.getState() == -1){ %>
                <td><a href="#" style="pointer-events: none;cursor: default;"><button class="btn btn-basic">Đơn hàng bị hủy</button></a></td>
                <td><a href="#" style="pointer-events: none;cursor: default;"><button class="btn btn-danger">Hết hàng</button></a></td>
                <%}else if(m.getState() == 0){ %>
                <td><a href="#" style="pointer-events: none;cursor: default;"><button class="btn btn-warning">Đang chờ xử lý</button></a></td>
                <td><a href="javascript:void(0)" onclick="checkorder(<%=m.getBill_id()%>)"><button class="btn btn-danger">Hủy đơn hàng</button></a></td>
                <%}else if(m.getState() == 2){ %>
                <td><a href="#" style="pointer-events: none;cursor: default;"><button class="btn btn-primary">Đang vận chuyển</button></a></td>
                <td><a href="javascript:void(0)" onclick="checkorder(<%=m.getBill_id()%>)"><button class="btn btn-danger">Hủy đơn hàng</button></a></td>
                 <%}else if(m.getState() == 3){ %>
                <td><a href="#" style="pointer-events: none;cursor: default;"><button class="btn btn-basic">Đã yêu cầu hủy đơn</button></a></td>
                <td><a href="javascript:void(0)" onclick="checkundo(<%=m.getBill_id()%>)"><button class="btn btn-default">Hoàn tác yêu cầu</button></a></td>
                <%}else if(m.getState() == 4){ %>
                <td><a href="#" style="pointer-events: none;cursor: default;"><button class="btn btn-basic">Đơn hàng bị hủy</button></a></td>
                <td><a href="javascript:void(0)" onclick="checkundo(<%=m.getBill_id()%>)"><button class="btn btn-default">Hoàn tác yêu cầu</button></a></td>
                <%}else if(m.getState() == 6){ %>
                <td><a href="#" style="pointer-events: none;cursor: default;"><button class="btn btn-basic">Đơn hàng bị hủy</button></a></td>
				<td><a href="#" style="pointer-events: none;cursor: default;"><button class="btn btn-success">Chấp nhận hủy đơn</button></a></td>
                <%}else{%>
                <td><a href="#" style="pointer-events: none;cursor: default;"><button class="btn btn-primary">Đang vận chuyển</button></a></td>
                <td><a href="#" style="pointer-events: none;cursor: default;"><button class="btn btn-danger">Từ chối hủy đơn</button></a></td>
                <%} %>
                
              </tr>
              <%			}
            			}
            		%>
            </tbody>
          </table>
          --%>   
        </section>
      </div>
      <script>
      setInterval(automatic, 1000);
      function automatic(){
      	$.ajax({            
              url: '<%=request.getContextPath()%>/managementauto',
              method: 'post',
              data:{},
              success:function(data){
              	$('#management').html(data);
              }
          });
      }
	function checkorder(x){
		var bill_id = x;
		var check = confirm('Bạn chắc chắn chứ ?');
		if(check){
			//$("#check"+x+"").attr('disabled','disabled');
			$("#change").html('<h6 style="color: red;font-weight: bold;">Ship thành công</h6>');
			$.ajax({
				url : '<%=request.getContextPath()%>/checkorder',
				type : 'post',
				data :{bill_id : bill_id},
				success : function(data) {
				}
			});
		}else{
			$("#check"+x+"").prop('checked', false);
		}
	}
	function checkundo(x){
		var bill_id = x;
		var check = confirm('Bạn chắc chắn chứ ?');
		if(check){
			//$("#check"+x+"").attr('disabled','disabled');
			$("#change").html('<h6 style="color: red;font-weight: bold;">Ship thành công</h6>');
			$.ajax({
				url : '<%=request.getContextPath()%>/checkundo',
				type : 'post',
				data :{bill_id : bill_id},
				success : function(data) {
				}
			});
		}else{
			$("#check"+x+"").prop('checked', false);
		}
	}
</script>   
 <%@ include file="/templates/public/inc/footer.jsp" %>