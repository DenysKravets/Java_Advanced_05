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
				<div class="name">
					<h4>Name:</h4>
					<label>${name}</label>
				</div>
				<div class="description">
					<h4>Description:</h4>
					<label>${description}</label>
				</div>
				<div class="price">
					<h4>Price:</h4>
					<label>${price}</label>
				</div>
				<button name="purchaseProduct" class="purchaseProduct" data-toggle="modal" data-target="#exampleModal">Add
					to cart</button>
			</div>
		</div>
	</div>

	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Confirm purchase</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">If you don't want to add this product to your bucket press Close</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button id="addToBucket" type="button" product-id="${id}" class="btn btn-primary" data-dismiss="modal">Add to bucket</button>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

			<script src="js/singleProduct.js"></script></body>
</html>