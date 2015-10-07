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

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String Role) {
		this.Role = Role;
	}
}
