<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li><a href="${pageContext.request.contextPath}/perfil">Back</a></li>
	</ul>
	<ul>
		<li><a href="${pageContext.request.contextPath}/admin/upload">Movie Upload</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/tag/">Create Tag</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/movie/">Set Movie Tag</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/listMovies">Edit Movie</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/addAdmin">Edit Super Admin Powers</a></li>
	</ul>
</body>
</html>