<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="topbar-wrapper">
	<div class="logo-wrapper">
		<div>
			<h2>Bulletin Board</h2>
		</div>
	</div>
	<div class="account-name-wrapper">
		<img class="profile-pic-round pic-border" height="40"
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrgTTV3ncyk_ArHQftXJkKB4Jek24P9_sf4T7KQq_XKmVd50PGgwqaFVZJheRJSZCQ-fk&usqp=CAU"
			alt="example picture"> <span><sec:authentication property="principal.username" /></span>
	</div>
</div>