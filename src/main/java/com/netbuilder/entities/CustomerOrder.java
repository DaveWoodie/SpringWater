package com.netbuilder.entities;

import java.util.Date;

public class CustomerOrder 
{
	private int customerOrderID;
	private Date datePlaced;
	private Date dateShipped;
	private Customer customer;
	private CustomerOrderStatus orderStatus;
	private Employee employee;
	
	/**
	 * 
	 * @param datePlaced
	 * @param customer
	 * @param orderStatus
	 * @param employee
	 */
	public CustomerOrder(Date datePlaced, Customer customer, CustomerOrderStatus orderStatus, Employee employee)
	{
		
		this.datePlaced = datePlaced;
		this.customer = customer;
		this.orderStatus = orderStatus;
		this.employee = employee;
	}
}
