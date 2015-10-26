/**
 * Author: Callum Cooper
 * Date: 22/10/2015
 * Description: basketUpdater.js is the javascript file that
 * 				allows the basket page to be updated once the
 * 				user has decided that they wish to purchase
 * 				an item.
 * Date modified: c33-cooper - 22/10/2015
 */

// Cookie attributes
var itemCountCookie;

// Basket attributes
var itemCount = 1;

// update the basket
function update() {
	var str = document.getElementById("basketCount");
	var replacedCount = str.replace("Microsoft", "Replaced");
	document.getElementById("basketCount").innerHTML = replacedCount;
}

// function for updating the basket
function basketUpdater() {
	setAllCookieVals(itemCount);
}

function updateItemCount() {
	itemCount += 1;
	setAllCookieVals(itemCount);
}

// Function sets all the cookie values for the items
function setAllCookieVals(iCount) {
	document.cookie = "itemCount = " + iCount;
}

// Function returns all the cookie values for the item count
function getCookies(name) {
	var re = new RegExp(name + "=([^;]+)");
    var value = re.exec(document.cookie);
    return (value != null) ? unescape(value[1]) : null;
}