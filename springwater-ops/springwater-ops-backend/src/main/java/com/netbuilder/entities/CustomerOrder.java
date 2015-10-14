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
	private boolean isPaid;
	private Address address;
	
	/**
	 * Constructor to build an instance of Customer Order.
	 * @author abutcher
	 * @date 06/10/2015
	 * @param datePlaced : Date of when order was placed.
	 * @param customer : the customer who placed the order.
	 * @param orderStatus : the current status of the order.
	 * @param employee : the employee who last checked out the order.
	 */
	public CustomerOrder(Date datePlaced, Customer customer, CustomerOrderStatus orderStatus, Employee employee, boolean isPaid, Address address) {
		
		this.datePlaced = new Date(datePlaced.getTime());
		this.customer = customer;
		this.customerOrderStatus = orderStatus;
		this.employee = employee;
		this.isPaid = isPaid;
		this.address = address;
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
	
	public boolean hasBeenPaid() {
		return isPaid;
	}
	
	public Address getDeliveryAddress() {
		return address;
	}
	
	public void setDateShipped(Date dateShipped) {
		this.dateShipped = new Date(dateShipped.getTime());
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void setOrderStatus(CustomerOrderStatus orderStatus) {
		this.customerOrderStatus = orderStatus;
	}
	
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
}