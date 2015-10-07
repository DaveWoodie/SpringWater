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
	private int idItem = 2;
	private int idPurchaseOrder = 3;

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.PurchaseOrderLine#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() {
		PurchaseOrderLine testClass = new PurchaseOrderLine(quantity, idItem,
				idPurchaseOrder);
		assertEquals("Should return 1", 1, testClass.getQuantity());
	}

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.PurchaseOrderLine#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		PurchaseOrderLine testClass = new PurchaseOrderLine(quantity, idItem,
				idPurchaseOrder);
		testClass.setQuantity(11);
		assertEquals("Should return 11", 11, testClass.getQuantity());
	}

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.PurchaseOrderLine#getIdItem()}.
	 */
	@Test
	public void testGetIdItem() {
		PurchaseOrderLine testClass = new PurchaseOrderLine(quantity, idItem,
				idPurchaseOrder);
		assertEquals("Should return 2", 2, testClass.getIdItem());
	}

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.PurchaseOrderLine#setIdItem(int)}.
	 */
	@Test
	public void testSetIdItem() {
		PurchaseOrderLine testClass = new PurchaseOrderLine(quantity, idItem,
				idPurchaseOrder);
		testClass.setIdItem(22);
		assertEquals("Should return 22", 22, testClass.getIdItem());
	}

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.PurchaseOrderLine#getIdPurchaseOrder()}.
	 */
	@Test
	public void testGetIdPurchaseOrder() {
		PurchaseOrderLine testClass = new PurchaseOrderLine(quantity, idItem,
				idPurchaseOrder);
		assertEquals("Should return 3", 3, testClass.getIdPurchaseOrder());
	}

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.PurchaseOrderLine#setIdPurchaseOrder(int)}
	 * .
	 */
	@Test
	public void testSetIdPurchaseOrder() {
		PurchaseOrderLine testClass = new PurchaseOrderLine(quantity, idItem,
				idPurchaseOrder);
		testClass.setIdPurchaseOrder(33);
		assertEquals("Should return 33", 33, testClass.getIdPurchaseOrder());
	}

}
