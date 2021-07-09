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
<body>
	<div id="header">
		<c:import url="http://daudecinc.tk/menu.html" />
	</div>
	<div id="content-wrapper">
		<div id="content" class="admin">
			<h1>Owner form</h1>
			<p>
				<a href="/boardgames/owners">&lt; Return to owners list</a>
			</p>
			<form:form modelAttribute="owner" action="save" method="post">
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
						<td>Surname 1:</td>
						<td>
							<form:input path="surname1"/>
							<form:errors path="surname1"/>
						</td>
					</tr>
					<tr>
						<td>Surname 2:</td>
						<td>
							<form:input path="surname2"/>
							<form:errors path="surname2"/>
						</td>
					</tr>
					<tr>
						<td>E-mail:</td>
						<td>
							<form:input path="email"/>
							<form:errors path="email"/>
						</td>
					</tr>
					<tr>
						<td>Phone:</td>
						<td>
							<form:input path="phone"/>
							<form:errors path="phone"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="Save" class="boton" />
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>	
</body>
</html>