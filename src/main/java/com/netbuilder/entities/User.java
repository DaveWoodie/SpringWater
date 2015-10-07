/** 
 * @author dwoodward
 * @date 06/10/2015
 */

package com.netbuilder.entities;

public class User {
	
	private int iDnum;
	private String pWd;
	private String forName;
	private String surName;
	private String email;
	private boolean isEmp;
	
	/**
	 * Constructor to build an instance of User, not null variables are password, forename, surname, email address and if the User is an Employee.
	 * @author dwoodward
	 * @date 06/10/2015
	 * @param pwd : String of the password of the user.
	 * @param fore : String of the user's forename.
	 * @param surn : String of the user's surname.
	 * @param ema : String of the User's email.
	 * @param emp : boolean 
	 */
	public User(String pwd, String fore, String surn, String ema, boolean emp) {
		
		pWd = pwd;
		forName = fore;
		surName = surn;
		email = ema;
		isEmp = emp;		
	}
	
	/**
	 * Default Constructor for testing purposes only.
	 */
	@Deprecated
	public User() {
	}
	
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
		return isEmp;
	}
}
