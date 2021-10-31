<%@page import="models.Staff"%>
<%@page import="models.Cart"%>
<%@page import="models.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Cafe House Template</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/notify.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/styles/metro/notify-metro.css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/js/jquery.min.js"></script>
 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/notify.min.js"></script>
   <script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/js/templatemo-script.js"></script>
	<script src="<%=request.getContextPath()%>/templates/public/js/notify.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/templates/public/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/templates/public/css/bootstrap-theme.min.css">
  	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet' type='text/css'>
  	<link href='http://fonts.googleapis.com/css?family=Damion' rel='stylesheet' type='text/css'>
  	<link href="<%=request.getContextPath()%>/templates/public/css/bootstrap.min.css" type="text/css" rel="stylesheet">
  	<link href="<%=request.getContextPath()%>/templates/public/css/font-awesome.min.css" type="text/css" rel="stylesheet">
  	<link href="<%=request.getContextPath()%>/templates/public/css/templatemo-style.css" type="text/css" rel="stylesheet">
  	<link rel="shortcut icon" href="<%=request.getContextPath()%>/templates/public/images/favicon.ico" type="image/x-icon" />
  </head>
  <body>
    <!-- Preloader -->
    	<%
			double totalMoney = 0;int totalProduct = 0,totalProductFinal = 0;int idProduct = 0;
			Cart cart = (Cart)session.getAttribute("cartProduct");
				if(cart == null){
					cart = new Cart();
					session.setAttribute("cartProduct", cart);
				}
			Staff staff = (Staff)session.getAttribute("staff");
		%>
    <div id="loader-wrapper">
      <div id="loader"></div>
      <div class="loader-section section-left"></div>
      <div class="loader-section section-right"></div>
    </div>
    <!-- End Preloader -->
    <div class="tm-top-header">
      <div class="container">
        <div class="row">
          <div class="tm-top-header-inner">
            <div class="tm-logo-container">
              <img src="<%=request.getContextPath()%>/templates/public/images/logo.png" alt="Logo" class="tm-site-logo">
              <h1 class="tm-site-name tm-handwriting-font">Cafe House</h1>
            </div>
            <div class="mobile-menu-icon">
              <i class="fa fa-bars"></i>
            </div>
            <nav class="tm-nav">
              <ul>
                <li><a href="<%=request.getContextPath()%>/index" class="active">Trang chủ</a></li>
                <li><a href="<%=request.getContextPath()%>/menu">Menu</a></li>
                <%
                	if(session.getAttribute("user") != null){
                %>
                <li><a href="<%=request.getContextPath()%>/special">Yêu thích</a></li>
                <%
                      }else{
                %>
                <li><a href="javascript:void(0)" onclick="alert('Bạn cần đăng nhập để xem yêu thích của mình !')">Yêu thích</a></li>
                <%
                      }
                %>
                <li><a href="<%=request.getContextPath()%>/contact">Góp ý</a></li>
                <li><a href="<%=request.getContextPath()%>/cart">Giỏ</a></li>
                <%
                	User user = null;
                	if(session.getAttribute("user") != null){
                		user = (User)session.getAttribute("user");
                %>
                <li><a>Xin chào, <%=user.getUser_fullname()%></a></li>
                <li><a href="<%=request.getContextPath()%>/management">Quản lý đơn hàng</a></li>
                <li><a href="<%=request.getContextPath()%>/logout">Đăng xuất</a></li>
                <%}else{%>
                <li><a href="<%=request.getContextPath()%>/login">Đăng nhập</a></li>
                <li><a href="<%=request.getContextPath()%>/signup">Đăng ký</a></li>
                <%}%>
                <li>
	                <form action="<%=request.getContextPath()%>/search" method="get">
	            		<div style="display: flex;">
			            	<input style="border-radius: 5px;color: black;border: 2px solid black;" type="text" name="name" placeholder="Nhập tên đồ uống  ..." required pattern="[a-zA-Z]+"
    oninvalid="setCustomValidity('Vui lòng nhập từ khóa tìm kiếm !')"
    onchange="try{setCustomValidity('')}catch(e){}" />
							<button type="submit" class="btn btn-default">Tìm kiếm</button>
	            		</div>
		   		   </form>
	   		   </li>
              </ul>
            </nav>
          </div>     
        </div>    
      </div>
    </div>