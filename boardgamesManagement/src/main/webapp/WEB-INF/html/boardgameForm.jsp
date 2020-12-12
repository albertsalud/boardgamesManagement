<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Boardgame form</title>
</head>
<body>
	<h1>Boardgame form</h1>
	<form:form modelAttribute="boardgame">
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
				<td colspan="2">
					<input type="submit" value="Save" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>