/**
 * @author Freshwater
 * @date 07/10/2015
 */

package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.Employee;

public interface EmployeeManager {
	// CREATE
	public void persistEmployee(Employee e);
	public void persistAuthors(ArrayList<Employee> e);
	
	// READ
	public Employee findByID(int ID);
	public ArrayList<Employee> getEmployeeList();
	
	// UPDATE
	public void updateEmployee(Employee e);
	
	// DELETE
	public void removeAuthor(Employee e);
}
