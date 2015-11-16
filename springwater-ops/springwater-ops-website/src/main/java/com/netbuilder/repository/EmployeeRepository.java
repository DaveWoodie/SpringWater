package com.netbuilder.repository;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import com.netbuilder.entities.Employee;
import com.netbuilder.entities.Role;
//import entities.PurchaseOrder;

/**
 * @author Freshwater
 * @date 07/10/2015
 */

public interface EmployeeRepository extends CrudRepository<Employee, String> {
	
	public Employee findByID(int ID);
	public ArrayList<Employee> findByRole(Role role);
}