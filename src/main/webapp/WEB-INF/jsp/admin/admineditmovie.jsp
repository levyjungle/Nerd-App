<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li><a href="${pageContext.request.contextPath}/admin/listMovies">Back</a></li>
	</ul>
	<form action="${pageContext.request.contextPath}/video/editFile" method="post">
		<input type="hidden" name="code" value="${media.code}">
		<input type="text" name="name" value="${media.name}">
		<textarea rows="3" cols="30" name="synopsis">${media.synopsis}</textarea>
		<input type="submit" value="Atualizar">
	</form>
	
	<center>
		<h1>${media.name}</h1>
		<video width="50%" height="500px" controls preload="none">
			<source src="${media.urlVideo}" type="${media.mediaVideoType}">
		</video>
		<br>
		<article>${media.synopsis}</article>
		<c:forEach items="${comment}" var="comment">
			<h3>${comment.person.name}</h3>
			<article>${comment.comment}</article>
			<article>${comment.datetime }</article>
			<a href="${pageContext.request.contextPath}/video/delete/${comment.code}/${media.code}">Apagar</a>
		</c:forEach>
	</center>
</body>
</html>