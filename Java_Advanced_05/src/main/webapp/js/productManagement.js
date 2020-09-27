$(function() {

	//Send product
	$("#login-submit").click(function() {

		var name = $("#login-form #name").val();
		var description = $("#login-form #description").val();
		var price = $("#login-form #price").val();

		var productData = {
			name: name,
			description: description,
			price: price
		};

		$.ajax({
			type : "POST",
			data : JSON.stringify(productData),
			contentType : "application/json",
			url : "http://localhost:8080/Java_Advanced_05/productManager",
			success : function(data) {
				if (data == "Success") {
					$("form")[0].reset();
					console.log("It just works");
				}
			}
		});

	});

});
