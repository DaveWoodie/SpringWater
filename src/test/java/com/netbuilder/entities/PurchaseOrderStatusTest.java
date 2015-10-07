package com.netbuilder.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class PurchaseOrderStatusTest {

	@Test
	public void testGetID() {
		PurchaseOrderStatus p = new PurchaseOrderStatus();
		assertEquals("Should return 0", 0, p.getStatusID());
	}
	
	@Test
	public void testStatus() {
		PurchaseOrderStatus p = new PurchaseOrderStatus();
		assertNull(p.getPurchOrderStatus());
	}

}
