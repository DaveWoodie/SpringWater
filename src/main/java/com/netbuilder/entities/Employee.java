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

	/**
	 * Method to get the employees ID.
	 * 
	 * @return return int datatype containing the employees ID.
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Method to set the employees ID.
	 * 
	 * @param ID : int containing the employees ID.
	 */
	public void setID(int ID) {
		this.ID = ID;
	}

	/**
	 * Method to get the employees role.
	 * 
	 * @return return Role datatype containing the employees role.
	 */
	public Role getRole() {
		return Role;
	}

	/**
	 * Method to set the employees role.
	 * 
	 * @param Role : Role datatype containing the employees role.
	 */
	public void setRole(Role Role) {
		this.Role = Role;
	}
}
