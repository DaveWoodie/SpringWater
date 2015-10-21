package com.netbuilder.DBConnector;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class MongoDBConnector {

	static final String databaseURL = null;
	static final String userName = null;
	static final String passWord = null;
	
	private String host = "localhost";
	
	
	public void openCon() {
		
		try {
			
			//Connect to the host localhost through the default port 27017.
			Mongo mongo = new Mongo("localhost", 27017);
		
			MongoClient mongoClient = new MongoClient();
			DB db = mongoClient.getDB("database name");
			boolean auth = db.authenticate("username", "password".toCharArray());
			
			//To get a table or collection from a Mongo DB
			DBCollection table = db.getCollection("user");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	
}
