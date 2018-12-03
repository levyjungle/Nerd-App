<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
</head>
<body>
	<h1>${media.name}</h1>
	<h2>Media Tags</h2>
	<c:forEach items="${mediaTag}" var="mediaTag">
		<p>Remove: <a href="#">${mediaTag.tag.nameTag}</a></p>
	</c:forEach>
	<h3>Tag List</h2>
	<c:forEach items="${tag}" var="tag">
		<p>Add: <a href="#">${tag.tagName}</a></p>
	</c:forEach>
</body>
</html>