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
<link
	href="/countries-services/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container">
		<h2>Welcome to ${mynameKey }</h2>
		<form action="addtodo" method="post">
			<fieldset class="form-group">
				<input type="hidden" name="updId"
					<c:if test="${not empty userKey}">
   value="${idKey }"
</c:if>>
				<label>Name</label> <input type="text" name="user"
					<c:if test="${not empty userKey}">
    value="${userKey}"
</c:if>
					class="form-control" required="required"
					oninvalid="this.setCustomValidity('Enter User name')"
					oninput="this.setCustomValidity('')"> <label>Description</label>
				<input type="text" name="desc" class="form-control"
					<c:if test="${not empty userKey}">
   value="${descKey }"
</c:if>
					required="required"
					oninvalid="this.setCustomValidity('Enter Descripton')"
					oninput="this.setCustomValidity('')">
					
					
					 <label>Target Date</label>
				<input type="text" name="targetDate" id="mydtval"
								<c:if test="${not empty dateKey}">
   value="<fmt:formatDate value="${dateKey}" pattern="dd/MM/yyyy"/>"
</c:if>
				
				class="form-control">
					
					
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
		<script type="text/javascript"
		src="/countries-services/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
		<script>
		$('#mydtval').datepicker({
		    format: 'dd/mm/yyyy'
		});
		</script>
</body>
</html>