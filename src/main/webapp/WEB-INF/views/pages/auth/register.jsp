<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="login-content">
	<form:form action="${ pageContext.request.contextPath }/register" method="POST" modelAttribute="userDto">
		<div class="form-group">
			<label for="name">Username</label> 
			<form:input class="form-input" path="name" id="email" />
		</div>
		<div class="form-group">
			<label for="email">Email</label> <form:input class="form-input"
				path="email" id="email" />
		</div>
		<div class="form-group">
			<label for="password">Password</label> <form:input class="form-input"
				path="password" id="password" type="password" />
		</div>
		<div class="form-group">
			<label for="password">Photo</label>
			<div class="media-input-wrapper">
				<div class="preview-input form-input">
					<img height="100"
						src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrgTTV3ncyk_ArHQftXJkKB4Jek24P9_sf4T7KQq_XKmVd50PGgwqaFVZJheRJSZCQ-fk&usqp=CAU"
						alt="example picture">
				</div>
				<input class="form-input" type="file">
			</div>
		</div>
		<div class="form-group">
			<input type="submit" value="Register"
				class="submit button form-input">
		</div>
	</form:form>
</div>