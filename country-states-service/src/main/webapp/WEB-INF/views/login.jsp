<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="/countries-services/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<h2>Welcome to JSP ${mynameKey } </h2>
	<hr>
	<form action="login" method="post">
		<table class="table table-striped">
			<tr>
				<td>Name</td>
				<td><input type="text" name="userName"></td>

			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>

			</tr>
			<tr>
				<td><input type="submit" value="Login" class="btn btn-outline-primary"></td>
			</tr>
		</table>
	</form>
	</div>
	<script type="text/javascript" src="/countries-services/webjars/jquery/3.4.1/jquery.min.js"></script>
		<script type="text/javascript" src="/countries-services/webjars/bootstrap/4.4.1-1/js/bootstrap.min.js"></script>

</body>
</html>