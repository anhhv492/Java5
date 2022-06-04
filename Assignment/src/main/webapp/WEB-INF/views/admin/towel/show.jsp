<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
		 integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous">
	</script>
</head>
<body class="container m-auto">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
		<div class="container-fluid">
			<a href="/towel/new" class="btn btn-primary navbar-brand">Thêm mới</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarScroll"
				aria-controls="navbarScroll" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarScroll">
				<ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll"
					style="-bs-scroll-height: 100px;">
					<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#"
						id="navbarScrollingDropdown" role="button"
						data-bs-toggle="dropdown" aria-expanded="false">Thể loại</a>
						<ul class="dropdown-menu"
							aria-labelledby="navbarScrollingDropdown">
							<c:forEach items="${listCate}" var="listCate">
								<li><a class="dropdown-item" href="/towel/select/${listCate.id}">${listCate.name}</a></li>
							</c:forEach>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<table class="table table-dark table-bordered">
		<thead>
			<tr>
				<th><input type="checkbox" id="check" name="check" class="form-check-input"></th>
				<th>Tên</th>
				<th>Giá</th>
				<th>Màu sắc</th>
				<th>Số lượng</th>
				<th>Chất liệu</th>
				<th>Kích thước</th>
				<th>Ngày tạo</th>
				<th>Loại</th>
				<th>Thao tác</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${listPro}" var="list">
			<tr>
				<td><input type="checkbox" id="check"name="check" class="form-check-input"></td>
				<td>${list.name }</td>
				<td>${list.price }</td>
				<td>${list.color }</td>
				<td>${list.count }</td>
				<td>${list.matter }</td>
				<td>${list.size }</td>
				<td><fmt:formatDate value="${list.createdDate}" pattern="dd/MM/yyyy"/></td>
				<td>${list.category.name}</td>
				<td>
					<a href="/towel/update?id=${list.id}" class="btn btn-warning">Chọn</a>
					<a href="/towel/delete?id=${list.id}" class="btn btn-danger">Xóa</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>	
	<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    
  </ul>
</nav>
</body>
</html>