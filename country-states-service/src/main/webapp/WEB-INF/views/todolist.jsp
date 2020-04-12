<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="/countries-services/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<h2>Welcome to ${mynameKey } </h2>
		<table class="table table-striped">
		<thead>
			<tr>
				<th>User</th>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is done</th>
				<th>Update</th>
				<th>Delete</th>
				
			</tr>
			</thead>
			<tbody>
			
			<c:forEach items="${ todoKey}" var="todo">
			<tr>
				<td>${todo.user }</td>
				<td>${todo.desc}</td>
				<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
				<td>${todo.done}</td>
				<td><a href="/countries-services/update?id=${todo.id}" class="btn btn-info">Edit</a></td>
				<td><a href="/countries-services/delete?id=${todo.id}" class="btn btn-outline-danger">Remove</a></td>
				
			</tr>
			</c:forEach>
			
				<tr>
				<td><a href="/countries-services/add-todo" style='text-decoration: none;' class="btn btn-outline-primary">Add Todo</a></td>
				<td><a href="/countries-services/login" style='text-decoration: none;' class="btn btn-outline-primary">Home</a></td>

			</tr>
			</tbody>
		</table>
		</div>
		<script type="text/javascript" src="/countries-services/webjars/jquery/3.4.1/jquery.min.js"></script>
		<script type="text/javascript" src="/countries-services/webjars/bootstrap/4.4.1-1/js/bootstrap.min.js"></script>
		
		
</body>
</html>