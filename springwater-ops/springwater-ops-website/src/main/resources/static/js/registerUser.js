/**
 * Author: Callum Cooper
 * 
 * Date: 20/10/2015
 * 
 * Description: registerUser.js is the javascript file
 * 				for the functionality which allows the user
 * 				to register on the loginRegister.jsp page.
 * 
 * Last Modified: 21/10/2015
 */

var firstNameCookie;
var lastNameCookie;
var email;
var password;
var confirmPassword;
var dob;
var telephoneNumber;

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
	if (password === confirmPassword && firstName != "" && lastName != "" && email != ""
		&& password != "" && confirmPassword != "" && dob != "" && telephoneNumber != "") {
		
		// Return false to the event window
		window.event.returnValue = false;
        
		// Jump to the registered confirmation page
		window.location.href="registerconfirmed";
	} else {
		alert("Error!\nAll fields must be completed.\nPassword and Confirmed Password must match.");
	}
	
	// Create cookies for user and set
    setAllCookieVals(firstName, lastName, email);
	
	// Create an alert box
	alert("Welcome " + getFirstNameCookie() + " " + getLastNameCookie() + ", you are now registered.");
}

// function sets all the cookie values for the user
function setAllCookieVals(fname, lname, email) {
    document.cookie = "firstName = " + fname;
    document.cookie = "lastName = " + lname;
    document.cookie = "email = " + email;
}

// function returns all the cookie values to the user
function getCookie(name) {
    var re = new RegExp(name + "=([^;]+)");
    var value = re.exec(document.cookie);
    return (value != null) ? unescape(value[1]) : null;
}

// Function to create random unique number for user
function getUniqueNumber() {
	return Math.floor((Math.random() * 6000000000000000000) + 1);
}