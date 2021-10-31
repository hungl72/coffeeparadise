<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/public/inc/header.jsp" %>

		<div class="container" align="center">
		<h2 class="text-center">Gửi ý kiến đóng góp thành công</h2>
	      <div style="margin-bottom: 20px;" class="col-xs-12" align="center">
	      	<img style="width: 200px;height: auto;" src="<%=request.getContextPath()%>/templates/public/images/email-mail-send-chat-letter-communication-message-icon.svg"/>
	      </div>
	      	<h3 class="text-center">Cảm ơn bạn đã gửi ý kiến đóng góp !</h3>
			<a href="<%=request.getContextPath()%>/index" class="tm-more-button margin-top-20" style="margin-bottom: 15px;">Quay lại trang chủ</a>
		</div>
<%@ include file="/templates/public/inc/footer.jsp" %>