<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
</head>
<body>
	<ul>
		<li><a href="${pageContext.request.contextPath}/admin/">Back</a></li>
	</ul>
	<form action="${pageContext.request.contextPath}/admin/searchMediaByName" method="post">
		<input type="text" name="movieName">
		<input type="submit" placeholder="Submit">
	</form>
	<c:forEach items="${movie}" var="movie">
		<article><b>${movie.name}</b> | <a href="${pageContext.request.contextPath}/video/assistir/${movie.code}">Assistir</a> | <a href="${pageContext.request.contextPath }/admin/editar/${movie.code}">Editar</a></article>
	</c:forEach>
	<br>
	<table>
		<th>Enviado por</th>
		<th>Nome</th>
		<c:forEach items="${media}" var="media">
			<tr>
				<td>${media.person.name}</td>
				<td>${media.name}</td>
				<td><a href="${pageContext.request.contextPath}/video/assistir/${media.code}">Assistir</a></td>
				<td><a href="${pageContext.request.contextPath }/admin/editar/${media.code}">Editar</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>