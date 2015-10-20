/**
 * Author: Callum Cooper
 * Date: 20/10/2015
 * Description: registerUser.js is the javascript file
 * 				for the functionality which allows the user
 * 				to register on the loginRegister.jsp page.
 */

function registerUserDetails() {
	
	// User attributes
	var firstName = document.getElementById("firstNameInput").value;
	var lastName = document.getElementById("lastNameInput").value;
	var email = document.getElementById("emailInput").value;
	var password = document.getElementById("passwordInput").value;
	var confirmPassword = document.getElementById("confirmPasswordInput").value;
	var dob = document.getElementById("dobInput").value;
	var telephoneNumber = document.getElementById("telephoneNumberInput").value;
	
	alert(firstName + " " + lastName + " " + email + " " + password + " " + confirmPassword + " " + dob + " " + telephoneNumber);
}