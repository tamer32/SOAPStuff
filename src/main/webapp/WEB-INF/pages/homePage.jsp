<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tf:layout>
	<p>
		<a href="${pageContext.servletContext.contextPath}/loginPage">Login</a>
	</p>
	<p>
		<a href="${pageContext.servletContext.contextPath}/registerPage">Register</a>
	</p>
</tf:layout>