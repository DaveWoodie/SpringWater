/**
 * @author chrisjwwalker
 * @date 22/10/2015
 */

package connections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bson.BSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import entities.Address;
import entities.Item;
import entities.WishList;

public class MongoPull {

	//Create Instance of Mongo Connector to connect to DB
	private MongoDBConnector mdbc = new MongoDBConnector();
	
	//Strings specifying database and collections to use
	private final String dataBase = "nbgardensdata";
	private final String AddrCol = "Address";
	private final String itemCol = "Item";
	private final String wishListCol = "WishList";
	
	//Lists returned by the following methods
	private List<String> itemInfs = new ArrayList<String>();
	private List<String> wishListSet = new ArrayList<String>();

	
	/*
	public static void main(String[] args) {
		
		MongoPull pull = new MongoPull();
		MongoPush push = new MongoPush();
		ArrayList<Item> items = pull.getItemsBySupplier(1, false);
		for(Item i : items) {
			i.print();
			System.out.println();
		}
		
	}
	*/
	
	
	public MongoPull() {
		
	}
	
	/**
	 * 
	 * Method to fetch an address based on an address ID
	 * @param id: Takes an int which is the address ID
	 * @return returns an Address object  containing the address associated with the ID
	 */
	public Address getAddress(int addressID) {
		//Connect to MongoDB
		mdbc.mongoConnect();
		
		//Connect to the NBGardensn database
		DB db = mdbc.getConnection().getDB(dataBase);
		//Get Specfic Collection
		DBCollection collection = db.getCollection(AddrCol);
		
		BasicDBObject addr = new BasicDBObject();
		addr.put("idAddress", addressID);
		DBObject addrObj = collection.findOne(addr);		
		
		Address address = makeAddressEntityFromMongoObject(addrObj);
		
		//Disconnect from MongoDB
		mdbc.mongoDisconnect();
		
		return address;
	}
	
	
	/**
	 * takes a Mongo address Object and converts it into a java Address entity
	 * @param addrObj
	 * @return
	 */
	private Address makeAddressEntityFromMongoObject(DBObject addrObj) {


		ArrayList<String> addressLines = new ArrayList<String>();
		
		BSONObject bsobj = (BSONObject) addrObj.get("AddressLines");
		Set<String> keys = bsobj.keySet();
		for(String key : keys) {
			String val = bsobj.get(key).toString();
			addressLines.add(val);
		}
		String city = addrObj.get("City").toString();
		
		Object countyCheck = addrObj.get("County");
		String county = null;
		if(countyCheck != null) {
			county = addrObj.get("County").toString();
		}
		
		String postCode = addrObj.get("PostCode").toString();
		
		Address address;
		if(county == null) {
			address = new Address(addressLines, city, postCode);
		} else {
			address = new Address(addressLines, city, county, postCode);
		}
		
		Integer customerID;
		if(addrObj.get("idCustomer") != null) {
			customerID = (Integer) addrObj.get("idCustomer");
			address.setCustomerID(customerID);
		}
		
		address.setAddressID(((Double)(addrObj.get("idAddress"))).intValue());
		
		return address;
				
	}
	
	/**
	 * 
	 * returns an Item entity based on idItem
	 * @param id: Takes an int which is the idItem of a given item
	 * @return returns an Item object containing all the information for the given item
	 */
	public Item getItem(int id) {
		//Connect to MongoDB
		mdbc.mongoConnect();
		
		//Connect to the NBGardens database
		DB db = mdbc.getConnection().getDB(dataBase);
		//Get Specific Collection
		DBCollection collection = db.getCollection(itemCol);
		
		BasicDBObject searchItem = new BasicDBObject();
		searchItem.put("idItem", id);
		DBObject itemObj = collection.findOne(searchItem);
		
		itemInfs.clear();
		
		Item newItem = makeItemEntityFromMongoObject(itemObj);
		
		//Disconnect from MongoDB
		mdbc.mongoDisconnect();
		
		return newItem;
	}
	
	/**
	 * returns all items provided by the passed supplier. If includeDiscontinued is set to true, will return discontinued items as well
	 * @param supplierID
	 * @param includeDiscontinued - flag to request discontinued items as well as current items
	 * @return
	 */
	public ArrayList<Item> getItemsBySupplier(int supplierID, boolean includeDiscontinued) {
		ArrayList<Item> items = new ArrayList<Item>();

		mdbc.mongoConnect();
		
		//Connect to the NBGardens database
		DB db = mdbc.getConnection().getDB(dataBase);
		//Get Specific Collection
		DBCollection collection = db.getCollection(itemCol);

		BasicDBObject searchItem = new BasicDBObject();
		searchItem.put("idSupplier", supplierID);
		if(!includeDiscontinued) {
			searchItem.put("Discontinued", false);
		}
		
		DBCursor cursor = collection.find(searchItem);
		
		while(cursor.hasNext()) {
			cursor.next();
			Item item = makeItemEntityFromMongoObject(cursor.curr());
			items.add(item);
		}
		
		mdbc.mongoDisconnect();
		
		return items;
		
		
		
	}
	
	private Item makeItemEntityFromMongoObject(DBObject itemObj) {

		Item newItem;
		
		String itemName = itemObj.get("ItemName").toString();
		String itemDescription = itemObj.get("ItemDescription").toString();
		String numberInStock = itemObj.get("NumberInStock").toString();
		String itemPrice = itemObj.get("ItemPrice").toString();
		String itemCost = itemObj.get("ItemCost").toString();
		String imageLocation = itemObj.get("ImageLocation").toString();
		itemInfs.add(itemObj.get("SalesRate").toString());
		itemInfs.add(itemObj.get("PSalesRate").toString());
		boolean isPorousWare = handleMongoBoolean(itemObj.get("IsPorousware"));
		boolean discontinued = handleMongoBoolean(itemObj.get("Discontinued"));
		String idSupplier = itemObj.get("idSupplier").toString();
		
		newItem = new Item(itemName, itemDescription, Float.parseFloat(itemPrice), Float.parseFloat(itemCost), (int) Float.parseFloat(numberInStock), imageLocation, discontinued, isPorousWare, (int) Float.parseFloat(idSupplier));
		newItem.setItemID((Integer) itemObj.get("idItem") );
		
		
		BSONObject bsobj = (BSONObject) itemObj.get("Attributes");
		Set<String> keys = bsobj.keySet();
		for(String key : keys) {
			String val = bsobj.get(key).toString();
			
			try {
				newItem.addAttribute(key, val);
			} catch (Exception e) {
				throw new Error(e);
			}
		}
		
		return newItem;
	}
	
	/**
	 * Wrapper method for getItem() in order to return the Item corresponding to the passed itemID within an ArrayList containing only that item
	 * @param itemID
	 * @return
	 */
	public ArrayList<Item> getItemAsArrayList(int itemID) {
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList.add(getItem(itemID));
		return itemList;
	}
	
	/**
	 * method to evaluate the passed Mongo boolean field
	 * @param fieldToEvaluate
	 * @return
	 */
	private boolean handleMongoBoolean(Object fieldToEvaluate) {
		return fieldToEvaluate.toString().equals("true");
	}
	
	/**
	 * 
	 * Method to fetch the contents of a customers wish list
	 * 
	 * Order that information is returned 
	 * 	> idItemX
	 * 
	 * @param id : Takes an int which is the idCustomer of a customer 
	 * @return returns a List containing the items stored within a customers wish list 
	 */
	public WishList getWishList(int custID) {
		//Connect to MongoDB
		mdbc.mongoConnect();
		
		//Connect to the NBGardensn database
		DB db = mdbc.getConnection().getDB(dataBase);
		//Get Specfic Collection
		DBCollection collection = db.getCollection(wishListCol);
		
		BasicDBObject wL = new BasicDBObject();
		wL.put("idCustomer", custID);
		DBObject wishListObj = collection.findOne(wL);
		
		wishListSet.clear();
		
		ArrayList<Item> wlItems = new ArrayList<Item>();
		BSONObject itemObj = (BSONObject) wishListObj.get("items");
		Set<String> keys = itemObj.keySet();
		for(String key : keys) {
			Integer itemID = (Integer) itemObj.get(key);
			wlItems.add(getItem(itemID));
		}
		
		WishList wish = new WishList(custID, wlItems);
				
		//Disconnect from MongoDB
		mdbc.mongoDisconnect();
		
		return wish;
	}
}