package com.netbuilder.entities;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for Supplier entity
 * @author tstacey
 * @date 07/10/2015
 */
public class SupplierTest {

	@Test
	public void testBlankConstructor() {
		Supplier s = new Supplier();
		assertNotNull("Empty supplier constructor should create a new supplier object", s);
	}
	
	@Test
	public void testSupplierNameFromConstructor() {
		Address a = new Address();
		Supplier s = new Supplier("Gnome Force LTD", a);
		assertEquals("Supplier name should be Gnome Force LTD", s.getSupplierName(), "Gnome Force LTD");
	}
	

	@Test
	public void testSupplierAddressFromConstructor() {
		Address a = new Address();
		Supplier s = new Supplier("Gnome Force LTD", a);
		assertEquals("Supplier address should be the same as passed to constructor", s.getAddress(), a);
	}

}
