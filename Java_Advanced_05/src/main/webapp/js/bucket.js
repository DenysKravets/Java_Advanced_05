$(document).ready(function(){
	
	// Filter table
  $("#tableSearch").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
  

	

  	//Display selected products
	var buckets = null;

	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "http://localhost:8080/Java_Advanced_05/bucket",
		success: function(data){
			buckets = data;
		}
	}).done(function() {
		
		console.log(buckets);
		
		productContainer = "";
		
		jQuery.each(buckets, function(i, value) {
			
			productContainer += "<tr>"
					+ "<td>" + value.name + "</td>"
					+ "<td>" + value.description + "</td>"
					+ "<td>" + value.price + "</td>"
					+ "<td>" + value.purchaseDate.date.year + "-" + value.purchaseDate.date.month + "-" + value.purchaseDate.date.day + "</td>"
					+ "<td><button onclick='deleteBucket(this)' class='delete' name='delete' bucketId='" + value.bucketId + "'>Delete</button></td>"
				+ "</tr>"
			
		});
		
		$("#myTable").html(productContainer);
		
	});
	
  
});

//Delete bucket
function deleteBucket(button) {
	
	$.ajax({
		type: "DELETE",
		url: "http://localhost:8080/Java_Advanced_05/bucket?id=" + button.getAttribute("bucketid"),
		success: function(){
			window.location.reload();
		}
	});
	
}

