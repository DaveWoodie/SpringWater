/**
 * @author ccooper
 * @date 07/10/2015
 */

package com.netbuilder.entityrepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.netbuilder.entities.Customer;

/**
 * 
 * Interface to hold the find methods for the customer
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	public Customer findByName(String name);
	public List<Customer> getCustomers();
	public List<Customer> getDob();
	public List<Customer> getPhoneNumber();
	public List<Customer> getBlackListStrikes();
}
