<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp" />
<body>
	<div id="header">
		<c:import url="http://daudecinc.tk/menu.html" />
	</div>
	<div id="content-wrapper">
		<div id="content" class="admin">
			<h1>Owners list</h1>
			<p>
				<a href="/boardgames/owners/new">&gt; Add a new owner</a>
			</p>
			<p>
				<a href="/boardgames">&lt; Return to boardgames list</a>
			</p>
			<c:if test="${owners != null}">
				<table id="data-table" cellpadding="5" cellspacing="0">
					<tr>
						<th>Surname</th>
						<th>Name</th>
						<th>E-mail</th>
						<th>Phone</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${owners}" var="currentOwner">
						<tr>
							<td>${currentOwner.surname1}</td>
							<td>${currentOwner.name}</td>
							<td>${currentOwner.email}</td>
							<td>${currentOwner.phone}</td>
							<td>
								<a href="/boardgames/owners/${currentOwner.id}">&gt; Edit</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<c:import url="logout.jsp" />
		</div>
	</div>
</body>
</html>