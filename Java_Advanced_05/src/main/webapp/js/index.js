$(function() {
	
	//Bootstrap login template
	function toLogin() {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$('#login-form-link').addClass('active');
	}
	
	function toRegister() {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$('#register-form-link').addClass('active');
	}
	
    $('#login-form-link').click(toLogin);
	$('#register-form-link').click(toRegister);
	
	//Registration
	$("#register-submit").click(function() {
		
		var firstName = $("#register-form #firstName").val();
		var lastName = $("#register-form #lastName").val();
		var email = $("#register-form #email").val();
		var password = $("#register-form #password").val();
		var confirmPassword = $("#register-form #confirmPassword").val();
		
		if (firstName == '' || lastName == '' || email == ''
			|| password == '' || confirmPassword == '') {
			alert("Please fill all fields...!!!!!!");
		} else if ((password.length) < 1) {
			alert("Password should atleast 1 character in length...!!!!!!");
		} else if (!(password).match(confirmPassword)) {
			alert("Your passwords don't match. Try again?");
		} else {
			
			var userData = {
				firstName: firstName,
				lastName: lastName,
				email: email,
				password: password,
				confirmPassword: confirmPassword	
			}
			
			$.ajax({
				type: "POST",
				data: JSON.stringify(userData),
				contentType: "application/json",
				url: "http://localhost:8080/Java_Advanced_05/registration",
				success: function(data){
					if(data == "Success") {
						$("form")[0].reset();
						$("form")[1].reset();
						toLogin();
					}
				}
			});

		}

	});
	
	//Login
	$("#login-submit").click(function() {
		
		var email = $("#login-form #email").val();
		var password = $("#login-form #password").val();
		
		if (email == '' || password == '') {
			alert("Please fill all fields...!!!!!!");
		} else {
			var userData = {
				email: email,
				password: password,
			}
			
			$.ajax({
				type: "POST",
				data: JSON.stringify(userData),
				contentType: "application/json",
				url: "http://localhost:8080/Java_Advanced_05/login",
				success: function(data){
					if(data.url) {
						window.location = data.url;
					} else {
						$("form")[0].reset();
						$("form")[1].reset();
						alert("Wrong Email or Password!")
					}
				}
			});

		}

	});
	
	
});
