$(function() {
	
	//Logout
	$(".logout").click(function() {
		
			$.ajax({
				type: "GET",
				contentType: "application/json",
				url: "http://localhost:8080/Java_Advanced_05/logout",
				success: function(data){
					if(data.url) {
						window.location = data.url;
					} else {

					}
				}
			});

		})

});
	

