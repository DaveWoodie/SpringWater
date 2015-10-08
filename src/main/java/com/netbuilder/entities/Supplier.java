package com.netbuilder.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Class to hold all of the details for one Supplier
 * @author tstacey
 * @date 06/10/2015
 */

@Entity
public class Supplier {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int supplierID;
	
	private String supplierName;
	private String telephone;
	private String email;
	private Address address;
	
	
	/**
	 * Blank constructor to create an empty Supplier object. USed in testing only
	 */
	@Deprecated
	public Supplier() {
		
	}
	
	/**
	 * Constructor for a supplier with not null values of supplier name and address object
	 * telephone and email fields are nullable and must be entered using setTelephone(String) and setEmail(String) Methods
	 * @param supplierName
	 * @param address
	 */
	public Supplier(String supplierName, Address address) {
		this.supplierName = supplierName;
		this.address = address;
	}
	
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public int getSupplierID() {
		return this.supplierID;
	}
	
	public String getSupplierName() {
		return this.supplierName;
	}
	
	public String getTelephone() {
		return this.telephone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public Address getAddress() {
		return this.address;
	}
}
