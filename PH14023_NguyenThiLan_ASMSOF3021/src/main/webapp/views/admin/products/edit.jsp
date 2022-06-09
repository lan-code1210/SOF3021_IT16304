<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Account</title>
</head>
<body>
	<form:form method="POST"
	 action="/IT16304.ASM/admin/products/update/${product.id }" 
	 modelAttribute="product">
		<div>
			<label>Name</label>
			<form:input path="name" name="name"/>
			<form:errors path="name" class="text-danger" style="color:red"/>
		</div>
		<div>
			<label>Image</label>
			<form:input path="image" name="image" />
			<form:errors path="image" class="text-danger" style="color:red"/>
		</div>
		<div>
			<label>Price</label>
			<form:input path="price" name="price"/>
			<form:errors path="price" class="text-danger" style="color:red"/>
		</div>
		<div>
			<label>Category</label>
			<form:select path="category_id" name="category_id">
			<form:options items="${ctg}" />
			</form:select>
		</div>
		<form:button>Update</form:button>
	</form:form>
</body>
</html>