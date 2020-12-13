<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Boardgames list</title>
<script type="text/javascript">
function askForDeleteBoardgame(){
	return confirm("The selected boardgame will be deleted. Continue?");
}

</script>
</head>
<body>
	<h1>Boardgames list</h1>
	<p>
		<a href="/boardgames/new">&gt; Add a new boardgame</a>
	</p>
	<c:if test="${boardgames != null}">
		<table>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${boardgames}" var="currentBoardgame">
				<tr>
					<td>${currentBoardgame.name}</td>
					<td>${currentBoardgame.description}</td>
					<td>
						<a href="/boardgames/${currentBoardgame.id}">&gt; Edit</a>
						<a href="/boardgames/delete?boardgameId=${currentBoardgame.id}" onclick="return askForDeleteBoardgame();">&gt; Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>