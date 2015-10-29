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
import entities.Review;
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

	
	
//	public static void main(String[] args) {
//		
//		MongoPull pull = new MongoPull();
//		MongoPush push = new MongoPush();
//		
//		
//		ArrayList<Review> revs = new ArrayList<Review>();
//		revs.add(new Review("spadeyboiii", 0,
//				"It's not so hip to be square with this poorly crafted spade")
//		);
//		revs.add(new Review("luvmeshrubs", 0,
//				"The worst spade I have ever purchased.")
//		);
//		revs.add(new Review("luvmeshrubs1", 0, "Not good at all."));
//		revs.add(new Review("xXspearjacksonXx", 5,
//				"WOW. BRILLIANT. BEST SPADE EVER."));
//		revs.add(new Review("xXspearjackson2Xx", 5,
//				"WOW. BRILLIANT. BEST SPADE EVER."));
//		revs.add(new Review("xXspearjackson3Xx", 5,
//				"WOW. BRILLIANT. BEST SPADE EVER."));
//		revs.add(new Review("xXspearjackson4Xx", 5,
//				"WOW. BRILLIANT. BEST SPADE EVER."));
//		revs.add(new Review("xXspearjackson5Xx", 5,
//				"WOW. BRILLIANT. BEST SPADE EVER."));
//		revs.add(new Review("xXspearjackson6Xx", 5,
//				"WOW. BRILLIANT. BEST SPADE EVER."));
//		Item newItem = new Item(
//						"Neverbend Square Shovel",
//						"Square, open socket shovel. Hammer finish epoxy coated head for improved resistance to rust, scratches, humidity and alkalines in the soil. Weatherproofed hardwood shaft for greater durability. Supergrip handle - forward tilt gives the ideal digging angle. Treaded for more comfortable digging.",
//						(float)29.99,
//						(float)15.40,
//						85,
//						"neverbend.jpg",
//						false,
//						false,
//						1,
//						35,
//						30,
//						revs
//					);
//		try {
//			newItem.addAttribute("Category", "Tools");
//			newItem.addAttribute("Keyword", "Spade");
//			newItem.addAttribute("Color", "Grey");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new Error(e);
//		}
//		
//		push.addItem(newItem);
//		
//		revs = new ArrayList<Review>();
//		revs.add(new Review("gn0meconnoisseur", 4,
//				"I give this gnome a 4/5"));
//		revs.add(new Review("iLUVGNOMEZ", 4, "Smashing gnome lads."));
//		
//		newItem = new Item(
//				"Happy Gnome",
//				"Beautifully hand decorated Standing Gnome Statuary for your yard or garden",
//				(float)11.99,
//				(float)3.90,
//				200,
//				"happygnome.jpg",
//				false,
//				true,
//				2,
//				78,
//				102,
//				revs
//			);
//		try {
//			newItem.addAttribute("Category", "Gnomes");
//			newItem.addAttribute("Keyword", "Gnome");
//			newItem.addAttribute("Color", "Green");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new Error(e);
//		}
//		
//		push.addItem(newItem);
//		
//		revs = new ArrayList<Review>();
//		revs.add(new Review("gn0meconnoisseur", 5,
//				"I give this gnome a 5/5"));
//		revs.add(new Review("gnometorious", 5, "I love a good mushroom!"));
//		
//		newItem = new Item(
//				"Gnome With Mushroom",
//				"Add color, spice and life to your outdoors with these cast stone resin gnome statuaries. These sturdy statuaries boast hues of blue, green and red. Made of Polyresin. Whimsical Gnome figures. Skillfully crafted to be balanced and durable.",
//				(float)11.99,
//				(float)3.90,
//				180,
//				"mushroomgnome.jpg",
//				false,
//				true,
//				2,
//				20,
//				5,
//				revs
//			);
//		try {
//			newItem.addAttribute("Category", "Gnomes");
//			newItem.addAttribute("Keyword", "Gnome");
//			newItem.addAttribute("Color", "Green");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new Error(e);
//		}
//
//		push.addItem(newItem);
//		
//		revs = new ArrayList<Review>();
//		revs.add(new Review("gn0meconnoisseur", 4,
//				"I give this gnome a 4/5"));
//		revs.add(new Review("gardenblitz", 4, "4 stars."));
//		
//		newItem = new Item(
//				"Gnome With Lantern",
//				"This wonderfully detailed garden gnome statue carries a lantern with an LED light. Made of cold cast resin, the gnome measures 17 inches tall, 8 inches wide and 6 inches deep. The lantern itself is 2 1/4 inches in diameter, 5 inches tall. He`s hand-painted, and shows great detail. The lantern runs on a pair of AA Batteries (not included). This statue makes a wonderful gift for any gnome collector.",
//				(float)11.99,
//				(float)3.90,
//				580,
//				"lanterngnome.jpg",
//				false,
//				true,
//				2,
//				109,
//				100,
//				revs
//			);
//		try {
//			newItem.addAttribute("Category", "Gnomes");
//			newItem.addAttribute("Keyword", "Gnome");
//			newItem.addAttribute("Color", "Blue");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new Error(e);
//		}
//
//		push.addItem(newItem);
//		
//		revs = new ArrayList<Review>();
//		revs.add(new Review("gn0meconnoisseur", 3,
//				"I give this gnome a 3/5"));
//		revs.add(new Review("wheelbarrowKING", 4, "Wheely good"));
//		revs.add(new Review("johnwheelbarrowman", 5,
//				"Another top gnome to add to my wheelbarrow gnome collection."));
//		
//		newItem = new Item(
//				"Gnome With Wheelbarrow",
//				"Our garden gnome is ready for his farmyard chores and he's even brought his trusty wheelbarrow to assist! Endowed with an oversized, pointed red gnome hat, this unique garden gnome statue promises to lend his magic to home or garden. Lovingly sculpted, then intricately cast in quality designer resin, this Design Toscano exclusive garden gnome sculpture is hand-painted one piece at a time exclusively by Toscano skilled gnome artisans. ",
//				(float)11.99,
//				(float)3.90,
//				350,
//				"wheelbarrowgnome.jpg",
//				false,
//				true,
//				2,
//				55,
//				102,
//				revs
//			);
//		try {
//			newItem.addAttribute("Category", "Gnomes");
//			newItem.addAttribute("Keyword", "Gnome");
//			newItem.addAttribute("Color", "Blue");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new Error(e);
//		}
//
//		push.addItem(newItem);
//		
//		revs = new ArrayList<Review>();
//		revs.add(new Review("gn0meconnoisseur", 4,
//				"I give this gnome a 5/5"));
//		revs.add(new Review("gnorman", 5,
//				"Three cheeky chaps, what could go wrong?!"));
//		revs.add(new Review("pondLAD", 3,
//				"I lost one of my gnomes in the pond."));
//		
//		newItem = new Item(
//				"Gnome Triple Pack",
//				"This set of 3 garden gnomes... Hear no evil... See no evil... Speak no evil garden gnomes are ready to be placed in your garden!  They are approx. 6 inches tall, made of polyresin, which is resistant to weather. Can be placed inside or for outside use! They are adorable, colorful, reds, greens and blues!  Just plain cute!!!",
//				(float)11.99,
//				(float)3.90,
//				58,
//				"threegnomes.jpg",
//				false,
//				true,
//				2,
//				95,
//				26,
//				revs
//			);
//		try {
//			newItem.addAttribute("Category", "Gnomes");
//			newItem.addAttribute("Keyword", "Gnome");
//			newItem.addAttribute("Color", "Red");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new Error(e);
//		}
//		
//
//		push.addItem(newItem);
//		
//		revs = new ArrayList<Review>();
//		revs.add(new Review("gn0meconnoisseur", 0,
//				"I give this gnome a 0/5"));
//		revs.add(new Review("sp00kyGn0m3", 0, "What the hell is this?!!"));
//		
//		newItem = new Item(
//				"Creepy Gnome",
//				"I don't know what's in that moonshine, but it keeps him up all night. All the better to keep watch over your yard. ",
//				(float)11.99,
//				(float)3.90,
//				263,
//				"creepygnome.jpg",
//				false,
//				true,
//				2,
//				25,
//				7,
//				revs
//			);
//		try {
//			newItem.addAttribute("Category", "Gnomes");
//			newItem.addAttribute("Keyword", "Gnome");
//			newItem.addAttribute("Color", "Green");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new Error(e);
//		}
//
//		push.addItem(newItem);
//		
//		revs = new ArrayList<Review>();
//		revs.add(new Review("potsmouth", 5, "Just what I needed!"));
//		revs.add(new Review("XxxxxxxPOTxxxxxxX", 5,
//				"Top pot for a top lad."));
//		
//		newItem = new Item(
//				"Large Brown Pot",
//				"A large striped pot made of only the finest clay.",
//				(float)25.99,
//				(float)10.15,
//				212,
//				"pot03.jpg",
//				false,
//				true,
//				1,
//				50,
//				55,
//				revs
//			);
//		try {
//			newItem.addAttribute("Category", "Pottery");
//			newItem.addAttribute("Keyword", "Pot");
//			newItem.addAttribute("Color", "Red");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new Error(e);
//		}
//
//		push.addItem(newItem);
//		
//		revs = new ArrayList<Review>();
//		revs.add(new Review("loveAgoodDuck", 0,
//				"Doesn't come with a rubber duck. 0/5"));
//		
//		newItem = new Item(
//				"Jacuzzi 5001",
//				"This superior quality hot tub is ideal for 6-7 people great for parties or just relaxing in the full length lounger position and is the ultimate entertainment tub with cool features like the corner Ice Bucket there are no other hot tubs available on the market that compares with the amount of features and the quality offered by this fantastic spa.",
//				(float)8999.99,
//				(float)2500.00,
//				25,
//				"jacuzzi02.jpg",
//				false,
//				true,
//				1,
//				2,
//				1,
//				revs
//			);
//		try {
//			newItem.addAttribute("Category", "Furniture");
//			newItem.addAttribute("Keyword", "Jacuzzi");
//			newItem.addAttribute("Color", "White");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new Error(e);
//		}
//
//		push.addItem(newItem);
//		
//		
//		
////		
////		ArrayList<Item> items = pull.getAllItems();
////		for(Item it : items) {
////			it.print();
////			System.out.println();
////		}
//		
//		ArrayList<Address> addresses = pull.getAllAddresses();
//		for(Address a : addresses) {
//			push.updateAddress(a);
//		}
//		
//	}
//	
	public MongoPull() {
		
	}
	

	/*********************************************************************************/
	// ADDRESSES ADDRESSES ADDRESSES ADDRESSES ADDRESSES ADDRESSES ADDRESSES ADDRESSES
	/*********************************************************************************/
	 
	
	/**
	 * 
	 * Method to fetch an address based on an address ID
	 * @param id: Takes an int which is the address ID
	 * @return returns an Address object  containing the address associated with the ID
	 */
	public Address getAddress(int addressID) {
		//Connect to MongoDB
		mdbc.mongoConnect();
		
		DBCollection collection = this.getCollection(AddrCol);
		
		BasicDBObject addr = new BasicDBObject();
		addr.put("idAddress", addressID);
		DBObject addrObj = collection.findOne(addr);
		
		Address address = makeAddressEntityFromMongoObject(addrObj);
		
		//Disconnect from MongoDB
		mdbc.mongoDisconnect();
		
		return address;
	}
	
	/**
	 * returns all Addresses stored in the MongoDB database
	 * @return ArrayList of Address entities
	 */
	public ArrayList<Address> getAllAddresses() {
		ArrayList<Address> addresses = new ArrayList<Address>();
		//Connect to MongoDB
		mdbc.mongoConnect();
		
		DBCollection collection = this.getCollection(AddrCol);
		
		DBCursor cursor = collection.find();
		while(cursor.hasNext()) {
			DBObject addrObj =  cursor.next();
			addresses.add(makeAddressEntityFromMongoObject(addrObj));
		}		
		//Disconnect from MongoDB
		mdbc.mongoDisconnect();
		
		return addresses;
	}
	
	/**
	 * Returns an ArrayList of Address entities corresponding to the passed customerID
	 * @param custID - the id of the customer for whom you want addresses
	 * @return ArrayList of Address entities
	 */
	public ArrayList<Address> getAddressesByCustomerID(int custID) {
		ArrayList<Address> addresses = new ArrayList<Address>();
		//Connect to MongoDB
		mdbc.mongoConnect();
		
		DBCollection collection = this.getCollection(AddrCol);
		BasicDBObject searchObj = new BasicDBObject();
		searchObj.put("idCustomer", custID);
		
		DBCursor cursor = collection.find(searchObj);
		while(cursor.hasNext()) {
			DBObject addrObj =  cursor.next();
			addresses.add(makeAddressEntityFromMongoObject(addrObj));
		}		
		//Disconnect from MongoDB
		mdbc.mongoDisconnect();
		
		return addresses;
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
	

	/******************************************************************************/
	// ITEMS ITEMS ITEMS ITEMS ITEMS ITEMS ITEMS ITEMS ITEMS ITEMS ITEMS ITEMS ITEMS
	/******************************************************************************/
	
	
	/**
	 * 
	 * returns an Item entity based on idItem
	 * @param id: Takes an int which is the idItem of a given item
	 * @return returns an Item object containing all the information for the given item
	 */
	public Item getItem(int id) {
		//Connect to MongoDB
		mdbc.mongoConnect();
		
		DBCollection collection = this.getCollection(itemCol);
		
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
		
		DBCollection collection = this.getCollection(itemCol);

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

	/**
	 * returns all items (both current and discontinued) from the mongoDB database
	 * @return ArrayList of Item entities
	 */
	public ArrayList<Item> getAllItems() {
		ArrayList<Item> items = new ArrayList<Item>();

		mdbc.mongoConnect();
		
		DBCollection collection = this.getCollection(itemCol);
		DBCursor cursor = collection.find();
		while(cursor.hasNext()) {
			DBObject itemObj = cursor.next();
			items.add(makeItemEntityFromMongoObject(itemObj));
		}
		return items;
	}
	
	/**
	 * returns all Items from the MongoDB that are marked as discontinued
	 * @return ArrayList of Item entities
	 */
	public ArrayList<Item> getAllDiscontinuedItems() {
		return this.getAllItems(true);
	}

	/**
	 * returns all Items from the MongoDB that are not marked as discontinued
	 * @return ArrayList of Item entities
	 */
	public ArrayList<Item> getAllCurrentItems() {
		return this.getAllItems(false);
	}
	
	
	/**
	 * returns all Items from the MongoDB database depending on the passed discontinued boolean
	 * @param discontinued
	 * @return ArrayList of Item Entities
	 */
	private ArrayList<Item> getAllItems(boolean discontinued) {
		ArrayList<Item> items = new ArrayList<Item>();

		mdbc.mongoConnect();
		
		DBCollection collection = this.getCollection(itemCol);
		BasicDBObject searchItem = new BasicDBObject();
		searchItem.put("Discontinued", discontinued);
		
		DBCursor cursor = collection.find(searchItem);
		while(cursor.hasNext()) {
			DBObject itemObj = cursor.next();
			items.add(makeItemEntityFromMongoObject(itemObj));
		}
		return items;
	}
	
	
	/**
	 * returns all non-discontinued items with an attribute to match the name-value pair passed to the method
	 * @param attributeName - the name of the attribute to search for
	 * @param attributeVal - the corresponding string value of that attribute
	 * @return ArrayList of Item entities
	 */
	public ArrayList<Item> getItemsByAttribute(String attributeName, String attributeVal) {
		ArrayList<Item> items = new ArrayList<Item>();

		mdbc.mongoConnect();
		
		DBCollection collection = this.getCollection(itemCol);
		BasicDBObject searchObj = new BasicDBObject();
		searchObj.put("Attributes."+attributeName,attributeVal);
		
		DBCursor cursor = collection.find(searchObj);
		while(cursor.hasNext()) {
			DBObject itemObj = cursor.next();
			Item i = makeItemEntityFromMongoObject(itemObj);
			if(!i.isDiscontinued()) {
				items.add(i);
			}
		}
		return items;
	}
	

	/**
	 * returns all non-discontinued items with an attribute to match the name-value pair passed to the method
	 * @param attributeName - the name of the attribute to search for
	 * @param attributeVal - the corresponding Integer value of that attribute
	 * @return ArrayList of Item entities
	 */
	public ArrayList<Item> getItemsByAttribute(String attributeName, Integer attributeVal) {
		return getItemsByAttribute(attributeName,((Double)attributeVal.doubleValue()).toString());
		
	}

	/**
	 * returns all non-discontinued items with an attribute to match the name-value pair passed to the method
	 * @param attributeName - the name of the attribute to search for
	 * @param attributeVal - the corresponding Double value of that attribute
	 * @return ArrayList of Item entities
	 */
	public ArrayList<Item> getItemsByAttribute(String attributeName, Double attributeVal) {
		return getItemsByAttribute(attributeName,attributeVal.toString());
		
	}
	
	private Item makeItemEntityFromMongoObject(DBObject itemObj) {

		Item newItem;
		
		String itemName = itemObj.get("ItemName").toString();
		String itemDescription = itemObj.get("ItemDescription").toString();
		String numberInStock = itemObj.get("NumberInStock").toString();
		String itemPrice = itemObj.get("ItemPrice").toString();
		String itemCost = itemObj.get("ItemCost").toString();
		String imageLocation = itemObj.get("ImageLocation").toString();
		String salesRate = (itemObj.get("SalesRate").toString());
		String pSalesRate = (itemObj.get("PSalesRate").toString());
		boolean isPorousWare = handleMongoBoolean(itemObj.get("IsPorousware"));
		boolean discontinued = handleMongoBoolean(itemObj.get("Discontinued"));
		String idSupplier = itemObj.get("idSupplier").toString();
		
		newItem = new Item(itemName, itemDescription, Float.parseFloat(itemPrice), Float.parseFloat(itemCost), (int) Float.parseFloat(numberInStock), imageLocation, discontinued, isPorousWare, (int) Float.parseFloat(idSupplier), (int) Float.parseFloat(salesRate), (int) Float.parseFloat(pSalesRate));
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
		
		ArrayList<Review> reviews = getReviewsFromMongoItem(itemObj);
		for(Review r : reviews) {
			newItem.addReview(r);
		}
		
		
		
		return newItem;
	}
	
	private ArrayList<Review> getReviewsFromMongoItem(DBObject itemObj) {
		ArrayList<Review> revs = new ArrayList<Review>();
		BSONObject bsobj = (BSONObject) itemObj.get("Reviews");
		if(bsobj != null) {
			Set<String> keys = bsobj.keySet();
			for(String key : keys) {
				DBObject rev = (DBObject) bsobj.get(key);
				String auth = rev.get("reviewAuthor").toString();
				int rating = (Integer) rev.get("reviewRating");
				String body = rev.get("reviewBody").toString();
				Review newRev = new Review(auth, rating, body);
				revs.add(newRev);
				
			}
		}
		return revs;
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
	
	

	/**********************************************************************************/
	// WISHLIST WISHLIST WISHLIST WISHLIST WISHLIST WISHLIST WISHLIST WISHLIST WISHLIST
	/**********************************************************************************/
	
	
	/**
	 * Returns the WishList entity from the MongoDB database corresponding to the passed customerID
	 * @param custID : Takes an int which is the idCustomer of a customer 
	 * @return returns a List containing the items stored within a customer's wish list 
	 */
	public WishList getWishList(int custID) {
		//Connect to MongoDB
		mdbc.mongoConnect();
		DBCollection collection = this.getCollection(wishListCol);
		
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
	
	

	/**********************************************************************************/
	// MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC MISC
	/**********************************************************************************/
	
	
	/**
	 * returns a collection from the nbgardens database
	 * @param collectionName - the name of the collection to be returned
	 * @return collection
	 */
	private DBCollection getCollection(String collectionName) {
		//Connect to the NBGardens database
		DB db = mdbc.getConnection().getDB(dataBase);
		//Get Specfic Collection
		DBCollection collection = db.getCollection(collectionName);
		return collection;
	}

	/**
	 * method to evaluate the passed Mongo boolean field
	 * @param fieldToEvaluate
	 * @return
	 */
	private boolean handleMongoBoolean(Object fieldToEvaluate) {
		return fieldToEvaluate.toString().equals("true");
	}
}