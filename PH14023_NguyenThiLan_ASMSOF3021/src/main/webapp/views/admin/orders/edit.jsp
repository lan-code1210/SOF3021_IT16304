<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
</head>
<body>
	<form:form method="POST"
	 action="/IT16304.ASM/admin/orders/update/${order.id }" 
	 modelAttribute="order">
		<div>
			<label>Address</label>
			<form:input path="address" name="address"/>
			<form:errors path="address" class="text-danger" style="color:red"/>
		</div>
		<div>
			<label>User</label>
			<form:select path="user" name="user">
			<form:options items="${user}" />
			</form:select>
		</div>
		<form:button>Submit</form:button>
	</form:form>
</body>
</html>