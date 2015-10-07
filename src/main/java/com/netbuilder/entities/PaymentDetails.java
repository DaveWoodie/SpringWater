/**
 * @author chrisjwwalker
 * @date 06/10/2015
 */

package com.netbuilder.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class PaymentDetails {
	
	//Attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPaymentDetails;
	private String cardType;
	private String cardNumber;
	private String name;
	private String expiryDate;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="idCustomer")
	private Customer idCustomer;
	private Address idAddress;
	
	/**
	 * Constructor to build instance of PaymentDetails, not null variables are cardType, cardNumber, name, expiryDate
	 * 
	 * @param cardType : String; Type of card
	 * @param cardNumber : String; Number of on the card
	 * @param name : String; Name on the card
	 * @param expiryDate : String; Expiry date on the card
	 * @param idCustomer : Customer; Customer associcated with the payment details
	 * @param idAddress : Address; The billing address
	 */
	
	public PaymentDetails(String cardType, String cardName, String name, String expiryDate, Customer idCustomer, Address idAddress) {
		this.cardType = cardType;
		this.cardNumber = cardName;
		this.name = name;
		this.expiryDate = expiryDate;
		this.idCustomer = idCustomer;
		this.idAddress = idAddress;
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
