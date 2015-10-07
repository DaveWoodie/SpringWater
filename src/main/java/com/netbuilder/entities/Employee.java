/**
 * @author Freshwater
 * @date 06/10/2015
 */

package com.netbuilder.entities;

public class Employee {
	private int ID;
	private Role Role;

	/**
	 * Constructor to create an instance of employee.
	 * 
	 * @param ID : int of the employee's ID.
	 * @param Role : Role of the employee's role.
	 */
	public Employee(int ID, Role Role) {
		this.ID = ID;
		this.Role = Role;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public Role getRole() {
		return Role;
	}

	public void setRole(Role Role) {
		this.Role = Role;
	}
}
