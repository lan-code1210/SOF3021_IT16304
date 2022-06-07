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
	 action="/IT16304.ASM/admin/accounts/store" 
	 modelAttribute="account">
		<div>
			<label>Fullname</label>
			<form:input path="fullname" name="fullname"/>
			<form:errors path="fullname" class="text-danger" style="color:red"/>
		</div>
		<div>
			<label>Email</label>
			<form:input path="email" name="email" type="email" />
			<form:errors path="email" class="text-danger" style="color:red"/>
		</div>
		<div>
			<label>Username</label>
			<form:input path="username" name="username"/>
			<form:errors path="username" class="text-danger" style="color:red"/>
		</div>
		<div>
			<label>Password</label>
			<form:password path="password" name="password"/>
			<form:errors path="password" class="text-danger" style="color:red"/>
		</div>
		<div>
			<label>Photo</label>
			<form:input path="photo" name="photo"/>
			<form:errors path="photo" class="text-danger" style="color:red"/>
		</div>
		<div>
			<label>Role</label>
			<form:select path="admin" name="admin">
				<form:option value="0">User</form:option>
				<form:option value="1">Admin</form:option>
			</form:select>
		</div>
		<form:button>Submit</form:button>
	</form:form>
</body>
</html>