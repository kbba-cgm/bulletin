<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="login-content">
	<form:form action="${ pageContext.request.contextPath }/register" method="POST" modelAttribute="userDto">
		<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> --%>
		<div class="form-group">
			<label for="name">Username</label> 
			<form:input class="form-input" path="name" id="name" />
			<form:errors class="error-msg" path="name"></form:errors>
		</div>
		<div class="form-group">
			<label for="email">Email</label> <form:input class="form-input"
				path="email" id="email" />
			<form:errors class="error-msg" path="email"></form:errors>
		</div>
		<div class="form-group">
			<label for="password">Password</label> <form:input class="form-input"
				path="password" id="password" type="password" />
			<form:errors class="error-msg" path="password"></form:errors>
		</div>
		<div class="form-group">
			<label for="photo">Photo</label>
			<div class="media-input-wrapper">
				<div class="preview-input form-input">
					<c:choose>
						<c:when test="${ userDto.photo.length() > 0 }">
							<img height="100" id="profile-preview-photo"
							src="${ userDto.photo }"
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
				<input class="form-input" type="file" id="fileUpload" accept="image/*" value="${userDto.photo}" />
				<form:input path="photo" type="" id="imageData" value="${userDto.photo}" />
			</div>
				<div class="error-msg form-input" id="profile-photo-type-error"></div>
		</div>
		<div class="form-group">
			<input type="submit" value="Register"
				class="submit button form-input">
		</div>
	</form:form>
</div>
<script></script>