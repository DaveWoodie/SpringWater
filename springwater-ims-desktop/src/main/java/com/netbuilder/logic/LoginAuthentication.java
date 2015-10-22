/**
 * 
 */
package com.netbuilder.logic;

import java.util.ArrayList;

import com.netbuilder.apploader.LoginLoader;

public class LoginAuthentication 
{
	LoginLoader loginLoader = new LoginLoader();
	
	ArrayList<Integer> userList = new ArrayList<Integer>();
	ArrayList<String> passwordList = new ArrayList<String>();
	
	public LoginAuthentication()
	{
		userList = loginLoader.getUsers();
		passwordList = loginLoader.getPasswords();
	}
	
	public boolean checkLogin(int userID, String Password)
	{
		for(int i = 0; i < userList.size(); i++)
		{
			if(userID == userList.get(i) && Password == passwordList.get(i))
			{
				return true;
			}
		}
		return false;
	}
}
