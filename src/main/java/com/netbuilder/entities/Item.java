///////////////////////////////
//							 //
//	Project SpringWater		 //
//	Chris J W Walker		 //
//	Item details			 //
//							 //
///////////////////////////////

package com.netbuilder.entities;

public class Item {

	//Item attributes
	private int idItem;
	private String itemName;
	private float price;
	private int stock;
	private String imageLocation;
	private boolean discontinued;
	private int salesRate;
	private int pSalesRate;
	private boolean isPorousware;
	private Supplier idSupplier;
	
	//Constructor
	public Item(String iName, float p, int s, String iLoc, boolean dc, int sr, int psr, boolean ip, Supplier ids) {
		itemName = iName;
		price = p;
		stock = s;
		imageLocation = iLoc;
		discontinued = dc;
		salesRate = sr;
		pSalesRate = psr;
		isPorousware = ip;
		idSupplier = ids;
	}

    //Getters
	public int idItem() {
		return idItem;
	}
	
    public String getItemName() {
		return itemName;
	}
    
    public float getPrice() {
		return price;
	}
    
    public int getStock() {
		return stock;
	}
    
    public String getImageLocation() {
		return imageLocation;
	}
    
    public int getSalesRate() {
		return salesRate;
	}
    
    public int getpSalesRate() {
		return pSalesRate;
	}
    
    public Supplier getIdSupplier() {
		return idSupplier;
	}

    //Setters
    public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}

    public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}
    
    public void setPorousware(boolean isPorousware) {
		this.isPorousware = isPorousware;
	}

    public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}
    
	public void setSalesRate(int salesRate) {
		this.salesRate = salesRate;
	}

	public void setpSalesRate(int pSalesRate) {
		this.pSalesRate = pSalesRate;
	}
	
    //Booleans
	public boolean isDiscontinued() {
		return discontinued;
	}

	public boolean isPorousware() {
		return isPorousware;
	}
}
