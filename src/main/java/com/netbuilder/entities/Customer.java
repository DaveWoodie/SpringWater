package com.netbuilder.entities;

public class Customer {
	
	// Customer attributes
	private int idCustomer;
	private float credit;
	private String phoneNumber;
	
	// Class Constructor
	public Customer(float credit, String phoneNumber)
	{
		// Initialise attributes
		this.credit = credit;
		this.phoneNumber = phoneNumber;
	}
	
	// ID customer accessors
	public int getIdCustomer()
	{
		return this.idCustomer;
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

	// Phone number mutator
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
