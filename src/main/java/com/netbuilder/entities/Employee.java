/**
 * @author Freshwater
 * @date 06/10/2015
 */

package com.netbuilder.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	@OneToOne
	@PrimaryKeyJoinColumn(name = "idRole")
	private Role Role;

	/**
	 * Constructor to create an instance of employee.
	 * 
	 * @param ID : int of the employee's ID.
	 * @param Role : Role of the employee's role.
	 */
	public Employee(Role Role) {
		this.Role = Role;
	}

	public int getID() {
		return ID;
	}


	public Role getRole() {
		return Role;
	}

	public void setRole(Role Role) {
		this.Role = Role;
	}
}
