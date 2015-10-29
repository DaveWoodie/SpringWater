package com.netbuilder.test;

import java.util.ArrayList;

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
	private String firstName;
	private String lastName;
	private int customerID;
	private String username;
	private String email;
	private String dateOfBirth;
	private String phoneNumber;
	private double customerCredit;
	private ArrayList<Address> addressList;
	
	// Class constructor
	public User(int customerID, String username, String email, String dateOfBirth,
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
				addressList = new ArrayList<Address>();
			}
	
	// ACCESSORS ****
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public int getCustomerID() {
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
	
	public void addAddress(Address address) {
		addressList.add(address);
	}
	
	public ArrayList<Address> getAddressList() {
		return addressList;
	}
}
