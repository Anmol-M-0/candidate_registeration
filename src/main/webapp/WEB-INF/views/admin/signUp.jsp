<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Signup new Admin</title>
</head>
<body>
	<jsp:include page="../fragments/header.jsp" />
	<div class="container">

		<div class="row">
			<h1>Resource</h1>
		</div>
		<spring:url value="/admin/confirm" var="formURL" />
		<form:form modelAttribute="signUpDTO" method="post" url="${formURL}">
			<div class="row">

				<div class="form-group">
					<form:label path="name.firstName">First Name</form:label>
					<form:input path="name.firstName" id="firstname"
						cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="name.middleName">Middle name</form:label>
					<form:input path="name.middleName" id="middleName"
						cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="name.lastName">Last Name</form:label>
					<form:input path="name.lastName" id="lastName"
						cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="email">Email</form:label>
					<form:input path="email" type="email" id="email"
						cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="password">Password</form:label>
					<form:input path="password" type="password" id="password"
						cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="phoneNumber.phoneNumber">Phone Number</form:label>
					<form:input path="phoneNumber.phoneNumber" id="phoneNumber"
						cssClass="form-control" />
				</div>
				<div class="form-group">
					<input type="submit" value="Submit" class="btn btn-default" />
				</div>
			</div>

		</form:form>
	</div>
</body>
</html>