/**
 * @author dwoodward
 * @date 06/10/2015
 */

package com.netbuilder.entities;

public class CustomerOrderStatus {

	private int statusID;
	private String status;
	
	/**
	 * Empty constructor to create an instance of the Customer Order Status Class.
	 */
	public CustomerOrderStatus () {
	}
	
	public int getStatusID() {
		return statusID;
	}
	
	/**
	 * Method to get the Customer Order Status.
	 * @return Returns data type string.
	 */
	public String getCustOrderStatus() {
		return status;
	}
	
}
