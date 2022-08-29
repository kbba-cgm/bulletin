<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="post-list-div">
	<div class="post-list-header">
		<div class="flex-box justify-content-between align-items-center">
			<div class="page-title">Post list</div>
		</div>
	</div>
	<div class="post-list-table">
		<table class="table">
			<thead>
				<tr>
					<th>No.</th>
					<th>Title</th>
					<th>Content</th>
					<th>Publish</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty posts}">
						<c:forEach var="post" items="${posts}">
							<tr>
								<td>${ post.id }</td>
								<td>${ post.title }</td>
								<td>
								<c:choose>
									<c:when test="${ post.content.length() > 100 }">
										<c:out value="${fn:substring(post.content, 0, 99)}..." />							
									</c:when>
									<c:otherwise>
										${ post.content }
									</c:otherwise>
								</c:choose>
								</td>

								<td><c:choose>
										<c:when test="${ post.is_published }">
											yes
										</c:when>
										<c:otherwise>
											no
										</c:otherwise>
									</c:choose></td>
								<td>
									<div class="flex-box">
										<a class="action_icon detail"
											href="${pageContext.request.contextPath}/post/${post.id}">
											<i class="fa-solid fa-circle-info"></i></a> 
										<a class="action_icon edit"
											href="${pageContext.request.contextPath}/post/${post.id}/edit"><i
											class="fa-solid fa-pen-to-square"></i></a>
										<div class="action_icon delete" >
											<form action="${pageContext.request.contextPath}/post/${post.id}/delete" method="post">
												<sec:csrfInput />
												<button><i class="fa-solid fa-trash"></i></button>											
											</form>										
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr class="empty-board">
							<td colspan="5">No post on board.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>