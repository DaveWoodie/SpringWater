package com.netbuilder.entities;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class CustomerOrderTest {
	Date dp = new Date();
	Customer c = new Customer(10,"01234", dp);
	CustomerOrderStatus os = new CustomerOrderStatus();
	Role r = new Role(1, "Manager");
	Employee e = new Employee(2, r);
		
	@Test
	public void testIsCustomer() {
		CustomerOrder co = new CustomerOrder(dp,c,os,e);
		assertNotNull(co);
	}
	
	@Test
	public void testGetID() {
		CustomerOrder co = new CustomerOrder(); 
		assertEquals("should return 0", 0, co.getCustomerOrderID());
	}
	
	@Test
	public void testGetSetEmployee() {
		CustomerOrder co = new CustomerOrder(); 
		co.setEmployee(e);
		assertEquals("should be the same employee",e,co.getEmployee());
	}
	
	@Test
	public void testGetSetDateShipped()	{
		CustomerOrder co = new CustomerOrder(); 
		co.setDateShipped(dp);
		assertEquals("should be the same date shipped",dp,co.getDateShipped());
	}
	
	@Test
	public void testGetSetOrderStatus() {
		CustomerOrder co = new CustomerOrder(); 
		co.setOrderStatus(os);
		assertEquals("should be the same order status",os,co.getCustomerOrderStatus());
	}
	
	@Test
	public void testGetDatePlaced() {
		CustomerOrder co = new CustomerOrder(dp,c,os,e);
		assertEquals("should be the same date placed",dp,co.getDatePlaced());
	}
	
	@Test
	public void testGetCustomer() {
		CustomerOrder co = new CustomerOrder(dp,c,os,e);
		assertEquals("should be the same customer",c,co.getCustomer());
	}
	
	@Test
	public void testGet() {
		CustomerOrder co = new CustomerOrder(dp,c,os,e);
		assertEquals("should be the same date placed",dp,co.getDatePlaced());
	}
}
