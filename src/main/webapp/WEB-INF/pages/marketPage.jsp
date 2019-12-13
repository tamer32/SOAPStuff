<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tf:layout>
	<body>
		<div class="d-inline-flex justify-content-start">
			<table  class="table table-hover table-striped table-dark">
				<tr>
					<th>Item name</th>
					<th colspan="3">attributes</th>
				</tr>
				<c:forEach items="${marketItems}" var="item" varStatus="status">
					<tr>
						<td>${item.name}</td>
						<td>STR:${item.strenght}</td>
						<td>AGI:${item.agility}</td>
						<td>INT:${item.intelect}</td>
					</tr>
				</c:forEach>
				<tr>
				<td style="width: 100%;" colspan="4">
				<a id="back"  href="" class="btn btn-primary btn-lg" style="width: 100%;" id="backToCharacterScreen"> Back</a>
				</td>
				</tr>
			</table>
		</div>
		<script>
		const backBtn = document.getElementById('back');
		const href = window.location.href.split("/")[4];
		backBtn.href = "/userInfo/" + href;
		</script>
		
	</body>
</tf:layout>
