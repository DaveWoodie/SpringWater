/**
 * @author Freshwater
 * @date 06/10/2015
 */

package com.netbuilder.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
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
