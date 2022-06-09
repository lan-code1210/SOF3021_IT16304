<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta charset="UTF-8">
<title>Update Order_detail</title>
</head>
<body>
	<form:form method="POST"
	 action="/IT16304.ASM/admin/order_details/update/${orderdetail.id}" 
	 modelAttribute="orderdetail">
		<div>
			<label>Product</label>
			<form:select path="product" name="product">
			<form:options items="${listPro}" />
			</form:select>
		</div>
		<div>
			<label>Order</label>
			<form:select path="order" name="order">
			<form:options items="${listOrd}" />
			</form:select>
		</div>
		<div>
			<label>Quantity</label>
			<form:input path="quantity" name="quantity" />
			<form:errors path="quantity" class="text-danger" style="color:red"/>
		</div>
		<div>
			<label>Price</label>
			<form:input path="price" name="price"/>
			<form:errors path="price" class="text-danger" style="color:red"/>
		</div>
		<form:button>Update</form:button>
	</form:form>
</body>
</html>