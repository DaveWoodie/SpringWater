/**
 * 
 */
package com.netbuilder.entities;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author cboucher
 * @date 07/10/2015
 */
public class CustomerOrderLineTest {

	private int quantity = 1;
	private int idItem = 2;
	private int idCustomerOrder = 3;

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.CustomerOrderLine#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() {
		CustomerOrderLine testClass = new CustomerOrderLine(quantity, idItem,
				idCustomerOrder);
		assertEquals("Should return 1", 1, testClass.getQuantity());
	}

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.CustomerOrderLine#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		CustomerOrderLine testClass = new CustomerOrderLine(quantity, idItem,
				idCustomerOrder);
		testClass.setQuantity(11);
		assertEquals("Should return 11", 11, testClass.getQuantity());
	}

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.CustomerOrderLine#getIdItem()}.
	 */
	@Test
	public void testGetIdItem() {
		CustomerOrderLine testClass = new CustomerOrderLine(quantity, idItem,
				idCustomerOrder);
		assertEquals("Should return 2", 2, testClass.getIdItem());
	}

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.CustomerOrderLine#setIdItem(int)}.
	 */
	@Test
	public void testSetIdItem() {
		CustomerOrderLine testClass = new CustomerOrderLine(quantity, idItem,
				idCustomerOrder);
		testClass.setIdItem(22);
		assertEquals("Should return 22", 22, testClass.getIdItem());
	}

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.CustomerOrderLine#getIdCustomerOrder()}.
	 */
	@Test
	public void testGetIdCustomerOrder() {
		CustomerOrderLine testClass = new CustomerOrderLine(quantity, idItem,
				idCustomerOrder);
		assertEquals("Should return 3", 3, testClass.getIdCustomerOrder());
	}

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.CustomerOrderLine#setIdCustomerOrder(int)}
	 * .
	 */
	@Test
	public void testSetIdCustomerOrder() {
		CustomerOrderLine testClass = new CustomerOrderLine(quantity, idItem,
				idCustomerOrder);
		testClass.setIdCustomerOrder(33);
		assertEquals("Should return 33", 33, testClass.getIdCustomerOrder());
	}

}
