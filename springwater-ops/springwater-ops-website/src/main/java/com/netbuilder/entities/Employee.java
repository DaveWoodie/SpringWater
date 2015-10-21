/**
 * @author Freshwater
 * @date 06/10/2015
 */

package com.netbuilder.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@OneToOne (cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "idEmployee")
	private User user;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@PrimaryKeyJoinColumn(name = "idRole")
	private Role role;

	/**
	 * Constructor to create an instance of employee.
	 * 
	 * @param ID : int of the employee's ID.
	 * @param Role : Role of the employee's role.
	 */
	public Employee(User user, Role Role) {
		this.user = user;
		this.role = Role;
	}

	public User getUser() {
		return user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role Role) {
		this.role = Role;
	}
}