/**
  *@author "chrisjwwalker"
  *@date "07/10/2015"
  */

package com.netbuilder.entities;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class ItemTest {

//	private String itemName = "Red Gnome";
//	private String desc = "It's a gnome";
//	private float price = 9.99f;
//	private int stock = 274;
//	private String imageLocation = "C:/Users/chrisjwwalker/redGnome.png";
//	private boolean discontinued = false;
//	private int salesRate = 2;
//	private int pSalesRate = 78;
//	private boolean isPorousware = false;
//	private Supplier idSupplier = new Supplier(null, null);
//	private HashMap<String, String> attributesMap;
//
//	@Test
//	public void testIdItem() {
//		setupAttributesMap();
//		Item i = new Item(itemName, desc, price, stock, imageLocation, discontinued, salesRate, pSalesRate, isPorousware, idSupplier, attributesMap);
//		assertEquals("Item ID should be null", 0, i.getIdItem());
//	}
//
//	@Test
//	public void testGetItemName() {
//		setupAttributesMap();
//		Item i = new Item(itemName, desc, price, stock, imageLocation, discontinued, salesRate, pSalesRate, isPorousware, idSupplier, attributesMap);
//		i.setItemName("Green Gnome");
//		assertEquals("Name shouldn't match iName", "Green Gnome", i.getItemName());
//	}
//
//	@Test
//	public void testGetPrice() {
//		setupAttributesMap();
//		Item i = new Item(itemName, desc, price, stock, imageLocation, discontinued, salesRate, pSalesRate, isPorousware, idSupplier, attributesMap);
//		i.setPrice(5.23f);
//		assertEquals(5.23f, i.getPrice(), 0);
//	}
//
//	@Test
//	public void testGetStock() {
//		setupAttributesMap();
//		Item i = new Item(itemName, desc, price, stock, imageLocation, discontinued, salesRate, pSalesRate, isPorousware, idSupplier, attributesMap);
//		i.setStock(100);
//		assertEquals(100, i.getStock(), 0);
//	}
//
//	@Test
//	public void testGetImageLocation() {
//		setupAttributesMap();
//		Item i = new Item(itemName, desc, price, stock, imageLocation, discontinued, salesRate, pSalesRate, isPorousware, idSupplier, attributesMap);
//		i.setImageLocation("https://image.co.uk/gnome.jpg");
//		assertEquals("https://image.co.uk/gnome.jpg", i.getImageLocation());
//	}
//
//	@Test
//	public void testGetSalesRate() {
//		setupAttributesMap();
//		Item i = new Item(itemName, desc, price, stock, imageLocation, discontinued, salesRate, pSalesRate, isPorousware, idSupplier, attributesMap);
//		i.setSalesRate(3);
//		assertEquals("Get sales Rate", 3, i.getSalesRate());
//	}
//
//	//Float test
////	@Test
////	public void testGetSalesRate() {
////		Item i = new Item(iName, p, s, iLoc, dc, sr, psr, ip, ids);
////		i.setSalesRate(3.0f);
////		assertEquals(i.getSalesRate(), 3.0f, 0.01f);
////	}
//	
//	@Test
//	public void testGetpSalesRate() {
//		setupAttributesMap();
//		Item i = new Item(itemName, desc, price, stock, imageLocation, discontinued, salesRate, pSalesRate, isPorousware, idSupplier, attributesMap);
//		i.setpSalesRate(45);
//		assertEquals("Get past sales rate", 45, i.getpSalesRate());
//	}
//
//	@Test
//	public void testIsDiscontinued() {
//		setupAttributesMap();
//		Item i = new Item(itemName, desc, price, stock, imageLocation, discontinued, salesRate, pSalesRate, isPorousware, idSupplier, attributesMap);
//		assertFalse(i.isDiscontinued());
//	}
//
//	@Test
//	public void testIsPorousware() {
//		setupAttributesMap();
//		Item i = new Item(itemName, desc, price, stock, imageLocation, discontinued, salesRate, pSalesRate, isPorousware, idSupplier, attributesMap);
//		assertFalse(i.isPorousware());
//	}
//	
//	@Test
//	public void testGetAttributes() {
//		
//	}
//	
//	private void setupAttributesMap() {
//		attributesMap = new HashMap<String, String>();
//		attributesMap.put("Hat Colour", "Red");
//		attributesMap.put("Height", "28cm");
//		attributesMap.put("Width", "7cm");
//		attributesMap.put("Depth", "7cm");
//		attributesMap.put("Accessory", "Fishing Rod");
//	}
}