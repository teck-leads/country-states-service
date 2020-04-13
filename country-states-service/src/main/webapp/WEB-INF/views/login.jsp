<%@include file="common/header.jspf"%>
<%@include file="common/navigationLogin.jspf"%>
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
<%@include file="common/footer.jspf"%>

