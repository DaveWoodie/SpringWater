/**
 * @author chrisjwwalker
 * @date 22/10/2015
 */

package com.netbuilder.DBConnector;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bson.BSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.netbuilder.entities.Address;
import com.netbuilder.entities.Item;
import com.netbuilder.entities.WishList;

public class MongoPull {

	//Create Instance of Mongo Connector to connect to DB
	private MongoDBConnector mdbc = new MongoDBConnector();
	
	//Strings specifying database and collections to use
	private final String dataBase = "nbgardensdata";
	private final String AddrCol = "Address";
	private final String itemCol = "Item";
	private final String wishListCol = "WishList";
	
	//Lists returned by the following methods
	private List<String> itemInfs = new ArrayList<String>();
	private List<String> wishListSet = new ArrayList<String>();
	private ArrayList<Item> itemList = new ArrayList<Item>();

	
	/*
	public static void main(String[] args) {
		
		MongoPull tst = new MongoPull();
		tst.getWishList(3).print();
	}
	*/
	
	public MongoPull() {
		
	}
	
	/**
	 * 
	 * Method to fetch an address based on an address ID
	 * 
	 * In order that information is returned
	 *	> Address Lines
	 *		> Address Line 1
	 *		> Address Line 2
	 *	> City
	 *	> County
	 *	> Post Code
	 * 
	 * @param id: Takes an int which is the address ID
	 * @return returns a List containing the address associated with the ID
	 */
	public Address getAddress(int addressID) {
		//Connect to MongoDB
		mdbc.mongoConnect();
		
		//Connect to the NBGardensn database
		DB db = mdbc.getConnection().getDB(dataBase);
		//Get Specfic Collection
		DBCollection collection = db.getCollection(AddrCol);
		
		BasicDBObject addr = new BasicDBObject();
		addr.put("idAddress", addressID);
		DBObject addrObj = collection.findOne(addr);		
		
		
		ArrayList<String> addressLines = new ArrayList<String>();
		
		BSONObject bsobj = (BSONObject) addrObj.get("AddressLines");
		Set<String> keys = bsobj.keySet();
		for(String key : keys) {
			String val = bsobj.get(key).toString();
			addressLines.add(val);
		}
		String city = addrObj.get("City").toString();
		
		Object countyCheck = addrObj.get("County");
		String county = null;
		if(countyCheck != null) {
			county = addrObj.get("County").toString();
		}
		
		String postCode = addrObj.get("PostCode").toString();
		
		Address address;
		if(county == null) {
			address = new Address(addressLines, city, postCode);
		} else {
			address = new Address(addressLines, city, county, postCode);
		}
		
		Integer customerID;
		if(addrObj.get("idCustomer") != null) {
			customerID = (Integer) addrObj.get("idCustomer");
			address.setCustomerID(customerID);
		}
		
		address.setAddressID(((Double)(addrObj.get("idAddress"))).intValue());
		
				
		//Disconnect from MongoDB
		mdbc.mongoDisconnect();
		
		return address;
	}
	
	/**
	 * 
	 * Method to fetch all the information stored on a given item based on idItem
	 * 
	 * In order that information is returned
	 * 	> Item Name
	 * 	> Item Description
	 * 	> Image Location
	 * 	> Number in stock
	 * 	> Item Price 
	 * 	> Item Cost
	 * 	> Sales Rate
	 * 	> Previous Sales Rate
	 * 	> Is Porous?
	 * 	> Discontinued?
	 * 	> Supplier ID
	 * 	> Attributes
	 * 		> Height
	 * 		> Width
	 * 		> Depth
	 * 		> Following Attributes aren't in every Item...
	 * 			> HatColour
	 * 			> Accessory
	 * 			> Dial Stone
	 * 			> Colour
	 *			> Number of People
	 * 
	 * @param id: Takes an int which is the idItem of a given item
	 * @return returns a list containing all the information for the given item
	 */
	public Item getItem(int id) {
		//Connect to MongoDB
		mdbc.mongoConnect();
		
		String attrs[] = {"Height","Width","Depth","HatColour","Accessory","DialStone","Colour","NumberOfPeople"};
		
		//Connect to the NBGardens database
		DB db = mdbc.getConnection().getDB(dataBase);
		//Get Specific Collection
		DBCollection collection = db.getCollection(itemCol);
		
		BasicDBObject item = new BasicDBObject();
		item.put("idItem", id);
		DBCursor cursor = collection.find(item);
		
		itemInfs.clear();
		itemList.clear();
		
		Item newItem = null;
		
		while(cursor.hasNext()) {
			
			cursor.next();
			String itemName = cursor.curr().get("ItemName").toString();
			String itemDescription = cursor.curr().get("ItemDescription").toString();
			String numberInStock = cursor.curr().get("NumberInStock").toString();
			String itemPrice = cursor.curr().get("ItemPrice").toString();
			String itemCost = cursor.curr().get("ItemCost").toString();
			String imageLocation = cursor.curr().get("ImageLocation").toString();
			itemInfs.add(cursor.curr().get("SalesRate").toString());
			itemInfs.add(cursor.curr().get("PSalesRate").toString());
			boolean isPorousWare = handleMongoBoolean(cursor.curr().get("IsPorousware"));
			boolean discontinued = handleMongoBoolean(cursor.curr().get("Discontinued"));
			String idSupplier = cursor.curr().get("idSupplier").toString();
			
			newItem = new Item(itemName, itemDescription, Float.parseFloat(itemPrice), Float.parseFloat(itemCost), (int) Float.parseFloat(numberInStock), imageLocation, discontinued, isPorousWare, (int) Float.parseFloat(idSupplier));
			
			BSONObject bsobj = (BSONObject) cursor.curr().get("Attributes");
			Set<String> keys = bsobj.keySet();
			for(String key : keys) {
				String val = bsobj.get(key).toString();
				
				try {
					newItem.addAttribute(key, val);
				} catch (Exception e) {
					throw new Error(e);
				}
			}
			newItem.setItemID(id);
			
			itemList.add(newItem);
		}
		
		cursor.close();
		
		//Disconnect from MongoDB
		mdbc.mongoDisconnect();
		
		return newItem;
	}
	
	/**
	 * Wrapper method for getItem() in order to return the Item corresponding to the passed itemID within an ArrayList containing only that item
	 * @param itemID
	 * @return
	 */
	public ArrayList<Item> getItemAsArrayList(int itemID) {
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList.add(getItem(itemID));
		return itemList;
	}
	
	/**
	 * method to evaluate the passed Mongo boolean field
	 * @param fieldToEvaluate
	 * @return
	 */
	private boolean handleMongoBoolean(Object fieldToEvaluate) {
		return fieldToEvaluate.toString().equals("true");
	}
	
	/**
	 * 
	 * Method to fetch the contents of a customers wish list
	 * 
	 * Order that information is returned 
	 * 	> idItemX
	 * 
	 * @param id : Takes an int which is the idCustomer of a customer 
	 * @return returns a List containing the items stored within a customers wish list 
	 */
	public WishList getWishList(int custID) {
		//Connect to MongoDB
		mdbc.mongoConnect();
		
		//Connect to the NBGardensn database
		DB db = mdbc.getConnection().getDB(dataBase);
		//Get Specfic Collection
		DBCollection collection = db.getCollection(wishListCol);
		
		BasicDBObject wL = new BasicDBObject();
		wL.put("idCustomer", custID);
		DBObject wishListObj = collection.findOne(wL);
		
		wishListSet.clear();
		
		ArrayList<Item> wlItems = new ArrayList<Item>();
		BSONObject itemObj = (BSONObject) wishListObj.get("items");
		Set<String> keys = itemObj.keySet();
		for(String key : keys) {
			Integer itemID = (Integer) itemObj.get(key);
			wlItems.add(getItem(itemID));
		}
		
		WishList wish = new WishList(custID, wlItems);
				
		//Disconnect from MongoDB
		mdbc.mongoDisconnect();
		
		return wish;
	}
}