/**
 * @author chrisjwwalker
 * @date 22/10/2015
 */

package connections;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;

public class MongoDBConnector {

	/*
	 * 
	 * String to specify URL to MongoDB
	 * 
	 * */
	static final String mongoURL = "10.50.15.39";
	
	private MongoClient mongoClient;
	
	/**
	 * 
	 * Method to connect to the MongoDB
	 * 
	 */
	public void mongoConnect() {
		try {
			mongoClient = new MongoClient(mongoURL, 27017);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * Method to disconnect from MongoDB
	 * 
	 */
	public void mongoDisconnect() {
		mongoClient.close();
	}
	
	/**
	 * 
	 * public method to return the mongo client to be used in other classes
	 * 
	 * @return MongoClient
	 */
	public MongoClient getConnection() {
		return mongoClient;
	}
}
