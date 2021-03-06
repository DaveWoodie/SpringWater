package com.netbuilder.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class to hold all of the details for one Supplier
 * @author tstacey
 * @date 06/10/2015
 */

public class Supplier implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int supplierID;
	private String supplierName;
	private String telephone;
	private String email;
	private int addressID;
	private int averageDeliveryTime;
	private String logoLocation;
	
	/**
	 * Blank constructor to create an empty Supplier object. USed in testing only
	 */
	@Deprecated
	public Supplier() { }
	
	/**
	 * Constructor for a supplier with not null values of supplier name and address object
	 * telephone and email fields are nullable and must be entered using setTelephone(String) and setEmail(String) Methods
	 * @param supplierName
	 * @param address
	 */
	public Supplier(String supplierName, int addressID) {
		this.supplierName = supplierName;
		this.addressID = addressID;
		this.logoLocation = "Gnomes R' Us";
	}
	
	public void setSupplierID(int id) {
		this.supplierID =id;
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
	
	public void setAddress(int addressID) {
		this.addressID = addressID;
	}
	
	public void setAverageDeliveryTime(int time) {
		this.averageDeliveryTime = time;
	}
	
	public void setLogoLocation(String logoLocation) {
		this.logoLocation = logoLocation;
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
	
	public int getAddressID() {
		return this.addressID;
	}
	
	public int getAverageDeliveryTime() {
		return this.averageDeliveryTime;
	}
	
	public String getLogoLocation() {
		return logoLocation;
	}
}