//package com.netbuilder.entities;
//
//import static org.junit.Assert.*;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import org.junit.Test;
//
///**
// * 
// * @author ccooper
// * @date 07/10/2015
// *
// */
//
//public class WishListTest {
//	
////	/**
////	 * WishList test attributes
////	 */
////	private Customer cust = new Customer();
////	private Item itemOne = new Item(1, "Gnome");
////	private Item itemTwo = new Item(2, "Jacuzzi");
////	private Item itemThree = new Item(3, "Brick");
////	private ArrayList<Item> itemList;
////	
////	@Test
////	public void testFullConstructor() {
////		addItemsToList(itemOne);
////		WishList w = new WishList(cust, itemList);
////		
////		assertNotNull("Wishlist should be constructed", w);
////	}
////	
////	@Test
////	public void testPartialConstructor() {
////		WishList w = new WishList(cust);
////		
////		assertNotNull("Wishlist should be constructed with partial constructor", w);
////	}
////	
////	@Test
////	public void testNumberOfItems() {
////		addItemsToList(itemOne, itemTwo);
////		
////		WishList w = new WishList(cust, itemList);
////		assertEquals("Should be two items in WishList", w.getNumberOfItems(), 2);
////	}
////	
////	@Test
////	public void testGetItemByID() {
////		addItemsToList(itemOne, itemTwo, itemThree);
////		
////		WishList w = new WishList(cust, itemList);
////		Item i = new Item();
////		try {
////			i = w.getItemByID(2);
////		} catch (IOException e) {
////			fail("Couldn't find item in item list");
////		}
////		
////		assertSame("ItemTwo should have been returned from Item List", i, itemTwo);
////	}
////	
////	@Test
////	public void testExceptionWhenNoID() {
////		addItemsToList(itemOne, itemTwo, itemThree);
////		
////		WishList w = new WishList(cust, itemList);
////		try {
////			w.getItemByID(4);
////			fail("should have thrown an exception as no Item with ID 4 in Item ArrayList");
////		} catch (IOException e) {
////			// code should throw an exception
////			assertTrue(true);
////		}
////		
////	}
////	
////	@Test
////	public void testAddItem() {
////		addItemsToList(itemOne, itemTwo);
////		
////		WishList w = new WishList(cust, itemList);
////		w.addItem(itemThree);
////		assertEquals("Should be three items in WishList", w.getNumberOfItems(), 3);
////	}
////	
////	@Test
////	public void testRemoveItem() {
////		addItemsToList(itemOne, itemTwo, itemThree);
////		
////		WishList w = new WishList(cust, itemList);
////		Item i = new Item();
////		try {
////			i = w.removeItem(3);
////		} catch (IOException e) {
////			fail("Couldn't find item in item list");
////		}
////		
////		assertSame("itemThree should have been returned from Item List", i, itemThree);
////	}
////	
////	@Test
////	public void testExceptionWhenCantRemove() {
////		addItemsToList(itemOne, itemTwo, itemThree);
////		
////		WishList w = new WishList(cust, itemList);
////		try {
////			w.removeItem(4);
////			fail("should have thrown an exception as no Item with ID 4 in Item ArrayList");
////		} catch (IOException e) {
////			// code should throw an exception
////			assertTrue(true);
////		}
////	}
////	
////	@Test
////	public void testRemoveAll() {
////		addItemsToList(itemOne, itemTwo, itemThree);
////		
////		WishList w = new WishList(cust, itemList);
////		w.removeAllItems();
////		assertEquals("Should have removed all items from WishList", w.getNumberOfItems(), 0);
////	}
////	
////	private void addItemsToList(Item... itemsToAdd) {
////		itemList = new ArrayList<Item>();
////		for(Item i : itemsToAdd) {
////			itemList.add(i);
////		}
////	}
//	
//}
