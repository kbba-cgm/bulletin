<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="photo_url" value="${pageContext.request.contextPath}/resources/images/${ userEditDto.photo }"></c:set>
<div class="form-div">
	<div class="form-header">
		<div class="page-title">Edit Profile</div>
	</div>
	<div class="form-wrapper">
		<form:form action="${pageContext.request.contextPath}/profile/edit" modelAttribute="userEditDto" method="post">  
			<form:hidden path="id" />
			<%-- Name => <c:out value="${ userEditDto.name }"></c:out> <hr>
			Email => <c:out value="${ userEditDto.email }"></c:out> <hr>
			Photo => <c:out value="${ userEditDto.photo }"></c:out> <hr>
			Base64String => <c:out value="${ userEditDto.base64String }"></c:out> <hr>
			returnImageString => <c:out value="${ userEditDto.imageString }"></c:out> <hr> --%>
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
						<c:when test="${ not empty userEditDto.imageString }">
							<img height="100" id="profile-preview-photo"
							src="${ userEditDto.imageString }"
							alt="example picture">
						</c:when>
						<c:when test="${ not empty userEditDto.photo }">
							<img height="100" id="profile-preview-photo"
							src="${ photo_url }"
							alt="example picture">
						</c:when>
						<c:otherwise>
							<img height="100" id="profile-preview-photo"
							src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrgTTV3ncyk_ArHQftXJkKB4Jek24P9_sf4T7KQq_XKmVd50PGgwqaFVZJheRJSZCQ-fk&usqp=CAU"
							alt="example picture">
						</c:otherwise>
					</c:choose>
					<div>
						<div id="remove_photo" class="button action-button d-none" style="margin: 10px 0; background-color: crimson;">Remove photo</div>
					</div>
				</div>
				<!-- <input class="form-input" type="file"> -->
				<input style="width: 100%" class="form-input" type="file" id="fileUpload" accept="image/*" value="${userEditDto.imageString}" />
			</div>
		</div>
			<div class="error-msg" id="profile-photo-type-error"></div>
			<form:input path="imageString" type="" id="imageData" value="${userEditDto.imageString}" />
			<c:if test="${ not empty userEditDto.photo }">
				<form:input path="photo" type="" id="oldImageData" value="${userEditDto.photo}" />
				<form:input path="base64String" type="" id="oldImageString" value="${userEditDto.base64String}" />
			</c:if>
			<div class="form-group">
				<input type="submit" class="submit button form-input" value="update">
			</div>
		</form:form>
	</div>
</div>