<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sec:authentication property="principal.photo" var="photo"/>
<c:set var="photo_url" value="${pageContext.request.contextPath}/resources/images/${ photo }"></c:set>
<div class="topbar-wrapper">
	<div class="logo-wrapper">
		<div>
			<h2>Bulletin Board</h2>
		</div>
	</div>
	<div class="account-name-wrapper">
		<c:choose>
			<c:when test="${ not empty photo }">
				<img class="profile-pic-round pic-border" height="40"
					src="${ photo_url }" alt="example picture">
			</c:when>
			<c:otherwise>
				<img class="profile-pic-round pic-border" height="40"
					src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrgTTV3ncyk_ArHQftXJkKB4Jek24P9_sf4T7KQq_XKmVd50PGgwqaFVZJheRJSZCQ-fk&usqp=CAU"
					alt="example picture">
			</c:otherwise>
		</c:choose>
		<span><sec:authentication property="principal.username" /></span>
	</div>
</div>