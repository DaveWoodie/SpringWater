package com.netbuilder.entities;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for Address entity
 * @author tstacey
 * @date 07/10/2015
 */

@SuppressWarnings("deprecation")
public class AddressTest {

	@Test
	public void testEmptyConstructor() {
		Address a = new Address();
		assertNotNull("new Address entity should not be null", a);
	}

	@Test
	public void testFullConstructorAddressOne() {
		Address a = new Address("NETbuilder LTD", "5th Floor, Anchorage 1", "Manchester", "Lancs", "M50 3YJ");
		assertEquals("Address Line one should be 'NETbuilder LTD'", a.getAddressLineOne(), "NETbuilder LTD");
	}

	@Test
	public void testFullConstructorAddressTwo() {
		Address a = new Address("NETbuilder LTD", "5th Floor, Anchorage 1", "Manchester", "Lancs", "M50 3YJ");
		assertEquals("Address line two should be '5th Floor, Anchorage 1'", a.getAddressLineTwo(), "5th Floor, Anchorage 1");
	}

	@Test
	public void testFullConstructorCity() {
		Address a = new Address("NETbuilder LTD", "5th Floor, Anchorage 1", "Manchester", "Lancs", "M50 3YJ");
		assertEquals("City should be 'Manchester'", a.getCity(), "Manchester");
	}

	@Test
	public void testFullConstructorCounty() {
		Address a = new Address("NETbuilder LTD", "5th Floor, Anchorage 1", "Manchester", "Lancs", "M50 3YJ");
		assertEquals("County one should be 'Lancs'", a.getCounty(), "Lancs");
	}

	@Test
	public void testFullConstructorPostCode() {
		Address a = new Address("NETbuilder LTD", "5th Floor, Anchorage 1", "Manchester", "Lancs", "M50 3YJ");
		assertEquals("Post code should be 'M50 3YJ'", a.getPostCode(), "M50 3YJ");
	}
	
	@Test
	public void testPartialConstructorAddressOne() {
		Address a = new Address("NETbuilder LTD", "Manchester", "Lancs", "M50 3YJ");
		assertEquals("Address Line one should be 'NETbuilder LTD'", a.getAddressLineOne(), "NETbuilder LTD");
	}

	@Test
	public void testPartialConstructorCity() {
		Address a = new Address("NETbuilder LTD", "Manchester", "Lancs", "M50 3YJ");
		assertEquals("City should be 'Manchester'", a.getCity(), "Manchester");
	}

	@Test
	public void testPartialConstructorCounty() {
		Address a = new Address("NETbuilder LTD", "Manchester", "Lancs", "M50 3YJ");
		assertEquals("County one should be 'Lancs'", a.getCounty(), "Lancs");
	}

	@Test
	public void testPartialConstructorPostCode() {
		Address a = new Address("NETbuilder LTD", "Manchester", "Lancs", "M50 3YJ");
		assertEquals("Post code should be 'M50 3YJ'", a.getPostCode(), "M50 3YJ");
	}
	
	@Test
	public void testPartialConstructorAddressTwo() {
		Address a = new Address("NETbuilder LTD", "Manchester", "Lancs", "M50 3YJ");
		assertNull("On partial constructor instantiation, Address line two should be NULL", a.getAddressLineTwo());
	}
	

	@Test
	public void testPartialConstructorAddressTwoAfterSetting() {
		Address a = new Address("NETbuilder LTD", "Manchester", "Lancs", "M50 3YJ");
		a.setAddressLineTwo("5th Floor, Anchorage 1");
		assertEquals("After partial constructor instantiation and setAddressLineTwo('5th Floor, Anchorage 1'), Address line two should be '5th Floor, Anchorage 1'", a.getAddressLineTwo(), "5th Floor, Anchorage 1");
	}
}
