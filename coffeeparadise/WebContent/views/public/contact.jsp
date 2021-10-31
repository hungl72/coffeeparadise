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
          <h2 class="white-text tm-handwriting-font tm-welcome-header"><img src="<%=request.getContextPath()%>/templates/public/images/header-line.png" alt="Line" class="tm-header-line">&nbsp;Kết nối với chúng tôi&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/templates/public/images/header-line.png" alt="Line" class="tm-header-line"></h2>
          <h2 class="gold-text tm-welcome-header-2">Cafe House</h2>
          <p class="gray-text tm-welcome-description">Cafe House is free <span class="gold-text">responsive Bootstrap</span> v3.3.5 layout by <span class="gold-text">templatemo</span>. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculusnec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.</p>
          <a href="#main" class="tm-more-button tm-more-button-welcome">Đóng góp ý kiến</a>      
        </div>
        <img src="<%=request.getContextPath()%>/templates/public/images/table-set.png" alt="Table Set" class="tm-table-set img-responsive">            
      </div>      
    </section>
    <div class="tm-main-section light-gray-bg">
      <div class="container" id="main">
        <section class="tm-section row" style="padding-top: 40px;">
          <h2 class="col-lg-12 margin-bottom-30">Ý kiến của bạn</h2>    <%
    	if(request.getAttribute("result").equals("0")){
    		
    	}else{
    %>
    	<h3 style="color: red;">Có lỗi khi gửi góp ý, mời bạn thử lại !</h3>
    <%
    	}
    %>
          <form id="form" action="<%=request.getContextPath()%>/contact" method="post" class="tm-contact-form">
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <input type="text" id="contact_name" name="name" class="form-control" placeholder="Họ và tên"/>
              </div>
              <div class="form-group">
                <input type="text" id="contact_email" name="phone" class="form-control" placeholder="phone"/>
              </div>
              <div class="form-group">
                <input type="text" id="contact_subject" name="title" class="form-control" placeholder="Tiêu đề"/>
              </div>
              <div class="form-group">
                <textarea id="contact_message" name="content" class="form-control" rows="6" placeholder="Nội dung"></textarea>
              </div>
              <div class="form-group">
              <%
              	if(session.getAttribute("user") != null){
              %>
                <button class="tm-more-button" type="submit" name="submit">Gửi nội dung</button>
              <%
              	}else{
              %>
              	<button class="tm-more-button" onsubmit="return false" onclick="alert('Bạn cần phải đăng nhập trước khi gửi góp ý')" >Gửi nội dung</button>
              	<script>
                $("#form").submit(function(e){
                    e.preventDefault();
                });
              	</script>
              <%}%>
              </div>               
            </div>
            <div class="col-lg-6 col-md-6">
              <img style="width: 500px;height: auto;" src="<%=request.getContextPath()%>/templates/public/images/at-home-5000290_1920.jpg"/>
            </div> 
          </form>
        </section>
      </div>
    </div> 
 <%@ include file="/templates/public/inc/footer.jsp" %>