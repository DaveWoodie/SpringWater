package entityrepository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entities.Employee;
import entities.Role;

/**
 * @author Freshwater
 * @date 07/10/2015
 */

public interface EmployeeRepository {
	
	public Employee findByID(int ID);
	public ArrayList<Employee> findByRole(Role role);
}