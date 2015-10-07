package com.netbuilder.entitymanagers;

import java.util.List;

import com.netbuilder.entities.CustomerOrderStatus;

public interface CustomerOrderStatusManager {

	//CREATES
	/**
	 * Method to make a single status.
	 * @param s : The CustomerOrderStatus to add.
	 */
	public void persistCustomerOrderStatus(CustomerOrderStatus s);
	/**
	 * Method to create a set of status' from a List.
	 * @param s : The CustomerOrderStatus List to add.
	 */
	public void persistCustomerOrderStatus(List<CustomerOrderStatus> s);
	
	//READS
	/**
	 * Method to return a status by it's ID number.
	 * @param i : the ID of the status.
	 * @return Returns data type CustomerOrderStatus.
	 */
	public CustomerOrderStatus findByID (Integer i);
	/**
	 * Method to return a status by it's name number.
	 * @param s : the name of the status.
	 * @return Returns data type CustomerOrderStatus.
	 */
	public CustomerOrderStatus findByStatus (String s);

	//UPDATE
	//No need to update these statuses we want them to never change.
	
	//DELETE
	//Same as above.
}
