<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="ErrorPage.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<tf:layout>
	<h2>Enter into a world of dangers and adventures!</h2>
	<form:form action="createUser" modelAttribute="playerInfoBean" method="POST">
		
		Enter your name Hero:<form:input path="username" class="form-group mx-sm-3 mb-2" id="username" />
		  
		<form:errors path="username"/>
		<br/>
		Choose your class:
		<form:radiobutton path="playerClass" value="Warrior"/> Warrior
		<form:radiobutton path="playerClass"  value="Bowman"/> Bowman
		<form:radiobutton path="playerClass"  value="Rogue" /> Rogue
		<form:radiobutton path="playerClass"  value="Sorcerer"/> Sorcerer<br>
		<form:errors path="playerClass"/>
		<input type="submit" value="Let's go on an adventure" class="btn btn-primary" name="indexSubmitButton">
	</form:form>
</tf:layout>