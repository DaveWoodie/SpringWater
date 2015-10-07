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
public class PurchaseOrderStatus {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer statusID;
	private String status;
	
	/**
	 * Empty constructor to create an instance of the Purchase Order Status Class.
	 */
	public PurchaseOrderStatus () {
	}
	
	public Integer getStatusID() {
		return statusID;
	}
	
	/**
	 * Method to get the Purchase Order Status.
	 * @return Returns data type string.
	 */
	public String getPurchOrderStatus() {
		return status;
	}
	
}
