<%@page import="models.Product"%>
<%@page import="daos.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
    <div class="tm-main-section light-gray-bg">
      <div class="container" id="main">
        <section class="tm-section tm-section-margin-bottom-0 row">
          <div class="col-lg-12 tm-section-header-container">
            <h2 class="tm-section-header gold-text tm-handwriting-font"><img src="<%=request.getContextPath()%>/templates/public/images/logo.png" alt="Logo" class="tm-site-logo"> Kêt quả tìm kiếm</h2>
            <div class="tm-hr-container"><hr class="tm-hr"></div>
          </div>
          <div class="col-lg-12 tm-popular-items-container">
          <%
          	if(request.getAttribute("listSearch") != null){
          		ArrayList<Product> listSearch = (ArrayList<Product>)request.getAttribute("listSearch");
          		for(Product p : listSearch){
          %>
            <div class="tm-popular-item">
              <img style="width:286px;height: 200px" src="<%=request.getContextPath()%>/templates/public/images/<%=p.getProduct_image()%>" alt="Popular" class="tm-popular-item-img">
              <div class="tm-popular-item-description">
                <a style="text-decoration: none;" href="<%=request.getContextPath()%>/detail?product_id=<%=p.getProduct_id()%>"><h3 class="tm-handwriting-font tm-popular-item-title"><%=p.getProduct_name()%></h3><hr class="tm-popular-item-hr"></a>
                <p><%=p.getProduct_description()%></p>
              </div>             
            </div>
            <%
                     }
          		}
          %>
          </div>       
        </section>
      </div>
    </div>
<%@ include file="/templates/public/inc/footer.jsp" %> 