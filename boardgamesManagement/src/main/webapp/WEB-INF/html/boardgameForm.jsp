<%@page import="com.albertsalud.bgmanagement.model.BoardgameType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Boardgame form</title>
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
	<form:form modelAttribute="boardgame" action="/boardgames/save">
		<form:hidden path="id"/>
		<table>
			<tr>
				<td>Name:</td>
				<td>
					<form:input path="name"/>
					<form:errors path="name"/>
				</td>
			</tr>
			<tr>
				<td>Description:</td>
				<td>
					<form:textarea path="description"/>
					<form:errors path="description"/>
				</td>
			</tr>
			<tr>
				<td>Image name:</td>
				<td>
					<form:input path="imageName"/>
					<form:errors path="imageName"/>
				</td>
			</tr>
			<tr>
				<td>Type:</td>
				<td>
					<form:select path="types" multiple="multiple" items="${boardgame.types}"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Save" />
				</td>
			</tr>
		</table>
	</form:form>
	<select id="boardgameTypes">
		<%
		for(BoardgameType currentType : BoardgameType.values()){
			%>
			<option value="<%=currentType.name() %>"><%=currentType.name() %></option>
			<%
		}
		%>
	</select>
	<button onclick="addBoardgameType()">Add</button>
</body>
</html>