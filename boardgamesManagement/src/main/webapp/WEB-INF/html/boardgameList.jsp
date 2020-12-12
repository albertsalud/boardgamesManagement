<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Boardgames list</title>
</head>
<body>
	<h1>Boardgames list</h1>
	<c:if test="${boardgames != null}">
		<table>
			<tr>
				<th>Name</th>
				<th>Description</th>
			</tr>
			<c:forEach items="${boardgames}" var="currentBoardgame">
				<tr>
					<td>${currentBoardgame.name}</td>
					<td>${currentBoardgame.description}</td>
					<td>
						<a href="/boardgames/${currentBoardgame.id}">&gt; Edit</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>