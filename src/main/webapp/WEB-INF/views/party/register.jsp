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
<title>Register new party</title>
</head>
<body>
	<jsp:include page="../fragments/header.jsp" />
	<div class="container">

		<div class="row">
			<h1>Resource</h1>
		</div>
		<form:form modelAttribute="partyDTO" method="post" >
			<div class="row">

				<div class="form-group">
					<form:label path="partyName">Name</form:label>
					<form:input path="partyName" id="partyName"
						cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="agenda">Agenda</form:label>
					<form:input path="agenda" id="agenda"
						cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="partyDescription.description">Description</form:label>
					<form:textarea path="partyDescription.description" id="partyDescription"
						cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="email">Email</form:label>
					<form:input path="email" type="email" id="email"
						cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="officeAddress.street">street</form:label>
					<form:input path="officeAddress.street" id="street"
						cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="officeAddress.city">city</form:label>
					<form:input path="officeAddress.city" id="city"
						cssClass="form-control" />
				</div><div class="form-group">
					<form:label path="officeAddress.state">state</form:label>
					<form:input path="officeAddress.state" id="state"
						cssClass="form-control" />
				</div><div class="form-group">
					<form:label path="officeAddress.country">country</form:label>
					<form:input path="officeAddress.country" id="country"
						cssClass="form-control" />
				</div></div><div class="form-group">
					<form:label path="officeAddress.pincode">pincode</form:label>
					<form:input path="officeAddress.pincode" id="pincode"
						cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="contactNumber.phoneNumber">Phone Number</form:label>
					<form:input path="contactNumber.phoneNumber" id="phoneNumber"
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