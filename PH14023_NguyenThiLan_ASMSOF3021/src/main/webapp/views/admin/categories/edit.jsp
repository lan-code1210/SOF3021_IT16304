<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Category</title>
</head>
<body>
	<form:form method="POST" action="/IT16304.ASM/admin/categories/store"
		modelAttribute="category">
		<div>
			<label>Name</label>
			<form:input path="name" name="name" />
		</div>

		<form:button>Update</form:button>
	</form:form>
</body>
</html>