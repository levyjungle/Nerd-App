<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<th>Nome</th>
		<c:forEach items="${media}" var="media">
			<tr>
				<td>${media.name}</td>
				<td><a href="${pageContext.request.contextPath}/video/assistir/${media.code}">Assistir</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>