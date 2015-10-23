/**
 * @author Freshwater
 * @date 21/10/2015
 */

package com.netbuilder.logic;

import javax.swing.JOptionPane;

import com.netbuilder.apploader.LoginLoader;

/**
 * Class to authenticate a user's login
 */
public class LoginAuthentication 
{
	LoginLoader loginLoader = new LoginLoader();
	EncryptPassword encryption = new EncryptPassword();
	
	/**
	 * Constructor that fills the user name and password lists from the SQL database through the Login Loader class
	 */
	public LoginAuthentication()
	{
		
	}
	
	/**
	 * Method that checks if the user name and password input matches the SQL data
	 * 
	 * @param userID : The user name taken from the login GUI
	 * @param passwordField : The Password char array taken from the login GUI
	 * @return Returns true if the user name and password match the SQL data
	 */
	public boolean checkLogin(String userString, char[] passwordField)
	{
		//checks empty String
		if(userString.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please enter a valid user name and password");
			return false;
		}
		
		//Convert userID to int
		int userID = Integer.parseInt(userString);
		
		//Converts char array to a String
		String passwordString = new String(passwordField);
		
		String encryptedPassword = encryption.checkSHA1(passwordString);
		
		if(loginLoader.checkDetails(userID, encryptedPassword)) {
			return true;
		}
		
		JOptionPane.showMessageDialog(null, "Incorrect user name or password");
		return false;
		

//		//Search lists for a match
//		for(int i = 0; i < userList.size(); i++)
//		{
//			if(userID == userList.get(i) && encryptedPassword.equals(passwordList.get(i)))
//			{
//				return true;
//			}
//		}
//		JOptionPane.showMessageDialog(null, "Incorrect user name or password");
//		return false;
	}
}
