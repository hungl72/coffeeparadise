<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login V12</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/templates/public/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/templates/public/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/templates/public/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/templates/public/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/templates/public/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/templates/public/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/templates/public/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/templates/public/css/util.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/templates/public/css/main.css">
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/templates/public/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/templates/public/vendor/bootstrap/js/popper.js"></script>
	<script src="<%=request.getContextPath()%>/templates/public/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/templates/public/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/templates/public/js/main.js"></script>
	<script src="<%=request.getContextPath()%>/templates/public/js/jqueryvalidatemin.js"></script>

</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('<%=request.getContextPath()%>/templates/public/images/img-02.jpg');padding-top: 0px;">
			<div class="wrap-login100 p-t-0 p-b-0">
				<form id="form" class="login100-form validate-form" action="<%=request.getContextPath()%>/signup" method="post">
					<span class="login100-form-title p-t-20 p-b-45">
						Đăng ký tài khoản
					</span>
					<div class="wrap-input100 validate-input m-b-10">
						<input class="input100" type="text" name="name" placeholder="Họ và tên">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-user"></i>
						</span>
					</div>	
					<div class="wrap-input100 validate-input m-b-10">
						<input class="input100" type="text" name="email" placeholder="Email">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input m-b-10">
						<input class="input100" type="password" name="pass" id="pass" placeholder="Mật khẩu">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock"></i>
						</span>
					</div>
					<div class="wrap-input100 validate-input m-b-10">
						<input class="input100" type="password" name="repass" placeholder="Nhập lại mật khẩu">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock"></i>
						</span>
					</div>
					<div class="container-login100-form-btn p-t-10">
						<button class="login100-form-btn">
							Đăng ký
						</button>
					</div>
					<div class="text-center w-full p-t-25 p-b-230">
					</div>
				</form>
			</div>
		</div>
	</div>
<script type="text/javascript">
		$(document).ready(function (){
			$('#form').validate({
				rules:{
					"name":{
						required: true,
						maxlength: 100,
					},
					"pass":{
						required: true,
						minlength: 8,
					},
					"repass":{
						required: true,
						equalTo: "#pass",
					},
					"email":{
						required: true,
						email: true,
					},
				},
				messages:{
					"name":{
						required: "Vui lòng nhập họ tên !",
						maxlength: "Họ tên không quá 100 ký tự !",
					},
					"pass":{
						required: "Vui lòng nhập password !",
						minlength: "Mật khẩu tối thiểu 8 ký tự !",
					},
					"repass":{
						required: "Vui lòng nhập lại mật khẩu !",
						equalTo: "Mật khẩu không trùng !",
					},
					"email":{
						required: "Vui lòng nhập email !",
						email:"Vui lòng nhập email đúng dịnh dạng !",
					},
				}
			});
		});
	</script>
</body>
</html>