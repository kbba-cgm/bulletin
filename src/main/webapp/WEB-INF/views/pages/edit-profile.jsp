<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<div class="form-div">
	<div class="form-header">
		<div class="page-title">Edit Profile</div>
	</div>
	<div class="form-wrapper">
		<form:form action="${pageContext.request.contextPath}/profile/edit" modelAttribute="userEditDto" method="post">  
			<form:hidden path="id" />
			<div class="form-group">
				<label for="title">Username</label> 
				<form:input class="form-input" type="text" path="name" id="title" />
				<form:errors class="error-msg" path="name" />
			</div>
			<div class="form-group">
				<label for="email">Email</label>
				<form:input class="form-input" path="email" id="email" />
				<form:errors class="error-msg" path="email" />
			</div>
			<div class="form-group">
				<input type="submit" class="submit button form-input" value="update">
			</div>
		</form:form>
	</div>
</div>