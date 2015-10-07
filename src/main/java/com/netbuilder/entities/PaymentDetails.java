///////////////////////////////
//							 //
//	Project SpringWater		 //
//	Chris J W Walker		 //
//	Payment details			 //
//							 //
///////////////////////////////

/**
 * @author chrisjwwalker
 * @date 06/10/2015
 */

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
	
	/**
	 * Constructor to build instance of PaymentDetails, not null variables are cardType, cardNumber, name, expiryDate
	 * 
	 * @param cT : String; Type of card
	 * @param cN : String; Number of on the card
	 * @param n : String; Name on the card
	 * @param eD : String; Expiry date on the card
	 * @param idc : Customer; Customer associcated with the payment details
	 * @param ida : Address; The billing address
	 */
	
	public PaymentDetails(String cT, String cN, String n, String eD, Customer idc, Address ida) {
		cardType = cT;
		cardNumber = cN;
		name = n;
		expiryDate = eD;
		idCustomer = idc;
		idAddress = ida;
	}
	
	//Getters
	
	/**
	 * Method to get the payment ID
	 * @return Returns int data type
	 */
	public int getIdPaymentDetails() {
		return idPaymentDetails;
	}
	
	/**
	 * Method to get the card type
	 * @return Returns String data type
	 */
	public String getCardType() {
		return cardType;
	}
	
	/**
	 * Method to get the card number
	 * @return Returns String data type
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	
	/**
	 * Method to get the name on the card
	 * @return Returns the String data type
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Method to get the expiry date of the card
	 * @return Returns the String data type
	 */
	public String getExpiryDate() {
		return expiryDate;
	}
	
	/**
	 * Method to get the customer associated with the payment details
	 * @return Returns the Customer
	 */
	public Customer getIdCustomer() {
		return idCustomer;
	}
	
	/**
	 * Method to get the billing address
	 * @return Returns the billing address
	 */
	public Address getIdAddress() {
		return idAddress;
	}

	//Setters
	
	/**
	 * Method to set the cards type
	 * @param cardType: String of card type
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	/**
	 * Method to set the card number
	 * @param cardNumber : String of card number
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * Method to set the name on the card
	 * @param name : String of the name on the card
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method to set the expiry of the card
	 * @param expiryDate : String of the cards expiry date
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
}