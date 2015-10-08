/**
 * @author abutcher
 * @date 07/10/2015
 */
package com.netbuilder.entityrepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.CustomerOrderStatus;
import com.netbuilder.entities.Employee;

/**
 * Interface to hold the find methods for customer order
 */
public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Integer>  {

	public CustomerOrder findByID(int id);
	public List<CustomerOrder> findByCustomer(Customer c);
	public List<CustomerOrder> findByEmployee(Employee e);
	public List<CustomerOrder> findByStatus(CustomerOrderStatus cos);
}
