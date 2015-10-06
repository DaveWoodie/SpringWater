/**
 * @author dwoodward
 * @date 06/10/2015
 */

package com.netbuilder.entities;

public class PurchaseOrderStatus {

	private int statusID;
	private String status;
	
	/**
	 * Empty constructor to create an instance of the Purchase Order Status Class.
	 */
	public PurchaseOrderStatus () {
	}
	
	public int getStatusID() {
		return statusID;
	}
	
	/**
	 * Method to get the Purchase Order Status.
	 * @return Returns data type string.
	 */
	public String getCustOrderStatus() {
		return status;
	}
	
}
