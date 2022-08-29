<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/admin.css" />" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>

<title><tiles:insertAttribute name="title" /></title>
</head>
<body>
	<div>
		<tiles:insertAttribute name="header" />
	</div>
	<div class="layout">
		<div class="side-bar">
			<tiles:insertAttribute name="sideBar" />
		</div>
		<div class="main">
			<tiles:insertAttribute name="body" />
		</div>
	</div>

	<script src=<c:url value='/resources/js/admin.js'/>></script>
</body>
</html>