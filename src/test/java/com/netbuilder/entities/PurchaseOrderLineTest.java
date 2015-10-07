/**
 * 
 */
package com.netbuilder.entities;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author cboucher
 *
 */
public class PurchaseOrderLineTest {

	private int quantity = 1;
	private Item item = new Item();
	private PurchaseOrder purchaseOrder = new PurchaseOrder();

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.PurchaseOrderLine#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() {
		PurchaseOrderLine testClass = new PurchaseOrderLine(quantity, item,
				purchaseOrder);
		assertEquals("Should return 1", 1, testClass.getQuantity());
	}

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.PurchaseOrderLine#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		PurchaseOrderLine testClass = new PurchaseOrderLine(quantity, item,
				purchaseOrder);
		testClass.setQuantity(11);
		assertEquals("Should return 11", 11, testClass.getQuantity());
	}

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.PurchaseOrderLine#getIdItem()}.
	 */
	@Test
	public void testGetItem() {
		PurchaseOrderLine testClass = new PurchaseOrderLine(quantity, item,
				purchaseOrder);
		assertNotNull(testClass.getItem());
	}

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.PurchaseOrderLine#getIdPurchaseOrder()}.
	 */
	@Test
	public void testGetPurchaseOrder() {
		PurchaseOrderLine testClass = new PurchaseOrderLine(quantity, item,
				purchaseOrder);
		assertNotNull(testClass.getPurchaseOrder());
	}

}
