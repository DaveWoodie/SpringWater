package com.netbuilder.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

/**
 * Test class for Address entity
 * @author tstacey
 * @date 07/10/2015
 */

@SuppressWarnings("deprecation")
public class AddressTest {

	ArrayList<String> addressLines = new ArrayList<String>(Arrays.asList("NETbuilder LTD", "5th Floor", "Anchorage 1"));
	Address fullAddress = new Address(new Customer(), addressLines, "Manchester", "Lancs", "M50 3YJ");
	Address partialAddress = new Address(new Customer(), addressLines, "Manchester", "M50 3YJ");
	
	@Test
	public void testEmptyConstructor() {
		Address a = new Address();
		assertNotNull("new Address entity should not be null", a);
	}

	@Test
	public void testFullConstructorAddressLines() {
		assertEquals("2nd line of full address should be '5th Floor'", fullAddress.getAddressLines().get(1), "5th Floor");
	}

	@Test
	public void testFullConstructorCity() {
		assertEquals("City should be 'Manchester'", fullAddress.getCity(), "Manchester");
	}

	@Test
	public void testFullConstructorCounty() {
		assertEquals("County one should be 'Lancs'", fullAddress.getCounty(), "Lancs");
	}

	@Test
	public void testFullConstructorPostCode() {
		assertEquals("Post code should be 'M50 3YJ'", fullAddress.getPostCode(), "M50 3YJ");
	}
	
	@Test
	public void testPartialConstructorAddressLines() {
		assertEquals("Address Line one should be 'NETbuilder LTD'", partialAddress.getAddressLines().get(0), "NETbuilder LTD");
	}

	@Test
	public void testPartialConstructorCity() {
		assertEquals("City should be 'Manchester'", partialAddress.getCity(), "Manchester");
	}

	@Test
	public void testPartialConstructorCounty() {
		assertNull("County should be null", partialAddress.getCounty());
	}

	@Test
	public void testPartialConstructorPostCode() {
		assertEquals("Post code should be 'M50 3YJ'", partialAddress.getPostCode(), "M50 3YJ");
	}
		
}
