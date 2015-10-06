package com.netbuilder.entities;

import java.util.Date;

/**
 * 
 * @author ccooper
 *
 */

public class Customer {
	
	// Customer attributes
	private int idCustomer;
	private Date dob;
	private float credit;
	private String phoneNumber;
	
	// Class Constructor
	public Customer(float credit, String phoneNumber, Date dob)
	{
		// Initialise attributes
		this.credit = credit;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
	}
	
	// ID customer accessors
	public int getIdCustomer()
	{
		return this.idCustomer;
	}
	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// Credit accessor
	public float getCredit()
	{
		return this.credit;
	}
	
	// Phone number accessor
	public String getPhoneNumber()
	{
		return this.phoneNumber;
	}
	
	// ID customer mutator
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	// Credit mutator
	public void setCredit(float credit) {
		this.credit = credit;
	}
}
