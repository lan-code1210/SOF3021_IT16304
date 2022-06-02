<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta charset="UTF-8">
<title>New Account</title>
</head>
<body>
	<form:form method="POST"
	 action="/IT16304.ASM/admin/products/store" 
	 modelAttribute="product">
		<div>
			<label>Name</label>
			<form:input path="name" name="name"/>
		</div>
		<div>
			<label>Image</label>
			<form:input path="image" name="image" />
		</div>
		<div>
			<label>Price</label>
			<form:input path="price" name="price"/>
		</div>
		<div>
			<label>Category</label>
			<form:select path="category_id" name="category_id">
			<form:options items="${ctg}" />
			</form:select>
		</div>
		<form:button>Submit</form:button>
	</form:form>
</body>
</html>