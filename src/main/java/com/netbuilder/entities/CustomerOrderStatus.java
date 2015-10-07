/**
 * @author dwoodward
 * @date 06/10/2015
 */

package com.netbuilder.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerOrderStatus {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
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
