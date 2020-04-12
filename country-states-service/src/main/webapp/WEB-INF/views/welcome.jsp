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
		<h2>Welcome to JSP</h2>
		<hr>
		<table class="table table-striped">
			<tr>
				<td>Name</td>
				<td>${nameKey }</td>

			</tr>
			<tr>
				<td>Password</td>
				<td>${pwdKey }</td>

			</tr>

			<tr>
				<td>Manage your Todo here</td>
				<td><a href="/countries-services/list-todo"
					style='text-decoration: none;' class="btn btn-outline-primary">Todo</a></td>

			</tr>

		</table>
		<script type="text/javascript"
			src="/countries-services/webjars/jquery/3.4.1/jquery.min.js"></script>
		<script type="text/javascript"
			src="/countries-services/webjars/bootstrap/4.4.1-1/js/bootstrap.min.js"></script>
	</div>
</body>
</html>