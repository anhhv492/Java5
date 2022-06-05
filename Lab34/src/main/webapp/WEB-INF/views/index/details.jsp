<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${!empty details }">
	<div class="row offset-2">
		<div class="col-12 col-md-4 mt-1 mb-3">
			<div class="card">
				<a href="shop-single.html" class="text-center mt-4"> <img
					src="/PH14045_HaVietAnh_Assignment/img/${details.img}"style="width: 300px;height: 320px" 
					class="card-img-top img-fluid"
					alt="...">
				</a>
				<div class="card-body">
					<ul class="list-unstyled d-flex justify-content-between">
						<li><i class="text-warning fa fa-star"></i> <i
							class="text-warning fa fa-star"></i> <i
							class="text-warning fa fa-star"></i> <i
							class="text-muted fa fa-star"></i> <i
							class="text-muted fa fa-star"></i></li>
					</ul>
					
					<a class="btn btn-warning" href="/PH14045_HaVietAnh_Assignment/user/addCart?id=${details.id}">
						Thêm vào giỏ hàng
					</a>
				</div>
			</div>
		</div>
		<div class="col-12 col-md-4 mt-1 mb-3">
			<div class="card">
				<div class="card-body">
					<ul class="form-group">
						<li class="h3">Tên: ${details.ten}</li>
						<li class="h3">Màu: ${details.mauSac}</li>
						<li class="h3">Còn: ${details.soLuong} cái</li>
						<li class="h3">Size: ${details.kichThuoc}</li>
						<li class="h3">Giá: ${details.donGia}</li>
					</ul>
					<br>
				</div>
			</div>
		</div>
	</div>
</c:if>