<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>

<form action="/Java_Advanced_05/registration" method="post">
	Registration
	<br>
	<br>
	<label>First Name<input type="text" name="firstName"></label>
	<br>
	<label>Last Name<input type="text" name="lastName"></label>
	<br>
	<label>Email<input type="text" name="email"></label>
	<br>
	<label>Password<input type="text" name="password"></label>
	<br>
	<input type="submit" value="register">
	<br>
</form>

</body>
</html>