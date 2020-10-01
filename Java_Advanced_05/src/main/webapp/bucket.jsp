<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	
	<!-- style -->
	<link rel="stylesheet" href="css/mainPage.css">
	
	<!-- Bootstrap 3.3.0 -->
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	
	
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container" style="margin-top: 40px;">
		<input class="form-control mb-4" id="tableSearch" type="text"
			placeholder="Type something to search list items" style="width: 350px; margin: 5px;">

		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody id="myTable">
				<tr>
					<td>Name</td>
					<td>Description</td>
					<td>Price</td>
					<td>Date</td>
					<td><button onclick="oi()" id="delete" name="delete" bucketId="">Delete</button></td>
				</tr>
			</tbody>
		</table>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

			<script src="js/bucket.js"></script></body>
</html>