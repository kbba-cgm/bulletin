<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authentication property="principal.photo" var="photo"/>
<div class="post-list-div">
	<div class="post-list-header">
		<div class="flex-box justify-content-between align-items-center">
			<div class="page-title">Profile Detail</div>
		</div>
	</div>
	<div class="card">
		<div class="card-content">
			<div class="flex-box">
				<div>
				<c:choose>
					<c:when test="${ not empty photo }">
						<img class="side-bar-pic" height="100"
							src="<c:url value='${ photo }'/>" 
							alt="example picture">					
					</c:when>
					<c:otherwise>
						<img class="side-bar-pic" height="100"
							src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrgTTV3ncyk_ArHQftXJkKB4Jek24P9_sf4T7KQq_XKmVd50PGgwqaFVZJheRJSZCQ-fk&usqp=CAU"
							alt="example picture">					
					</c:otherwise>
				</c:choose>
				</div>
				<div class="form-group">
					<h2><sec:authentication property="principal.username" /></h2>
					<div><sec:authentication property="principal.email" /></div>
					<div>Role: <sec:authentication property="principal.role.name" /></div>
					<div>
						<a class="button action-button" href="${ pageContext.request.contextPath }/profile/edit">
							Edit
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>