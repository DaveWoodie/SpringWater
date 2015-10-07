package com.netbuilder.entities;

/**
 * 
 * @author ccooper
 * @date 06/10/2015
 *
 */

public class WishListLine {
	
	// Wish list line attributes
	private int idItem;
	private int idCustomer;
	
	/**
	 * @Class constructor initialises Wish List Line attributes
	 * @param idItem : The unique id of the item
	 * @param idCustomer : The unique id of the customer
	 */
	public WishListLine(int idItem, int idCustomer) {
		// Initialise attributes
		this.idItem = idItem;
		this.idCustomer = idCustomer;
	}
	
	/**
	 * 
	 * @Method is an accessor for the item ID.
	 */
	public int getIdItem() {
		return idItem;
	}
	
	/**
	 * 
	 * @Method is an accessor for the customer ID
	 */
	public int getIdCustomer() {
		return idCustomer;
	}

	/**
	 * 
	 * @Method is a mutator for the item id.
	 */
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	
	/**
	 * 
	 * @Method is a mutator customer ID.
	 */
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	
}
