package com.netbuilder.entities;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;

/**
 * Class to hold all of the details for an address. Used for both customer addresses and supplier addresses
 * @author tstacey
 * @date 06/10/2015
 */
public class Address {

	private int addressID;
	private Integer customerID;
	private ArrayList<String> addressLines;
	private String city;
	private String county;
	private String postCode;
	
	/**
	 * Constructor for a new address with full details completed
	 * @param addressLines : ArrayList<String> of the lines of the address (House number, name, street, city etc.)
	 * @param city : String of the city name
	 * @param county : String of the county of the address
	 * @param postCode : String of the address post code
	 */
	public Address(Integer customerID, ArrayList<String> addressLines, String city, String county, String postCode) {
		this.customerID = customerID;
		copyAddressLines(addressLines);
		this.city = city;
		this.county = county;
		this.postCode = postCode;
	}
	
	/**
	 * Constructor for a new address without County completed
	 * @param addressLineOne : String of the first line of the address (House number)
	 * @param city : String of the city name
	 * @param county : String of the county of the address 
	 * @param postCode : String of the address post code
	 */
	public Address(Integer customerID, ArrayList<String> addressLines, String city, String postCode) {
		this.customerID = customerID;
		copyAddressLines(addressLines);
		this.city = city;
		this.postCode = postCode;
	}
	
	/**
	 * Full constructor for an address without a Customer. Used for adding Supplier addresses
	 * @param addressLines
	 * @param city
	 * @param county
	 * @param postCode
	 */
	public Address(ArrayList<String> addressLines, String city, String county, String postCode) {
		copyAddressLines(addressLines);
		this.city = city;
		this.county = county;
		this.postCode = postCode;
	}
	
	/**
	 * Partial constructor for an address without a Customer or County. Used for adding Supplier addresses
	 * @param addressLines
	 * @param city
	 * @param postCode
	 */
	public Address(ArrayList<String> addressLines, String city, String postCode) {
		copyAddressLines(addressLines);
		this.city = city;
		this.postCode = postCode;
	}
	
	/**
	 * Blank constructor for a new address entity. For testing only
	 */
	@Deprecated
	public Address() { }
	
	
	/**
	 * Creates a deep copy of the passed ArrayList and assigns it to the Address's addressLines ArrayList
	 * @param newAddresLines
	 */
	private void copyAddressLines(ArrayList<String> newAddressLines) {
		this.addressLines = new ArrayList<String>();
		for(String s : newAddressLines) {
			this.addressLines.add(s);
		}
	}
	
	public void setAddressLines(ArrayList<String> newAddressLines) {
		copyAddressLines(newAddressLines);
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setCounty(String county) {
		this.county = county;
	}
	
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	public void setCustomerID(int id) {
		this.customerID = id;
	}
	
	/**
	 * returns true if the address belongs to a customer
	 * @return
	 */
	public boolean isCustomerAddress() {
		if(customerID == null) {
			return false;
		}
		return true;
	}
	
	public Integer getCustomerID() throws IOException {
		if(this.customerID == null) {
			throw new IOException();
		}
		return this.customerID;
	}
	
	public int getAddressID() {
		return this.addressID;
	}
	
	public ArrayList<String> getAddressLines() {
		return this.addressLines;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public String getCounty() {
		return this.county;
	}
	
	public String getPostCode() {
		return this.postCode;
	}
	
	public void print() {
		System.out.println("Address ID: "+this.addressID);
		System.out.println("Customer ID: "+this.customerID);
		for(int i = 0; i < addressLines.size(); i++) {
			System.out.println("Addr Line "+(i+1)+": "+addressLines.get(i));
		}
		System.out.println("City: "+this.city);
		System.out.println("County: "+this.county);
		System.out.println("PostCode: "+this.postCode);
	}
}