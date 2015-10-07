package com.netbuilder.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

	
	private String iName = "Red Gnome";
	private double p = 9.99;
	private int s = 274;
	private String iLoc = "C:/Users/chrisjwwalker/redGnome.png";
	private boolean dc = false;
	private int sr = 46;
	private int psr = 78;
	private boolean ip = true;
	private Supplier ids = new Supplier(null, null);
	
	@Test
	public void testItem() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
	}

	@Test
	public void testIdItem() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
		assertNull("Item ID should be null", i.idItem());
	}

	@Test
	public void testGetItemName() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
		assertEquals("Name should match name", iName, i.getItemName());
	}

	@Test
	public void testGetPrice() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
		assertEquals(p, i.getPrice(), 0);
	}

	@Test
	public void testGetStock() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
		assertEquals(s, i.getStock(), 0);
	}

	@Test
	public void testGetImageLocation() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
		assertEquals("Name should match iLoc", iLoc, i.getImageLocation());
	}

	@Test
	public void testGetSalesRate() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
		assertEquals(sr, i.getSalesRate(), 0);
	}

	@Test
	public void testGetpSalesRate() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
		assertEquals(s, i.getpSalesRate(), 0);
	}

	@Test
	public void testGetIdSupplier() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
		assertNull("Item ID should be null", ids.getSupplierID());
	}

	@Test
	public void testIsDiscontinued() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
		assertFalse(dc);
	}

	@Test
	public void testIsPorousware() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
		assertFalse(ip);
	}

	@Test
	public void testSetItemName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPrice() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetStock() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetImageLocation() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPorousware() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDiscontinued() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSalesRate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetpSalesRate() {
		fail("Not yet implemented");
	}
}
