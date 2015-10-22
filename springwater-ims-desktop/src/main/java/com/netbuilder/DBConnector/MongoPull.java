/**
 * @author chrisjwwalker
 * @date 22/10/2015
 */

package com.netbuilder.DBConnector;

import java.util.ArrayList;
import java.util.List;

import org.bson.BSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class MongoPull {

	//Create Instance of Mongo Connector to connect to DB
	private MongoDBConnector mdbc = new MongoDBConnector();
	
	//Strings specifying database and collections to use
	private final String dataBase = "nbgardensdata";
	private final String AddrCol = "Address";
	private final String itemCol = "Item";
	private final String wishListCol = "WishList";
	
	//Lists returned by the following methods
	private List<String> addrVals = new ArrayList<String>();
	private List<String> itemInfs = new ArrayList<String>();
	private List<String> wishListSet = new ArrayList<String>();

	public MongoPull() {

	}
	
	/**
	 * 
	 * Method to fetch an address based on an address ID
	 * 
	 * @param id: Takes an int which is the address ID
	 * @return returns a List containing all the lines of address associated with the ID
	 */
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
				addrVals.add(bsobj.get("AddressLine" + i).toString());
				i++;
			}
			
			addrVals.add(cursor.curr().get("City").toString());
			addrVals.add(cursor.curr().get("County").toString());
			addrVals.add(cursor.curr().get("PostCode").toString());
		}
		
		cursor.close();
				
		//Disconnect from MongoDB
		mdbc.mongoDisconnect();
		
		return addrVals;
	}
	
	/**
	 * 
	 * Method to fetch all the information stored on a given item based on idItem
	 * 
	 * @param id: Takes an int which is the idItem of a given item
	 * @return returns a list containing all the information for the given item
	 */
	public List<String> getItemInf(int id) {
		//Connect to MongoDB
		mdbc.mongoConnect();
		
		String attrs[] = {"Height","Width","Depth","HatColour","Accessory","DialStone","Colour","NumberOfPeople"};
		
		//Connect to the NBGardensn database
		DB db = mdbc.getConnection().getDB(dataBase);
		//Get Specfic Collection
		DBCollection collection = db.getCollection(itemCol);
		
		BasicDBObject item = new BasicDBObject();
		item.put("idItem", id);
		DBCursor cursor = collection.find(item);		
		
		itemInfs.clear();
		
		while(cursor.hasNext()) {
			
			cursor.next();
			
			itemInfs.add(cursor.curr().get("ItemName").toString());
			itemInfs.add(cursor.curr().get("ItemDescription").toString());
			itemInfs.add(cursor.curr().get("NumberInStock").toString());
			itemInfs.add(cursor.curr().get("ItemPrice").toString());
			itemInfs.add(cursor.curr().get("ItemCost").toString());
			itemInfs.add(cursor.curr().get("SalesRate").toString());
			itemInfs.add(cursor.curr().get("PSalesRate").toString());
			itemInfs.add(cursor.curr().get("IsPorousware").toString());
			itemInfs.add(cursor.curr().get("Discontinued").toString());
			itemInfs.add(cursor.curr().get("idSupplier").toString());
			
			BSONObject bsobj = (BSONObject) cursor.curr().get("Attributes");
			
			for(int i = 0; i < attrs.length; i++) {
				if(bsobj.containsField(attrs[i])) {
					itemInfs.add(bsobj.get(attrs[i]).toString());
				}
			}
		}
		
		cursor.close();
		
		//Disconnect from MongoDB
		mdbc.mongoDisconnect();
		
		return itemInfs;
	}
	
	/**
	 * 
	 * Method to fetch the contents of a customers wish list
	 * 
	 * @param id : Takes an int which is the idCustomer of a customer 
	 * @return returns a List containing the items stored within a customers wish list 
	 */
	public List<String> getWishList(int id) {
		//Connect to MongoDB
		mdbc.mongoConnect();
		
		//Connect to the NBGardensn database
		DB db = mdbc.getConnection().getDB(dataBase);
		//Get Specfic Collection
		DBCollection collection = db.getCollection(wishListCol);
		
		BasicDBObject wL = new BasicDBObject();
		wL.put("idCustomer", id);
		DBCursor cursor = collection.find(wL);		
		
		wishListSet.clear();
		
		while(cursor.hasNext()) {
			
			cursor.next();
			
			BSONObject bsobj = (BSONObject) cursor.curr().get("items");
			int i = 1; 
			while(bsobj.containsField("idItem" + i)) {
				wishListSet.add(bsobj.get("idItem" + i).toString());
				
				i++;
			}
		}
		
		cursor.close();
				
		//Disconnect from MongoDB
		mdbc.mongoDisconnect();
		
		return wishListSet;
	}
}