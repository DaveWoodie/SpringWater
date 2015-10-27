/**
 * @author chrisjwwalker
 * @date 06/10/2015
 */

package com.netbuilder.entities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.data.annotation.Id;

public class Item {
	//Item attributes
	@Id
	private int idItem;
	private String itemName;
	private String itemDescription;
	private float price;
	private float cost;
	private int stock;
	private String imageLocation;
	private boolean discontinued;
	//Might need these rates to be float
	private double salesRate;
	private double pSalesRate;
	private boolean isPorousware;
	
	private HashMap<String, String> attributes;
	
	private int idSupplier;
	
	/**
	 * Constructor to build an instance of Item, not null variables are itemName, price, stock, imageLocation, discontinued and isPorousware
	 * 
	 * @author chrisjwwalker
	 * @param itemName : String; name of the item
	 * @param price : float; price of the item
	 * @param stock: int; how many of said item are in stock
	 * @param imageLocation: String; path to the image
	 * @param discontinued: boolean; is the item discontinued? Don't order more if true
	 * @param salesRate: int; how many of said item has been sold in this sales period
	 * @param pSalesRate: int; how many of said item have been sold in the last sales period
	 * @param isPorousware: boolean; can said item have porousware applied to it?
	 * @param idSupplier: Supplier: relates to the supplier information that this item can be purchased from
	 * @param attributes: HashMap of Srting to String detailing all of the procuct attributes
	 */
	public Item(String itemName, String itemDescription, float price, float cost, int stock, String imageLocation, boolean discontinued, boolean isPorousware, int idSupplier) {
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.price = price;
		this.cost = cost;
		this.stock = stock;
		this.imageLocation = imageLocation;
		this.discontinued = discontinued;
//		this.salesRate = salesRate;
//		this.pSalesRate = pSalesRate;
		this.isPorousware = isPorousware;
		this.idSupplier = idSupplier;
		this.attributes = new HashMap<String, String>();
	}
	
	@Deprecated
	public Item() { }
	
	/**
	 * Constructor that sets the Item's ID and name. Used in testing WishList's findItemByID() Method
	 * @param itemID
	 * @param itemName
	 */
	@Deprecated
	public Item(int itemID, String itemName) {
		this.idItem = itemID;
		this.itemName = itemName;
	}

    //Getters
	
	/**
	 * Method to get the items ID
	 * @return Returns int data type
	 */
	public int getIdItem() {
		return idItem;
	}
	
	/**
	 * Method to get the items name
	 * @return Returns String data type
	 */
    public String getItemName() {
		return itemName;
	}
    
    public String getDescription() {
    	return itemDescription;
    }
    
    /**
     * Method to get the price of the item
     * @return Returns double data type
     */
    public float getPrice() {
		return price;
	}
    
    public float getCost() {
    	return cost;
    }
    
    /**
     * Method to get how many of this item is in stock
     * @return Returns int data type
     */
    public int getStock() {
		return stock;
	}
    
    /**
     * Method to get the image location
     * @return Returns String data type
     */
    public String getImageLocation() {
		return imageLocation;
	}
    
    /**
     * Method to get the sales rate for this period
     * @return Returns int data type
     */
    public double getSalesRate() {
		return salesRate;
	}
    
    /**
     * Method to get the sales rate for the last period
     * @return Returns int data type
     */
    public double getpSalesRate() {
		return pSalesRate;
	}
    
    /**
     * Method to get the supplier information
     * @return Returns a Supplier Object
     */
    public int getIdSupplier() {
		return idSupplier;
	}
    
    /**
     * Method to see if item is discontinued
     * @return Returns true/false
     */
    public boolean isDiscontinued() {
		return discontinued;
	}

    /**
     * Method to see if the item can have porousware applied
     * @return Returns true/false
     */
	public boolean isPorousware() {
		return isPorousware;
	}

	public HashMap<String, String> getAttributes() {
		return attributes;
	}
	
	public String getAttribute(String attributeName) {
		return attributes.get(attributeName);
	}
    //Setters
    
	
	public void setItemID(int id) {
		this.idItem = id;
	}
    /**
     * Method to set the items name
     * @param itemName: String of the item name
     */
    public void setItemName(String itemName) {
		this.itemName = itemName;
	}
    
    public void setDescription(String newDescription) {
    	this.itemDescription = newDescription;
    }

    /**
     * Method to set the items price
     * @param price: Int of items price
     */
	public void setPrice(float price) {
		this.price = price;
	}
	
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	/**
	 * Method to set the items stock count
	 * @param stock: Int of the item stock count
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Method to set the images path
	 * @param imageLocation: String of the image path
	 */
    public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}
    
    /**
     * Method to set the item to porousable
     * @param isPorousware: Boolean to set if the item is porousable 
     */
    public void setPorousware(boolean isPorousware) {
		this.isPorousware = isPorousware;
	}

    /**
     * Method to set the item to discontinued or not
     * @param discontinued: boolean to set if the item is discontinued
     */
    public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}
    
    /**
     * Method to set the sales rate for this period
     * @param salesRate: int to set the sales rate for this period
     */
	public void setSalesRate(int salesRate) {
		this.salesRate = salesRate;
	}

	/**
	 * Method to set the sales rate for the last period
	 * @param pSalesRate: int to set the sales rate for the last period
	 */
	public void setpSalesRate(int pSalesRate) {
		this.pSalesRate = pSalesRate;
	}
	
	public void setAllAttributes(HashMap<String, String> newAttributes) {
		this.attributes = new HashMap<String, String>();
		attributes.putAll(newAttributes);
	}
	
	/**
	 * adds a new name and value pair to the item's attributes
	 * Throws exception if the attribute already exists within the item
	 * @param attributeName
	 * @param attributeVal
	 * @throws Exception
	 */
	public void addAttribute(String attributeName, String attributeVal) throws Exception {
		if(attributes.containsKey(attributeName)) {
			throw new Exception();
		} else {
			attributes.put(attributeName, attributeVal);
		}
	}
	
	/**
	 * updates the value associated with one of the Item's attributes.
	 * Throws exception if the attribute doesn't already exist within the item
	 * @param attributeName
	 * @param newAttributeVal
	 * @throws Exception
	 */
	public void updateAttributeValue(String attributeName, String newAttributeVal) throws Exception {
		if(!attributes.containsKey(attributeName)) {
			throw new Exception();
		} else {
			attributes.put(attributeName, newAttributeVal);
		}
	}
	
	public void removeAttribute(String attributeName) {
		attributes.remove(attributeName);
	}
	
	/**
	 * prints out the item's deets to the console. Used in testing
	 */
	public void print() {
		System.out.println("idItem: "+idItem);
		System.out.println("ItemName: "+itemName);
		System.out.println("ItemDescription: "+itemDescription);
		System.out.println("ImageLocation: "+imageLocation);
		System.out.println("NumberInStock: "+stock);
		System.out.println("ItemPrice: "+price);
		System.out.println("ItemCost: "+cost);
		System.out.println("SalesRate: "+salesRate);
		System.out.println("PSalesRate: "+pSalesRate);
		System.out.println("IsPorousware: "+isPorousware);
		System.out.println("IsDiscontinued: "+discontinued);
		System.out.println("idSupplier: "+idSupplier);
		System.out.println("ATTRIBUTES:");

	    Iterator<Entry<String, String>> it = attributes.entrySet().iterator();
	    while (it.hasNext()) {
			Map.Entry<String,String> pair = (Map.Entry<String, String>)it.next();
	        System.out.println(pair.getKey()+" - "+pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
		
	}
}