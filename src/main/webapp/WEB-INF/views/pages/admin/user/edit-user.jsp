<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2 class="main-title">User Management</h2>
<div class="wrapper">
	<div class="form-wrapper">
		<h3 class="form-title">Edit User</h3>
		<form:form action="${pageContext.request.contextPath}/admin/user/edit"
			modelAttribute="userEditDto" method="post">
			<form:hidden path="id" />
			<div class="form-group">
				<label for="name">Username</label>
				<form:input class="form-control" type="text" path="name" id="name" />
				<form:errors class="error-msg" path="name" />
			</div>
			<div class="form-group">
				<label for="email">Email</label>
				<form:input class="form-control" type="email" path="email"
					id="email" />
				<form:errors class="error-msg" path="email" />
			</div>
			<div class="form-group">
				<label class="role-label">Roles</label>
				<div class="form-group">
					<form:select class="form-control" path="role.id"
						items="${ roles }" itemValue="id" itemLabel="name">
					</form:select>
					<form:errors class="error-msg" path="role.id" />
				</div>
			</div>
			<div>
				<input class="button action-button" type="submit" value="Create">
			</div>
		</form:form>
	</div>
</div>