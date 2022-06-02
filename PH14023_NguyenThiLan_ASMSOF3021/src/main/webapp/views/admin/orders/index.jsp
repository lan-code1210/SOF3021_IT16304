<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<button type="button" class="btn btn-outline-primary">
		<a href="/IT16304.ASM/admin/orders/create">New order</a>
	</button>
	<table class="table table-striped">
		<thead>
			<th>ID</th>
			<th><a href="/IT16304.ASM/admin/orders/index?field=user">User</a></th>
			<th><a href="/IT16304.ASM/admin/orders/index?field=address">Address</a></th>
			<th><a href="/IT16304.ASM/admin/orders/index?field=createDate">Create Date</a></th>
			<th colspan="2">Action</th>
		</thead>
		<tbody>
			<c:forEach items="${data.content }" var="order">
				<tr>
					<td>${order.id }</td>
					<td>${order.user.fullname}</td>
					<td>${order.address }</td>
					<td>${order.createDate}</td>
					<td><a
						href="/IT16304.ASM/admin/orders/edit/${order.id }">Update</a></td>
					<td><a
						href="/IT16304.ASM/admin/orders/delete/${order.id }">delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<ul class="pagination">
			<li class="page-item"><a class="page-link"
				href="/IT16304.ASM/admin/orders/index"> First page </a></li>
			<li class="page-item"><a class="page-link"
				href="/IT16304.ASM/admin/orders/index?page=${ data.number - 1 }">
					Previos page </a></li>
			<li class="page-item"><a class="page-link"
				href="/IT16304.ASM/admin/orders/index?page=${ data.number + 1 }">
					Next page </a></li>
			<li class="page-item"><a class="page-link"
				href="/IT16304.ASM/admin/orders/index?page=${ data.totalPages - 1 }">
					Last page </a></li>
		</ul>
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