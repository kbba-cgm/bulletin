<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<h2 class="main-title">Category Management</h2>
<div class="wrapper">
	<div class="form-wrapper">
		<h3 class="form-title">Create New Category</h3>
		<form:form action="${pageContext.request.contextPath}/admin/category/create" modelAttribute="categoryDto" method="post">
			<div class="form-group">
				<label for="name">Category Name</label> 
				<form:input class="form-control" type="text" path="name" id="name" />
				<form:errors class="error-msg" path="name" />
			</div>
			<div>
				<input class="button action-button" type="submit" value="Create">
			</div>
		</form:form>
	</div>
</div>