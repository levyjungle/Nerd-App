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
	<table>
		<th>Name</th>
		<c:forEach items="${media}" var="media">
			<tr>
				<td>${media.name}</td>
				<td><a href="${pageContext.request.contextPath}/admin/movie/edit/${media.code}">EditTag</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>