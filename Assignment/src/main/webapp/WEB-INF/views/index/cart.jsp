<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<section style="background-color: #eee;">
  <div class="container py-5">
    <div class="row d-flex justify-content-center align-items-center">
      <div class="col">
        <div class="card shopping-cart" style="border-radius: 15px;">
          <div class="card-body text-black">

            <div class="row">
              <div class="col-lg-12 col-12 px-5 py-4">

                <h3 class="mb-5 pt-2 text-center fw-bold text-uppercase">Giỏ hàng</h3>
			<c:forEach items="${listProCart}" var="list">
                <div class="d-flex align-items-center mb-5">
                  <div class="flex-shrink-0">
                    <img src="/PH14045_HaVietAnh_Assignment/img/${list.img}"
                      class="img-fluid" style="width: 150px;" alt="Generic placeholder image">
                  </div>
                  <div class="flex-grow-1 ms-3">
                    <a href="/PH14045_HaVietAnh_Assignment/user/deleteCart?id=${list.id }" class="float-end text-black"><i class="fas fa-times"></i></a>
                    <h5 class="text-primary">Tên sản phẩm: ${list.ten }</h5>
                    <h6 style="color: #9e9e9e;">Màu sắc: ${list.mauSac }</h6>
                    <div class="d-flex align-items-center">
                      <p class="fw-bold mb-0 me-5 pe-3">Đơn giá: $<fmt:formatNumber>${list.donGia }</fmt:formatNumber></p>
                 <!-- <div class="def-number-input number-input safari_only">
                        <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
                          class="minus"></button>
                          
                        <input class="quantity fw-bold text-black" min="0" name="quantity" value="1"
                          type="number">
                        <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
                          class="plus"></button>
                      </div> --> 
                    </div>
                  </div>
                </div>
			</c:forEach>

                <hr class="mb-4" style="height: 2px; background-color: #1266f1; opacity: 1;">

                <div class="d-flex justify-content-between p-2 mb-2" style="background-color: #e1f5fe;">
                  <h5 class="fw-bold mb-0">Tổng:</h5>
                  <h5 class="fw-bold mb-0"><fmt:formatNumber>${donGia }</fmt:formatNumber> VNĐ</h5>
                </div>
	
              </div>
              <div class="col-lg-6 px-5 py-4">
				<a class="btn btn-warning" class="btn btn-danger" 
									data-bs-toggle="modal" data-bs-target="#exampleModal">Thanh toán</a>
              </div>
			<!-- Modal -->
				<div class="modal fade" tabindex="-1" id="exampleModal" aria-labelledby="exampleModalLabel" aria-hidden="true">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="exampleModalLabel">Thanh toán</h5>
				        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				      </div>
				      <div class="modal-body">
				        Xác nhận thanh toán?
				      </div>
				      <div class="modal-footer">
				        <a href="/PH14045_HaVietAnh_Assignment/user/buy" type="submit"
							class="btn btn-primary">Xác nhận</a>
				        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				      </div>
				    </div>
				  </div>
				</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<style>
	@media (min-width: 1025px) {
	  .h-custom {
	    height: 100vh !important;
	  }
	}
	
	.number-input input[type="number"] {
	  -webkit-appearance: textfield;
	  -moz-appearance: textfield;
	  appearance: textfield;
	}
	
	.number-input input[type=number]::-webkit-inner-spin-button,
	.number-input input[type=number]::-webkit-outer-spin-button {
	  -webkit-appearance: none;
	}
	
	.number-input button {
	  -webkit-appearance: none;
	  background-color: transparent;
	  border: none;
	  align-items: center;
	  justify-content: center;
	  cursor: pointer;
	  margin: 0;
	  position: relative;
	}
	
	.number-input button:before,
	.number-input button:after {
	  display: inline-block;
	  position: absolute;
	  content: '';
	  height: 2px;
	  transform: translate(-50%, -50%);
	}
	
	.number-input button.plus:after {
	  transform: translate(-50%, -50%) rotate(90deg);
	}
	
	.number-input input[type=number] {
	  text-align: center;
	}
	
	.number-input.number-input {
	  border: 1px solid #ced4da;
	  width: 10rem;
	  border-radius: .25rem;
	}
	
	.number-input.number-input button {
	  width: 2.6rem;
	  height: .7rem;
	}
	
	.number-input.number-input button.minus {
	  padding-left: 10px;
	}
	
	.number-input.number-input button:before,
	.number-input.number-input button:after {
	  width: .7rem;
	  background-color: #495057;
	}
	
	.number-input.number-input input[type=number] {
	  max-width: 4rem;
	  padding: .5rem;
	  border: 1px solid #ced4da;
	  border-width: 0 1px;
	  font-size: 1rem;
	  height: 2rem;
	  color: #495057;
	}
	
	@media not all and (min-resolution:.001dpcm) {
	  @supports (-webkit-appearance: none) and (stroke-color:transparent) {
	
	    .number-input.def-number-input.safari_only button:before,
	    .number-input.def-number-input.safari_only button:after {
	      margin-top: -.3rem;
	    }
	  }
	}
	
	.shopping-cart .def-number-input.number-input {
	  border: none;
	}
	
	.shopping-cart .def-number-input.number-input input[type=number] {
	  max-width: 2rem;
	  border: none;
	}
	
	.shopping-cart .def-number-input.number-input input[type=number].black-text,
	.shopping-cart .def-number-input.number-input input.btn.btn-link[type=number],
	.shopping-cart .def-number-input.number-input input.md-toast-close-button[type=number]:hover,
	.shopping-cart .def-number-input.number-input input.md-toast-close-button[type=number]:focus {
	  color: #212529 !important;
	}
	
	.shopping-cart .def-number-input.number-input button {
	  width: 1rem;
	}
	
	.shopping-cart .def-number-input.number-input button:before,
	.shopping-cart .def-number-input.number-input button:after {
	  width: .5rem;
	}
	
	.shopping-cart .def-number-input.number-input button.minus:before,
	.shopping-cart .def-number-input.number-input button.minus:after {
	  background-color: #9e9e9e;
	}
	
	.shopping-cart .def-number-input.number-input button.plus:before,
	.shopping-cart .def-number-input.number-input button.plus:after {
	  background-color: #4285f4;
	}
</style>