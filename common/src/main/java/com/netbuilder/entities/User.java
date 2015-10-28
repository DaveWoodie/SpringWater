/** 
 * @author dwoodward
 * @date 06/10/2015
 */

package com.netbuilder.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int iDnum;
	
	private String pWd;
	private String forName;
	private String surName;
	private String email;
	private boolean isEmployee;
	
	/**
	 * Constructor to build an instance of User, not null variables are password, forename, surname, email address and if the User is an Employee.
	 * @author dwoodward
	 * @date 06/10/2015
	 * @param pwd : String of the password of the user.
	 * @param foreName : String of the user's forename.
	 * @param surName : String of the user's surname.
	 * @param email : String of the User's email.
	 * @param emp : Boolean to determine if the User is an Employee or not.
	 */
	public User(String pwd, String foreName, String surName, String email, boolean emp) {
		this.pWd = pwd;
		this.forName = foreName;
		this.surName = surName;
		this.email = email;
		this.isEmployee = emp;		
	}

	/**
	 * Default Constructor for testing purposes only.
	 */
	@Deprecated
	public User() { }
	
	/**
	 * Method to set the value of the User's password.
	 * @param p : String of the password.
	 */
	public void setPwd(String p) {
		pWd = p;
	}
	
	/**
	 * Method to set the value of the User's forename.
	 * @param f : String of the forename.
	 */
	public void setForeName(String f) {
		forName = f;
	}
	
	/**
	 * Method to set the value of the User's surname.
	 * @param s : String of the Users surname.
	 */
	public void setSurnName(String s) {
		surName = s;
	}
	
	/**
	 * Method to set the value of the User's email.
	 * @param em : String of the Users email.
	 */
	public void setEmail(String em) { 
		email = em;
	}
	
	public void setUserID(int i) {
		iDnum = i;
	}
	
	/**
	 * Method to get the User's ID Number.
	 * @return Returns int data type.
	 */
	public int getUserID() {
		return iDnum;
	}
	
	/**
	 * Method to get the User's password.
	 * @return Returns String data type.
	 */
	public String getUserPwd() {
		return pWd;
	}
	
	/**
	 * Method to get the User's forename.
	 * @return Returns String data type.
	 */
	public String getUserFore() {
		return forName;
	}
	
	/**
	 * Method to get the User's surname.
	 * @return Returns String data type.
	 */
	public String getUserSurn() {
		return surName;
	}
	
	/**
	 * Method to get the User's email.
	 * @return Returns String data type.
	 */
	public String getUserEmail() { 
		return email;
	}
	
	/**
	 * Method to get the boolean for if a User is an employee.
	 * @return Returns boolean data type.
	 */
	public boolean getIsEmployee() {
		return isEmployee;
	}
}