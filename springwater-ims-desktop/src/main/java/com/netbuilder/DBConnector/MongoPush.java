package com.netbuilder.DBConnector;

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
import com.mongodb.util.JSON;
import com.netbuilder.entities.Address;
import com.netbuilder.entities.Item;

import org.bson.BSONObject;
import org.bson.Document;

public class MongoPush {
	
	//Create instance of MongoDB Connector to connect to DB
	private MongoDBConnector mdbc = new MongoDBConnector();
	private final String dataBase = "nbgardensdata";
	
	public static void main(String[] args) {
		
		MongoPush tst = new MongoPush();
		Item item = new Item("Gnomeo", "Gnome Rome. Get it?", (float)3.51, (float)2.02, 500, "A4", false, false, 3);
		tst.addItem(item);
	}
	
	/**
	 * Adds the passed Item to the MongoDB database and returns the ID assigned to the new Item
	 * @param item
	 * @return
	 */
	public int addItem(Item item) {
		// TODO change item costs/prices to doubles instead of floats
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

		BasicDBObject itemObject = createItemDBObjectFromItem(item, newItemID);
						
		collection.insert(itemObject);
		
		mdbc.mongoDisconnect();
		
		return newItemID;
	}
	
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
	 * creates the BasicDBObject in order to add it to MongoDB from an Item entity
	 * @param item
	 * @param id
	 * @return
	 */
	private BasicDBObject createItemDBObjectFromItem(Item item, int id) {
		BasicDBObject itemObject = new BasicDBObject();
		itemObject.put("idItem", id);
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
	 * Creates the Item Attributes HashMap from the attributes of the passed Item
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
	 * Adds the passed address to the MongoDB database and returns the int value of the ID assigned to the new address
	 * @param addr
	 * @return the ID that was assigned to the new address
	 */
	public int addAddress(Address addr) {

		mdbc.mongoConnect();
		DB db = mdbc.getConnection().getDB(dataBase);
		BasicDBObject addressObject = new BasicDBObject();
		BasicDBObject addressLines = new BasicDBObject();
		
		int newAddrID;
		try {
			newAddrID = getMaxInt("Address", "idAddress")+1;
		} catch (Exception e) {
			System.out.println("Unable to find Address Collection or idAddress in addAddress() in MongoPush");
			throw new Error(e);
		}
		
		addressObject.put("idAddress",  (double) newAddrID);
		
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
		
		
		DBCollection collection = db.getCollection("Address");
		collection.insert(addressObject);
		mdbc.mongoDisconnect();
		return newAddrID;
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
	 * deletes an address from the MongoDB database specified by the passed id
	 * @param id
	 */
	public void deleteAddressByID(int id) {

		mdbc.mongoConnect();
		DB db = mdbc.getConnection().getDB("nbgardensdata");
		DBCollection collection = db.getCollection("Address");
		

		BasicDBObject addr = new BasicDBObject();
		addr.put("idAddress", id);
		DBObject doc = collection.findOne(addr);
		collection.remove(doc);
	}
	
	public void updateAddress() {
		
	}
	
	public void destoryAddress() {
		
	}
	
	public void createWishList() {
		
	}
	
	public void updateWishList() {
		
	}
}
