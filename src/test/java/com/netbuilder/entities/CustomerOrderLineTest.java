/**
 * 
 */
package com.netbuilder.entities;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

/**
 * @author cboucher
 * @date 07/10/2015
 */
public class CustomerOrderLineTest {

	private int quantity = 1;
	private Item item = new Item();
	private CustomerOrder customerOrder = new CustomerOrder();

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.CustomerOrderLine#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() {
		CustomerOrderLine testClass = new CustomerOrderLine(quantity, item,
				customerOrder);
		assertEquals("Should return 1", 1, testClass.getQuantity());
	}

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.CustomerOrderLine#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		CustomerOrderLine testClass = new CustomerOrderLine(quantity, item,
				customerOrder);
		testClass.setQuantity(11);
		assertEquals("Should return 11", 11, testClass.getQuantity());
	}

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.CustomerOrderLine#getIdItem()}.
	 */
	@Test
	public void testGetIdItem() {
		CustomerOrderLine testClass = new CustomerOrderLine(quantity, item,
				customerOrder);
		assertNotNull(testClass.getItem());
	}

	/**
	 * Test method for
	 * {@link com.netbuilder.entities.CustomerOrderLine#getIdCustomerOrder()}.
	 */
	@Test
	public void testGetIdCustomerOrder() {
		CustomerOrderLine testClass = new CustomerOrderLine(quantity, item,
				customerOrder);
		assertNotNull(testClass.getCustomerOrder());
	}

}
