package entityrepository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import entities.Employee;
//import entities.PurchaseOrder;
import entities.Role;

/**
 * @author Freshwater
 * @date 07/10/2015
 */

public interface EmployeeRepository extends CrudRepository<Employee, String> {
	
	public Employee findByID(int ID);
	public ArrayList<Employee> findByRole(Role role);
}