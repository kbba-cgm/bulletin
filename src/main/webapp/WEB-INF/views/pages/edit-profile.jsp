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
			<label for="photo">Photo</label>
			<div class="">
				<div class="preview-input form-input">
					<c:choose>
						<c:when test="${ userEditDto.photo.length() > 0 }">
							<img height="100" id="profile-preview-photo"
							src="${ userEditDto.photo }"
							alt="example picture">
						</c:when>
						<c:otherwise>
							<img height="100" id="profile-preview-photo"
							src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrgTTV3ncyk_ArHQftXJkKB4Jek24P9_sf4T7KQq_XKmVd50PGgwqaFVZJheRJSZCQ-fk&usqp=CAU"
							alt="example picture">
						</c:otherwise>
					</c:choose>
				</div>
				<!-- <input class="form-input" type="file"> -->
				<input class="form-input" type="file" id="fileUpload" accept="image/*" value="${userEditDto.photo}" />
				<form:input path="photo" type="hidden" id="imageData" value="${userEditDto.photo}" />
			</div>
				<div class="error-msg form-input" id="profile-photo-type-error"></div>
		</div>
			<div class="form-group">
				<input type="submit" class="submit button form-input" value="update">
			</div>
		</form:form>
	</div>
</div>