<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>New Order_detail</title>
</head>
<body>
	<form:form method="POST"
	 action="/IT16304.ASM/admin/order_details/store" 
	 modelAttribute="orderdetail">
		<div>
			<label>Product</label>
			<form:select path="product" name="product">
			<c:forEach items="${listPro }" var="pro">
			<form:option value="${pro.id}" >${pro.name }</form:option>
			</c:forEach>
			</form:select>
		</div>
		<div>
			<label>Order</label>
			<form:select path="order" name="order">
			<c:forEach items="${listOrd }" var="od">
			<form:option value="${od.id}" >${od.address }</form:option>
			</c:forEach>
			
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
		<form:button>Submit</form:button>
	</form:form>
</body>
</html>