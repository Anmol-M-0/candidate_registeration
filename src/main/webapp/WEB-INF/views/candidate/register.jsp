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
<title>Register new Candidate</title>
</head>
<body>
	<jsp:include page="../fragments/header.jsp" />
	<div class="container">

		<div class="row">
			<h1>Candidate</h1>
		</div>
		<spring:url value="/candidate/confirm" var="formURL" />
		<form:form modelAttribute="cand" method="post" action="${formURL}">
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
				</div><div class="form-group">
					<form:label path="partyName">Party Name</form:label>
					<form:input path="partyName" id="partyName"
						cssClass="form-control" />
				</div>
				<!-- <input type="date">  -->
				<div class="form-group">
					<form:label path="dob">Date of birth</form:label>
					<form:input path="dob" type="date" id="dob"
						cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="email">Email</form:label>
					<form:input path="email" type="email" id="email"
						cssClass="form-control" />
				</div>
				
				<div class="form-group">
					<form:label path="address.street">street</form:label>
					<form:input path="address.street" id="street"
						cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="address.city">city</form:label>
					<form:input path="address.city" id="city"
						cssClass="form-control" />
				</div><div class="form-group">
					<form:label path="address.state">state</form:label>
					<form:input path="address.state" id="state"
						cssClass="form-control" />
				</div><div class="form-group">
					<form:label path="address.country">country</form:label>
					<form:input path="address.country" id="country"
						cssClass="form-control" />
				</div></div><div class="form-group">
					<form:label path="address.pincode">pin code</form:label>
					<form:input path="address.pincode" id="pincode"
						cssClass="form-control" />
				
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