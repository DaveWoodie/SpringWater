package com.netbuilder.DBConnector;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class MongoPush {
	
	//Create instance of MongoDB Connector to connect to DB
	private MongoDBConnector mdbc = new MongoDBConnector();
	
	private final String dataBase = "nbgardensdata";
	
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
