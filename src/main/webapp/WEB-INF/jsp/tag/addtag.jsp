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
	
	<form action="${pageContext.request.contextPath}/admin/tag/insertTag" method="post">
		<input type="text" name="tagName" placeholder="Nome da Tag">
		<input type="submit" placeholder="Submit">
	</form>
	<br>
	<form action="${pageContext.request.contextPath}/admin/tag/searchTag" method="post">
		<input type="text" name="tagName" placeholder="buscarTag">
		<input type="submit" placeholder="Submit">
	</form>
	
	<div>
		<c:forEach items="${result}" var="tag">
			<article><b>${tag.tagName}</b> have codigo like <b>${tag.code}</b></article>
		</c:forEach>
	</div>
	<br>
	<table>
		<th>TagCode</th>
		<th>TagName</th>
		<c:forEach items="${tag}" var="tag">
			<tr>							
				<td>${tag.code}</td>
				<td>${tag.tagName}
				<td><a href="${pageContext.request.contextPath}/admin/tag/removeTag/${tag.code}">Remove</a></td>		
			</tr>
		</c:forEach>
	</table>
</body>
</html>