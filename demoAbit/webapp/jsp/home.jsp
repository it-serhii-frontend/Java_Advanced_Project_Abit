<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Welcome</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>
	<div class="container">

		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 25%">
			<h3 class="w3-bar-item">Menu</h3>
			<a href="/home" class="w3-bar-item w3-button">Home</a>
		</div>

		<div style="margin-left: 25%">

			<div class="w3-container w3-teal">
				<h1>Entrants</h1>
			</div>

			<div class="w3-container">

				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
					<h2>
						Welcome ${pageContext.request.userPrincipal.name} <a
							onclick="document.forms['logoutForm'].submit()">Logout</a>
					</h2>

				</c:if>


				<c:if test="${not empty entrants}">

					<c:forEach items="${entrants}" var="currentEntrant">


						<div class="w3-card-4" style="width: 50%">
							<header class="w3-container w3-light-grey">
								<h3>${currentEntrant.name}</h3>
							</header>
							<div class="w3-container">
								<p>Entrant</p>
								<hr>
								<img src="https://travel-up.com.ua/uploads/media/deafult-profile-pitcher.png"
									alt="Avatar" class="w3-left w3-circle w3-margin-right"
									style="width: 60px">
								<p>${currentEntrant.firstName}</p>
								<p>${currentEntrant.lastName}</p>
								<p>${currentEntrant.faculty}</p>

								<br>
							</div>
							<button class="w3-button w3-block w3-dark-grey">add new</button>
						</div>

					</c:forEach>
				</c:if>

			</div>

		</div>


	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>


</body>
</html>