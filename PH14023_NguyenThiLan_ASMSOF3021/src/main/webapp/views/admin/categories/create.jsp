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
		<c:if test="${!isEdit }">
		<div>
			<label>Id</label>
			<form:input path="id" name="id" />
		</div>
		</c:if>
		<c:if test="${isEdit }">
		<div>
			<label>Id</label>
			<form:input path="id" name="id" />
		</div>
		</c:if>
		<div>
			<label>Name</label>
			<form:input path="name" name="name" />
		</div>
		<c:if test="${isEdit }">
		<form:button>Create</form:button>
		</c:if>
		<c:if test="${!isEdit }">
		<form:button>Update</form:button>
		</c:if>
	</form:form>
</body>
</html>