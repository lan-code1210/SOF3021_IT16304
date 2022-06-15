<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>New order</title>
</head>
<body>
	<form:form method="POST" action="/IT16304.ASM/admin/orders/store"
		modelAttribute="order">
		<div>
			<label>Address</label>
			<form:input path="address" name="address" />
			<form:errors path="address" class="text-danger" style="color:red" />
		</div>
		<div>
			<label>User:</label>
			
			<form:select path="user" name="user">
				<c:forEach items="${account }" var="ac">
					<form:option value="${ ac.id }">${ ac.fullname }</form:option>
				</c:forEach>
			</form:select>
		</div>
		<form:button>Submit</form:button>
	</form:form>
</body>
</html>