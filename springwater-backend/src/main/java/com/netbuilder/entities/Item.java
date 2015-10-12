/**
 * @author chrisjwwalker
 * @date 06/10/2015
 */

package com.netbuilder.entities;

import org.springframework.data.annotation.Id;

public class Item {

	//Item attributes
	@Id
	private int idItem;
	private String itemName;
	private float price;
	private int stock;
	private String imageLocation;
	private boolean discontinued;
	//Might need these rates to be float
	private int salesRate;
	private int pSalesRate;
	private boolean isPorousware;
	
	
	private Supplier idSupplier;
	
	/**
	 * Constructor to build an instance of Item, not null variables are itemName, price, stock, imageLocation, discontinued and isPorouswares
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
	 */
	public Item(String itemName, float price, int stock, String imageLocation, boolean discontinued, int salesRate, int pSalesRate, boolean isPorousware, Supplier idSupplier) {
		this.itemName = itemName;
		this.price = price;
		this.stock = stock;
		this.imageLocation = imageLocation;
		this.discontinued = discontinued;
		this.salesRate = salesRate;
		this.pSalesRate = pSalesRate;
		this.isPorousware = isPorousware;
		this.idSupplier = idSupplier;
	}
	
	@Deprecated
	public Item() {
		
	}
	
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
    
    /**
     * Method to get the price of the item
     * @return Returns double data type
     */
    public double getPrice() {
		return price;
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
    public int getSalesRate() {
		return salesRate;
	}
    
    /**
     * Method to get the sales rate for the last period
     * @return Returns int data type
     */
    public int getpSalesRate() {
		return pSalesRate;
	}
    
    /**
     * Method to get the supplier information
     * @return Returns a Supplier Object
     */
    public Supplier getIdSupplier() {
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

    //Setters
    
    /**
     * Method to set the items name
     * @param itemName: String of the item name
     */
    public void setItemName(String itemName) {
		this.itemName = itemName;
	}

    /**
     * Method to set the items price
     * @param price: Int of items price
     */
	public void setPrice(float price) {
		this.price = price;
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
}
