<%@include file="common/header.jspf"%>
<%@include file="common/navigationLogin.jspf"%>
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
</div>
<%@include file="common/footer.jspf"%>