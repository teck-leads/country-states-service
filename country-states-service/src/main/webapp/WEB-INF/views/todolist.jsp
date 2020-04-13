<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>

<div class="container">
	<h2>Welcome to ${mynameKey }</h2>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>User</th>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is done?</th>
				<th>Update</th>
				<th>Delete</th>

			</tr>
		</thead>
		<tbody>

			<c:forEach items="${ todoKey}" var="todo">
				<tr>
					<td>${todo.user }</td>
					<td>${todo.desc}</td>
					<td><fmt:formatDate value="${todo.targetDate}"
							pattern="dd/MM/yyyy" /></td>
					<td>${todo.done}</td>
					<td><a href="/countries-services/update?id=${todo.id}"
						class="btn btn-info">Edit</a></td>
					<td><a href="/countries-services/delete?id=${todo.id}"
						class="btn btn-outline-danger">Remove</a></td>

				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>
<%@include file="common/footer.jspf"%>