<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="post-list-div">
	<div class="post-list-header">
		<div class="flex-box justify-content-between align-items-center">
			<h2 class="main-title">Category list</h2>
			<div>
				<div class="action-button button">
					<a
						href="${ pageContext.request.contextPath }/admin/category/create">Create
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
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${ not empty categories }">
						<c:forEach items="${ categories }" var="category">
							<tr>
								<td>${ category.id }</td>
								<td>${ category.name }</td>
								<td class="flex-box align-item-center">
									<a class="action_icon edit" href="${pageContext.request.contextPath}/admin/category/${category.id}/edit">
										<i class="fa-solid fa-pen-to-square"></i>
									</a>
									<form action="${pageContext.request.contextPath}/admin/category/${ category.id }/delete"
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
							<td colspan="3">No category.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>