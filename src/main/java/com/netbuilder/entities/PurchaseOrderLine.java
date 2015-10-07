package com.netbuilder.entities;

/**
 * Class representing a line in a product order
 * 
 * @author cboucher
 * @date 06/10/2015
 */
public class PurchaseOrderLine {

	// Global variables
	private int quantity;
	private int idItem;
	private int idPurchaseOrder;

	/**
	 * Class constructor
	 * 
	 * @param quantity
	 *            : The quantity of the item
	 * @param idItem
	 *            : The ID of the item
	 * @param idPurchaseOrder
	 *            : The ID of the purchase order
	 */
	public PurchaseOrderLine(int quantity, int idItem, int idPurchaseOrder) {
		this.quantity = quantity;
		this.idItem = idItem;
		this.idPurchaseOrder = idPurchaseOrder;
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
	 * Method to get the purchase order ID
	 * 
	 * @return The ID of the purchase order
	 */
	public int getIdPurchaseOrder() {
		return idPurchaseOrder;
	}

	/**
	 * Method to set the purchase order ID
	 * 
	 * @param idPurchaseOrder
	 *            : The ID of the purchase order
	 */
	public void setIdPurchaseOrder(int idPurchaseOrder) {
		this.idPurchaseOrder = idPurchaseOrder;
	}

}
