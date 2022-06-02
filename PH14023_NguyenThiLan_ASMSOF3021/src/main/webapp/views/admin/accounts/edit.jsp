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
	 action="/IT16304.ASM/admin/accounts/update/${account.id }" 
	 modelAttribute="account">
		<div>
			<label>Fullname</label>
			<form:input path="fullname" name="fullname"/>
		</div>
		<div>
			<label>Email</label>
			<form:input path="email" name="email" type="email" />
		</div>
		<div>
			<label>Username</label>
			<form:input path="username" name="username"/>
		</div>
		<div>
			<label>Photo</label>
			<form:input path="photo" name="photo"/>
		</div>
		<div>
			<label>Role</label>
			<form:select path="admin" name="admin">
				<form:option value="0">User</form:option>
				<form:option value="1">Admin</form:option>
			</form:select>
		</div>
		<form:button>Update</form:button>
	</form:form>
</body>
</html>