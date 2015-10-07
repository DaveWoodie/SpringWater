/**
 * @author jforster
 * @date 6/10/2015
 */
package com.netbuilder.entities;

import java.util.Date;

public class PurchaseOrder {
	private int idPurchaseOrder;
	private Date datePlaced;
	private Date dateExpected;
	private Employee employee;
	private PurchaseOrderStatus purchaseOrderStatus;
	private Supplier supplier;
	
	/**
	 * Constructor to build an instance of PurchaseOrder, not null variables are date placed, employee owning, the order status and the supplier
	 * @author jforster
	 * @date 6/10/2015
	 * @param dP : Date of current time
	 * @param e : Employee assigned to order
	 * @param pOS : PurchaseOrderStatus of the order
	 * @param s : Supplier who fufills the order 
	 */
	public PurchaseOrder (Date dP, Employee e, PurchaseOrderStatus pOS, Supplier s) {
		datePlaced = dP;
		employee = e;
		purchaseOrderStatus = pOS;
		supplier = s;
	}
	
	/**
	 * Blank constructor for testing purchase only
	 */
	@Deprecated
	public PurchaseOrder() {
		
	}
	/**
	 * Method to get the purchase order's ID number
	 * @return returns int data type
	 */
	public int getIDPurchaseOrder() {
		return idPurchaseOrder;
	}
	
	/**
	 * Method to get the purchase order's date of creation
	 * @return returns Date data type
	 */
	public Date getDatePlaced() {
		return datePlaced;
	}
	
	/**
	 * Method to get the purchase order's expected arrival date
	 * @return returns Date data type
	 */
	public Date getDateExpected() {
		return dateExpected;
	}
	
	/**
	 * Method to get the purchase order's creator
	 * @return returns Employee data type
	 */
	public Employee getEmployee() {
		return employee;
	}
	
	/**
	 * Method to get the purchase order's current status
	 * @return returns PurchaseOrderStatus data type
	 */
	public PurchaseOrderStatus getPurchaseOrderStatus() {
		return purchaseOrderStatus;
	}
	
	/**
	 * Method to get the purchase order's supplier
	 * @return returns Supplier data type
	 */
	public Supplier getSupplier() {
		return supplier;
	}
	
	
	/**
	 * Method to set the expected date of arrival for the purchase order
	 * @param dE : Date of predicted arrival time
	 */
	public void setDateExpected(Date dE) {
		dateExpected = dE;
	}
	
	/**
	 * Method to set the employee working on this order
	 * @param e : Employee to work on the order
	 */
	public void setEmployee(Employee e) {
		employee = e;
	}
	
	/**
	 * Method to set the current status of the purchase order
	 * @param pOS : Status of the purchase order
	 */
	public void setPurchaseOrderStatus(PurchaseOrderStatus pOS) {
		purchaseOrderStatus = pOS;
	}
	
}
