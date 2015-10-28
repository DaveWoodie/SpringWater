/**
 * @author chrisjwwalker
 * @date 22/10/2015
 */

package com.netbuilder.connections;

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

	
	
	
//	public static void main(String[] args) {
//		
//		MongoPull pull = new MongoPull();
//		MongoPush push = new MongoPush();
//		ArrayList<Address> a = pull.getAllAddresses();
//		for (Address b : a) {
//			b.print();
//			System.out.println();
//		}
//		
//	}
	
	
	
	
	public MongoPull() {
		
	}
	

	/*********************************************************************************/
	// ADDRESSES ADDRESSES ADDRESSES ADDRESSES ADDRESSES ADDRESSES ADDRESSES ADDRESSES
	/*********************************************************************************/
	 
	
	/**
	 * 
	 * Method to fetch an address based on an address ID
	 * @param id: Takes an int which is the address ID
	 * @return returns an Address object  containing the address associated with the ID
	 */
	public Address getAddress(int addressID) {
		//Connect to MongoDB
		mdbc.mongoConnect();
		
		DBCollection collection = this.getCollection(AddrCol);
		
		BasicDBObject addr = new BasicDBObject();
		addr.put("idAddress", addressID);
		DBObject addrObj = collection.findOne(addr);
		
		Address address = makeAddressEntityFromMongoObject(addrObj);
		
		//Disconnect from MongoDB
		mdbc.mongoDisconnect();
		
		return address;
	}
	
	/**
	 * returns all Addresses stored in the MongoDB database
	 * @return ArrayList of Address entities
	 */
	public ArrayList<Address> getAllAddresses() {
		ArrayList<Address> addresses = new ArrayList<Address>();
		//Connect to MongoDB
		mdbc.mongoConnect();
		
		DBCollection collection = this.getCollection(AddrCol);
		
		DBCursor cursor = collection.find();
		while(cursor.hasNext()) {
			DBObject addrObj =  cursor.next();
			addresses.add(makeAddressEntityFromMongoObject(addrObj));
		}		
		//Disconnect from MongoDB
		mdbc.mongoDisconnect();
		
		return addresses;
	}
	
	/**
	 * Returns an ArrayList of Address entities corresponding to the passed customerID
	 * @param custID - the id of the customer for whom you want addresses
	 * @return ArrayList of Address entities
	 */
	public ArrayList<Address> getAddressesByCustomerID(int custID) {
		ArrayList<Address> addresses = new ArrayList<Address>();
		//Connect to MongoDB
		mdbc.mongoConnect();
		
		DBCollection collection = this.getCollection(AddrCol);
		BasicDBObject searchObj = new BasicDBObject();
		searchObj.put("idCustomer", custID);
		
		DBCursor cursor = collection.find(searchObj);
		while(cursor.hasNext()) {
			DBObject addrObj =  cursor.next();
			addresses.add(makeAddressEntityFromMongoObject(addrObj));
		}		
		//Disconnect from MongoDB
		mdbc.mongoDisconnect();
		
		return addresses;
	}

	/**
	 * takes a Mongo address Object and converts it into a java Address entity
	 * @param addrObj
	 * @return
	 */
	private Address makeAddressEntityFromMongoObject(DBObject addrObj) {


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
		
		return address;
				
	}
	

	/******************************************************************************/
	// ITEMS ITEMS ITEMS ITEMS ITEMS ITEMS ITEMS ITEMS ITEMS ITEMS ITEMS ITEMS ITEMS
	/******************************************************************************/
	
	
	/**
	 * 
	 * returns an Item entity based on idItem
	 * @param id: Takes an int which is the idItem of a given item
	 * @return returns an Item object containing all the information for the given item
	 */
	public Item getItem(int id) {
		//Connect to MongoDB
		mdbc.mongoConnect();
		
		DBCollection collection = this.getCollection(itemCol);
		
		BasicDBObject searchItem = new BasicDBObject();
		searchItem.put("idItem", id);
		DBObject itemObj = collection.findOne(searchItem);
		
		itemInfs.clear();
		
		Item newItem = makeItemEntityFromMongoObject(itemObj);
		
		//Disconnect from MongoDB
		mdbc.mongoDisconnect();
		
		return newItem;
	}
	
	/**
	 * returns all items provided by the passed supplier. If includeDiscontinued is set to true, will return discontinued items as well
	 * @param supplierID
	 * @param includeDiscontinued - flag to request discontinued items as well as current items
	 * @return
	 */
	public ArrayList<Item> getItemsBySupplier(int supplierID, boolean includeDiscontinued) {
		ArrayList<Item> items = new ArrayList<Item>();

		mdbc.mongoConnect();
		
		DBCollection collection = this.getCollection(itemCol);

		BasicDBObject searchItem = new BasicDBObject();
		searchItem.put("idSupplier", supplierID);
		if(!includeDiscontinued) {
			searchItem.put("Discontinued", false);
		}
		
		DBCursor cursor = collection.find(searchItem);
		
		while(cursor.hasNext()) {
			cursor.next();
			Item item = makeItemEntityFromMongoObject(cursor.curr());
			items.add(item);
		}
		
		mdbc.mongoDisconnect();
		
		return items;
		
	}

	/**
	 * returns all items (both current and discontinued) from the mongoDB database
	 * @return ArrayList of Item entities
	 */
	public ArrayList<Item> getAllItems() {
		ArrayList<Item> items = new ArrayList<Item>();

		mdbc.mongoConnect();
		
		DBCollection collection = this.getCollection(itemCol);
		DBCursor cursor = collection.find();
		while(cursor.hasNext()) {
			DBObject itemObj = cursor.next();
			items.add(makeItemEntityFromMongoObject(itemObj));
		}
		return items;
	}
	
	/**
	 * returns all Items from the MongoDB that are marked as discontinued
	 * @return ArrayList of Item entities
	 */
	public ArrayList<Item> getAllDiscontinuedItems() {
		return this.getAllItems(true);
	}

	/**
	 * returns all Items from the MongoDB that are not marked as discontinued
	 * @return ArrayList of Item entities
	 */
	public ArrayList<Item> getAllCurrentItems() {
		return this.getAllItems(false);
	}
	
	
	/**
	 * returns all Items from the MongoDB database depending on the passed discontinued boolean
	 * @param discontinued
	 * @return ArrayList of Item Entities
	 */
	private ArrayList<Item> getAllItems(boolean discontinued) {
		ArrayList<Item> items = new ArrayList<Item>();

		mdbc.mongoConnect();
		
		DBCollection collection = this.getCollection(itemCol);
		BasicDBObject searchItem = new BasicDBObject();
		searchItem.put("Discontinued", discontinued);
		
		DBCursor cursor = collection.find(searchItem);
		while(cursor.hasNext()) {
			DBObject itemObj = cursor.next();
			items.add(makeItemEntityFromMongoObject(itemObj));
		}
		return items;
	}
	
	private Item makeItemEntityFromMongoObject(DBObject itemObj) {

		Item newItem;
		
		String itemName = itemObj.get("ItemName").toString();
		String itemDescription = itemObj.get("ItemDescription").toString();
		String numberInStock = itemObj.get("NumberInStock").toString();
		String itemPrice = itemObj.get("ItemPrice").toString();
		String itemCost = itemObj.get("ItemCost").toString();
		String imageLocation = itemObj.get("ImageLocation").toString();
		itemInfs.add(itemObj.get("SalesRate").toString());
		itemInfs.add(itemObj.get("PSalesRate").toString());
		boolean isPorousWare = handleMongoBoolean(itemObj.get("IsPorousware"));
		boolean discontinued = handleMongoBoolean(itemObj.get("Discontinued"));
		String idSupplier = itemObj.get("idSupplier").toString();
		
		newItem = new Item(itemName, itemDescription, Float.parseFloat(itemPrice), Float.parseFloat(itemCost), (int) Float.parseFloat(numberInStock), imageLocation, discontinued, isPorousWare, (int) Float.parseFloat(idSupplier));
		newItem.setItemID((Integer) itemObj.get("idItem") );
		
		
		BSONObject bsobj = (BSONObject) itemObj.get("Attributes");
		Set<String> keys = bsobj.keySet();
		for(String key : keys) {
			String val = bsobj.get(key).toString();
			
			try {
				newItem.addAttribute(key, val);
			} catch (Exception e) {
				throw new Error(e);
			}
		}
		
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
	
	

	/**********************************************************************************/
	// WISHLIST WISHLIST WISHLIST WISHLIST WISHLIST WISHLIST WISHLIST WISHLIST WISHLIST
	/**********************************************************************************/
	
	
	/**
	 * Returns the WishList entity from the MongoDB database corresponding to the passed customerID
	 * @param custID : Takes an int which is the idCustomer of a customer 
	 * @return returns a List containing the items stored within a customer's wish list 
	 */
	public WishList getWishList(int custID) {
		//Connect to MongoDB
		mdbc.mongoConnect();
		DBCollection collection = this.getCollection(wishListCol);
		
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
	
	

	/**********************************************************************************/
	// MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC
	/**********************************************************************************/
	
	
	/**
	 * returns a collection from the nbgardens database
	 * @param collectionName - the name of the collection to be returned
	 * @return collection
	 */
	private DBCollection getCollection(String collectionName) {
		//Connect to the NBGardens database
		DB db = mdbc.getConnection().getDB(dataBase);
		//Get Specfic Collection
		DBCollection collection = db.getCollection(collectionName);
		return collection;
	}

	/**
	 * method to evaluate the passed Mongo boolean field
	 * @param fieldToEvaluate
	 * @return
	 */
	private boolean handleMongoBoolean(Object fieldToEvaluate) {
		return fieldToEvaluate.toString().equals("true");
	}
}