/**
 * Author: Callum Cooper
 * Date: 26/10/2015
 * Description: basket.js is a more refined version
 * 				to update the basket.
 * Last Modified: 26/10/2015
 */

var shoppingcart =
{
    var obj = {}, items = [];

    obj.AddItem = function(itemNo,quantity,price){
    var item = { itemNo = itemNo, quantity = quantity, price = price };
    items.push(item)
    };

    obj.GetAllItems = function(){
       return items;
    };

    obj.GetItemByNo = function(num){
    for(var i=0;i <items.length;i++)
    {
      if(items[i].itemNo === num)
      return item[i];  
    }
    return null;
    };

    obj.CalculateTotal = function() { 
    var total;
    for(var i=0;i <items.length;i++)
    {
      total = total + (items[i].quantity*items[i].price);
    }
    return total;
    };

    return obj;
};