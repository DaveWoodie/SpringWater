/**
 * @author ccooper
 * @date 07/10/2015
 */

package com.netbuilder.entityrepository;

import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.netbuilder.entities.Customer;

/**
 * 
 * Interface to hold the find methods for the customer
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	public List<Customer> findByName(String name);
	public Customer findByIDCustomer(int customerID);
	public List<Customer> findByDob(Date dob);
	public List<Customer> findByPhoneNumber(String phoneNumber);
}
