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
	public String firstName;
	public String lastName;
	private String customerID;
	private String username;
	private String email;
	private String dateOfBirth;
	private String phoneNumber;
	private double customerCredit;
	
	// Class constructor
	public User(String customerID, String username, String email, String dateOfBirth,
			String phoneNumber, double customerCredit, 
			String firstName, String lastName) {
				
				// Initialise attributes
				this.customerID = customerID;
				this.username = username;
				this.email = email;
				this.dateOfBirth = dateOfBirth;
				this.phoneNumber = phoneNumber;
				this.customerCredit = customerCredit;
				this.firstName = firstName;
				this.lastName = lastName;
			}
	
	// ACCESSORS ****
	public String getCustomerFistName() {
		return this.firstName;
	}
	
	public String getCustomerLastName() {
		return this.lastName;
	}
	
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
	
	public double getCustomerCredit() {
		return this.customerCredit;
	}
}
