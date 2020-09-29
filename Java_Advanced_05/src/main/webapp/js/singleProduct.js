$(function() {
	

		//Registration
	$("#addToBucket").click(function() {

		var productId = $("#addToBucket").attr("product-id");

		$.ajax({
			type : "POST",
			data : JSON.stringify({productId: productId}),
			contentType : "application/json",
			url : "http://localhost:8080/Java_Advanced_05/bucketManager",
			success : function(data) {
				alert("Success");
			}
		});

	});

});
