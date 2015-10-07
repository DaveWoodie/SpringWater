package com.netbuilder.entities;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author ccooper
 * @date 07/10/2015
 *
 */

public class WishListLineTest {
	
	/**
	 * WishListLine test attributes
	 */
	private int idItem = 1;
	private int idCustomer = 101;
	
	/**
	 * @Test run a test to check whether
	 * the get Id item returns a correct
	 * value.
	 */
	public void testGetIdItem() {
		WishListLine wishListLine = new WishListLine(idItem, idCustomer);
		assertSame("The objects are not the same!!", idItem, wishListLine.getIdItem());
	}
	
	/**
	 * @Test run a test to check whether 
	 * the get Id item method returns
	 * the correct value.
	 */
	public void testGetIdCustomer() {
		WishListLine wishListLine = new WishListLine(idItem, idCustomer);
		assertSame("The objects are not the same!!", idCustomer, wishListLine.getIdCustomer());
	}
	
	/**
	 * @Test run a test to check whether
	 * the set Id method mutates the data
	 * in the correct way.
	 */
	public void testSetIdItem() {
		WishListLine wishListLine = new WishListLine(idItem, idCustomer);
		wishListLine.setIdItem(idItem);
		assertSame("The objects are not the same!!", idItem, wishListLine.getIdItem());
	}
	
	/**
	 * @Test run a test to check whether
	 * the set Id customer method mutates
	 * the data in the correct way.
	 */
	public void testSetIdCustomer() {
		WishListLine wishListLine = new WishListLine(idItem, idCustomer);
		wishListLine.setIdCustomer(idCustomer);
		assertSame("The objects are not the same!!", idCustomer, wishListLine.getIdCustomer());
	}
	
}
