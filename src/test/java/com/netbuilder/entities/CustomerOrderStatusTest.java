package com.netbuilder.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerOrderStatusTest {

	@Test
	public void testGetID() {
		CustomerOrderStatus c = new CustomerOrderStatus();
		assertEquals("Should return 0", 0, c.getStatusID());
	}
	
	@Test
	public void testStatus() {
		CustomerOrderStatus c = new CustomerOrderStatus();
		assertNull(c.getCustOrderStatus());
	}

}
