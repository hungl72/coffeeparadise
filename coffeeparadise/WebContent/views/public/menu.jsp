<%@page import="models.Product"%>
<%@page import="models.Categories"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section class="tm-welcome-section">
      <div class="container tm-position-relative">
        <div class="tm-lights-container">
          <img src="<%=request.getContextPath()%>/templates/public/images/light.png" alt="Light" class="light light-1">
          <img src="<%=request.getContextPath()%>/templates/public/images/light.png" alt="Light" class="light light-2">
          <img src="<%=request.getContextPath()%>/templates/public/images/light.png" alt="Light" class="light light-3">  
        </div>        
        <div class="row tm-welcome-content">
          <h2 class="white-text tm-handwriting-font tm-welcome-header"><img src="<%=request.getContextPath()%>/templates/public/images/header-line.png" alt="Line" class="tm-header-line">&nbsp;Menu&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/templates/public/images/header-line.png" alt="Line" class="tm-header-line"></h2>
          <h2 class="gold-text tm-welcome-header-2">Cafe House</h2>
          <p class="gray-text tm-welcome-description">Nhiều người, không chịu được vị đắng của cà phê nên thường bỏ đường hoặc sữa cho bớt đắng. Tôi không cho đường hay sữa vào cà phê bởi tôi biết: phải nếm trải qua cay đắng mới cảm nhận được ngọt ngào đến lịm người. Cho dù vẫn tiếp tục phải uống cà phê đắng nhưng tôi vẫn không nản lòng vì dư vị ngọt ngào của nó.</p>
          <a href="#main" class="tm-more-button tm-more-button-welcome">Bạn uống gì ?</a>      
        </div>
        <img src="<%=request.getContextPath()%>/templates/public/images/table-set.png" alt="Table Set" class="tm-table-set img-responsive">  
      </div>      
    </section>
    <div class="tm-main-section light-gray-bg">
      <div class="container" id="main">
        <section class="tm-section row">
          <div class="col-lg-9 col-md-9 col-sm-8">
            <h2 class="tm-section-header gold-text tm-handwriting-font">Variety of Menus</h2>
            <h2>Cafe House</h2>
            <p class="tm-welcome-description">This is free HTML5 website template from <span class="blue-text">template</span><span class="green-text">mo</span>. Fndimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Ettiam sit amet orci eget eros faucibus tincidunt.</p>
            <a href="#" class="tm-more-button margin-top-30">Read More</a> 
          </div>
          <div class="col-lg-3 col-md-3 col-sm-4 tm-welcome-img-container">
            <div class="inline-block shadow-img">
              <img src="<%=request.getContextPath()%>/templates/public/images/1.jpg" alt="Image" class="img-circle img-thumbnail">  
            </div>              
          </div>            
        </section>          
        <section class="tm-section row">
          <div class="col-lg-12 tm-section-header-container margin-bottom-30">
            <h2 class="tm-section-header gold-text tm-handwriting-font"><img src="<%=request.getContextPath()%>/templates/public/images/logo.png" alt="Logo" class="tm-site-logo"> Menu có gì nào ?</h2>
            <div class="tm-hr-container"><hr class="tm-hr"></div>
          </div>
          <div>
            <div class="col-lg-3 col-md-3">
              <div class="tm-position-relative margin-bottom-30">              
                <nav class="tm-side-menu">
                  <%
                  	if(request.getAttribute("listCategories") != null){
                  		ArrayList<Categories> listCategories = (ArrayList<Categories>)request.getAttribute("listCategories");
                  		for(Categories categories : listCategories){
				  %>
                  <ul>
                    <li><a href="javascript:void(0)" onclick="myFunction(<%=categories.getCategories_id()%>)" class="active"><%=categories.getCategories_name()%></a></li>
                  </ul>    
                  <%                  			
                  		}
                  	}
                  %>          
                </nav>    
                <img src="<%=request.getContextPath()%>/templates/public/images/vertical-menu-bg.png" alt="Menu bg" class="tm-side-menu-bg">
              </div>  
            </div>          
            <div id="display" class="tm-menu-product-content col-lg-9 col-md-9"> <!-- menu content -->
              <%
              	if(request.getAttribute("listProduct") != null){
              		ArrayList<Product> listProduct = (ArrayList<Product>)request.getAttribute("listProduct");
              		for(Product product : listProduct){
			  %>
              <div class="tm-product">
                <img style="width: 190px;height: 170px;" src="<%=request.getContextPath()%>/templates/public/images/<%=product.getProduct_image()%>" alt="Product">
                <div class="tm-product-text" style="margin-left: 1.5%;">
                  <a href="<%=request.getContextPath()%>/detail?product_id=<%=product.getProduct_id()%>" style="text-decoration: none;"><h3 class="tm-product-title"><%=product.getProduct_name()%></h3></a>
                  <a href="<%=request.getContextPath()%>/detail?product_id=<%=product.getProduct_id()%>" style="text-decoration: none;"><p class="tm-product-description"><%=product.getProduct_description()%></p></a>
                </div>
                <div class="tm-product-price">
                  <a href="javascript:void(0)" class="tm-product-price-link tm-handwriting-font"><span class="tm-product-price-currency">$</span><%=product.getProduct_price()%></a>
                </div>
              </div>
              <%
              		}
              	}
              %>
            </div>
          </div>          
        </section>
      </div>
    </div>
<script>
	function myFunction(x) {
	var categories_id = x;
	$.ajax({
		url : '<%=request.getContextPath()%>/ajaxproduct',
		type : 'post',
		data :{categories_id : categories_id},
		success : function(data) {
			$("#display").html(data);
		}
	});
};
</script>  
<%@ include file="/templates/public/inc/footer.jsp" %>
