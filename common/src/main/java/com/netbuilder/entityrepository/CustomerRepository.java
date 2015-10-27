package com.netbuilder.entityrepository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netbuilder.entities.Customer;

/**
 * 
 * Interface to hold the find methods for the customer
 * @author ccooper
 * @date 07/10/2015
 */

public interface CustomerRepository {
	public List<Customer> findByName(String name);
	public Customer findByIDCustomer(int customerID);
	public List<Customer> findByDob(Date dob);
	public List<Customer> findByPhoneNumber(String phoneNumber);
}