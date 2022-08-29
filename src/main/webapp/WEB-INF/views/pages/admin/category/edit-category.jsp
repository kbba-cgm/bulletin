<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<h2 class="main-title">Category Management</h2>
<div class="wrapper">
	<div class="form-wrapper">
		<h3 class="form-title">Edit Category</h3>
		<form:form action="${pageContext.request.contextPath}/admin/category/edit" modelAttribute="categoryDto" method="post">
			<form:hidden path="id" />
			<div class="form-group">
				<label for="name">Category Name</label> 
				<form:input class="form-control" type="text" path="name" id="name" />
				<form:errors class="error-msg" path="name" />
			</div>
			<div>
				<input class="button action-button" type="submit" value="Update">
			</div>
		</form:form>
	</div>
</div>