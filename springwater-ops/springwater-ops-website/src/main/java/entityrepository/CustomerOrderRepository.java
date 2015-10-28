package entityrepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entities.Customer;
import entities.CustomerOrder;
import entities.CustomerOrderStatus;
import entities.Employee;

/**
 * Interface to hold the find methods for customer order
 * 
 * @author abutcher
 * @date 07/10/2015
 */

public interface CustomerOrderRepository {
	public CustomerOrder findByID(int id);
	public List<CustomerOrder> findByCustomer(Customer c);
	public List<CustomerOrder> findByEmployee(Employee e);
	public List<CustomerOrder> findByStatus(CustomerOrderStatus cos);
}
