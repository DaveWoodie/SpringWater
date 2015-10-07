/**
  *@author "chrisjwwalker"
  *@date "07/10/2015"
  */

package com.netbuilder.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

	private String iName = "Red Gnome";
	private float p = 9.99f;
	private int s = 274;
	private String iLoc = "C:/Users/chrisjwwalker/redGnome.png";
	private boolean dc = false;
	private int sr = 2;
	private int psr = 78;
	private boolean ip = false;
	private Supplier ids = new Supplier(null, null);

	@Test
	public void testIdItem() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
		assertEquals("Item ID should be null", 0, i.idItem());
	}

	@Test
	public void testGetItemName() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
		i.setItemName("Green Gnome");
		assertEquals("Name shouldn't match iName", "Green Gnome", i.getItemName());
	}

	@Test
	public void testGetPrice() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
		i.setPrice(5.23f);
		assertEquals(5.23f, i.getPrice(), 0);
	}

	@Test
	public void testGetStock() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
		i.setStock(100);
		assertEquals(100, i.getStock(), 0);
	}

	@Test
	public void testGetImageLocation() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
		i.setImageLocation("https://image.co.uk/gnome.jpg");
		assertEquals("https://image.co.uk/gnome.jpg", i.getImageLocation());
	}

	@Test
	public void testGetSalesRate() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
		i.setSalesRate(3);
		assertEquals("Get sales Rate", 3, i.getSalesRate());
	}

	//Float test
//	@Test
//	public void testGetSalesRate() {
//		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
//		i.setSalesRate(3.0f);
//		assertTrue(i.getSalesRate().equals(3.0f));
//	}
	
	@Test
	public void testGetpSalesRate() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
		i.setpSalesRate(45);
		assertEquals("Get past sales rate", 45, i.getpSalesRate());
	}

	@Test
	public void testIsDiscontinued() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
		assertFalse(i.isDiscontinued());
	}

	@Test
	public void testIsPorousware() {
		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
		assertFalse(i.isPorousware());
	}
}