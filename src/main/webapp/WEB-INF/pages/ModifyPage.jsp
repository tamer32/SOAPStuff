<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<tf:layout>
	<form:form action="${pageContext.request.contextPath}/modifyPage/${playerInfo.id}" modelAttribute="playerInfo"
		method="POST">
		
		Rename your character:<form:input path="username"
			class="form-group mx-sm-3 mb-2" />
			<input type="submit" value="Rename" id="renameButton">
		<form:errors path="username" />
	</form:form>
</tf:layout>
