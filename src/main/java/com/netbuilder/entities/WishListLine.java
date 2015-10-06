package com.netbuilder.entities;

public class WishListLine {
	
	// Wish list line attributes
	private int idItem;
	private int idCustomer;
	
	// Class constructor
	public WishListLine(int idItem, int idCustomer)
	{
		// Initialise attributes
		this.idItem = idItem;
		this.idCustomer = idCustomer;
	}

	public int getIdItem() {
		return idItem;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	
}
