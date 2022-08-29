<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<div class="form-div">
	<div class="form-header">
		<div class="page-title">Edit Post</div>
	</div>
	<div class="form-wrapper">
		<form:form action="${pageContext.request.contextPath}/post/edit" modelAttribute="postDto" method="post">
			<form:hidden path="id" />
			<div class="form-group">
				<label for="title">Ttile</label> 
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
			<%-- <div class="form-group">
				<label for="category">Category</label> 
				<form:select class="form-select2 form-input" path="" id="category" multiple="multiple">  
					<form:option class="form-option" value="work" label="Work"/>
					<form:option class="form-option" value="rule" label="Rule"/>
					<form:option class="form-option" value="general" label="General"/>
				</form:select>
			</div> --%>
			<div class="published-div">
				<c:choose>
					<c:when test="is_published">
						<form:checkbox id="is_published" path="is_published" value="1" selected="selected" />  
					</c:when>
					<c:otherwise>
						<form:checkbox id="is_published" path="is_published" value="1"/>  					
					</c:otherwise>
				</c:choose>
				<label for="is_published">Is published</label>
			</div>
			<div class="form-group">
				<input type="submit" class="submit button form-input" value="Update">
			</div>
		</form:form>
	</div>
</div>