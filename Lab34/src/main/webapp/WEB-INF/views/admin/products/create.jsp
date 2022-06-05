<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div class="container card">
	<div class="row offset-1 mt-3">
		<h2 class="form-title text-success mt-3">Quản lý sản phẩm</h2>
		<!-- form -->
		<c:if test="${!empty sessionScope.isSuccess }">
		<div class="alert alert-success">
			${ sessionScope.isSuccess }
		</div>
		<c:remove var="isSuccess" scope="session"/>
		</c:if>
		<c:if test="${!empty sessionScope.isFalse }">
			<div class="alert alert-danger">
				${ sessionScope.isFalse }
			</div>
			<c:remove var="isFalse" scope="session"/>
		</c:if>
		<form method="POST" class="row"
			action="/PH14045_HaVietAnh_Assignment/admin/product/store">
			<div class="col-5">
				<div class="form-group mt-3">
				<label>Thể loại</label>
					<select name="categoryId" class="form-select">
						<c:forEach items="${ cate }" var="cate">
							<option value="${ cate.id }">${ cate.ten }</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group mt-3">
					<label for="name"><i
						class="zmdi zmdi-apps"></i></label> <input
						type="text" name="ten" placeholder="Tên sản phẩm" class="form-control"
						required />
				</div>
				<div class="form-group mt-3">
					<label for="name"><i
						class="zmdi zmdi-filter-list"></i></label> <input
						type="number" name="soLuong" placeholder="Số lượng" class="form-control"
						required />
				</div>	
				<div class="form-group mt-3">
					<label for="name"><i
						class="zmdi zmdi-card"></i></label> <input
						type="number" name="donGia" placeholder="Đơn giá" class="form-control"
						required />
				</div>	
			</div>
			<div class="col-5 ms-5">
				<div class="form-group mt-3">
					<label for="name"><i
						class="zmdi zmdi-flower"></i></label> <input
						type="text" name="mauSac" placeholder="Màu sắc" class="form-control"
						required />
				</div>	
				<div class="form-group mt-3">
					<label for="name"><i
						class="zmdi zmdi-grid"></i></label> <input
						type="text" name="kichThuoc" placeholder="Kích thước" class="form-control"
						required />
				</div>
				<div class="form-group mt-3">
				<label>Chọn ảnh để thêm</label>
				</div>
				<div class="mt-3">
					<button class="btn btn-dark" type="submit">Thêm</button>
					
				</div>
			</div>
		</form>
	</div>
	<a class="btn btn-dark" href="/PH14045_HaVietAnh_Assignment/admin/product/insertExcel">Thêm File Excel</a>
	<!-- do data len table -->
	<div class="ms-4 me-4 mt-3">
		<label>Thể loại</label>
			<select name="categoryId" class="form-select">
					<c:forEach items="${ cate }" var="cate">
						<option value="${ cate.id }">${ cate.ten }</option>
					</c:forEach>
			</select>
		<c:if test="${ !empty listSP }">
			<table class="table table-dark table-striped">
				<thead>
					<th>Tên</th>
					<th>Số lượng</th>
					<th>Đơn giá</th>
					<th>Màu sắc</th>
					<th>Thể loại</th>
					<th>Hình ảnh</th>
					<th colspan="2">Thao tác</th>
				</thead>
				<tbody>
					<c:forEach items="${ listSP }" var="pr">
						<tr>
							<td>${pr.ten}</td>
							<td>${pr.soLuong}</td>
							<td>${pr.donGia}</td>
							<td>${pr.mauSac}</td>
							<td>${pr.category.ten}</td>
							<td><img src="/PH14045_HaVietAnh_Assignment/img/${pr.img}" style="width: 120px"></td>
							<td><a
								href="/PH14045_HaVietAnh_Assignment/admin/product/edit?id=${pr.id}"
								class="btn btn-primary">Cập nhật</a>
								<button type="button" data-bs-target="#pr${pr.id }" class="btn btn-danger" 
									data-bs-toggle="modal" data-bs-target="#exampleModal">
								  Xóa
								</button></td>
									
									
									<!-- Button trigger modal -->
								
								
								<!-- Modal -->
								<div class="modal fade" id="pr${pr.id }" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
								  <div class="modal-dialog">
								    <div class="modal-content">
								      <div class="modal-header">
								        <h5 class="modal-title" id="exampleModalLabel">Xóa danh mục</h5>
								        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
								      </div>
								      <div class="modal-body">
								        Xóa không thể khôi phục lại!
								      </div>
								      <div class="modal-footer">
								        <a href="/PH14045_HaVietAnh_Assignment/admin/product/delete?id=${pr.id }"
											class="btn btn-primary">Xác nhận</a>
								        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
								      </div>
								    </div>
								  </div>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</div>