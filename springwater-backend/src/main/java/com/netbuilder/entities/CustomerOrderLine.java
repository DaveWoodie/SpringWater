package com.netbuilder.entities;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Class representing a line in a customer order
 * 
 * @author cboucher
 * @date 06/10/2015
 */
public class CustomerOrderLine {

	private int quantity;
	@Id
	private Item item;
	
	@Id
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "idCustomerOrder")
	private CustomerOrder customerOrder;

	/**
	 * Class constructor
	 * 
	 * @param quantity
	 *            : The quantity of the item
	 * @param item
	 *            : The item
	 * @param customerOrder
	 *            : The customer order
	 */
	public CustomerOrderLine(int quantity, Item item,
			CustomerOrder customerOrder) {
		this.quantity = quantity;
		this.item = item;
		this.customerOrder = customerOrder;
	}

	/**
	 * Method to get the quantity
	 * 
	 * @return The quantity of the item
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Method to set the quantity
	 * 
	 * @param quantity
	 *            : The new quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Method to get the item
	 * 
	 * @return The item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Method to get the customer order
	 * 
	 * @return The customer order
	 */
	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

}