package com.netbuilder.entities;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	private float credit = 10.0f;
	private String phoneNumber = "0791633254";
	private String dateString = "11-01-1990";
	private SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
	private Date dob;
	
	
	/**
	 * Used to set the dob Date field before running each test.
	 * @author tstacey
	 * @date 07/10/2015
	 */
	private void setDate() {
		try {
			dob = dFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Testing the Constructor for the DoB field
	 * @author tstacey
	 * @date 07/10/2015
	 */
	@Test
	public void testConstructor() {
		setDate();
		Customer c = new Customer(credit, phoneNumber, dob);
		assertEquals("Date not initiated properly", c.getDob(), dob);
	}
	
	/**
	 * @Test Run a test to make sure that the get ID customer returns the
	 *       correct value of the customers ID from the User test.
	 */
	@Test
	public void testGetIdCustomer() {
		setDate();
		Customer customer = new Customer(credit, phoneNumber, dob);
		assertEquals("The objects are not the same!!", 0, customer.getIdCustomer());
	}

	/**
	 * @Test Run a test to make sure that the
	 * customers date of birth returns the correct 
	 * value.
	 * @author dwoodward
	 * @date 07/10/2015
	 */
	@Test
	public void testGetDob() {
		setDate();
		Customer customer = new Customer(credit, phoneNumber, dob);
		assertNotNull("The object is not NULL", customer.getDob());
	}

	/**
	 * @Test Run a test to make sure that the get customers phone number returns
	 *       the correct value.
	 */
	@Test
	public void testGetPhoneNumber() {
		setDate();
		Customer customer = new Customer(credit, phoneNumber, dob);
		assertTrue(customer.getPhoneNumber().equals("0791633254"));
	}

	/**
	 * @Test Run a test to check whether the getCredit
	 * method returns the correct value.
	 * @author dwoodward
	 * @date 07/10/2015
	 * Changed the way the check was made to include a tolerance. This is the only way to check floats.
	 */
	@Test
	public void testGetCredit() {
		setDate();
		Customer customer = new Customer(credit, phoneNumber, dob);
		assertEquals(customer.getCredit(), 10.0f, 0.01);
	}
	//Removed this as you should never be able to change the customers ID
//	/**
//	 * @Test Run a test to check whether the customer ID
//	 *  mutator is working correctly.
//	 */
//	@Test
//	public void testsetIdCustomer() {
//		Customer customer = new Customer(credit, phoneNumber, dob);
//		customer.setIdCustomer(idCustomer);
//		assertSame("The objects are not the same!!", idCustomer, customer.getIdCustomer());
//	}
	
	/**
	 * @Test Run a test to check whether the customers
	 * Date of Birth returns the correct value.
	 * @author dwoodward
	 * @date 07/10/2015
	 */
	@Test
	public void testSetDob() {
		setDate();
		Customer customer = new Customer(credit, phoneNumber, dob);
		Date d = new Date();
		customer.setDob(d);
		assertEquals("The object is NULL", d, customer.getDob());
	}

	/**
	 * @Test Run a test to check whether the customers 
	 * set phone number method returns the correct value.
	 * @author dwoodward
	 * @test 07/10/2015
	 */
	@Test
	public void testSetPhoneNumber() {
		setDate();
		Customer customer = new Customer(credit, phoneNumber, dob);
		customer.setPhoneNumber("07555555555");
		assertTrue(customer.getPhoneNumber().equals("07555555555"));
	}

	/**
	 * @Test Run a test to check whether the get credit returns
	 * the correct value.
	 * @author dwoodward
	 * @date 07/10/2015
	 */
	@Test
	public void testSetCredit() {
		setDate();
		Customer customer = new Customer(credit, phoneNumber, dob);
		customer.setCredit(12.0f);
		assertEquals(customer.getCredit(), 12.0f, 0.01);
	}
}
