<%@page import="com.albertsalud.bgmanagement.model.enums.BoardgameType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Boardgame form</title>
<style>
	td {
		vertical-align: top;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

function addBoardgameType(){
	var selectedType = $("#boardgameTypes option:selected");
	console.log("selectedType", selectedType);
	
	$("#types").append(selectedType);
}

</script>
</head>
<body>
	<h1>Boardgame form</h1>
	<p>
		<a href="/boardgames">&lt; Return to boardgames list</a>
	</p>
	<form:form modelAttribute="boardgame" action="/boardgames/save" method="post" enctype="multipart/form-data">
		<form:hidden path="id"/>
		<table>
			<tr>
				<td>Name:</td>
				<td colspan="2">
					<form:input path="name"/>
					<form:errors path="name"/>
				</td>
			</tr>
			<tr>
				<td>Description:</td>
				<td colspan="2">
					<form:textarea path="description"/>
					<form:errors path="description"/>
				</td>
			</tr>
			<tr>
				<td>Image file:</td>
				<td colspan="2">
					<input type="file" name="image" accept="image/png, image/jpeg" />
				</td>
			</tr>
			<tr>
				<td>Image:</td>
				<td colspan="2">
					<form:input path="imageName"/>
					<form:errors path="imageName"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<img alt="Boardgame image" src="http://daudecinc.tk/uploaded/images/${boardgame.imageName}">
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
					<form:errors path="minAge"/>
				</td>
				<td>
					<form:input path="maxAge"/>
					<form:errors path="maxAge"/>
				</td>
			</tr>
			<tr>
				<td>Players (min - max):</td>
				<td>
					<form:input path="minPlayers"/>
					<form:errors path="minPlayers"/>
				</td>
				<td>
					<form:input path="maxPlayers"/>
					<form:errors path="maxPlayers"/>
				</td>
			</tr>
			<tr>
				<td>Time to play:</td>
				<td colspan="2">
					<form:input path="timeToPlay"/>
					<form:errors path="timeToPlay"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="Save" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>