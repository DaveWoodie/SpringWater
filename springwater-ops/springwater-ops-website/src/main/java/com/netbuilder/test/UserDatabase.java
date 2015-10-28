package com.netbuilder.test;

import java.util.ArrayList;

/**
 * 
 * @author ccooper
 * @date 28/10/2015
 * @description file contains dummy data for the user database.
 * @lastModified 28/10/2015
 *
 */

public class UserDatabase {

	// Create a list for users
	static public ArrayList<User> userList;
	
	// Fill the user database with dummy data
	static public void fillDatabase() {
		
		// Initialise the user list
		userList = new ArrayList<User>();
		
		// Add items to the list
		userList.add(new User(
				"01", "CallumCooper", "callum.cooper@netbuilder.com",
						"12/05/1993", "07917800649", 100.00, "Callum", "Cooper"));
	}
	
	// return the user database
	static public ArrayList<User> users(String userID) {
		
		// Query the featured data
		ArrayList<User> users = new ArrayList<User>();
		
		// Add users to the list
		users.add(userList.get(0));
		
		return users;
	}
}
