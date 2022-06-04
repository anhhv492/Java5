<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
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
<body>
	<div class="container">
		<form:form action="/towel/insert" method="post" class="form-group" modelAttribute="towelModel">
			<div class="col-10">
				<div class="form-group mt-3">
					<label for="name">Thể loại</label> 
					<select name="category" class="form-select">
						<c:forEach items="${listCate}" var="listCate">
							<option value="${listCate.id}">
								${listCate.name}
							</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group mt-3">
					<label for="name"><i
						class="zmdi zmdi-apps"></i></label> <input
						type="text" name="name" placeholder="Tên sản phẩm" class="form-control"
						required />
				</div>
				<div class="form-group mt-3">
					<label for="name"><i
						class="zmdi zmdi-filter-list"></i></label> <input
						type="number" name="count" placeholder="Số lượng" class="form-control"
						required />
				</div>	
				<div class="form-group mt-3">
					<label for="name"><i
						class="zmdi zmdi-card"></i></label> <input
						type="number" name="price" placeholder="Đơn giá" class="form-control"
						required />
				</div>	
				<div class="form-group mt-3">
					<label for="name"><i
						class="zmdi zmdi-card"></i></label> <input
						type="text" name="matter" placeholder="Chất vải" class="form-control"
						required />
				</div>	
				<div class="form-group mt-3">
					<label for="name"><i
						class="zmdi zmdi-flower"></i></label> <input
						type="text" name="color" placeholder="Màu sắc" class="form-control"
						required />
				</div>	
				<div class="form-group mt-3">
					<label for="name"><i
						class="zmdi zmdi-grid"></i></label> <input
						type="text" name="size" placeholder="Kích thước" class="form-control"
						required />
				</div><div class="form-group mt-3">
					<button type="submit" class="btn btn-dark">Thêm</button>
					<a href="/home" class="btn btn-primary">Back</a>
				</div>
			</div>
		</form:form>
	</div>	
</body>
</html>