package com.netbuilder.DBConnector;

import java.net.UnknownHostException;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class MongoDBConnector {

	static final String databaseURL = null;
	static final String userName = "admin";
	static final String passWord = "netbuilder";
	
	private String host = "localhost";
	
	
	public static void openCon() {
		
		try {
			
			//Connect to the host localhost through the default port 27017.
			Mongo mongo = new Mongo("10.50.15.27", 27017);
		
			MongoClient mongoClient = new MongoClient();
			DB db = mongoClient.getDB("nbgardensdata");
			boolean auth = db.authenticate(userName, passWord.toCharArray());
			
			//To get a table or collection from a Mongo DB
			DBCollection table = db.getCollection("user");
			
			Set<String> collections = db.getCollectionNames();

			for (String collectionName : collections) {
				System.out.println(collectionName);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args) {
		openCon();
	}
}
