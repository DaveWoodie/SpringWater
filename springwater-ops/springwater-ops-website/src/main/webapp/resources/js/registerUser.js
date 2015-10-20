/**
 * Author: Callum Cooper
 * 
 * Date: 20/10/2015
 * 
 * Description: registerUser.js is the javascript file
 * 				for the functionality which allows the user
 * 				to register on the loginRegister.jsp page.
 * 
 * Last Modified: 20/10/2015
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
	
	// Run a check to see whether users passwords match
	if (password === confirmPassword && firstName != "" && lastName != "") {
		
		// Return false to the event window
		window.event.returnValue = false;
		
		// Jump to the registered confirmation page
		window.location.href="registerConfirmedPage.jsp";
	} else {
		alert("Error!\nAll fields must be completed.\nPassword and Confirmed Password must match.");
	}
}