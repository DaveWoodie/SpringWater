package com.netbuilder.DBConnector;

import java.util.Set;

import com.mongodb.DB;

public class MongoConnectTest {

	private static MongoDBConnector mdbc = new MongoDBConnector();
	
	public static void main(String [] args) {
		
		mdbc.mongoConnect();
		
		DB db = mdbc.getConnection().getDB("nbgardensdata");
		
		Set<String> collections = db.getCollectionNames();
		
		for(String collectionName: collections) {
			System.out.println(collectionName);
		}
		
		mdbc.mongoDisconnect();
	}
}
