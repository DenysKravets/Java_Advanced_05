<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	
	<!-- style -->
	<link rel="stylesheet" href="css/productManagement.css">
	
	<!-- Bootstrap 3.3.0 -->
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	
	
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="addProduct">
			<label>Add product</label>
			<form id="login-form" role="form" style="display: block;">
				<div class="form-group">
					<input type="text" name="name" id="name" tabindex="1"
						class="form-control" placeholder="Product Name" value="">
				</div>
				<div class="form-group">
					<textarea name="description" id="description" tabindex="2"
						class="form-control" placeholder="Enter product description"></textarea>
				</div>
				<div class="form-group">
					<input type="text" name="price" id="price" tabindex="2"
						class="form-control" placeholder="price">
				</div>
				
				<div class="form-group">
					<div class="row">
						<div class="col-sm-6 col-sm-offset-3">
							<input type="button" name="login-submit" id="login-submit"
								tabindex="4" class="form-control btn btn-login"
								value="Add product">
						</div>
					</div>
				</div>
				
			</form>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
	
	<script src="js/productManagement.js"></script>
	
</body>
</html>