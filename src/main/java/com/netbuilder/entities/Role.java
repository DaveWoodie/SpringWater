/**
 * @author Freshwater
 * @date 06/10/2015
 */

package com.netbuilder.entities;

public class Role {
	private int ID;
	private String Role;

	/**
	 * Constructor to create an instance of an employees role.
	 * 
	 * @param ID : int of the roles ID.
	 * @param Role : String of the role.
	 */
	public Role(int ID, String Role) {
		this.ID = ID;
		this.Role = Role;
	}

	/**
	 * Method to get the roles ID;
	 * 
	 * @return int datatype that contains the roles ID.
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Method to set the roles ID.
	 * 
	 * @param ID : int containing the roles ID.
	 */
	public void setID(int ID) {
		this.ID = ID;
	}

	/**
	 * Method to get the Role.
	 * 
	 * @return String datatype containing the role.
	 */
	public String getRole() {
		return Role;
	}

	/**
	 * Method to set the role.
	 * 
	 * @param Role : String containing the role.
	 */
	public void setRole(String Role) {
		this.Role = Role;
	}
}
