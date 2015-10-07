package com.netbuilder.entities;

/**
 * Class representing a line in a customer order
 * 
 * @author cboucher
 * @date 06/10/2015
 */
public class CustomerOrderLine {

	// Global variables
	private int quantity;
	private int idItem;
	private int idCustomerOrder;

	/**
	 * Class constructor
	 * 
	 * @param quantity
	 *            : Quantity of the item
	 * @param idItem
	 *            : ID of the item
	 * @param idCustomerOrder
	 *            : ID of the customer order
	 */
	public CustomerOrderLine(int quantity, int idItem, int idCustomerOrder) {
		this.quantity = quantity;
		this.idItem = idItem;
		this.idCustomerOrder = idCustomerOrder;
	}

	/**
	 * Method to get the quantity
	 * 
	 * @return The quantity of the item in the line
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Method to set the quantity
	 * 
	 * @param quantity
	 *            : Quantity of the item
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Method to get the item ID
	 * 
	 * @return The ID of the item
	 */
	public int getIdItem() {
		return idItem;
	}

	/**
	 * Method to set the item ID
	 * 
	 * @param idItem
	 *            : The ID of the item
	 */
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	/**
	 * Method to get the customer order ID
	 * 
	 * @return The ID of the customer order
	 */
	public int getIdCustomerOrder() {
		return idCustomerOrder;
	}

	/**
	 * Method to set the customer order ID
	 * 
	 * @param The
	 *            ID of the customer order
	 */
	public void setIdCustomerOrder(int idCustomerOrder) {
		this.idCustomerOrder = idCustomerOrder;
	}

}
