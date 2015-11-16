/**
 * @author dwoodward
 * @date 06/10/2015
 */

package com.netbuilder.entities;

import java.io.Serializable;

public class CustomerOrderStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int statusID;
	private String status;
	
	/**
	 * Customer Order Status constructor with parameter to set the status
	 * @param status
	 */
	public CustomerOrderStatus (String status) {
		this.status = status;
	}
	
	/**
	 * Empty constructor to create an instance of the Customer Order Status Class. Used in testing
	 */
	@Deprecated
	public CustomerOrderStatus () { }
	
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
	
	public void setCustomerOrderID (int id) {
		statusID = id;
	}
}