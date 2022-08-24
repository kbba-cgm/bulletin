<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="main-content">
	<c:choose>
		<c:when test="${not empty posts}">
			<div class="card-grid">
				<c:forEach var="post" items="${posts}">
					<div class="card">
						<div class="card-content">
							<div class="card-title">
								<div class="post-category">
									<span>#category</span> <span>#category</span>
								</div>
								<div class="post-title"><a href="${pageContext.request.contextPath}/post/${post.id}">${ post.title }</a></div>
								<div class="post-date">${ post.updated_at.toLocaleString() }</div>
							</div>
							<div class="card-body">
								<div class="post-body">
								<c:choose>
									<c:when test="${ post.content.length() > 200 }">
										<c:out value="${fn:substring(post.content, 0, 199)}..." />		
									</c:when>
									<c:otherwise>
										${ post.content }
									</c:otherwise>
								</c:choose>
								</div>
							</div>
							<div class="card-footer">
								<div class="author">
									<div class="side-bar-account">
										<img class="profile-pic-round" height="30"
											src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrgTTV3ncyk_ArHQftXJkKB4Jek24P9_sf4T7KQq_XKmVd50PGgwqaFVZJheRJSZCQ-fk&usqp=CAU"
											alt="example picture">
										<div>Kyaw Bo Bo Aung</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:when>
		<c:otherwise>
			<div class="empty-board">No post on board.</div>
		</c:otherwise>
	</c:choose>
</div>