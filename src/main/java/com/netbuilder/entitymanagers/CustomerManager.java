package com.netbuilder.entitymanagers;

import java.util.ArrayList;
import java.util.List;

import com.netbuilder.entities.Customer;

/**
 * 
 * @author ccooper
 * @date 07/10/2015
 *
 */

/**
 * 
 *Entity manager containing CRUD methods for the Customer entity
 */
public interface CustomerManager {
	//////////// CREATE //////////////////	
	public void persistCustomer(Customer customer);
	public void persistCustomers(List<Customer> customers);
	
	//////////// READ //////////////////
	public Customer findByName(String name);
	public List<Customer> getCustomers();
	public List<Customer> getDob();
	public List<Customer> getPhoneNumber();
	public List<Customer> getBlackListStrikes();
	
	//////////// UPDATE //////////////////
	public void updateCustomer(Customer customer);
	
	//////////// DELETE //////////////////
	public void removeCustomer(Customer customer);
}
