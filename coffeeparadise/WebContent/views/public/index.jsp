<%@page import="models.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<section class="tm-welcome-section">
      <div class="container tm-position-relative">
        <div class="tm-lights-container">
          <img src="<%=request.getContextPath()%>/templates/public/images/light.png" alt="Light" class="light light-1">
          <img src="<%=request.getContextPath()%>/templates/public/images/light.png" alt="Light" class="light light-2">
          <img src="<%=request.getContextPath()%>/templates/public/images/light.png" alt="Light" class="light light-3">  
        </div>        
        <div class="row tm-welcome-content">
          <h2 class="white-text tm-handwriting-font tm-welcome-header"><img src="<%=request.getContextPath()%>/templates/public/images/header-line.png" alt="Line" class="tm-header-line">&nbsp;Welcome To&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/templates/public/images/header-line.png" alt="Line" class="tm-header-line"></h2>
          <h2 class="gold-text tm-welcome-header-2">Cafe House</h2>
          <p class="gray-text tm-welcome-description">Cà phê không chỉ là một loại đồ uống; nó là thứ gì đó đang xảy ra. Không phải mốt thời thượng, mà giống như một sự kiện, một nơi để đến, nhưng không giống như một địa điểm, mà giống như nơi nào đó bên trong bản thân. Nó cho bạn thời gian, nhưng không phải thực sự là giờ và phút, mà một cơ hội để làm chính mình, và uống cốc thứ hai.</p>
          <a href="#main" class="tm-more-button tm-more-button-welcome">Đi thôi nào !</a>      
        </div>
        <img src="<%=request.getContextPath()%>/templates/public/images/table-set.png" alt="Table Set" class="tm-table-set img-responsive">             
      </div>      
    </section>
    <div class="tm-main-section light-gray-bg">
      <div class="container" id="main">
        <section class="tm-section row">
          <div class="col-lg-9 col-md-9 col-sm-8">
            <h2 class="tm-section-header gold-text tm-handwriting-font">Thức uống tốt nhất dành cho bạn</h2>
            <h2>Cafe House</h2>
            <p class="tm-welcome-description">Trong màu đen của cà phê tinh ý sẽ thấy được nét sóng sánh của màu nâu đỏ, sau vị đắng ngắm lòng là dư vị ngòn ngọt lạ kì của vị hương. Nhìn đời qua lăng kính phân kì sẽ thấy ngỡ ngàng sự hòa quyện của một tập hợp bao nhiêu là màu sắc, thoang thoảng trong kí ức bao trùm cả không gian những mùi vị của yêu thương.</p>
            <a href="#" class="tm-more-button margin-top-30">Xem thêm</a> 
          </div>
          <div class="col-lg-3 col-md-3 col-sm-4 tm-welcome-img-container">
            <div class="inline-block shadow-img">
              <img src="<%=request.getContextPath()%>/templates/public/images/1.jpg" alt="Image" class="img-circle img-thumbnail">  
            </div>              
          </div>            
        </section>          
        <section class="tm-section tm-section-margin-bottom-0 row">
          <div class="col-lg-12 tm-section-header-container">
            <h2 class="tm-section-header gold-text tm-handwriting-font"><img src="<%=request.getContextPath()%>/templates/public/images/logo.png" alt="Logo" class="tm-site-logo"> Đồ uống mới nhất</h2>
            <div class="tm-hr-container"><hr class="tm-hr"></div>
          </div>
          <div class="col-lg-12 tm-popular-items-container">
          <%
          	if(request.getAttribute("listProductNew") != null){
          		ArrayList<Product> listProductNew = (ArrayList<Product>)request.getAttribute("listProductNew");
          		for(Product product : listProductNew){
          %>
             <div class="tm-popular-item">
              <img style="width:286px;height: 200px" src="<%=request.getContextPath()%>/templates/public/images/<%=product.getProduct_image()%>" alt="Popular" class="tm-popular-item-img">
              <div class="tm-popular-item-description">
                <a style="text-decoration: none;" href="<%=request.getContextPath()%>/detail?product_id=<%=product.getProduct_id()%>"><h3 class="tm-handwriting-font tm-popular-item-title"><%=product.getProduct_name()%></h3><hr class="tm-popular-item-hr"></a>
                <p><%=product.getProduct_description()%></p>
              </div>              
            </div>
          <%          		
          			}
          		}
          %>   
          </div>          
        </section>
        <section class="tm-section tm-section-margin-bottom-0 row">
          <div class="col-lg-12 tm-section-header-container">
            <h2 class="tm-section-header gold-text tm-handwriting-font"><img src="<%=request.getContextPath()%>/templates/public/images/logo.png" alt="Logo" class="tm-site-logo"> Xem nhiều nhất</h2>
            <div class="tm-hr-container"><hr class="tm-hr"></div>
          </div>
          <div class="col-lg-12 tm-popular-items-container">
            <%
          	if(request.getAttribute("listViews") != null){
          		ArrayList<Product> listViews = (ArrayList<Product>)request.getAttribute("listViews");
          		for(Product product : listViews){
          %>
             <div class="tm-popular-item">
              <img style="width:286px;height: 200px" src="<%=request.getContextPath()%>/templates/public/images/<%=product.getProduct_image()%>" alt="Popular" class="tm-popular-item-img">
              <div class="tm-popular-item-description">
                <a style="text-decoration: none;" href="<%=request.getContextPath()%>/detail?product_id=<%=product.getProduct_id()%>"><h3 class="tm-handwriting-font tm-popular-item-title"><%=product.getProduct_name()%></h3><hr class="tm-popular-item-hr"></a>
                <p><%=product.getProduct_description()%></p>
              </div>              
            </div>
          <%          		
          			}
          		}
          %>   
          </div>          
        </section>
        <section class="tm-section">
          <div class="row">
            <div class="col-lg-12 tm-section-header-container">
              <h2 class="tm-section-header gold-text tm-handwriting-font"><img src="<%=request.getContextPath()%>/templates/public/images/logo.png" alt="Logo" class="tm-site-logo"> Daily Menu</h2> 
              <div class="tm-hr-container"><hr class="tm-hr"></div> 
            </div>  
          </div>          
          <div class="row">
            <div class="tm-daily-menu-container margin-top-60">
              <div class="col-lg-4 col-md-4">
                <img src="<%=request.getContextPath()%>/templates/public/images/menu-board.png" alt="Menu board" class="tm-daily-menu-img">      
              </div>            
              <div class="col-lg-8 col-md-8">
                <p>Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus.</p>
                <ol class="margin-top-30">
                  <li>Tellus eget condimentum rhoncus.</li> 
                  <li>Sem quam semper libero.</li>
                  <li>Sit amet adipiscing sem neque sed ipsum.</li> 
                  <li>Nam quam nunc, blandit vel, luctus pulvinar.</li> 
                  <li>Maecenas nec odio et ante tincidunt tempus.</li> 
                  <li>Donec vitae sapien ut libero ventenatis faucibus.</li> 
                </ol>
                <a href="#" class="tm-more-button margin-top-30">Xem thêm</a>    
              </div>
            </div>
          </div>          
        </section>
      </div>
    </div> 
 <%@ include file="/templates/public/inc/footer.jsp" %>