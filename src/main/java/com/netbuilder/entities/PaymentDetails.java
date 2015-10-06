///////////////////////////////
//							 //
//	Project SpringWater		 //
//	Chris J W Walker		 //
//	Payment details			 //
//							 //
///////////////////////////////

package com.netbuilder.entities;

public class PaymentDetails {
	
	//Attributes
	private int idPaymentDetails;
	private String cardType;
	private String cardNumber;
	private String name;
	private String expiryDate;
	private Customer idCustomer;
	private Address idAddress;
	
	
	public PaymentDetails(String cT, String cN, String n, String eD, Customer idc, Address ida) {
		cardType = cT;
		cardNumber = cN;
		name = n;
		expiryDate = eD;
		idCustomer = idc;
		idAddress = ida;
	}
	
	//Getters
	public int getIdPaymentDetails() {
		return idPaymentDetails;
	}
	
	public String getCardType() {
		return cardType;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getExpiryDate() {
		return expiryDate;
	}
	
	public Customer getIdCustomer() {
		return idCustomer;
	}
	
	public Address getIdAddress() {
		return idAddress;
	}

	//Setters
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
}
