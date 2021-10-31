<%@page import="models.Item"%>
<%@page import="java.util.Map"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
   	double money = 0;int id = 0;
    	try{
	    	if(session.getAttribute("cartProduct") != null){
	    		Cart cartProduct = (Cart)session.getAttribute("cartProduct");
	    			if(cartProduct.getCartItem().size() > 0){
    %>
<div class="container">
<h2 class="text-center">Đồ uống đã chọn</h2>
 <table class="table table-hover table-condensed" style="text-align: center;"> 
 
  <thead> 
   <tr>
   	<th style="width:15%">Ảnh đồ uống</th>
    <th style="width:15%">Tên đồ uống</th> 
    <th style="width:10%">Đơn giá ($)</th> 
    <th style="width:10%">Số lượng</th> 
    <th style="width:10%" class="text-center">Thành tiền</th>
    <th style="width:10%" class="text-center">Hủy đặt</th>
   </tr> 
  </thead>
  <tbody id="cart">
    <%
  	for(Map.Entry<Integer, Item> listItem : cartProduct.getCartItem().entrySet()){
  		money += Math.round((listItem.getValue().getAmount() * listItem.getValue().getMoney()*(100-listItem.getValue().getProduct().getPromotion())/100)*1000.0)/1000.0;
  		id = listItem.getValue().getProduct().getProduct_id();
  %>
  <tr>  
   <td><img src="<%=request.getContextPath()%>/templates/public/images/<%=listItem.getValue().getProduct().getProduct_image()%>" alt="<%=listItem.getValue().getProduct().getProduct_name()%>" class="img-responsive" style="width: 180px;height: auto;"></td>
   <td><p><%=listItem.getValue().getProduct().getProduct_name()%></p></td> 
   <td data-th="Price"><%=Math.round((listItem.getValue().getMoney()*(100-listItem.getValue().getProduct().getPromotion())/100)*1000.0)/1000.0%></td> 
   <td data-th="Quantity"><%=listItem.getValue().getAmount()%></td> 
   <td data-th="Subtotal" class="text-center"><%=Math.round((listItem.getValue().getAmount() * listItem.getValue().getMoney()*(100-listItem.getValue().getProduct().getPromotion())/100)*1000.0)/1000.0%></td>
   <td class="actions" data-th="">
    <button class="btn btn-danger" onclick="myFunction(<%=listItem.getKey()%>)"><i class="fa fa-trash-o"></i>
    </button>
   </td> 
  </tr>
     <%	
		}
	%>
    </tbody>
    <tr>
<td><a href="<%=request.getContextPath()%>/menu" class="tm-more-button margin-top-30">Tiếp tục mua</a></td>
<td></td>
<td><form method="post" action="https://sandbox.nganluong.vn:8088/nl35/checkout.api.nganluong.post.php">
<input type=hidden name=receiver value="hungpbc99@gmail.com" /><input type=hidden name=product value="<%=id%>" />
<input type=hidden name=price value="<?php echo $total; ?>" />
<input type=hidden name=return_url value="http://complete.com/thank.php" /><input type=hidden name=comments value="" />
<input type=image src="https://www.nganluong.vn/data/images/buttons/11.gif" />
</form></td>
<td><div id="paypal-button-container"></div></td>
<td></td>
<%
	if(session.getAttribute("user") != null){
%>
<td><a href="<%=request.getContextPath()%>/pay" class="tm-more-button margin-top-30">Thanh toán</a></td> 
<%		
	}else{
%>
<td><a href="javascript:void(0)" onclick="alert('Bạn cần đăng nhập trước khi thanh toán !')" class="tm-more-button margin-top-30">Thanh toán</a></td> 
</tr>
<%
    		}
	}else if(request.getParameter("nofication") == null){
%>
<div class="container">
  <div style="margin-bottom: 20px;" class="col-xs-12" align="center">
  <img src="/CoffeeParadise/templates/public/images/unnamed.png"/>
  </div>
  <h3 class="text-center">Không có sản phẩm nào trong giỏ hàng của bạn.</h3>
</div>	
<%
	}else{
%>
		<h2 class="text-center">Đặt hàng thành công</h2>
		<div class="container">
	      <div style="margin-bottom: 20px;" class="col-xs-12" align="center">
	      	<img style="width: 200px;height: auto;" src="<%=request.getContextPath()%>/templates/public/images/universal-set-1011-512.png"/>
	      </div>
	      <h3 class="text-center">Chúc bạn thưởng thức ngon miệng.</h3>
	</div>
<%	
	}
}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
%>
 </table>
</div>
<script src="https://www.paypalobjects.com/api/checkout.js"></script>
<script>
	function myFunction(x) {
	var product_id = x;
	$.ajax({
		url : '<%=request.getContextPath()%>/deleteajax',
		type : 'post',
		data :{product_id : product_id},
		success : function(data) {
			$("#cart").html(data);
		}
	});
};

paypal.Button.render({
    env: 'sandbox', // Or 'production'
    // Set up the payment:
    // 1. Add a payment callback
    client: {
        sandbox: 'AU0ThAZgF2LygxQc8eGp_MWdztLsoC_9spejzkt2C9EOrRvL-xCYFn_893bh9CjfbMelWYynt9zUm3XO',
        production: ''
    },
    commit: true,
    payment: function(data, actions) {
        return actions.payment.create({
            payment: {
                transactions: [{
                    amount: {
                        total: <%=money%>,
                        currency: 'USD'
                    }
                }]
            }
        });
    },
    onAuthorize: function(data, actions) {alert(data);
        return actions.payment.execute().then(function() {
        	
            window.location = "http://localhost:8080/CoffeeParadise/cart?nofication=true";
        })
    }
}, '#paypal-button-container');
</script> 
 <%@ include file="/templates/public/inc/footer.jsp" %>