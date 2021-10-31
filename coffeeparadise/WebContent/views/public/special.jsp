<%@page import="org.apache.catalina.filters.ExpiresFilter.XServletOutputStream"%>
<%@page import="models.Favourite"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
<h2 class="text-center">Danh sách yêu thích</h2>
 <table class="table table-hover table-condensed" style="text-align: center;"> 

  <thead>
   <tr>
   	<th style="width:10%">Mã đồ uống</th>
   	<th style="width:12%">Ảnh đồ uống</th>
    <th style="width:12%">Tên đồ uống</th> 
    <th style="width:10%">Đơn giá ($)</th> 
    <th style="width:10%">Khuyến mãi</th> 
    <th style="width:10%" class="text-center">Hủy thích</th>
   </tr> 
  </thead>
  <tbody id="display">
    <%
  	if(request.getAttribute("listFavourite") != null){
  		ArrayList<Favourite> listFavourite = (ArrayList<Favourite>)request.getAttribute("listFavourite");
  		for(Favourite f : listFavourite){
  			System.out.print("ten san pham"+f.getFavourite_name()+"ma user "+f.getUser_id());
  %>
  <tr>
   <td><%=f.getProduct_id()%></td>  
   <td><img src="<%=request.getContextPath()%>/templates/public/images/<%=f.getFavourite_image()%>" alt="<%=f.getFavourite_image()%>" class="img-responsive" style="width: 180px;height: auto;"></td>
   <td><p><%=f.getFavourite_name()%></p></td> 
   <td data-th="Price"><%=f.getFavourite_price()%></td> 
   <td data-th="Quantity"><%=f.getFavourite_promotion()%></td> 
   <td class="actions" data-th="">
    <button class="btn btn-danger" onclick="myFunction('<%=user.getUser_id()%>,<%=f.getFavourite_name()%>')"><i class="fa fa-trash-o"></i>
    </button>
   </td> 
  </tr>
  <%
    	}
  	}
  %>
    </tbody>
 </table>
</div>
<script>
function myFunction(x) {
	var idandname = x;
	$.ajax({
		url : '<%=request.getContextPath()%>/deleteajax',
		type : 'get',
		data :{idandname : idandname},
		success : function(data) {
			$("#display").html(data);
		}
	});
};
</script>
<%@ include file="/templates/public/inc/footer.jsp" %>