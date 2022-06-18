<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/templatemo.css">
	<link rel="stylesheet" href="/css/custom.css">
	<!-- Load fonts style after rendering the layout styles -->
	<link rel="stylesheet" href="/css/fontawesome.min.css">
	<!-- load  login, sign up -->
	<link rel="stylesheet" href="/fonts/material-icon/css/material-design-iconic-font.min.css">
    <script src="js/sweetalert2.min.js"></script>
</head>
<body>

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
	<!-- Close Top Nav -->
	<nav class="navbar navbar-expand-lg navbar-light shadow">
		<div
			class="container d-flex justify-content-between align-items-center">

			<a class="navbar-brand text-success logo h1 align-self-center"
				href="/home">VANH</a>

			<button class="navbar-toggler border-0" type="button"
				data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div
				class="align-self-center collapse navbar-collapse flex-fill d-lg-flex justify-content-lg-between"
				id="templatemo_main_nav">
				
				<div class="flex-fill ">
				
					<ul
						class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
						<li class="nav-item"><a class="nav-link"
							href="/home">Trang chủ</a>
						</li>
						
						<a class="btn" data-bs-toggle="dropdown"
							id="#danhmuc">Danh mục</a>
						<!-- list danh muc -->
						<ul class="dropdown-menu start-50" aria-labelledby="danhmuc">
							<c:forEach items="${sessionScope.listCates }" var="cates">
								<li><a class="dropdown-item" href="/cart/shop?id=${cates.id }">
									${cates.name}</a></li>
							</c:forEach>
						</ul> 
						<li class="nav-item">
							<a class="nav-link" href="/cart/show-cart">Giỏ hàng</a>
						</li>
						
					</ul>
					
				</div>
				<div class="navbar align-self-center d-flex">	
						
					<c:if test="${!empty sessionScope.account && sessionScope.account.role==1}">
						<a class="nav-icon position-relative text-decoration-none dropdown-toggle"
							href="#" id="manage" data-bs-toggle="dropdown"> <i
							class="fa fa-briefcase text-dark "></i> <span
							class="">Quản lý</span>
						</a>
						<ul class="dropdown-menu"
							aria-labelledby="manage">
							<li><a class="dropdown-item" href="/admin/users/get-all">Tài khoản</a></li>
							<li><a class="dropdown-item" href="/admin/categories/get-all">Thể loại</a></li>
							<li><a class="dropdown-item" href="/admin/towels/get-all">Sản phẩm</a></li>
							<hr>
							<li><a class="dropdown-item" href="/admin/orders/get-all">Đơn hàng</a></li>
						</ul>
					</c:if>
					<a class="nav-icon position-relative text-decoration-none dropdown-toggle"
						href="#" id="signUp" data-bs-toggle="dropdown"> <i
						class="fa fa-fw fa-user text-dark mr-3"></i> <span
						class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark"></span>
						<c:if test="${!empty sessionScope.account}">
							${sessionScope.account.name}
						</c:if>
					</a>
					<ul class="dropdown-menu"
						aria-labelledby="signUp">
						<c:if test="${empty sessionScope.account}">
							<li><a class="dropdown-item" href="/user/login">Đăng nhập</a></li>
							<li><a class="dropdown-item" href="/user/create">Đăng ký</a></li>
						</c:if>
						<c:if test="${!empty sessionScope.account}">
							<li><a class="dropdown-item" href="/user/fChangePass">Đổi mật khẩu</a></li>
							<li><a class="dropdown-item" href="/user/edit">Cập nhật thông tin</a></li>
							<li><a class="dropdown-item" href="/user/history">Lịch sử mua hàng</a></li>
						<hr>
							<li><a class="dropdown-item" href="/user/logout">Đăng xuất</a></li>
						</c:if>
						
					</ul>
				</div>
			</div>

		</div>
	</nav>
	<!-- Close Header -->
	<jsp:include page="${view}"></jsp:include>
	<!-- Start Footer -->
	<footer class="bg-dark mt-3" id="tempaltemo_footer">
		<div class="container">
			<div class="row">

				<div class="col-md-4 pt-5">
					<h2 class="h2 text-success border-bottom pb-3 border-light logo">VANH
						Shop</h2>
					<ul class="list-unstyled text-light footer-link-list">
						<li><i class="fas fa-map-marker-alt fa-fw"></i> Hà Nội</li>
						<li><i class="fa fa-phone fa-fw"></i> <a
							class="text-decoration-none" href="tel:010-020-0340">098-429-7473</a>
						</li>
						<li><i class="fa fa-envelope fa-fw"></i> <a
							class="text-decoration-none" href="mailto:info@company.com">anhhv492@gmail.com</a>
						</li>
					</ul>
				</div>

				<div class="col-md-4 pt-5">
					<h2 class="h2 text-light border-bottom pb-3 border-light">Products</h2>
					<ul class="list-unstyled text-light footer-link-list">
						<li><a class="text-decoration-none" href="#">Luxury</a></li>
						<li><a class="text-decoration-none" href="#">Sport Wear</a></li>
						<li><a class="text-decoration-none" href="#">Men's Shoes</a></li>
						<li><a class="text-decoration-none" href="#">Women's
								Shoes</a></li>
						<li><a class="text-decoration-none" href="#">Popular
								Dress</a></li>
						<li><a class="text-decoration-none" href="#">Gym
								Accessories</a></li>
						<li><a class="text-decoration-none" href="#">Sport Shoes</a></li>
					</ul>
				</div>

				<div class="col-md-4 pt-5">
					<h2 class="h2 text-light border-bottom pb-3 border-light">Further
						Info</h2>
					<ul class="list-unstyled text-light footer-link-list">
						<li><a class="text-decoration-none" href="#">Home</a></li>
						<li><a class="text-decoration-none" href="#">About Us</a></li>
						<li><a class="text-decoration-none" href="#">Shop
								Locations</a></li>
						<li><a class="text-decoration-none" href="#">FAQs</a></li>
						<li><a class="text-decoration-none" href="#">Contact</a></li>
					</ul>
				</div>

			</div>

			<div class="row text-light mb-4">
				<div class="col-12 mb-3">
					<div class="w-100 my-3 border-top border-light"></div>
				</div>
				<div class="col-auto me-auto">
					<ul class="list-inline text-left footer-icons">
						<li
							class="list-inline-item border border-light rounded-circle text-center">
							<a class="text-light text-decoration-none" target="_blank"
							href="http://facebook.com/"><i
								class="fab fa-facebook-f fa-lg fa-fw"></i></a>
						</li>
						<li
							class="list-inline-item border border-light rounded-circle text-center">
							<a class="text-light text-decoration-none" target="_blank"
							href="https://www.instagram.com/"><i
								class="fab fa-instagram fa-lg fa-fw"></i></a>
						</li>
						<li
							class="list-inline-item border border-light rounded-circle text-center">
							<a class="text-light text-decoration-none" target="_blank"
							href="https://twitter.com/"><i
								class="fab fa-twitter fa-lg fa-fw"></i></a>
						</li>
						<li
							class="list-inline-item border border-light rounded-circle text-center">
							<a class="text-light text-decoration-none" target="_blank"
							href="https://www.linkedin.com/"><i
								class="fab fa-linkedin fa-lg fa-fw"></i></a>
						</li>
					</ul>
				</div>
				<div class="col-auto">
					<label class="sr-only" for="subscribeEmail">Email address</label>
					<div class="input-group mb-2">
						<input type="text" class="form-control bg-dark border-light"
							id="subscribeEmail" placeholder="Email address">
						<div class="input-group-text btn-success text-light">Subscribe</div>
					</div>
				</div>
			</div>
		</div>

		<div class="w-100 bg-black py-3">
			<div class="container">
				<div class="row pt-2">
					<div class="col-12">
						<p class="text-left text-light">
							Copyright &copy; 2021 Company Name | Designed by <a
								rel="sponsored" href="https://templatemo.com" target="_blank">TemplateMo</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		
	</footer>
	<!-- End Footer -->

	<!-- Start Script -->
	<script src="/js/jquery.min.js"></script>
	<script src="/js/popper.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<!-- End Script -->
</body>
</html>


