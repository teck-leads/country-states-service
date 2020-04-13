<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
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
				oninput="this.setCustomValidity('')"> <label>Target
				Date</label> <input type="text" name="targetDate" id="mydtval"
				<c:if test="${not empty dateKey}">
   value="<fmt:formatDate value="${dateKey}" pattern="dd/MM/yyyy"/>"
</c:if>
				class="form-control">


		</fieldset>
		<button type="submit" class="btn btn-outline-primary">Add/Update
			Todo</button>
	</form>
</div>
<%@include file="common/footer.jspf"%>