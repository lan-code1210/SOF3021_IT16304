<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Category</title>
</head>
<body>
	<form:form method="POST" action="/IT16304.ASM/admin/categories/store"
		modelAttribute="category">
		<div>
			<label>Name</label>
			<form:input path="name" name="name" />
			<form:errors path="name" class="text-danger" style="color:red"/>
		</div>
		
		<form:button>Create</form:button>
	</form:form>
</body>
</html>