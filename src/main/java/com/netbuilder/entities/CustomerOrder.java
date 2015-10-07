/**
 * @author abutcher
 * @date 06/10/2015
 */

package com.netbuilder.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class CustomerOrder 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int customerOrderID;
	private Date datePlaced;
	private Date dateShipped;
	@ManyToOne
	@PrimaryKeyJoinColumn (name="idCustomer")
	private Customer customer;
	@ManyToOne
	@PrimaryKeyJoinColumn (name="idCustomerOrderStatus")
	private CustomerOrderStatus customerOrderStatus;
	@ManyToOne
	@PrimaryKeyJoinColumn (name="idEmployee")
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
	public CustomerOrder(Date datePlaced, Customer customer, CustomerOrderStatus orderStatus, Employee employee) {
		this.datePlaced = datePlaced;
		this.customer = customer;
		this.customerOrderStatus = orderStatus;
		this.employee = employee;
	}
	
	/**
	 * Default constructor to build an instance of Customer Order (Testing purposes only)
	 * @author abutcher
	 * date 07/10/2015
	 */
	@Deprecated
	public CustomerOrder() {
		
	}

	public int getCustomerOrderID() {
		return customerOrderID;
	}

	public Date getDatePlaced() {
		return datePlaced;
	}

	public Date getDateShipped() {
		return dateShipped;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public CustomerOrderStatus getCustomerOrderStatus() {
		return customerOrderStatus;
	}
	
	public void setDateShipped(Date dateShipped) {
		this.dateShipped = dateShipped;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void setOrderStatus(CustomerOrderStatus orderStatus) {
		this.customerOrderStatus = orderStatus;
	}
}
