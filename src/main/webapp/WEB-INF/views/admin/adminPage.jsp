<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>${sessionScope.admin.name.firstName}'s Home Page</title>
</head>
<body>
	<jsp:include page='../fragments/header.jsp' />
	<h5>
		<a href='<spring:url value="/candidate/register"/>'>New Candidate
			registration</a>
	</h5>
	<h5>
		<a href='<spring:url value="/party/register"/>'>New Party
			registration</a>
	</h5>
	<h5>
		<a href='<spring:url value="/admin/logout"/>'>Logout</a>
	</h5>
	<form method="post" action="<spring:url value="/party/partyDetails/1"/>">
		<input type="submit" value="Search Party">
	</form>
	<span>${entity} registered</span>
</body>
</html>