package com.netbuilder.entities;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

/**
 * 
 * @author ccooper
 * @date 07/10/2015
 *
 */

public class CustomerTest {

	/**
	 * Customer test attributes
	 */
	private int idCustomer = 10;
	private float credit = 10.0f;
	private String phoneNumber = "0791633254";
	private Date dob = new Date();

	/**
	 * @Test Run a test to make sure that the get ID customer returns the
	 *       correct value of the customers ID from the User test.
	 */
	public void testGetIdCustomer() {
		Customer customer = new Customer(credit, phoneNumber, dob);
		assertSame("The objects are not the same!!", idCustomer,
				customer.getIdCustomer());
	}

	/**
	 * @Test Run a test to make sure that the customers date of birth returns
	 *       the correct value.
	 */
	public void testGetDob() {
		Customer customer = new Customer(credit, phoneNumber, dob);
		assertNotNull("The object is NULL", dob);
	}

	/**
	 * @Test Run a test to make sure that the get customers phone number returns
	 *       the correct value.
	 */
	public void testGetPhoneNumber() {
		Customer customer = new Customer(credit, phoneNumber, dob);
		assertTrue(customer.getPhoneNumber().equals("0791633254"));
	}

	/**
	 * @Test Run a test to check whether the getCredit method returns the
	 *       correct value.
	 */
	public void testGetCredit() {
		Customer customer = new Customer(credit, phoneNumber, dob);
		assertSame("The objects are not the same!!", credit,
				customer.getCredit());
	}

	/**
	 * @Test Run a test to check whether the customer ID mutator is working
	 *       correctly.
	 */
	public void testsetIdCustomer() {
		Customer customer = new Customer(credit, phoneNumber, dob);
		customer.setIdCustomer(idCustomer);
		assertSame("The objects are not the same!!", idCustomer,
				customer.getIdCustomer());
	}

	/**
	 * @Test Run a test to check whether the customers Date of Birth returns the
	 *       correct value.
	 */
	public void testSetDob() {
		Customer customer = new Customer(credit, phoneNumber, dob);
		customer.setDob(dob);
		assertNotNull("The object is NULL", dob);
	}

	/**
	 * @Test Run a test to check whether the customers set phone number method
	 *       returns the correct value.
	 */
	public void testSetPhoneNumber() {
		Customer customer = new Customer(credit, phoneNumber, dob);
		customer.setPhoneNumber(phoneNumber);
		assertTrue(customer.getPhoneNumber().equals("0791633254"));
	}

	/**
	 * @Test Run a test to check whether the get credit returns the correct
	 *       value.
	 */
	public void testSetCredit() {
		Customer customer = new Customer(credit, phoneNumber, dob);
		customer.setCredit(credit);
		assertSame("The objects are not the same!!", credit,
				customer.getCredit());
	}
}
