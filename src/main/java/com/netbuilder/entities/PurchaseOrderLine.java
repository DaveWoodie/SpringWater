package com.netbuilder.entities;

/**
 * Class representing a line in a product order
 * 
 * @author cboucher
 *
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
	 * @param idItem
	 * @param idPurchaseOrder
	 */
	public PurchaseOrderLine(int quantity, int idItem, int idPurchaseOrder) {
		this.quantity = quantity;
		this.idItem = idItem;
		this.idPurchaseOrder = idPurchaseOrder;
	}

	/**
	 * Method to get the quantity
	 * 
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Method to set the quantity
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Method to get the item ID
	 * 
	 * @return idItem
	 */
	public int getIdItem() {
		return idItem;
	}

	/**
	 * Method to set the item ID
	 * 
	 * @param idItem
	 */
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	/**
	 * Method to get the purchase order ID
	 * 
	 * @return idPurchaseOrder
	 */
	public int getIdPurchaseOrder() {
		return idPurchaseOrder;
	}

	/**
	 * Method to set the purchase order ID
	 * 
	 * @param idPurchaseOrder
	 */
	public void setIdPurchaseOrder(int idPurchaseOrder) {
		this.idPurchaseOrder = idPurchaseOrder;
	}

}
