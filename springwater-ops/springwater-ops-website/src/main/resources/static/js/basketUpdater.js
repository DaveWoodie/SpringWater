/**
 * Author: Callum Cooper
 * Date: 22/10/2015
 * Description: basketUpdater.js is the javascript file that
 * 				allows the basket page to be updated once the
 * 				user has decided that they wish to purchase
 * 				an item.
 * Date modified: c33-cooper - 22/10/2015
 */

// Basket attributes
var itemCount = 0;

function updateBasketcount() {
	itemCount += 1;
}

function getBasketCount() {
	return itemCount;
}