<%@page import="com.albertsalud.bgmanagement.model.enums.BoardgameType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp" />
<style>
	td {
		vertical-align: top;
	}
</style>
<script type="text/javascript">
function addBoardgameType(){
	var selectedType = $("#boardgameTypes option:selected");
	console.log("selectedType", selectedType);
	
	$("#types").append(selectedType);
}
</script>
<body>
	<div id="header">
		<c:import url="${applicationScope.webURL}/menu.html" />
	</div>
	<div id="content-wrapper">
		<div id="content" class="admin">
			<div id="boardgame-image" style="float: right; max-width: 500px">
				<img style="width: 500px" alt="Boardgame image" src="${applicationScope.webURL}/uploaded/images/${boardgame.imageName}">
			</div>
			<h1>Boardgame form</h1>
			<p>
				<a href="/boardgames">&lt; Return to boardgames list</a>
			</p>
			<form:form modelAttribute="boardgame" action="/boardgames/save" method="post" enctype="multipart/form-data">
				<form:hidden path="id"/>
				<form:hidden path="imageName"/>
				<table>
					<tr>
						<td>Name:</td>
						<td colspan="2">
							<form:input path="name"/>
							<form:errors path="name" cssClass="error"/>
						</td>
					</tr>
					<tr>
						<td>Description:</td>
						<td colspan="2">
							<form:textarea path="description" maxlength="4000"/>
							<form:errors path="description" cssClass="error"/>
						</td>
					</tr>
					<tr>
						<td>Image file:</td>
						<td colspan="2">
							<input type="file" name="image" accept="image/png, image/jpeg" />
						</td>
					</tr>
					<tr>
						<td>Type:</td>
						<td>
							<form:select path="types" multiple="multiple" items="${boardgame.types}"/>
						</td>
						<td>
							<select id="boardgameTypes">
								<%
								for(BoardgameType currentType : BoardgameType.values()){
									%>
									<option value="<%=currentType.name() %>"><%=currentType.name() %></option>
									<%
								}
								%>
							</select>
							<button onclick="addBoardgameType(); return false;">Add new type</button>
						</td>
					</tr>
					<tr>
						<td>Ages (from - to):</td>
						<td>
							<form:input path="minAge"/>
							<form:errors path="minAge" cssClass="error"/>
						</td>
						<td>
							<form:input path="maxAge"/>
							<form:errors path="maxAge" cssClass="error"/>
						</td>
					</tr>
					<tr>
						<td>Players (min - max):</td>
						<td>
							<form:input path="minPlayers"/>
							<form:errors path="minPlayers" cssClass="error"/>
						</td>
						<td>
							<form:input path="maxPlayers"/>
							<form:errors path="maxPlayers" cssClass="error"/>
						</td>
					</tr>
					<tr>
						<td>Time to play:</td>
						<td colspan="2">
							<form:input path="timeToPlay"/>
							<form:errors path="timeToPlay" cssClass="error"/>
						</td>
					</tr>
					<tr>
						<td>Owner:</td>
						<td colspan="2">
							<form:select path="owner" items="${ownersList}"  itemLabel="fullName">
								<form:option value="">- Set the boardgame owner -</form:option>
							</form:select>
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<input type="submit" value="Save" class="boton" />
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>	
</body>
</html>