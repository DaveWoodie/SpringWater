package com.netbuilder.entities;

/**
 * Class to hold all of the details for an address. Used for both customer addresses, supplier addresses and payment addresses
 * @author tstacey
 * @date 06/10/2015
 */
public class Address {
	private int addressID;
	private String addressLineOne;
	private String addressLineTwo;
	private String city;
	private String county;
	private String postCode;
	

	/**
	 * Constructor for a new address with full details completed
	 * @param addressLineOne : String of the first line of the address (House number)
	 * @param addressLineTwo : String of the second line of the address (Building/development)
	 * @param city : String of the city name
	 * @param county : String of the county of the address 
	 * @param postCode : String of the address post code
	 */
	public Address(String addressLineOne, String addressLineTwo, String city, String county, String postCode) {
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.county = county;
		this.postCode = postCode;
	}
	
	/**
	 * Constructor for a new address without addressLineTwo completed
	 * @param addressLineOne : String of the first line of the address (House number)
	 * @param city : String of the city name
	 * @param county : String of the county of the address 
	 * @param postCode : String of the address post code
	 */
	public Address(String addressLineOne, String city, String county, String postCode) {
		this.addressLineOne = addressLineOne;
		this.city = city;
		this.county = county;
		this.postCode = postCode;
	}
	
	/**
	 * Blank constructor for a new address entity. For testing only
	 */
	@Deprecated
	public Address() {
		
	}
	
	public void setAddressLineOne(String lineOne) {
		this.addressLineOne = lineOne;
	}
	
	public void setAddressLineTwo(String lineTwo) {
		this.addressLineTwo = lineTwo;
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
	
	public int getAddressID() {
		return this.addressID;
	}
	
	public String getAddressLineOne() {
		return this.addressLineOne;
	}
	
	public String getAddressLineTwo() {
		return this.addressLineTwo;
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
	
	
}

	
