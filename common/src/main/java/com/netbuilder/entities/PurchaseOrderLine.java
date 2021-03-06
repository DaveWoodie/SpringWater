package com.netbuilder.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Class representing a line in a product order
 * 
 * @author cboucher
 * @date 06/10/2015
 */

public class PurchaseOrderLine implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int quantity;
	
	private int itemID;
	private int damagedQuantity;
	private PurchaseOrder purchaseOrder;

	/**
	 * Class constructor
	 * 
	 * @param quantity
	 *            : The quantity of the item
	 * @param item
	 *            : The item
	 * @param purchaseOrder
	 *            : The purchase order
	 */
	public PurchaseOrderLine(int quantity, int itemID,
			PurchaseOrder purchaseOrder) {
		this.quantity = quantity;
		this.itemID = itemID;
		this.purchaseOrder = purchaseOrder;
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
	 *            : The quantity of the item
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Method to get the item
	 * 
	 * @return The item
	 */
	public int getItemID() {
		return itemID;
	}
	
	public int getDamagedQuantity() {
		return damagedQuantity;
	}
	
	public void setDamagedQuantity(int i) {
		damagedQuantity = i;
	}
	
	/**
	 * Method to get the purchase order
	 * 
	 * @return The ID of the purchase order
	 */
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}
}