/**
 * @author abutcher
 * @date 06/10/2015
 */

package com.netbuilder.entities;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class CustomerOrderTest {
	Date dp = new Date();
	Customer c = new Customer(10,"01234", dp);
	CustomerOrderStatus os = new CustomerOrderStatus();
	Role r = new Role("Manager");
	Employee e = new Employee(r);
		
	@Test
	public void testIsCustomer() {
		CustomerOrder co = new CustomerOrder(dp,c,os,e,false);
		assertNotNull(co);
	}
	
	@Test
	public void testGetID() {
		CustomerOrder co = new CustomerOrder(); 
		assertEquals("should return 0", 0, co.getCustomerOrderID());
	}
	/**
	 * @author dwoodward
	 * @date 07/10/2015
	 * Changed the test to create a new instance to test and then check that for the JUnit
	 */
	@Test
	public void testGetSetEmployee() {
		CustomerOrder co = new CustomerOrder(); 
		Employee ee = new Employee(r);
		co.setEmployee(ee);
		assertEquals("should be the same employee", ee, co.getEmployee());
	}
	/**
	 * @author dwoodward
	 * @date 07/10/2015
	 * Changed the test to create a new instance to test and then check that for the JUnit
	 */
	@Test
	public void testGetSetDateShipped()	{
		CustomerOrder co = new CustomerOrder(); 
		Date d = new Date();
		co.setDateShipped(d);
		assertEquals("should be the same date shipped", d, co.getDateShipped());
	}
	/**
	 * @author dwoodward
	 * @date 07/10/2015
	 * Changed the test to create a new instance to test and then check that for the JUnit
	 */
	@Test
	public void testGetSetOrderStatus() {
		CustomerOrder co = new CustomerOrder(); 
		CustomerOrderStatus c = new CustomerOrderStatus();
		co.setOrderStatus(c);
		assertSame("should be the same order status", c, co.getCustomerOrderStatus());
	}
	
	@Test
	public void testGetDatePlaced() {
		CustomerOrder co = new CustomerOrder(dp,c,os,e,false);
		assertEquals("should be the same date placed", dp, co.getDatePlaced());
	}
	
	@Test
	public void testGetCustomer() {
		CustomerOrder co = new CustomerOrder(dp,c,os,e,false);
		assertEquals("should be the same customer", c, co.getCustomer());
	}
	
	@Test
	public void testGet() {
		CustomerOrder co = new CustomerOrder(dp,c,os,e,false);
		assertEquals("should be the same date placed", dp, co.getDatePlaced());
	}
}
