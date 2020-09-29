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

	<div class="container">
		<div class="subContainer">
			<div class="productContainer">
				<h3>Product</h3>
				<div class="name">
					<h4>Name:</h4>
					<label>Carrot</label>
				</div>
				<div class="description">
					<h4>Description:</h4>
					<label>It is good for your health boi!</label>
				</div>
				<div class="price">
					<h4>Price:</h4>
					<label>1032$</label>
				</div>
				<button name="purchaseProduct" class="purchaseProduct">Add
					to cart</button>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

			<script src="js/mainPage.js"></script></body>
</html>