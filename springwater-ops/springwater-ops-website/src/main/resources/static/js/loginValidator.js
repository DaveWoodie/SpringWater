/**
 * Author: Callum Cooper
 * Date: 22/10/2015
 * Description: loginValidator.js is the javascript file
 * 				that implements the functionality for a
 * 				user to login to the web site.
 * Last Modified: 22/10/2015
 */

// login attributes
var emailAddress;
var password;

// dummy database for users
var dummyEmailAddress = ["callumcoopz@googlemail.com", "alstock@nbgardens.com", "benback@nbgardens.com"];
var dummyPasswords = ["netbuilder", "thegaffer", "armylad212"];

function loginUser() {
	
	// Log user login details
	emailAddress = document.getElementById("emailAddressInput").value;
	password = document.getElementById("passwordInput").value;
	
	// check the email address
	if (emailAddress === checkEmailAddressDatabase(dummyEmailAddress, emailAddress) &&
			password === checkPasswordDatabase(dummyPasswords, password)) {
		alert("Address has been found in the database!!!");
		
		// Jump to the logged in profile page
		window.location.href="profile";
	} else {
		alert("Login details have NOT been found in database!!!");
	}
}

// function checks through database to see whether
// the email address that the user has input into the
// system matches the dummy data from the database
function checkEmailAddressDatabase(arr, obj) {
	
	for (var i=0; i<arr.length; i++) {
		if (arr[i] === obj) { return arr[i]; }
	}
	return "";
}

// function checks through database to see whether
// the password that the user had input into the
// system matches the dummy data from the database
function checkPasswordDatabase(arr, obj) {
	
	for (var i=0; i<arr.length; i++) {
		if (arr[i] === obj) { return arr[i]; }
	}
	return "";
}