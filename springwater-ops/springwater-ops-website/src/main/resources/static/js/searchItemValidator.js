/**
 * Author: Callum Cooper
 * Date: 26/10/2015
 * Description: File allows user to dynamically search
 * 				for an item from the search bar
 * Last Modified: 26/10/2015
 */

// search attributes
var searchString;

function searchItems() {
	
	// Initialise search string
	searchString = document.getElementById("searchInput").value;
	
	alert("You have searched for " + searchString);
}

function getSearchItem() {
	return searchString;
}