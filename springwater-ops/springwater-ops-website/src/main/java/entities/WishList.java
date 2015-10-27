package entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 * 
 * @author ccooper
 * @date 06/10/2015
 *
 */
public class WishList {
	
	private int customerID;
	private ArrayList<Item> items;
	
	/**
	 * @Class constructor initialises Wish List Line attributes
	 * @param item : The list of items to be added to the WishList
	 * @param customer : The customer that owns the WishList
	 */
	public WishList(int customerID, ArrayList<Item> items) {
		// Initialise attributes
		this.customerID = customerID;
		this.items = new ArrayList<Item>();
		for(int i = 0; i < items.size(); i++) {
			this.items.add(items.get(i));
		}
	}
	
	/**
	 * constructor to initialise WishList with a blank ArrayList of Items
	 * @param customer
	 * @MethodAuthor tstacey
	 * @date 08/10/2015
	 */
	public WishList(int customerID) {
		this.customerID = customerID;
		this.items = new ArrayList<Item>();
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public int getNumberOfItems() {
		return items.size();
	}
	
	public int getCustomerID() {
		return customerID;
	}

	public void addItem(Item i) {
		items.add(i);
	}
	
	/**
	 * searches for an item in the Customer's WishList by item ID and returns that Item.
	 * Throws IOException if item doesn't exist in WishList
	 * @MethodAuthor tstacey
	 * @param itemID
	 * @return Item
	 * @throws IOException
	 * @date 08/10/2015
	 */
	public Item getItemByID(int itemID) throws IOException {
		for(Item i : items) {
			if(i.getIdItem() == itemID) {
				return i;
			}
		}
		throw new IOException("Couldn't locate Item with ID "+itemID+"in WishList");
	}
	
	/**
	 * searches for an item in the Customer's WishList by item ID and removes that Item.
	 * Throws IOException if item doesn't exist in WishList
	 * @MethodAuthor tstacey
	 * @param itemID
	 * @return the removed item
	 * @throws IOException
	 * @date 08/10/2015
	 */
	public Item removeItem(int itemID) throws IOException {
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getIdItem() == itemID) {
				return items.remove(i);
				
			}
		}
		
		throw new IOException("Couldn't locate Item with ID "+itemID+"in WishList");
	}
	
	/**
	 * Removes all items from the Customer's WishList
	 * @MethodAuthor tstacey
	 * @date 08/10/2015
	 */
	public void removeAllItems() {
		int arraySize = items.size();
		for(int i = 0; i < arraySize; i++) {
			items.remove(0);
		}
	}
	
	/**
	 * 
	 * @Method is a mutator customer ID.
	 */
	public void setCustomer(int c) {
		this.customerID = c;
	}
	
	public void print() {
		System.out.println("Customer ID: "+this.customerID);
		System.out.println("Items: ");
		for(Item i : this.items) {
			System.out.println(i.getItemName());
		}
	}
}