<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<div class="form-div">
	<div class="form-header">
		<div class="page-title post-detail-title">${ postDto.title }</div>
	</div>
	<div class="form-wrapper">
		<div class="post-detail-content">${ postDto.content }</div>
		<div class="post-detail-date">${ postDto.updated_at.toLocaleString() }</div>
	</div>
</div>