package com.netbuilder.entities;

public class Address {
	private int addressID;
	private String addressLineOne;
	private String addressLineTwo;
	private String city;
	private String county;
	private String postCode;
	
	/**
	 * 
	 * @param addressLineOne
	 * @param addressLineTwo
	 * @param city
	 * @param county
	 * @param postCode
	 */
	public Address(String addressLineOne, String city, String postCode) {
		this.addressLineOne = addressLineOne;
		this.city = city;
		this.postCode = postCode;
	}
	
	public void setAddressLineTwo(String lineTwo) {
		this.addressLineTwo = lineTwo;
	}
	
	public void setCounty(String county) {
		this.county = county;
	}
	
	public void setAddressLineOne(String lineOne) {
		this.addressLineOne = lineOne;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	public String getaddressLineOne() {
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

	
