<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Chủ</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link href="./views/css/style.css" rel="stylesheet">
</head>
<body ng-app="myApp">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="#"><img
					src="images/FPT_Polytechnic.png"
					style="height: 50px; width: 130px;"></a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<a
						href="file:///C:/Users/Mr.Right/Documents/FE_FW/IT16302/Assignment/TrangChu.html"><span
						class="navbar-toggler-icon"></span></a>

				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#!trangchu"><i class="fas fa-home"></i>Trang
								chủ</a></li>
						<li class="nav-item"><a class="nav-link" href="#!gioithieu"><i
								class="fas fa-phone"></i>Giới thiệu</a></li>
						<c:if test="${ !empty sessionScope.user && user.admin == 1}">
							<li class="nav-item dropdown"><a
								class="nav-link text-dark dropdown-toggle" href="#"
								id="navbarDropdownMenuLink" role="button"
								data-bs-toggle="dropdown" aria-expanded="false"> <i
									class="fas fa-user-circle"></i> Quản lý
							</a>
								<ul class="dropdown-menu"
									aria-labelledby="navbarDropdownMenuLink">
									<li><a class="dropdown-item"
										href="/IT16304.ASM/admin/accounts/index">Account</a></li>
									<li><a class="dropdown-item"
										href="/IT16304.ASM/admin/categories/index">Category</a></li>
									<li><a class="dropdown-item"
										href="/IT16304.ASM/admin/products/index">Product</a></li>
									<li><a class="dropdown-item"
										href="/IT16304.ASM/admin/orders/index">Order</a></li>
									<li><a class="dropdown-item"
										href="/IT16304.ASM/admin/order_details/index">OrderDetail</a></li>
								</ul></li>
						</c:if>
						<li class="nav-item"><a class="nav-link " href="#!lienhe"><i
								class="fas fa-phone"></i>Liên hệ</a></li>
						<li class="nav-item"><a class="nav-link " href="#!gopy"><i
								class="fas fa-envelope"></i>Góp ý</a></li>
						<li class="nav-item"><a class="nav-link " href="#!hoidap"><i
								class="far fa-question-circle"></i>Hỏi đáp</a></li>
					</ul>
					<ul class="nav d-flex ">
						<!-- Button trigger modal -->
						<c:if test="${ !empty sessionScope.user}">
						<button type="button" class="btn btn-outline-danger"
							data-bs-toggle="modal" data-bs-target="#exampleModal">
							Đăng Xuất</button></c:if>
						<c:if test="${ empty sessionScope.user }">
						<button type="button" class="btn btn-outline-danger"
							data-bs-toggle="modal" data-bs-target="#exampleModal">
							<a href="/IT16304.Asm/login">Đăng nhập</a></button></c:if>	



						<li class="nav-item dropdown pull-right"><a
							class="nav-link text-dark dropdown-toggle navbar-right" href="#"
							id="navbarDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> <i
								class="fas fa-user-circle"></i> ${user.fullname }
						</a>
							<ul class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">
								<li><a class="dropdown-item" href="#!list_taikhoan">Tài
										khoản</a></li>
								<li><a class="dropdown-item" href="#!dangky">Đăng ký</a></li>
								<li><a class="dropdown-item"
									href="file:///C:/Users/Mr.Right/Documents/FE_FW/IT16302/Assignment/Doimatkhau.html?">Đổi
										mật khẩu</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- nav -->
		<header class="row">
			<div class="col-12" style="height: 200px;">
				<div id="carouselExampleIndicators" class="carousel slide"
					data-bs-ride="carousel">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img
								src="https://bapcai.vn/wp-content/uploads/2021/07/tieu-thuyet-viet-nam-20.jpg"
								class="d-block w-100 " style="height: 200px;">
						</div>
						<div class="carousel-item ">
							<img
								src="https://cf.shopee.vn/file/3fa2191c7049207f8abf344b0ed015d8_tn"
								class="d-block w-100 " style="height: 200px;">
						</div>
						<div class="carousel-item">
							<img
								src="https://toplist.vn/images/800px/bo-ke-bi-nan-589437.jpg"
								class="d-block w-100 " style="height: 200px;">
						</div>

					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
			</div>
		</header>
		<div class="row" ng-controller="my_controller">
			<aside class="col-12 col-md-12 mt-2 ">
				<section class="section-products">
					<div class="container">
						<div class="row justify-content">
							<div class="col-md-8 col-lg-6">
								<div class="header">
									<h2>Popular Products</h2>
								</div>
							</div>
						</div>
						<div class="row">
							<!-- Single Product -->
							<c:forEach items="${listPro}" var="pro">
								
									<div class="col-md-3 col-sm-6">
										<div class="product-grid">
											<div class="product-image">
												<a href="#" class="image"> <img style="width: 300px;height: 300px" class="pic-1"
													src="${pro.image }">
												</a>
												<ul class="product-links">
													<li><a href="#" data-tip="Add to Wishlist"><i
															class="fas fa-heart"></i></a></li>
													<li><a href="#" data-tip="Compare"><i
															class="fa fa-random"></i></a></li>
													<li><a href="#" data-tip="Quick View"><i
															class="fa fa-search"></i></a></li>
												</ul>
											</div>
											<div class="product-content">
												<ul class="rating">
													<li class="fas fa-star"></li>
													<li class="fas fa-star"></li>
													<li class="fas fa-star"></li>
													<li class="fas fa-star"></li>
													<li class="far fa-star"></li>
												</ul>
												<h3 class="title">
													<a href="#">${pro.name }</a>
												</h3>
												<div class="price">${pro.price}</div>
												<a class="add-to-cart" href="#">add to cart</a>
											</div>
										</div>
									</div>
								
							</c:forEach>
						</div>
					</div>
				</section>
			</aside>
		</div>
		<footer class="row bg-danger mt-2 text-center p-3 ">
			<span>Nguyễn Thị Lan</span>
		</footer>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>
	<script src="../js/agularjs.min.js"></script>
	<script src="../js/angular-route.js"></script>
	<script src="../controller/userController.js"></script>
</body>
</html>