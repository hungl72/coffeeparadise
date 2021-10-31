<%@page import="models.Message"%>
<%@page import="daos.StarDAO"%>
<%@page import="models.Star"%>
<%@page import="models.Comment"%>
<%@page import="models.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <style>
    @import url(//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css);
  /*reset css*/
  div,label{margin:0;padding:0;}
  h1{font-size:1.5em;margin:10px;}
  /****** Style Star Rating Widget *****/
  #rating{border:none;float:left;}
  #rating>input{display:none;}/*ẩn input radio - vì chúng ta đã có label là GUI*/
  #rating>label:before{margin:5px;font-size:1.25em;font-family:FontAwesome;display:inline-block;content:"\f005";}/*1 ngôi sao*/
  #rating>.half:before{content:"\f089";position:absolute;}/*0.5 ngôi sao*/
  #rating>label{color:#ddd;float:right;}/*float:right để lật ngược các ngôi sao lại đúng theo thứ tự trong thực tế*/
  /*thêm màu cho sao đã chọn và các ngôi sao phía trước*/
  #rating>input:checked~label,
  #rating:not(:checked)>label:hover, 
  #rating:not(:checked)>label:hover~label{color:#FFD700;}
  /* Hover vào các sao phía trước ngôi sao đã chọn*/
  #rating>input:checked+label:hover,
  #rating>input:checked~label:hover,
  #rating>label:hover~input:checked~label,
  #rating>input:checked~label:hover~label{color:#FFED85;}
  </style>
         <%
          	Product product = null;
      		if(request.getAttribute("productDetail") != null){
      			product = (Product)request.getAttribute("productDetail");
		%>
        <section class="tm-welcome-section" style="background-image: url('<%=request.getContextPath()%>/templates/public/images/<%=product.getProduct_image()%>');background-repeat: no-repeat;">
      <div class="container tm-position-relative">
        <div class="tm-lights-container"></div>        
        <div class="row tm-welcome-content">
          <h2 class="white-text tm-handwriting-font tm-welcome-header"><img src="<%=request.getContextPath()%>/templates/public/images/header-line.png" alt="Line" class="tm-header-line">&nbsp;<%=product.getProduct_name()%>&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/templates/public/images/header-line.png" alt="Line" class="tm-header-line"></h2>
          <h2 class="gold-text tm-welcome-header-2"></h2>
          <p class="gray-text tm-welcome-description"> <span class="gold-text"></p>
        </div>         
      </div>      
    </section>
    <div class="tm-main-section light-gray-bg" style="padding-top: 20px;">
      <div class="container" id="main">
        <section class="tm-section row">
          <p style="line-height: 25px;padding-bottom: 10px;"><%=product.getProduct_description_detail()%></p>
          <div class="col-xs-12 col-sm-12" style="padding-bottom: 20px;">
            <form action="<%=request.getContextPath()%>/cart" method="post">
              <table border="1px solid black" style="text-align: center;">
                <tr>
                  <th style="text-align: center;color: #CC0000;">Mã đồ uống</th>
                  <th class="col-xs-4 col-sm-2 col-md-3" style="text-align: center;color: #CC0000;">Tên đồ uống</th>
                  <th class="col-xs-4 col-sm-3 col-md-3" style="text-align: center;color: #CC0000;">Số lượng</th>
                  <th class="col-xs-4 col-sm-3 col-md-2" style="color: #CC0000;font-weight: bold;padding: 10px 20px;text-align: center;">Đơn giá ($)</th>
                  <th style="color: #CC0000;font-weight: bold;padding: 10px 20px;text-align: center;">Khuyến mãi (%)</th>
                  <th class="col-xs-3 col-sm-2 col-md-2" style="text-align: center;color: #CC0000;">Tổng giá ($)</th>
                  <%
                  	if(session.getAttribute("user") != null){
                  %>
                  <th class="col-xs-3 col-sm-2 col-md-2" style="text-align: center;color: #CC0000;"><a href="javascript:void(0)" onclick="myFunction(<%=product.getProduct_id()%>)" class="btn btn-default">Yêu thích</a></th>
                  <%}else{
                  %>
                  <th class="col-xs-3 col-sm-2 col-md-2" style="text-align: center;color: #CC0000;"><a href="javascript:void(0)" onclick="alert('Bạn cần đăng nhập để thực hiện chức năng này !')" class="btn btn-default">Yêu thích</a></th>
                  <%
                  } 
                  %>
                </tr>
                <tr>
                  <td class="col-xs-2" style="color: #0071BC;font-weight: bold;text-align: center;"><input name="productid" value="<%=product.getProduct_id()%>" style="width: 40px;height: auto;text-align: center;" readonly/></td>
                  <td class="col-xs-2" style="color: #0071BC;font-weight: bold;text-align: center;" id="name"><input value="<%=product.getProduct_name()%>" style="text-align: center;" readonly/></td>
                  <td style="padding: 5px;">
                    <div class="input-group col-xs-12 col-sm-12 col-md-11" style="margin: 0 auto">
                      <span class="input-group-btn ">
                        <button type="button" class="btn btn-default btn-number1" data-type="minus1" data-field1="quantity1">
                          <span class="glyphicon glyphicon-minus"></span>
                        </button>
                      </span>
                      <input type="text" name="quantity1" id="quantity" value="0" minAdults="0" maxAdults="10" class="form-control input-number-adults adultsValue" style="text-align: center;" readonly>
                      <span class="input-group-btn ">
                        <button type="button" class="btn btn-default btn-number1" data-type="plus1" data-field1="quantity1">
                          <span class="glyphicon glyphicon-plus"></span>
                        </button>
                      </span>
                    </div>
                  </td>
                  <td style="color: #0071BC;font-weight: bold;padding: 10px 20px;text-align: center;"><input name="price" id="price" value="<%=product.getProduct_price()%>" style="width: 40px;height: auto;text-align: center;" readonly/></td>
                  <td style="color: #0071BC;font-weight: bold;padding: 10px 20px;text-align: center;"><input name="promotion" id="promotion" value="<%=product.getPromotion()%>" style="width: 40px;height: auto;text-align: center;" readonly/></td>
                  <td class="col-xs-2" style="color: #0071BC;font-weight: bold;text-align: center;"><span><input name="total" id="total" value="0" style="width: 50px;height: auto;text-align: center;" readonly/></span></td>
                  <td><button type="submit" class="btn btn-default">Đặt mua</button></td>
                </tr>
              </table>
            </form>
          </div>
          <%	
				}
		  %>
          <div class="col-xs-12">
        <div class="container"> 
          <div class="comment-form-container" style="display: flex;justify-content: space-between;">
          <div style="width: 35%;">
            <h4>Bình luận của bạn :</h4>
            <form id="frm-comment">
                <div class="input-row">
                    <input type="hidden" name="comment_id" value="<%=product.getProduct_id()%>" id="commentId"placeholder="Name" /> 
                    <input class="input-field" type="text" name="name" id="name" placeholder="Name" />
                </div><br />
                <div class="input-row">
                    <textarea class="input-field" type="text" name="comment"
                        id="commentarea" placeholder="Add a Comment"></textarea>
                </div><br />
                <div>
                    <input type="button" class="btn-submit" id="submitButton"
                        value="Gửi bình luận" />
                </div>
            </form>
<div id="displaycomment">
	<%
		if(request.getAttribute("fullComment") != null){
			ArrayList<Comment> listComment = (ArrayList)request.getAttribute("fullComment");
			for(Comment c : listComment){
	%>
	<span><%=c.getDetail()%> - Bởi : <%=c.getUser()%> - Lúc <%=c.getTime()%></span><br />
	<%
			}
		}
	%>
</div>
          </div>
    <%
    	if(request.getAttribute("selectValueFinal") != null){
    		Star star = (Star)request.getAttribute("selectValueFinal");
    		if(star.getstar_average() >= 0 && star.getstar_average() <= 0.5){
    %>
     <div id="rating">
     	<h3>Mọi người đánh giá</h3>
        <input type="radio" value="5" disabled/>
        <label class = "full"  title="Awesome - 5 stars"></label>
        <input type="radio" value="4.5" disabled/>
        <label class="half" title="Pretty good - 4.5 stars"></label>
        <input type="radio" value="4" disabled/>
        <label class = "full"  title="Pretty good - 4 stars"></label>        
        <input type="radio" value="3.5" disabled/>
        <label class="half" title="Meh - 3.5 stars"></label>       
        <input type="radio" value="3" disabled/>
        <label class = "full"  title="Meh - 3 stars"></label>       
        <input type="radio" value="2.5" disabled/>
        <label class="half" title="Kinda bad - 2.5 stars"></label>     
        <input type="radio" value="2" disabled/>
        <label class = "full"  title="Kinda bad - 2 stars"></label>       
        <input type="radio" value="1.5" disabled/>
        <label class="half" title="Meh - 1.5 stars"></label>     
        <input type="radio" value="1" disabled/>
        <label class = "full"  title="Sucks big time - 1 star"></label>       
        <input type="radio" value="0.5" checked disabled/>
        <label class="half" title="Sucks big time - 0.5 stars"></label>
    </div><br />
    <%
    		}else if(star.getstar_average() > 0.5 && star.getstar_average() <= 1){
   	%>
   	<div id="rating">
   		<h3>Mọi người đánh giá</h3>
        <input type="radio" value="5" disabled/>
        <label class = "full"  title="Awesome - 5 stars"></label>
        <input type="radio" value="4.5" disabled/>
        <label class="half" title="Pretty good - 4.5 stars"></label>
        <input type="radio" value="4" disabled/>
        <label class = "full"  title="Pretty good - 4 stars"></label>        
        <input type="radio" value="3.5" disabled/>
        <label class="half" title="Meh - 3.5 stars"></label>       
        <input type="radio" value="3" disabled/>
        <label class = "full"  title="Meh - 3 stars"></label>       
        <input type="radio" value="2.5" disabled/>
        <label class="half" title="Kinda bad - 2.5 stars"></label>     
        <input type="radio" value="2" disabled/>
        <label class = "full"  title="Kinda bad - 2 stars"></label>       
        <input type="radio" value="1.5" disabled/>
        <label class="half" title="Meh - 1.5 stars"></label>     
        <input type="radio" value="1" checked disabled/>
        <label class = "full"  title="Sucks big time - 1 star"></label>       
        <input type="radio" value="0.5" disabled/>
        <label class="half" title="Sucks big time - 0.5 stars"></label>
    </div><br />
   	<%
    		}else if(star.getstar_average() > 1 && star.getstar_average() <= 1.5){
    %>
    <div id="rating">
    	<h3>Mọi người đánh giá</h3>
        <input type="radio" value="5" disabled/>
        <label class = "full"  title="Awesome - 5 stars"></label>
        <input type="radio" value="4.5" disabled/>
        <label class="half" title="Pretty good - 4.5 stars"></label>
        <input type="radio" value="4" disabled/>
        <label class = "full"  title="Pretty good - 4 stars"></label>        
        <input type="radio" value="3.5" disabled/>
        <label class="half" title="Meh - 3.5 stars"></label>       
        <input type="radio" value="3" disabled/>
        <label class = "full"  title="Meh - 3 stars"></label>       
        <input type="radio" value="2.5" disabled/>
        <label class="half" title="Kinda bad - 2.5 stars"></label>     
        <input type="radio" value="2" disabled/>
        <label class = "full"  title="Kinda bad - 2 stars"></label>       
        <input type="radio" value="1.5" checked disabled/>
        <label class="half" title="Meh - 1.5 stars"></label>     
        <input type="radio" value="1" disabled/>
        <label class = "full"  title="Sucks big time - 1 star"></label>       
        <input type="radio" value="0.5" disabled/>
        <label class="half" title="Sucks big time - 0.5 stars"></label>
    </div><br />
    <%
    	}else if(star.getstar_average() > 1.5 && star.getstar_average() <= 2){
    %>
    <div id="rating">
    	<h3>Mọi người đánh giá</h3>
        <input type="radio" value="5" disabled/>
        <label class = "full"  title="Awesome - 5 stars"></label>
        <input type="radio" value="4.5" disabled/>
        <label class="half" title="Pretty good - 4.5 stars"></label>
        <input type="radio" value="4" disabled/>
        <label class = "full"  title="Pretty good - 4 stars"></label>        
        <input type="radio" value="3.5" disabled/>
        <label class="half" title="Meh - 3.5 stars"></label>       
        <input type="radio" value="3" disabled/>
        <label class = "full"  title="Meh - 3 stars"></label>       
        <input type="radio" value="2.5" disabled/>
        <label class="half" title="Kinda bad - 2.5 stars"></label>     
        <input type="radio" value="2" checked disabled/>
        <label class = "full"  title="Kinda bad - 2 stars"></label>       
        <input type="radio" value="1.5" disabled/>
        <label class="half" title="Meh - 1.5 stars"></label>     
        <input type="radio" value="1" disabled/>
        <label class = "full"  title="Sucks big time - 1 star"></label>       
        <input type="radio" value="0.5" disabled/>
        <label class="half" title="Sucks big time - 0.5 stars"></label>
    </div><br />
    <%
    	}else if(star.getstar_average() > 2 && star.getstar_average() <= 2.5){
    %>
    <div id="rating">
    	<h3>Mọi người đánh giá</h3>
        <input type="radio" value="5" disabled/>
        <label class = "full"  title="Awesome - 5 stars"></label>
        <input type="radio" value="4.5" disabled/>
        <label class="half" title="Pretty good - 4.5 stars"></label>
        <input type="radio" value="4" disabled/>
        <label class = "full"  title="Pretty good - 4 stars"></label>        
        <input type="radio" value="3.5" disabled/>
        <label class="half" title="Meh - 3.5 stars"></label>       
        <input type="radio" value="3" disabled/>
        <label class = "full"  title="Meh - 3 stars"></label>       
        <input type="radio" value="2.5" checked disabled/>
        <label class="half" title="Kinda bad - 2.5 stars"></label>     
        <input type="radio" value="2" disabled/>
        <label class = "full"  title="Kinda bad - 2 stars"></label>       
        <input type="radio" value="1.5" disabled/>
        <label class="half" title="Meh - 1.5 stars"></label>     
        <input type="radio" value="1" disabled/>
        <label class = "full"  title="Sucks big time - 1 star"></label>       
        <input type="radio" value="0.5" disabled/>
        <label class="half" title="Sucks big time - 0.5 stars"></label>
    </div><br />
    <%
    	}else if(star.getstar_average() > 2.5 && star.getstar_average() <= 3){
    %>
    <div id="rating">
    	<h3>Mọi người đánh giá</h3>
        <input type="radio" value="5" disabled/>
        <label class = "full"  title="Awesome - 5 stars"></label>
        <input type="radio" value="4.5" disabled/>
        <label class="half" title="Pretty good - 4.5 stars"></label>
        <input type="radio" value="4" disabled/>
        <label class = "full"  title="Pretty good - 4 stars"></label>        
        <input type="radio" value="3.5" disabled/>
        <label class="half" title="Meh - 3.5 stars"></label>       
        <input type="radio" value="3" checked disabled/>
        <label class = "full"  title="Meh - 3 stars"></label>       
        <input type="radio" value="2.5" disabled/>
        <label class="half" title="Kinda bad - 2.5 stars"></label>     
        <input type="radio" value="2" disabled/>
        <label class = "full"  title="Kinda bad - 2 stars"></label>       
        <input type="radio" value="1.5" disabled/>
        <label class="half" title="Meh - 1.5 stars"></label>     
        <input type="radio" value="1" disabled/>
        <label class = "full"  title="Sucks big time - 1 star"></label>       
        <input type="radio" value="0.5" disabled/>
        <label class="half" title="Sucks big time - 0.5 stars"></label>
    </div><br />
    <%
    	}else if(star.getstar_average() > 3 && star.getstar_average() <= 3.5){
    %>
    <div id="rating">
    	<h3>Mọi người đánh giá</h3>
        <input type="radio" value="5" disabled/>
        <label class = "full"  title="Awesome - 5 stars"></label>
        <input type="radio" value="4.5" disabled/>
        <label class="half" title="Pretty good - 4.5 stars"></label>
        <input type="radio" value="4" disabled/>
        <label class = "full"  title="Pretty good - 4 stars"></label>        
        <input type="radio" value="3.5" checked disabled/>
        <label class="half" title="Meh - 3.5 stars"></label>       
        <input type="radio" value="3" disabled/>
        <label class = "full"  title="Meh - 3 stars"></label>       
        <input type="radio" value="2.5" disabled/>
        <label class="half" title="Kinda bad - 2.5 stars"></label>     
        <input type="radio"  value="2" disabled/>
        <label class = "full"  title="Kinda bad - 2 stars"></label>       
        <input type="radio" value="1.5" disabled/>
        <label class="half" title="Meh - 1.5 stars"></label>     
        <input type="radio" value="1" disabled/>
        <label class = "full"  title="Sucks big time - 1 star"></label>       
        <input type="radio" value="0.5" disabled/>
        <label class="half" title="Sucks big time - 0.5 stars"></label>
    </div><br />
    <%
    	}else if(star.getstar_average() > 3.5 && star.getstar_average() <= 4.0){
    %>
    <div id="rating">
    	<h3>Mọi người đánh giá</h3>
        <input type="radio" value="5" disabled/>
        <label class = "full"  title="Awesome - 5 stars"></label>
        <input type="radio" value="4.5" disabled/>
        <label class="half" title="Pretty good - 4.5 stars"></label>
        <input type="radio" value="4" checked disabled/>
        <label class = "full"  title="Pretty good - 4 stars"></label>        
        <input type="radio" value="3.5" disabled/>
        <label class="half" title="Meh - 3.5 stars"></label>       
        <input type="radio" value="3" disabled/>
        <label class = "full"  title="Meh - 3 stars"></label>       
        <input type="radio" value="2.5" disabled/>
        <label class="half" title="Kinda bad - 2.5 stars"></label>     
        <input type="radio" value="2" disabled/>
        <label class = "full"  title="Kinda bad - 2 stars"></label>       
        <input type="radio" value="1.5" disabled/>
        <label class="half" title="Meh - 1.5 stars"></label>     
        <input type="radio" value="1" disabled/>
        <label class = "full"  title="Sucks big time - 1 star"></label>       
        <input type="radio" value="0.5" disabled/>
        <label class="half" title="Sucks big time - 0.5 stars"></label>
    </div><br />
    <%
    	}else if(star.getstar_average() > 4.0 && star.getstar_average() <= 4.5){
	%>
    <div id="rating">
    	<h3>Mọi người đánh giá</h3>
        <input type="radio" value="5" disabled/>
        <label class = "full"  title="Awesome - 5 stars"></label>
        <input type="radio" value="4.5" checked disabled/>
        <label class="half" title="Pretty good - 4.5 stars"></label>
        <input type="radio" value="4" disabled/>
        <label class = "full"  title="Pretty good - 4 stars"></label>        
        <input type="radio" value="3.5" disabled/>
        <label class="half" title="Meh - 3.5 stars"></label>       
        <input type="radio" value="3" disabled/>
        <label class = "full"  title="Meh - 3 stars"></label>       
        <input type="radio" value="2.5" disabled/>
        <label class="half" title="Kinda bad - 2.5 stars"></label>     
        <input type="radio" value="2" disabled/>
        <label class = "full"  title="Kinda bad - 2 stars"></label>       
        <input type="radio" value="1.5" disabled/>
        <label class="half" title="Meh - 1.5 stars"></label>     
        <input type="radio" value="1" disabled/>
        <label class = "full"  title="Sucks big time - 1 star"></label>       
        <input type="radio" value="0.5" disabled/>
        <label class="half" title="Sucks big time - 0.5 stars"></label>
    </div><br />
	<%
    	}else{
    %>
    <div id="rating">
    	<h3>Mọi người đánh giá</h3>
        <input type="radio" value="5" checked disabled/>
        <label class = "full"  title="Awesome - 5 stars"></label>
        <input type="radio" value="4.5" disabled/>
        <label class="half" title="Pretty good - 4.5 stars"></label>
        <input type="radio" value="4" disabled/>
        <label class = "full"  title="Pretty good - 4 stars"></label>        
        <input type="radio" value="3.5" disabled/>
        <label class="half" title="Meh - 3.5 stars"></label>       
        <input type="radio" value="3" disabled/>
        <label class = "full"  title="Meh - 3 stars"></label>       
        <input type="radio" value="2.5" disabled/>
        <label class="half" title="Kinda bad - 2.5 stars"></label>     
        <input type="radio" value="2" disabled/>
        <label class = "full"  title="Kinda bad - 2 stars"></label>       
        <input type="radio" value="1.5" disabled/>
        <label class="half" title="Meh - 1.5 stars"></label>     
        <input type="radio" value="1" disabled/>
        <label class = "full"  title="Sucks big time - 1 star"></label>       
        <input type="radio" value="0.5" disabled/>
        <label class="half" title="Sucks big time - 0.5 stars"></label>
    </div><br />
    <%
    	}}
    %>
     <div id="rating">
         <h3>Đánh giá của bạn ?</h3>
        <input type="radio" id="star5" name="rating" value="5,<%=product.getProduct_id()%>" onclick="star('5,<%=product.getProduct_id()%>')"/>
        <label class = "full" for="star5" title="Awesome - 5 stars"></label>
        
        <input type="radio" id="star4half" name="rating" value="4.5,<%=product.getProduct_id()%>" onclick="star('4.5,<%=product.getProduct_id()%>')"/>
        <label class="half" for="star4half" title="Pretty good - 4.5 stars"></label>
        
        <input type="radio" id="star4" name="rating" value="4,<%=product.getProduct_id()%>" onclick="star('4,<%=product.getProduct_id()%>')"/>
        <label class = "full" for="star4" title="Pretty good - 4 stars"></label>
        
        <input type="radio" id="star3half" name="rating" value="3.5,<%=product.getProduct_id()%>" onclick="star('3.5,<%=product.getProduct_id()%>')"/>
        <label class="half" for="star3half" title="Meh - 3.5 stars"></label>
        
        <input type="radio" id="star3" name="rating" value="3,<%=product.getProduct_id()%>" onclick="star('3,<%=product.getProduct_id()%>')"/>
        <label class = "full" for="star3" title="Meh - 3 stars"></label>
        
        <input type="radio" id="star2half" name="rating" value="2.5,<%=product.getProduct_id()%>" onclick="star('2.5,<%=product.getProduct_id()%>')"/>
        <label class="half" for="star2half" title="Kinda bad - 2.5 stars"></label>
        
        <input type="radio" id="star2" name="rating" value="2,<%=product.getProduct_id()%>" onclick="star('2,<%=product.getProduct_id()%>')"/>
        <label class = "full" for="star2" title="Kinda bad - 2 stars"></label>
        
        <input type="radio" id="star1half" name="rating" value="1.5,<%=product.getProduct_id()%>" onclick="star('1.5,<%=product.getProduct_id()%>')"/>
        <label class="half" for="star1half" title="Meh - 1.5 stars"></label>
        
        <input type="radio" id="star1" name="rating" value="1,<%=product.getProduct_id()%>" onclick="star('1,<%=product.getProduct_id()%>')"/>
        <label class = "full" for="star1" title="Sucks big time - 1 star"></label>
        
        <input type="radio" id="starhalf" name="rating" value="0.5,<%=product.getProduct_id()%>" onclick="star('0.5,<%=product.getProduct_id()%>')"/>
        <label class="half" for="starhalf" title="Sucks big time - 0.5 stars"></label>
    </div><br />
      </div>
      </div>
        </section>
<!------ Include the above in your HEAD tag ---------->

<div class="container">
    <div class="row chat-window col-xs-5 col-md-3" id="chat_window_1" style="margin-left:10px;">
        <div class="col-xs-12 col-md-10" style="position: relative;left: 255%;">
        	<div class="panel panel-default">
                <div class="panel-heading top-bar">
                    <div class="col-md-8 col-xs-8">
                        <h3 class="panel-title"><span class="glyphicon glyphicon-comment"></span>&nbsp;<%=user.getUser_fullname()%></h3>
                    </div>
                    <div class="col-md-4 col-xs-4" style="text-align: right;">
                        <a href="javascript:void(0)"><span id="minim_chat_window" class="glyphicon glyphicon-minus icon_minim"></span></a>
                        <a href="#"><span class="glyphicon glyphicon-remove icon_close" data-id="chat_window_1"></span></a>
                    </div>
                </div>
                	<div class="panel-body msg_container_base" style="display: flex;flex-direction: column-reverse;">
                	<div class="mess">
                	<% 
                		if(request.getAttribute("findAll") != null){
                			ArrayList<Message> findAll = (ArrayList<Message>)request.getAttribute("findAll");
                			for(Message m : findAll){
                				if(m.getName().equals("Administrator") || m.getName().equals("Admin") || m.getName().equals("Moderator") || m.getName().equals("Staff")){
					%>
                    <div class="row msg_container base_sent">
                        <div class="col-md-10 col-xs-10">
                            <div class="messages msg_sent">
                                <p><%=m.getMessage_sent()%></p>
                                <time datetime="2009-11-13T20:00"><%=m.getMessage_time_sent()%></time>
                            </div>
                        </div>
                        <div class="col-md-2 col-xs-2 avatar">
                            <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">
                        </div>
                    </div>
                    <%
                    			}else{
                    %>				
                      <div class="row msg_container base_receive">
                        <div class="col-md-2 col-xs-2 avatar">
                            <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">
                        </div>
                        <div class="col-md-10 col-xs-10">
                            <div class="messages msg_receive">
                                <p><%=m.getMessage_sent()%></p>
                                <time datetime="2009-11-13T20:00"><%=m.getMessage_time_sent()%></time>
                            </div>
                        </div>
                    </div>
                    <%
                    			}
                    		}
                    	}
                    %>
                </div>
                </div>
               <form id="chat">
                 <div class="panel-footer">
                    <div class="input-group">
                        <input id="message" name="message" type="text" class="form-control input-sm chat_input" placeholder="Bạn có điều gì thắc mắc ?" />
                        <input id="id" type="hidden" name="id" value=""/>
                        <input id="username" type="hidden" name="name" value="<%=user.getUser_fullname()%>"/>
                        <span class="input-group-btn">
                        <button class="btn btn-primary btn-sm" id="submitMessage">Gửi</button>
                        </span>
                    </div>
                </div>
            </form>
    		</div>
        </div>
    </div>
    
    <div class="btn-group dropup">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
            <span class="glyphicon glyphicon-cog"></span>
            <span class="sr-only">Toggle Dropdown</span>
        </button>
        <ul class="dropdown-menu" role="menu">
            <li><a href="#" id="new_chat"><span class="glyphicon glyphicon-plus"></span> Novo</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-list"></span> Ver outras</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-remove"></span> Fechar Tudo</a></li>
            <li class="divider"></li>
            <li><a href="#"><span class="glyphicon glyphicon-eye-close"></span> Invisivel</a></li>
        </ul>
    </div>
</div>
    </div>
    </div>
<style>
body{
    height:400px;
    bottom: 0;
}
.col-md-2, .col-md-10{
    padding:0;
}
.panel{
    margin-bottom: 0px;
}
.chat-window{
    bottom:0;
    position:fixed;
    float:right;
    margin-left:10px;
}
.chat-window > div > .panel{
    border-radius: 5px 5px 0 0;
}
.icon_minim{
    padding:2px 10px;
}
.msg_container_base{
  background: #e5e5e5;
  margin: 0;
  padding: 0 10px 10px;
  max-height:300px;
  overflow-x:hidden;
}
.top-bar {
  background: #666;
  color: white;
  padding: 10px;
  position: relative;
  overflow: hidden;
}
.msg_receive{
    padding-left:0;
    margin-left:0;
}
.msg_sent{
    padding-bottom:20px !important;
    margin-right:0;
}
.messages {
  background: white;
  padding: 10px;
  border-radius: 2px;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
  max-width:80%;
}
.messages > p {
    font-size: 13px;
    margin: 0 0 0.2rem 0;
  }
.messages > time {
    font-size: 11px;
    color: #ccc;
}
.msg_container {
    padding: 10px;
    overflow: hidden;
    display: flex;
}
.avatar {
    position: relative;
}
.base_receive > .avatar:after {
    content: "";
    position: absolute;
    top: 0;
    right: 0;
    width: 0;
    height: 0;
    border: 5px solid #FFF;
    border-left-color: rgba(0, 0, 0, 0);
    border-bottom-color: rgba(0, 0, 0, 0);
}

.base_sent {
  justify-content: flex-end;
  align-items: flex-end;
}
.base_sent > .avatar:after {
    content: "";
    position: absolute;
    bottom: 0;
    left: 0;
    width: 0;
    height: 0;
    border: 5px solid white;
    border-right-color: transparent;
    border-top-color: transparent;
    box-shadow: 1px 1px 2px rgba(black, 0.2); // not quite perfect but close
}

.msg_sent > time{
    float: right;
}

.msg_container_base::-webkit-scrollbar-track
{
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
    background-color: #F5F5F5;
}

.msg_container_base::-webkit-scrollbar
{
    width: 12px;
    background-color: #F5F5F5;
}

.msg_container_base::-webkit-scrollbar-thumb
{
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
    background-color: #555;
}

.btn-group.dropup{
    position:fixed;
    left:0px;
    bottom:0;
}
div.stars {
  width: 270px;
  display: inline-block;
}
 
input.star { display: none; }
 
label.star {
  float: right;
  padding: 10px;
  font-size: 36px;
  color: #444;
  transition: all .2s;
}
 
input.star:checked ~ label.star:before {
  content: '\f005';
  color: #FD4;
  transition: all .25s;
}
 
input.star-5:checked ~ label.star:before {
  color: #FE7;
  text-shadow: 0 0 20px #952;
}
 
input.star-1:checked ~ label.star:before { color: #F62; }
 
label.star:hover { transform: rotate(-15deg) scale(1.3); }
 
label.star:before {
  content: '\f006';
  font-family: FontAwesome;
}
</style>
<script type="text/javascript">

    $(document).ready(function (){
    $('.btn-number1').click(function(event){
      event.preventDefault();
      var fieldName = $(this).attr('data-field1');
      var adults = $('#price').val();
      var promotion = $('#promotion').val();
      var type = $(this).attr('data-type');
      var input = $("input[name='"+fieldName+"']");
      var currentInput = parseInt(input.val());
      if(!isNaN(currentInput)){
        if(type == 'minus1'){
          var minVal = parseInt(input.attr('min1'));
          if(!minVal) minVal = 0;
          if(currentInput>minVal){input.val(currentInput-1).change();
            subAdults = ((currentInput-1)*parseFloat(adults)*(100-parseFloat(promotion))/100).toFixed(3);
            $('#total').val(subAdults);
            totalMonney = parseFloat($('.totalMonney').text(subAdults));}
          if(parseInt(input.val()) == minVal){$(this).attr('disabled',true);}
        }else if(type == 'plus1'){
          var maxVal = parseInt(input.attr('max1'));
          if(!maxVal) maxVal = 10;
          if(currentInput<maxVal){input.val(currentInput+1).change();
            sumAdults = ((currentInput+1)*parseFloat(adults)*(100-parseFloat(promotion))/100).toFixed(3);
            $('#total').val(sumAdults);
            totalMonney = parseFloat($('.totalMonney').text(sumAdults)).toFixed(3);}
          if(parseInt(input.val()) == maxVal){$(this).attr('disabled',true);}
        }	
      }else{input.val(0);}
    });
    $('.input-number-adults').focusin(function(){$(this).data('rootVal', $(this).val());});
    $('.input-number-adults').change(function(){
      var minValAdults = parseInt($(this).attr('minAdults'));
      var maxValAdults = parseInt($(this).attr('maxAdults'));
      if(!minValAdults){minValAdults==1}if(!maxValAdults){maxValAdults==1}
      var curVal = parseInt($(this).val());
      var nameVal = $(this).attr('name');
      if(curVal>=minValAdults){$(".btn-number1[data-type='minus1']").removeAttr('disabled');}
      else{alert('Không thể nhỏ hơn 0 !!!');$(this).val($(this).data('rootVal'));}
      if (curVal<=maxValAdults) {$(".btn-number1[data-type='plus1']").removeAttr('disabled');}
      else{alert('Tối đa chỉ được 10 !!!');$(this).val($(this).data('rootVal'));}
    });
  });
        var average = 0;var value = 0;
        $("#submitButton").click(function() {
        	$("#comment-message").css('display', 'none');
        	var product_id = $("input[id='commentId']").val();
        	var name = $("input[id='name']").val();;
        	var comment = $("textarea[id='commentarea']").val();
        	$.ajax({
        		url : '<%=request.getContextPath()%>/ajaxcomment',
        		type : 'post',
        		data :{product_id : product_id, name : name, comment : comment},
        		success : function(data) {
        			$("#displaycomment").html(data);
        			$("#name").val("");
        			$("#commentarea").val("");
        		}
        	});
        });var product_id;
        function myFunction(x) {
        	var product_id = x;
        	$.ajax({
        		url : '<%=request.getContextPath()%>/ajaxfavourite',
        		type : 'post',
        		data :{product_id : product_id},
        		success : function notify() {
        			$.notify("Đã thêm vào yêu thích thành công", "success");
        		}
        	});
        };
        
        <%
    	StarDAO starDAO = new StarDAO();
    	Star star = starDAO.selectTamCountFinal(1);
    %>
    var count = <%=star.getCount()%>;var average = 0;var value;var star_temporary = <%=star.getstar_temporary()%>
        function star(x){
        	value = $("input[value='"+x+"']").val();alert('Cảm ơn bạn đã đánh giá !');
        	count++;
        	$.ajax({
        		url : '<%=request.getContextPath()%>/ajaxstar',
        		type : 'post',
        		data :{count : count,value : value},
        		success : function(data) {
        			$('#review').html(data);
        		}
        	});
        };
        $(document).on('click', '.panel-heading span.icon_minim', function (e) {
            var $this = $(this);
            if (!$this.hasClass('panel-collapsed')) {
                $this.parents('.panel').find('.panel-body').slideUp();
                $this.addClass('panel-collapsed');
                $this.removeClass('glyphicon-minus').addClass('glyphicon-plus');
            } else {
                $this.parents('.panel').find('.panel-body').slideDown();
                $this.removeClass('panel-collapsed');
                $this.removeClass('glyphicon-plus').addClass('glyphicon-minus');
            }
        });
        $(document).on('focus', '.panel-footer input.chat_input', function (e) {
            var $this = $(this);
            if ($('#minim_chat_window').hasClass('panel-collapsed')) {
                $this.parents('.panel').find('.panel-body').slideDown();
                $('#minim_chat_window').removeClass('panel-collapsed');
                $('#minim_chat_window').removeClass('glyphicon-plus').addClass('glyphicon-minus');
            }
        });
        $(document).on('click', '#new_chat', function (e) {
            var size = $( ".chat-window:last-child" ).css("margin-left");
             size_total = parseInt(size) + 400;
            alert(size_total);
            var clone = $( "#chat_window_1" ).clone().appendTo( ".container" );
            
        });
        $(document).on('click', '.icon_close', function (e) {
            //$(this).parent().parent().parent().parent().remove();
            $( "#chat_window_1" ).remove();
        });
        
        $("#submitMessage").click(function(e){
        	e.preventDefault();
            $.ajax({            
                url: '<%=request.getContextPath()%>/usermessage',
                method: 'post',
                data:{id : <%=user.getUser_id()%>,  username : $("#username").val(), message : $("#message").val()},
                success:function(data){
					$('.mess').html(data);
					$('#message').val('');
                }
            });
        });
        var auto = setInterval(automatic, 1000);
        function automatic(){
        	var mess = $('.message').val();
        	if(mess != null || mess != "" || mess != ''){
        	$.ajax({            
                url: '<%=request.getContextPath()%>/usermessage',
                method: 'post',
                data:{id : <%=user.getUser_id()%>, name : name, username : $('#username').val(), message : mess},
                success:function(data){
                	$('.mess').html(data);
                }
            });
        	}else{}
        }
</script>
<%@ include file="/templates/public/inc/footer.jsp" %>