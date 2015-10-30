package com.netbuilder.test;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class to hold all of the details for an address. Used for both customer addresses and supplier addresses
 * @author tstacey
 * @date 06/10/2015
 */
public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int addressID;
	private Integer customerID;
	private ArrayList<String> addressLines;
	private String city;
	private String county;
	private String postCode;
	
	public Address(int addressID, Integer customerID, ArrayList<String> addressLines, String city, String county, String postCode) {
		this.addressID = addressID;
		this.customerID = customerID;
		this.addressLines = addressLines;
		this.city = city;
		this.county = county;
		this.postCode = postCode;
	}
	
	public int getAddressID() {
		return addressID;
	}
	
	public Integer getCustomerID() {
		return customerID;
	}
	
	public ArrayList<String> getAddressLines() {
		return addressLines;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getCounty() {
		return county;
	}
	
	public String getPostCode() {
		return postCode;
	}
	
	public String getFirstLine() {
		return addressLines.get(0);
	}
}
