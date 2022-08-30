<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<div class="form-div">
	<div class="form-header">
		<div class="page-title">Add New Post</div>
	</div>
	<div class="form-wrapper">
		<form:form action="${pageContext.request.contextPath}/post/create" modelAttribute="postDto" method="post">  
			<div class="form-group">
				<label for="title">Title</label> 
				<form:input class="form-input" type="text" path="title" id="title" />
				<form:errors class="error-msg" path="title" />
			</div>
			<div class="form-group">
				<label for="content">Content</label>
				<form:textarea class="form-input" path="content" id="content" cols="30"
					rows="10"></form:textarea>
				<form:errors class="error-msg" path="content" />
			</div>
			<form:checkboxes items="${ categories }" path="categories_id" itemLabel="name" itemValue="id" />
			<div class="published-div">
				<form:checkbox id="is_published" path="is_published" value="1"/>  
				<label for="is_published">Is published</label>
			</div>
			<div class="form-group">
				<input type="submit" class="submit button form-input" value="Create">
			</div>
		</form:form>
	</div>
</div>