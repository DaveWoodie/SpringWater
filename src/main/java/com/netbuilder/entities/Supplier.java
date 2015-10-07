package com.netbuilder.entities;

public class Supplier {
	private int supplierID;
	private String supplierName;
	private String telephone;
	private String email;
	private Address address;
	
	/**
	 * Constructor for a supplier with not null values of supplier name and address object
	 * telephone and email fields are nullable and must be entered using setTelephone(String) and setEmail(String) Methods
	 * @author tstacey
	 * @date 06/10/2015
	 * @param supplierName
	 * @param address
	 */
	public Supplier(String supplierName, Address address) {
		this.supplierName = supplierName;
		this.address = address;
	}
	
	/**
	 * Method to set the value of the Supplier's name
	 * @param supplierName
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	/**
	 * Method to set the value of the Supplier's telephone number
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	/**
	 * Method to set the value of the Supplier's email address
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Method to set the Address entity associated with the Supplier
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * Method to get the int value of the supplier ID
	 * @return : int of the Supplier's ID number
	 */
	public int getSupplierID() {
		return this.supplierID;
	}
	
	/**
	 * Method to get the Supplier's name
	 * @return : String of the Supplier's company name
	 */
	public String getSupplierName() {
		return this.supplierName;
	}
	
	/**
	 * Method to get the Supplier's contact telephone number
	 * @return : String of the Supplier's contact telephone number
	 */
	public String getTelephone() {
		return this.telephone;
	}
	
	/**
	 * Method to get the supplier's contact email address
	 * @return : String of the supplier's contact email address
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Method to get the Supplier's postal address
	 * @return : The Address object associated with the supplier
	 */
	public Address getAddress() {
		return this.address;
	}
}
