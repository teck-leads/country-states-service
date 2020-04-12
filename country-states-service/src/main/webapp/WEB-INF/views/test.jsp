<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="/countries-services/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container">
		<h2>Welcome to ${mynameKey }</h2>
		<hr>
		${userKey  }<br>
		${idKey }<br>
		${descKey }<br>
		<form action="addtodo" method="post">
			<fieldset class="form-group">
			<input type="hidden" name="id" value="${idKey }">
				<label>Name</label> <input type="text" name="user" value="${userKey  }"
					class="form-control" required="required"
					oninvalid="this.setCustomValidity('Enter User name')"
					oninput="this.setCustomValidity('')"> <label>Description</label>
				<input type="text" name="desc" class="form-control" value="${descKey }"
					required="required"
					oninvalid="this.setCustomValidity('Enter Descripton')"
					oninput="this.setCustomValidity('')">
			</fieldset>
			<button type="submit" class="btn btn-outline-primary">Add/Update
				Todo</button>
			<fieldset class="form-group">
				<label>Login page here</label> <a href="/countries-services/login"
					style='text-decoration: none;'
					class="btn btn-outline-primary form-control">Home</a>
			</fieldset>

		</form>
	</div>
	<script type="text/javascript"
		src="/countries-services/webjars/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="/countries-services/webjars/bootstrap/4.4.1-1/js/bootstrap.min.js"></script>
</body>
</html>