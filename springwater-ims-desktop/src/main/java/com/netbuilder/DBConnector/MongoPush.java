package com.netbuilder.DBConnector;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.netbuilder.entities.Address;

import org.bson.BSONObject;
import org.bson.Document;

public class MongoPush {
	
	//Create instance of MongoDB Connector to connect to DB
	private MongoDBConnector mdbc = new MongoDBConnector();
	
	private final String dataBase = "nbgardensdata";
	
	public static void main(String[] args) {
		
		MongoPush tst = new MongoPush();
		ArrayList<String> lines = new ArrayList<String>();
		lines.add("stoopid house");
		lines.add("25 stoopid lane");
		Address a = new Address(lines, "stoopidtown", "STU P1D");
		System.out.println(tst.addAddress(a));
	}
	
	public void addItem() {
		mdbc.mongoConnect();
		DB db = mdbc.getConnection().getDB("nbgardensdata");
		
		DBCollection collection = db.getCollection("Item");
		
		String json = "{idItem: 6, ItemName: 'Yellow Gnome'}";

		DBObject dbObject = (DBObject)JSON.parse(json);
						
		collection.insert(dbObject);
		
		mdbc.mongoDisconnect();
	}
	
	/**
	 * Adds the passed address to the MongoDB database and returns the int value of the ID assigned to the new address
	 * @param addr
	 * @return the ID that was assigned to the new address
	 */
	public int addAddress(Address addr) {

		mdbc.mongoConnect();
		DB db = mdbc.getConnection().getDB("nbgardensdata");
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
