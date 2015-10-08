package com.netbuilder.entities;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author ccooper
 * @date 06/10/2015
 *
 */

public class Customer {

	// Customer attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCustomer;
	private Date dob;
	private float credit;
	private String phoneNumber;
	private int blackListStrikes;

	/**
	 * @Class constructor initialises the customer attributes
	 * @param credit
	 * @param phoneNumber
	 * @param dob
	 */
	public Customer(float credit, String phoneNumber, Date dob) {
		// Initialise attributes
		this.credit = credit;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
	}
	
	@Deprecated
	public Customer() {
	}

	/**
	 * @Method is an accessor for the unique customer ID
	 */
	public int getIdCustomer() {
		return idCustomer;
	}

	/**
	 * @Method is an accessor for the customers Date of Birth.
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * Method is a mutator for the customers date of birth
	 * 
	 * @param dob
	 *            : The users date of birth attribute
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * Method is a mutator for the customers phone number
	 * 
	 * @param phoneNumber
	 *            : String literal value of the users phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Method is an accessor for the customers credit value Assigned to their
	 * account.
	 */
	public float getCredit() {
		return credit;
	}

	/**
	 * Method is an accessor for the customers phone number.
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	/**
	 * Method is an accessor for the customers amount of
	 * black list strikes.
	 */
	public int getBlacklistStrikes() {
		return this.blackListStrikes;
	}
	
	/**
	 * Method is a mutator for blacklist strike
	 * @param blackListStrikes
	 */
	public void setBlacklistStrikes(int blackListStrikes) {
		this.blackListStrikes = blackListStrikes;
	}

	/**
	 * Method is a mutator for the customers unique ID number.
	 * 
	 * @param idCustomer
	 *            : is the integer number for the customers unique ID number.
	 */
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	//Should never be able to set the customers ID indiviudally therefore I have commented this out. 
//	/**
//	 * Method is a mutator for the customers unique ID number.
//	 * 
//	 * @param idCustomer
//	 *            : is the integer number for the custoemrs unique ID number.
//	 */
//	public void setIdCustomer(int idCustomer) {
//		this.idCustomer = idCustomer;
//	}

	/**
	 * Method is a mutator for the customers credit value assigned to their
	 * account.
	 * 
	 * @param credit
	 *            : is the floating point number that represents the customers
	 *            credit value assigned to their account.
	 */
	public void setCredit(float credit) {
		this.credit = credit;
	}
}
