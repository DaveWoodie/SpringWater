package com.netbuilder.DBConnector;

import java.util.ArrayList;
import java.util.List;

import org.bson.BSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class MongoPull {

	private MongoDBConnector mdbc = new MongoDBConnector();
	
	private final String dataBase = "nbgardensdata";
	private final String AddrCol = "Address";
	private final String itemCol = "Item";
	private final String wishListCol = "WishList";
	
	private List<String> addrVals = new ArrayList<String>();

	public MongoPull() {

	}
	
	public List<String> getAddress(int id) {
		//Connect to MongoDB
		mdbc.mongoConnect();
		
		//Connect to the NBGardensn database
		DB db = mdbc.getConnection().getDB(dataBase);
		//Get Specfic Collection
		DBCollection collection = db.getCollection(AddrCol);
		
		BasicDBObject addr = new BasicDBObject();
		addr.put("idAddress", id);
		DBCursor cursor = collection.find(addr);		
		
		addrVals.clear();
		
		while(cursor.hasNext()) {
			
			cursor.next();
			
			BSONObject bsobj = (BSONObject) cursor.curr().get("AddressLines");
			int i = 1;
			while(bsobj.containsField("AddressLine" + i)) {
				//System.out.println(bsobj.get("AddressLine" + i).toString());
				addrVals.add(bsobj.get("AddressLine" + i).toString());
				
				i++;
			}
			
			
			addrVals.add(cursor.curr().get("City").toString());
			addrVals.add(cursor.curr().get("County").toString());
			addrVals.add(cursor.curr().get("PostCode").toString());
			
			//System.out.println(cursor.curr().get("City"));
			//System.out.println(cursor.curr().get("County"));
			//System.out.println(cursor.curr().get("PostCode"));
		}
				
		//Disconnect from MongoDB
		mdbc.mongoDisconnect();
		
		return addrVals;
	}
}