<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="login-content">
	<h2>
		<img height="100"
			src="https://icon-library.com/images/lock-icon-free/lock-icon-free-3.jpg"
			alt="">
	</h2>
	<form:form action="login" method="POST">
		<div class="form-group">
			<label for="email">Email</label> <input class="form-input"
				type="email" name="email" id="email">
		</div>
		<div class="form-group">
			<label for="password">Password</label> <input class="form-input"
				type="password" name="password" id="password">
		</div>
		<div class="input-group">
			<div class="input-group">
				<input class="remember-me" type="checkbox"> <label for="">Remember
					me</label>
			</div>
			<div class="input-group">
				<label for=""><a href="">Forget password?</a></label>
			</div>
		</div>
		<div class="form-group">
			<input type="submit" value="Login" class="submit button form-input">
		</div>
	</form:form>
</div>
