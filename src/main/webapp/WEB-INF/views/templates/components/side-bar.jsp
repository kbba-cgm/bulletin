<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sec:authentication property="principal.photo" var="photo"/>
<div class="side-bar-position">
	<div class="side-bar-content">
		<div class="side-bar-list">
			<a href="${ pageContext.request.contextPath }/profile/detail">
				<div class="side-bar-account">
					<c:choose>
						<c:when test="${ not empty photo }">
							<img class="side-bar-pic" height="30"
							src="${ photo }"
							alt="example picture">
						</c:when>
						<c:otherwise>
							<img class="side-bar-pic" height="30"
							src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrgTTV3ncyk_ArHQftXJkKB4Jek24P9_sf4T7KQq_XKmVd50PGgwqaFVZJheRJSZCQ-fk&usqp=CAU"
							alt="example picture">
						</c:otherwise>
					</c:choose>
					<div><sec:authentication property="principal.username" /></div>
				</div>
			</a>
		</div>
		<a href="${pageContext.request.contextPath}/post/create">
			<div class="button action-button side-bar-action-btn">Create Post</div>
		</a>
		<a href="${pageContext.request.contextPath}">
			<div class="side-bar-list">Home</div>
		</a>
		<a href="${pageContext.request.contextPath}/post/all">
			<div class="side-bar-list">My Posts</div>
		</a>
		<hr>
		<form action="${pageContext.request.contextPath}/logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<input type="submit" value="Logout" class="side-bar-list button side-bar-action-btn side-bar-logout" />
		</form>
	</div>
</div>
