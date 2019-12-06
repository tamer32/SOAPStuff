<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<tf:layout>
	<form enctype="application/json" id="loginForm">	
		Enter your name Hero:<input class="form-group mx-sm-3 mb-2" id="username" />
	</form>
	<input type="button" value="Character Screen" onclick="login()" />
	<script>
		function login() {
			let username= document.getElementById("username").value;
			$.ajax({
				type : "POST",
				url : "/CRUDAppTheSecound/loginUser?username="+username,				
				success : function loginSuccess(response) {
					window.alert(response.id);
					var Http = new XMLHttpRequest();
					Http.open("GET", "/CRUDAppTheSecound/userInfo");
					Http.send();
					window.location.replace("/CRUDAppTheSecound/userInfo");
				}
			});
		}
		function submit() {
			document.getElementById("loginForm").submit();
		}
	</script>
</tf:layout>