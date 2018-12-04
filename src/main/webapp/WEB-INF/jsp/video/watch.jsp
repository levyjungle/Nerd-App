<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nerdzonia</title>
</head>
<body>
	<ul>
		<li><a href="${pageContext.request.contextPath}/index">Voltar</a></li>
	</ul>
	<center>
		<h1>${media.name}</h1>
		<video width="50%" height="500px" controls preload="none">
			<source src="${media.urlVideo}" type="${media.mediaVideoType}">
		</video>
		<article>${media.synopsis}</article>
		<article>${media.datetime}</article>
		<div>
			<form action="${pageContext.request.contextPath}/video/videoComment" method="post">
				<input type="hidden" name="videoCode" value="${media.code}">
				<textarea rows="3" cols="100" name="message"></textarea>
				<input type="submit" value="Enviar"/>
			</form>
		</div>
		<c:forEach items="${comment}" var="comment">
			<h3>${comment.person.name}</h3>
			<article>${comment.comment}</article>
			<article>${comment.datetime }</article>
			<c:if test="${comment.person.code == userSession.person.code}">
			<a href="${pageContext.request.contextPath}/video/delete/${comment.code}/${media.code}">Apagar</a>
			</c:if>
		</c:forEach>
	</center>
</body>
</html>