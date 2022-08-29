<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="post-list-div">
	<div class="post-list-header">
		<div class="flex-box justify-content-between align-items-center">
			<h2 class="main-title">User list</h2>
			<div>
				<div class="action-button button">
					<a
						href="${ pageContext.request.contextPath }/admin/user/create">Create
						New</a>
				</div>
			</div>
		</div>
	</div>
	<div class="list-table">
		<table class="table">
			<thead>
				<tr>
					<th>No.</th>
					<th>Name</th>
					<th>Email</th>
					<th>Roles</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${ not empty users }">
						<c:forEach items="${ users }" var="user">
							<tr>
								<td>${ user.id }</td>
								<td>${ user.name }</td>
								<td>${ user.email }</td>
								<td>${ user.role.name }</td>
								<td class="flex-box align-item-center">
									<a class="action_icon edit" href="${pageContext.request.contextPath}/admin/user/${user.id}/edit">
										<i class="fa-solid fa-pen-to-square"></i>
									</a>
									<form action="${pageContext.request.contextPath}/admin/user/${ user.id }/delete"
										method="post">
										<button class="action_icon delete">
											<i class="fa-solid fa-trash"></i>
										</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="5">No User.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>