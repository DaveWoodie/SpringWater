package com.netbuilder.entitymanagers;

import java.util.List;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.CustomerOrderStatus;
import com.netbuilder.entities.Employee;

public interface CustomerOrderManager {

	// CREATE
	public void persistCustomerOrder (CustomerOrder customerOrder);
	public void persistCustomerOrders(List<CustomerOrder> customerOrders);
	
	// READ
	public CustomerOrder findByID(int id);
	public List<CustomerOrder> findByCustomer(Customer c);
	public List<CustomerOrder> findByEmployee(Employee e);
	public List<CustomerOrder> findByStatus(CustomerOrderStatus cos);
	public List<CustomerOrder> getCustomerOrders();
	
	// UPDATE
	public void updateAuthor (CustomerOrder customerOrder);
	
	// DELETE
	public void removeAuthor (CustomerOrder customerOrder);
	
}
