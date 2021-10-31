<%@page import="models.User"%>
<%@page import="models.Staff"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Administrator</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>
    <!-- Custom fonts for this template-->
    <link href="<%=request.getContextPath()%>/templates/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<%=request.getContextPath()%>/templates/admin/css/sb-admin-2.min.css" rel="stylesheet">
	<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/js/jquery.min.js"></script>
</head>
<div class="loadheader">
		<%
			Staff staff = null;
			if(session.getAttribute("staff") != null){
				staff = (Staff)session.getAttribute("staff");
			}
			%>
</div>
			<%
			User user = null;
			if(session.getAttribute("user") != null){
				user = (User)session.getAttribute("user");
			}
		%>
