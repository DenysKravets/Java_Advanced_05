$(function() {
	
	//Display available products
	var products = null;
	
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "http://localhost:8080/Java_Advanced_05/product",
		success: function(data){
			products = data;
		}
	}).done(function() {
		
		productContainer = "";
		
		jQuery.each(products, function(i, value) {
			
			productContainer += "<div class='productContainer'>"
				+ "<div class='name'>"
					+ "<h4>Name:</h4>"
					+ "<label>" + value.name + "</label>"
				+ "</div>"
				+ "<div class='description'>"
					+ "<h4>Description:</h4>"
					+ "<label>" + value.description + "</label>"
				+ "</div>"
				+ "<div class='price'>"
					+"<h4>Price:</h4>"
					+ "<label>" + value.price + "</label>"
				+ "</div>"
					+ "<div class='viewProduct'><a href='productManager?id=" + value.id + "'>View product</a></div>"
			+ "</div>";
			
		});
		
		$(".container div.subContainer").html(productContainer);
		
	});
	
	//

});

