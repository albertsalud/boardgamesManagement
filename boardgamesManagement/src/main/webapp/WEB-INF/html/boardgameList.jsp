<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp" />
<script type="text/javascript">
function askForDeleteBoardgame(){
	return confirm("The selected boardgame will be deleted. Continue?");
}
</script>
<body>
	<div id="header">
		<c:import url="${applicationScope.webURL}/menu.html" />
	</div>
	<div id="content-wrapper">
		<div id="content" class="admin">
			<h1>Boardgames list</h1>
			<p>
				<a href="/boardgames/new">&gt; Add a new boardgame</a>
			</p>
			<p>
				<a href="/boardgames/owners">&gt; Manage owners</a>
			</p>
			<c:if test="${boardgames != null}">
				<table id="data-table" cellpadding="5" cellspacing="0">
					<thead>
					<tr>
						<th>Name</th>
						<th>Description</th>
						<th>&nbsp;</th>
					</tr>
					</thead>
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
			<c:import url="logout.jsp" />
		</div>
	</div>
	<script type="text/javascript">
	$("#data-table").fancyTable({
		  sortColumn:0,// column number for initial sorting
		  sortOrder:'asc',// 'desc', 'descending', 'asc', 'ascending', -1 (descending) and 1 (ascending)
		  sortable:true,
		  pagination:true,// default: false
		  pagClosest: 3,
		  perPage: 10,
		  globalSearchExcludeColumns:[2],
		  paginationClass:"boton",
		  paginationClassActive:"boton-invertido"
		});

	</script>
</body>
</html>