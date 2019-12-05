<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tf:layout>

	<div class="d-inline-flex justify-content-start">
		<table class="table table-hover table-striped table-dark">
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Class</th>
				<th scope="col">Strenght</th>
				<th scope="col">Agility</th>
				<th scope="col">Intelect</th>
			</tr>
			<tr>
				<td id="username">${playerInfo.username}</td>
				<td id="class">${playerInfo.playerClass}</td>
				<c:forEach items="${playerInfo.playerAttributes}" var="playerStats"
					varStatus="status">
					<td>${playerStats.value}</td>
				</c:forEach>
				<form:form action="${pageContext.request.contextPath}/fightPage/${playerInfo.id}" modelAttribute="playerInfo" 
					method="GET">
					<td><input type="submit" value="Let's Fight!"
						class="btn btn-light"></td>
				</form:form>
				<form:form action="${pageContext.request.contextPath}/modifyPage/${playerInfo.id}" modelAttribute="playerUsername"
					method="GET" >
					<td><input type="submit" value="Rename" class="btn btn-light" id="modifyButton"></td>
				</form:form>
			</tr>
			<tr>
				<td>Experience</td>
				<td colspan="5"><div class="progress">
						<div class="progress-bar" role="progressbar"
							aria-valuenow="${playerInfo.exp}" aria-valuemin="0"
							aria-valuemax="10" style="width:${playerInfo.exp}%">${playerInfo.exp}</div>
					</div></td>
			</tr>
		</table>
	</div>
</tf:layout>