/**
 * @author dwoodward
 * @date 07/10/2015
 */

package com.netbuilder.entitymanagers;

import java.util.List;

import com.netbuilder.entities.User;

public interface UserManager {

	//CREATE
	/**
	 * Method to make a single User.
	 * @param u : Takes in User u to add to the list.
	 */
	public void persistUser(User u);
	
	/**
	 * Method to make a set of User's from a pre-generated List.
	 * @param u : List of User's.
	 */
	public void persistUser(List<User> u);
	
	//READ
	/**
	 * Method to find a single User by their ID number.
	 * @param i : ID number to search for.
	 * @return Returns data type User.
	 */
	public User findByID(Integer i);
	/**
	 * Method to find a User by their first name.
	 * @param s : String of the User's first name.
	 * @return Returns the data type User.
	 */
	public User findByForNam(String s);
	/**
	 * Method to find a set of users from their first name.
	 * @param s : String of the User's first name.
	 * @return Returns the data type User.
	 */
	public List<User> findByForNams(String s);
	/**
	 * Method to find a User by their surname name.
	 * @param s : String of the User's surname name.
	 * @return Returns the data type User.
	 */
	public User findBySurNam(String s);
	/**
	 * Method to find a set of users from their surname name.
	 * @param s : String of the Users surname name.
	 * @return Returns the data type User.
	 */
	public List<User> findBySurNams(String s);
	/**
	 * Method to find Users by their type (Either Employee or not).
	 * @param b : Boolean of true (employee) or false (customer).
	 * @return Returns the data type User.
	 */
	public List<User> findByEmploy(boolean b);
	
	//UPDATE
	/**
	 * Method to update a single User's password.
	 * @param s : String of the new password for the User.
	 */
	public void updatePassword(String s);
	/**
	 * Method to update a single User's forename.
	 * @param s : String of the new forename for the User.
	 */
	public void updateForName(String s);
	/**
	 * Method to update a single User's surname.
	 * @param s : String of the new surname for the User.
	 */
	public void updateSurName(String s);
	/**
	 * Method to update a single User's email.
	 * @param s : String of the new email for the User.
	 */
	public void updateEmail(String s);
	
	//DELETE
	//No deletes applicable to this class.
}
