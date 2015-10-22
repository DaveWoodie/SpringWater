package com.netbuilder.DBConnector;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;

public class MongoDBConnector {

	static final String mongoURL = "10.50.15.15";
	static final String userName = "superuser";
	static final String passWord = "12345678";
	
	private MongoClient mongoClient;
	
	public void mongoConnect() {
		try {
			mongoClient = new MongoClient(mongoURL, 27017);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public void mongoDisconnect() {
		mongoClient.close();
	}
	
	public MongoClient getConnection() {
		return mongoClient;
	}
}
