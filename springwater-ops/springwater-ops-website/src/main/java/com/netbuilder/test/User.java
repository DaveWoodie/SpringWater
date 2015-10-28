package com.netbuilder.test;

/**
 * 
 * @author ccooper
 * @date 28/10/2015
 * @description file holds data for the user to be used within
 * 				the profile.
 * @lastModified 28/10/2015
 *
 */

public class User {
	
	// User attributes
	private String customerID;
	private String username;
	private String email;
	private String dateOfBirth;
	private String phoneNumber;
	private int customerCredit;
	
	// Class constructor
	public User(String customerID, String username, String email, String dateOfBirth,
			String phoneNumber, int customerCredit) {
				
				// Initialise attributes
				this.customerID = customerID;
				this.username = username;
				this.email = email;
				this.dateOfBirth = dateOfBirth;
				this.phoneNumber = phoneNumber;
				this.customerCredit = customerCredit;
			}
	
	// ACCESSORS ****	
	public String getCustomerID() {
		return this.customerID;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public int getCustomerCredit() {
		return this.customerCredit;
	}

}
