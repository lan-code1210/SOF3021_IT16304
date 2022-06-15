<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OrderDetail</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
<c:if test="${!empty sessionScope.message }">
		<div class="alert alert-success">${sessionScope.message }</div>
		<c:remove var="message" scope="session" />
	</c:if>

	<c:if test="${!empty sessionScope.error }">
		<div class="alert alert-danger">${sessionScope.error }</div>
		<c:remove var="error" scope="session" />
	</c:if>
	<button type="button" class="btn btn-outline-primary">
		<a href="/IT16304.ASM/admin/order_details/create">New Product</a>
	</button>
	<table class="table table-striped">
		<thead>
			<th>ID</th>
			<th>Product</th>
			<th>Order</th>
			<th><a href="/IT16304.ASM/admin/order_details/index?field=price">Price</a></th>
			<th><a href="/IT16304.ASM/admin/order_details/index?field=quantity">Quantity</a></th>
			<th colspan="2">Action</th>
		</thead>
		<tbody>
			<c:forEach items="${data.content }" var="od_de">
				<tr>
					<td>${od_de.id }</td>
					<td>${od_de.product.name }</td>
					<td>${od_de.order.user.fullname }</td>
					<td>${od_de.price}</td>
					<td>${od_de.quantity}</td>
					<td><a
						href="/IT16304.ASM/admin/order_details/edit/${od_de.id }">Update</a></td>
					<td>
						<!-- Button trigger modal -->
						<button type="button" class="btn btn-outline-danger"
							data-bs-toggle="modal" data-bs-target="#exampleModal${od_de.id }">
							Delete</button> <!-- Modal -->
						<div class="modal fade" id="exampleModal${od_de.id }" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Delete</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">Bạn muốn xóa?</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Close</button>
										<button type="button" class="btn btn-ouline-danger"><a
						href="/IT16304.ASM/admin/order_details/delete/${od_de.id }">delete</a></button>
									</div>
								</div>
							</div>
						</div></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link"
					href="/IT16304.ASM/admin/order_details/index" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
				</a></li>
				<li class="page-item"><a class="page-link"
					href="/IT16304.ASM/admin/order_details/index?page=1">1</a></li>
				<li class="page-item"><a class="page-link"
					href="/IT16304.ASM/admin/order_details/index?page=2">2</a></li>
				<li class="page-item"><a class="page-link"
					href="/IT16304.ASM/admin/order_details/index?page=2">3</a></li>
				<li class="page-item"><a class="page-link"
					href="/IT16304.ASM/admin/order_details/index?page=${ data.totalPages - 1 }"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
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

</body>
</html>