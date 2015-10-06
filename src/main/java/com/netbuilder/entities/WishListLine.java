package com.netbuilder.entities;

/**
 * 
 * @author ccooper
 *
 */

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
	
	// ID item accessor
	public int getIdItem() {
		return idItem;
	}
	
	// Customer ID accessor
	public int getIdCustomer() {
		return idCustomer;
	}

	// ID item mutator
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	
	// ID Customer mutator
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	
}
