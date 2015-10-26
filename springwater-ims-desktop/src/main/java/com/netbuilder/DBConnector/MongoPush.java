package com.netbuilder.DBConnector;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import org.bson.BSONObject;
import org.bson.Document;

public class MongoPush {
	
	//Create instance of MongoDB Connector to connect to DB
	private MongoDBConnector mdbc = new MongoDBConnector();
	
	private final String dataBase = "nbgardensdata";
	
	public static void main(String[] args) {
		
		MongoPush tst = new MongoPush();
		tst.deleteAddressByID(17);
		//tst.addAddress();
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
	
	public void addAddress() {

		mdbc.mongoConnect();
		DB db = mdbc.getConnection().getDB("nbgardensdata");
		
		int newAddrID;
		try {
			newAddrID = getMaxInt("Address", "idAddress")+1;
		} catch (Exception e) {
			System.out.println("Unable to find Address Collection or idAddress in addAddress() in MongoPush");
			throw new Error(e);
		}
		
		
		System.out.println(newAddrID);
		
		DBCollection collection = db.getCollection("Address");

		
		
		String addr1 = "12 Highgarden Road";
		String addr2 = "Some kind of other address line";
		String city = "Telford";
		String county = "Shropshire";
		String postcode = "TF1 3JG";
		
		BasicDBObject addressLines = new BasicDBObject();
		addressLines.put("AddressLine1", addr1);
		addressLines.put("AddressLine2", addr2);
		
		BasicDBObject tstObj = new BasicDBObject();
		tstObj.put("idAddress",  (double) newAddrID);
		tstObj.put("AddressLines", addressLines);
		tstObj.put("City", city);
		tstObj.put("County", county);
		tstObj.put("PostCode", postcode);
		
		collection.insert(tstObj);
		mdbc.mongoDisconnect();
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
