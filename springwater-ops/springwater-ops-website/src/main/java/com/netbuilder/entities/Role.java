/**
 * @author Freshwater
 * @date 06/10/2015
 */

package com.netbuilder.entities;

import java.io.Serializable;

public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID;
	private String Role;

	/**
	 * Constructor to create an instance of an employee's role.
	 * 
	 * @param ID : int of the role's ID.
	 * @param Role : String of the role.
	 */
	public Role(String Role) {
		this.Role = Role;
	}

	public int getID() {
		return ID;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String Role) {
		this.Role = Role;
	}
	
	public void setID(int id) {
		this.ID = id;
	}
}