/**
 * @author abutcher
 * @date 06/10/2015
 */

package com.netbuilder.entities;

import java.util.Date;

public class CustomerOrder 
{
	private int customerOrderID;
	private final Date datePlaced;
	private Date dateShipped;
	private final Customer customer;
	private CustomerOrderStatus customerOrderStatus;
	private Employee employee;
	
	/**
	 * Constructor to build an instance of Customer Order
	 * @author abutcher
	 * @date 06/10/2015
	 * @param datePlaced : Date of
	 * @param customer
	 * @param orderStatus
	 * @param employee
	 */
	public CustomerOrder(Date datePlaced, Customer customer, CustomerOrderStatus orderStatus, Employee employee)
	{	
		this.datePlaced = datePlaced;
		this.customer = customer;
		this.customerOrderStatus = orderStatus;
		this.employee = employee;
	}
	
	/**
	 * Method to get the Customer Order ID.	
	 * @return Returns an Int data type.
	 */
	public int getCustomerOrderID() {
		return customerOrderID;
	}

	/**
	 * Method to get the Date the order was placed.
	 * @return Returns a Date data type.
	 */
	public Date getDatePlaced() {
		return datePlaced;
	}

	/**
	 * Method to get the Date the order was shipped.
	 * @return Returns a Date data type.
	 */
	public Date getDateShipped() {
		return dateShipped;
	}

	/**
	 * Method to get the Customer who placed the order.
	 * @return Returns a Customer data type.
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Method to get the Employee who is assigned to the order.
	 * @return Returns an Employee data type.
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * Method to get the customer order status.
	 * @return Returns a CustomerOrderStatus data type.
	 */
	public CustomerOrderStatus getCustomerOrderStatus() {
		return customerOrderStatus;
	}
	
	/**
	 * Method to set the Date the order was shipped.
	 * @param dateShipped : Date of date shipped.
	 */
	public void setDateShipped(Date dateShipped) {
		this.dateShipped = dateShipped;
	}

	/**
	 * Method to set the last Employee assigned to the order.
	 * @param employee : Employee to be assigned.
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	/**
	 * Method to set the current Order status
	 * @param orderStatus : new order status.
	 */
	public void setOrderStatus(CustomerOrderStatus orderStatus) {
		this.customerOrderStatus = customerOrderStatus;
	}
}
