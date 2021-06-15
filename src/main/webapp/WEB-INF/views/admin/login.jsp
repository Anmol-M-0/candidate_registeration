<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>login page</title>
</head>
<body>
<div>
<%-- <form method="post">

<label for="email" value="Email">
<input type="email" id="email" name="email" placeholder="Enter your email"/><br/>
<label for="password" value="Password"/>
<input type="password" id="password" name="password" placeholder="Input password"><br/>
<input type="submit" value="Login"> 
</form> --%>
<jsp:include page="../fragments/header.jsp"/>
<form:form modelAttribute="loginDTO" method="post">
<form:label path="email">Email</form:label>
<form:input path="email" type="email"/><br>
<form:label path="password">Password</form:label>
<form:input path="password" type="password"/><br>
<input type="submit" value="login"/>
</form:form>
</div>
</body>
</html>