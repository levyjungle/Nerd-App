<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<h1>${message}</h1>
	<form action="${pageContext.request.contextPath}/admin/searchPersonEmailAdmin" method="post">
		<input type="text" name="email" placeholder="email">
		<input type="submit" value="Search">
	</form>
		<c:if test="${result != null }">
			<h2>${result.code}</h2>
			<h2>${result.name}</h2>
			<h2>${result.profile.email}</h2>
			<c:choose>
				<c:when test="${result.admin == 1}">
					<td><a href="${pageContext.request.contextPath}/admin/addPowerOrRemove/${result.code}">Remove</a></td>
				</c:when>
				<c:otherwise>
					<td><a href="${pageContext.request.contextPath}/admin/addPowerOrRemove/${result.code}">With great power comes great responsibility</a></td>
				</c:otherwise>
			</c:choose>
		</c:if>
	<table>
		<th>Code</th>
		<th>Name</th>
		<th>Email</th>
		<th>Delete</th>
		<th>AdminPower</th>
		<c:forEach items="${person}" var="person">
			<tr>
				<td>${person.code}</td>
				<td>${person.name}</td>
				<td>${person.profile.email}</td>
				<td><a href="${pageContext.request.contextPath}/admin/adminDeletePerson/${person.code}">Delete This User</a></td>
				<c:choose>
					<c:when test="${person.admin == 1}">
						<td><a href="${pageContext.request.contextPath}/admin/addPowerOrRemove/${person.code}">Remove</a></td>
					</c:when>
					<c:otherwise>
						<td><a href="${pageContext.request.contextPath}/admin/addPowerOrRemove/${person.code}">With great power comes great responsibility</a></td>
					</c:otherwise>
				</c:choose>
				</c:forEach>
			</tr>
	</table>
</body>
</html>