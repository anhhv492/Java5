<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form"prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
		href="/Assignment/css/bootstrap.min.css">
	<link rel="stylesheet"
		href="/Assignment/css/templatemo.css">
	<link rel="stylesheet"
		href="/Assignment/css/custom.css">
	<!-- Load fonts style after rendering the layout styles -->
	<link rel="stylesheet"
		href="/Assignment/css/fontawesome.min.css">
	<!-- load  login, sign up -->
	<link rel="stylesheet"
		href="/Assignment/fonts/material-icon/css/material-design-iconic-font.min.css">
</head>
<body class="row">
<div style="color:red;" class="offset-2">assa</div>
	<!-- Start Top Nav -->
	<nav
		class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block"
		id="templatemo_nav_top">
		<div class="container text-light">
			<div class="w-100 d-flex justify-content-between">
				<div>
					<i class="fa fa-envelope mx-2"></i> <a
						class="navbar-sm-brand text-light text-decoration-none">Info:
						vietanhsvip@gmail.com</a> <i class="fa fa-phone mx-2"></i> <a
						class="navbar-sm-brand text-light text-decoration-none" href="#">098-429-7473</a>
				</div>
				<div>
					<a class="text-light" href="https://facebook.com/vietanhvs"
						target="_blank" rel="sponsored"><i
						class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a> <a
						class="text-light" href="https://www.instagram.com/vietanhvs/"
						target="_blank"><i class="fab fa-instagram fa-sm fa-fw me-2"></i></a>
					<a class="text-light" href="https://twitter.com/" target="_blank"><i
						class="fab fa-twitter fa-sm fa-fw me-2"></i></a><a class="text-light"
						href="https://www.linkedin.com/" target="_blank"><i
						class="fab fa-linkedin fa-sm fa-fw"></i></a>
				</div>
			</div>
		</div>
	</nav>

	<!-- Close Header -->
	<jsp:include page="${view}"></jsp:include>

	<script src="/Assignment/js/jquery.min.js"></script>
	<script src="/Assignment/js/popper.min.js"></script>
	<script src="/Assignment/js/bootstrap.min.js"></script>
	<!-- End Script -->
</body>
</html>