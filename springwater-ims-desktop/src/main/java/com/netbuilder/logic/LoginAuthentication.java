/**
 * @author Freshwater
 * @date 21/10/2015
 */

package com.netbuilder.logic;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.netbuilder.apploader.LoginLoader;

/**
 * Class to authenticate a user's login
 */
public class LoginAuthentication 
{
	LoginLoader loginLoader = new LoginLoader();
	
	ArrayList<Integer> userList = new ArrayList<Integer>();
	ArrayList<String> passwordList = new ArrayList<String>();
	
	/**
	 * Constructor that fills the user name and password lists from the SQL database through the Login Loader class
	 */
	public LoginAuthentication()
	{
		userList = loginLoader.getUsers();
		passwordList = loginLoader.getPasswords();
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
		
		//Search lists for a match
		for(int i = 0; i < userList.size(); i++)
		{
			if(userID == userList.get(i) && passwordString.equals(passwordList.get(i)))
			{
				return true;
			}
		}
		JOptionPane.showMessageDialog(null, "Login unsuccessful");
		return false;
	}
}
