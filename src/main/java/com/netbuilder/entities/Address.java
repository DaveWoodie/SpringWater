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
	
	/**
	 * Method to set the first line of the address (house number)
	 * @param lineOne
	 */
	public void setAddressLineOne(String lineOne) {
		this.addressLineOne = lineOne;
	}
	
	/**
	 * Method to set the second line of the address (Building/development)
	 * @param lineTwo
	 */
	public void setAddressLineTwo(String lineTwo) {
		this.addressLineTwo = lineTwo;
	}
	
	/**
	 * Method to set the city of the address
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Method to set the county of the address
	 * @param county
	 */
	public void setCounty(String county) {
		this.county = county;
	}
	
	/**
	 * Method to set the post code of the address
	 * @param postCode
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	/**
	 * method to get the ID of the Address
	 * @return int of the Address ID
	 */
	public int getAddressID() {
		return this.addressID;
	}
	
	/**
	 * Method to return the first line of the address (House Number)
	 * @return String of the first line of the address
	 */
	public String getAddressLineOne() {
		return this.addressLineOne;
	}
	
	/**
	 * Method to return the second line of the address (Building/development etc.)
	 * @return String of the second line of the address
	 */
	public String getAddressLineTwo() {
		return this.addressLineTwo;
	}
	
	/**
	 * MEthod to return the city of the address
	 * @return String of the address city
	 */
	public String getCity() {
		return this.city;
	}
	
	/**
	 * Method to return the county of the address
	 * @return String of the address county
	 */
	public String getCounty() {
		return this.county;
	}
	
	/**
	 * Method to return the post code of the address 
	 * @return String of the address post code
	 */
	public String getPostCode() {
		return this.postCode;
	}
	
	
}

	
