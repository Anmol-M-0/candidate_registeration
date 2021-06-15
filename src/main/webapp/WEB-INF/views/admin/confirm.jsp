<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation page</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="../fragments/header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<h2>Please review the following information</h2>
			<div class="form-group">
				<label for="name">Name</label> <span>${dto.name.fullName}</span>
			</div>
			<div class="form-group">
				<label for="email">Email</label> <span>${dto.email}</span>
			</div>
			<div class="form-group">
				<label for="phoneNumber">Phone Number</label> <span>${dto.phoneNumber.phoneNumber}</span>
			</div>
			<a href='<spring:url value="/admin/signUp"/>' class="btn btn-default">Edit</a>
			<a href='<spring:url value="/admin/save"/>'
				class="btn btn-default">Save</a>
		</div>
	</div>


</body>
</html>