package com.netbuilder.entityrepository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netbuilder.entities.Employee;
import com.netbuilder.entities.Role;

/**
 * @author Freshwater
 * @date 07/10/2015
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> 
{	
	public Employee findByID(int ID);
	public ArrayList<Employee> findByRole(Role role);
}