package com.netbuilder.connections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.netbuilder.entities.Address;
import com.netbuilder.entities.Item;
import com.netbuilder.entities.WishList;

/**
 * Class to create, update and delete entries from the MongoDB database
 * @author tstacey
 *
 */
public class MongoPush {
	
	//Create instance of MongoDB Connector to connect to DB
	private MongoDBConnector mdbc = new MongoDBConnector();
	private final String dataBase = "nbgardensdata";
	
	/*
	public static void main(String[] args) {
		
		MongoPush push = new MongoPush();
		MongoPull pull = new MongoPull();
		
		
	}
	*/

	/******************************************************************************/
	// CREATE CREATE CREATE CREATE CREATE CREATE CREATE CREATE CREATE CREATE CREATE
	/******************************************************************************/
	
	
	/**
	 * Adds the passed Item to the MongoDB database and returns the ID assigned to the new Item
	 * @param item
	 * @return
	 */
	public int addItem(Item item) {
		mdbc.mongoConnect();
		DB db = mdbc.getConnection().getDB(dataBase);
		
		DBCollection collection = db.getCollection("Item");
		
		int newItemID;
		try {
			newItemID = getMaxInt("Item", "idItem")+1;
		} catch (Exception e) {
			System.out.println("Unable to find Item Collection or idItem in addItem() in MongoPush");
			throw new Error(e);
		}
		item.setItemID(newItemID);
		BasicDBObject itemObject = makeMongoObjectFromItem(item);
						
		collection.insert(itemObject);
		
		mdbc.mongoDisconnect();
		
		return newItemID;
	}
	

	/**
	 * Adds the passed address to the MongoDB database and returns the int value of the ID assigned to the new address
	 * @param addr
	 * @return the ID that was assigned to the new address
	 */
	public int addAddress(Address addr) {

		mdbc.mongoConnect();
		DB db = mdbc.getConnection().getDB(dataBase);
		
		int newAddrID;
		try {
			newAddrID = getMaxInt("Address", "idAddress")+1;
		} catch (Exception e) {
			System.out.println("Unable to find Address Collection or idAddress in addAddress() in MongoPush");
			throw new Error(e);
		}
		addr.setAddressID(newAddrID);

		BasicDBObject addressObject = makeMongoObjectFromAddress(addr);
		DBCollection collection = db.getCollection("Address");
		
		collection.insert(addressObject);
		mdbc.mongoDisconnect();
		return newAddrID;
	}
	
	/**
	 * Adds a new WishList to the MongoDB database.
	 * Throws exception if wishlist for that customer already exists
	 * @param wish
	 * @throws Exception
	 */
	public void addWishList(WishList wish) throws Exception {

		mdbc.mongoConnect();
		DB db = mdbc.getConnection().getDB(dataBase);
		DBCollection collection = db.getCollection("WishList");
		
		BasicDBObject searchObj = new BasicDBObject();
		searchObj.put("idCustomer", wish.getCustomerID());
		DBObject checkObj = collection.findOne(searchObj);
		if(checkObj != null) {
			System.out.println("Tried to add new wishlist for customer where wishlist already exists");
			throw new Exception();
		} else {
			BasicDBObject newWishList = makeMongoObjectFromWishList(wish);
			collection.insert(newWishList);
		}
		
		mdbc.mongoDisconnect();
	}
	
	
	
	/******************************************************************************/
	// UPDATE UPDATE UPDATE UPDATE UPDATE UPDATE UPDATE UPDATE UPDATE UPDATE UPDATE
	/******************************************************************************/
	
	
	
	/**
	 * Updates the mongoDB database entry for the passed Item. USes the item's ID to find the entry to update
	 * @param item
	 */
	public void updateItem(Item item) {
		mdbc.mongoConnect();
		
		//Connect to the NBGardensn database
		DB db = mdbc.getConnection().getDB(dataBase);
		//Get Specfic Collection`
		DBCollection collection = db.getCollection("Item");
		
		BasicDBObject searchObj = new BasicDBObject();
		searchObj.put("idItem", item.getIdItem());
		//DBObject currItem = collection.findOne(searchObj);
		BasicDBObject newItemObj = makeMongoObjectFromItem(item);
		
		collection.update(searchObj, newItemObj);
		

		mdbc.mongoDisconnect();
	}
	
	/**
	 * updates an item's discontinued state to correspond with the passed boolean and id
	 * pass false to set the item as discontinued, true to set as continued
	 * @param itemID
	 * @param continuedState
	 */
	public void setContinuedStateForItem(int itemID, boolean continuedState) {
		mdbc.mongoConnect();
		DB db = mdbc.getConnection().getDB(dataBase);
		
		DBCollection collection = db.getCollection("Item");
		
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set", new BasicDBObject().append("Discontinued", !continuedState));
				
		BasicDBObject searchQuery = new BasicDBObject().append("idItem", itemID);

		collection.update(searchQuery, newDocument);
	}
	
	/**
	 * updates the MongoDB database entry for the passed WishList
	 * @param wish
	 */
	public void updateWishList(WishList wish) {

		mdbc.mongoConnect();
		DB db = mdbc.getConnection().getDB(dataBase);
		
		DBCollection collection = db.getCollection("WishList");
		
		BasicDBObject searchObj = new BasicDBObject();
		searchObj.put("idCustomer", wish.getCustomerID());
		
		BasicDBObject newWishList = makeMongoObjectFromWishList(wish);

		collection.update(searchObj, newWishList);

		mdbc.mongoDisconnect();
		
	}
	
	public void updateAddress(Address addr) {

		mdbc.mongoConnect();
		DB db = mdbc.getConnection().getDB(dataBase);
		
		DBCollection collection = db.getCollection("Address");
		
		BasicDBObject searchObj = new BasicDBObject();
		searchObj.put("idAddress", addr.getAddressID());
		
		BasicDBObject newAddress = makeMongoObjectFromAddress(addr);

		collection.update(searchObj, newAddress);

		mdbc.mongoDisconnect();
	}
	
	/******************************************************************************/
	// DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE
	/******************************************************************************/
	
	
	/**
	 * deletes an address from the MongoDB database specified by the passed id
	 * @param id
	 */
	public void deleteAddressByID(int id) {

		mdbc.mongoConnect();
		DB db = mdbc.getConnection().getDB(dataBase);
		DBCollection collection = db.getCollection("Address");
		

		BasicDBObject addr = new BasicDBObject();
		addr.put("idAddress", id);
		DBObject doc = collection.findOne(addr);
		collection.remove(doc);
	}
	
	/**
	 * deletes an item from the MongoDB database specified by the passed id
	 * @param id
	 */
	public void deleteItemByID(int id) {

		mdbc.mongoConnect();
		DB db = mdbc.getConnection().getDB(dataBase);
		DBCollection collection = db.getCollection("Item");
		

		BasicDBObject itm = new BasicDBObject();
		itm.put("idItem", id);
		DBObject doc = collection.findOne(itm);
		collection.remove(doc);
	}
	
	
	public void deleteWishListByCustomerID(int custID) {

		mdbc.mongoConnect();
		DB db = mdbc.getConnection().getDB(dataBase);
		DBCollection collection = db.getCollection("WishList");
		

		BasicDBObject itm = new BasicDBObject();
		itm.put("idCustomer", custID);
		DBObject doc = collection.findOne(itm);
		collection.remove(doc);
	}
	
	

	/******************************************************************************/
	// MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC
	/******************************************************************************/
	
	

	/**
	 * creates the BasicDBObject in order to add it to MongoDB from an Item entity
	 * @param item
	 * @param id
	 * @return
	 */
	private BasicDBObject makeMongoObjectFromItem(Item item) {
		BasicDBObject itemObject = new BasicDBObject();
		itemObject.put("idItem", item.getIdItem());
		itemObject.put("ItemName", item.getItemName());
		itemObject.put("ItemDescription", item.getDescription());
		itemObject.put("ImageLocation", item.getImageLocation());
		itemObject.put("NumberInStock", item.getStock());
		itemObject.put("ItemPrice", item.getPrice());
		itemObject.put("ItemCost", item.getCost());
		itemObject.put("SalesRate", item.getSalesRate());
		itemObject.put("PSalesRate", item.getpSalesRate());
		itemObject.put("IsPorousware", item.isPorousware());
		itemObject.put("Discontinued", item.isDiscontinued());
		itemObject.put("idSupplier", item.getIdSupplier());
		
		BasicDBObject itemAttributes = createAttributesFromItem(item);
		itemObject.put("Attributes",itemAttributes);
		return itemObject;
	}
	
	/**
	 * Creates the Item Attributes Mongo Object from the attributes of the passed Item
	 * @param item
	 * @return
	 */
	private BasicDBObject createAttributesFromItem(Item item) {
		BasicDBObject newAttributes = new BasicDBObject();
		HashMap<String, String> itemAttributes = item.getAttributes();
		
	    Iterator<Entry<String, String>> it = itemAttributes.entrySet().iterator();
	    while (it.hasNext()) {
			Map.Entry<String,String> pair = (Map.Entry<String, String>)it.next();
	        newAttributes.put(pair.getKey(),pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
		
		return newAttributes;
	}
	
	
	
	/**
	 * returns an integer value of the max aggregate of the passed column in the passed collection. throws Exception if collection or column doesn't exist
	 * requires a mongo connection to have been established
	 * @param collectionName
	 * @param idColumnName
	 * @return int max value
	 */
	private int getMaxInt(String collectionName, String columnName) throws Exception {

		int maxInt;
		DB db = mdbc.getConnection().getDB("nbgardensdata");
		DBCollection collection = db.getCollection(collectionName);

		DBCursor cursor = collection.find().sort(new BasicDBObject(columnName, -1)).limit(1);
		if(!cursor.hasNext()) {
			throw new Exception();
		} else {
			cursor.next();
			maxInt =  ((Double) cursor.curr().get(columnName)).intValue();
		}
		cursor.close();
		return maxInt;
	}
	
	/**
	 * Converts the passed WishList entity into a mongo object in order to upload it to the database
	 * @param wish - the WishList to be converted
	 * @return BasicDBObject corresponding to the wishlist
	 */
	private BasicDBObject makeMongoObjectFromWishList(WishList wish) {
		BasicDBObject wishListObject = new BasicDBObject();
		wishListObject.put("idCustomer", wish.getCustomerID());
		int numberOfItems = wish.getItems().size();
		int[] itemIDs = new int[numberOfItems];
		for(int i = 0; i < numberOfItems; i++) {
			itemIDs[i] = wish.getItems().get(i).getIdItem();
		}
		wishListObject.put("items", itemIDs);
		return wishListObject;
	}
	

	/**
	 * Converts an address entity into a MongoDB object for updating/adding to the database
	 * @param addr
	 * @return
	 */
	private BasicDBObject makeMongoObjectFromAddress(Address addr) {
		BasicDBObject addressObject = new BasicDBObject();
		BasicDBObject addressLines = new BasicDBObject();

		addressObject.put("idAddress",  (double) addr.getAddressID());
		
		if(addr.isCustomerAddress()) {
			try {
				int custID = addr.getCustomerID();
				addressObject.put("idCustomer", custID);
			} catch (Exception e) {
				System.out.println("***ERROR incorrect return value from isCustomerAddress() in addAddress() in MongoPush");
				throw new Error(e);
			}
		}
		
		ArrayList<String> addrLines = addr.getAddressLines();
		for(int i = 0; i < addrLines.size(); i++) {
			addressLines.put("AddressLine"+(i+1), addrLines.get(i));
		}
		
		addressObject.put("AddressLines", addressLines);
		
		addressObject.put("City", addr.getCity());
		if(addr.getCounty() != null) {
			addressObject.put("County", addr.getCounty());
		}

		addressObject.put("PostCode", addr.getPostCode());
		
		
		return addressObject;
	}
	
}
