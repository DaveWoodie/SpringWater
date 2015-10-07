/**
 * author@ Freshwater
 * date@ 07/10/2015
 */

package com.netbuilder.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoleTest {
	
	@Test
	public void testNotNullValueInRole() {
		
		//Role containing no null values
		Role r = new Role(0, "test");
		
		//Testing if Role is not null
		assertNotNull("Role ID should not be null", r.getID());
		assertNotNull("Role role should not be null", r.getRole());
	}
	
	@Test
	public void testGetRoleID(){
		
		Role r = new Role(0, "test");
		
		//Testing if Role returns the expected value
		assertEquals("Role ID should be 0", 0, r.getID());
	}
	
	@Test
	public void testSetRoleID(){
		
		Role r = new Role(0, "test");
		
		//Testing if Role sets and returns the expected value
		r.setID(1);
		assertEquals("Role ID should return 1", 1, r.getID());
	}
	
	@Test
	public void testGetRoleName(){
		
		Role r = new Role(0, "test");
		
		//Testing if Role name returns the expected value
		assertEquals("Role name should be 'test'", "test", r.getRole());
	}
	
	@Test
	public void testSetRoleName(){
		
		Role r = new Role(0, "test");
		
		//Testing if Role sets and returns the expected value
		r.setRole("testName");
		assertEquals("Role name should return 'testName", "testName", r.getRole());
	}
	
	@Test
	public void testNullStringValueInRole(){
		
		//Role containing a null String value
		Role r = new Role(0, null);
		
		//Testing if Role contains a null value
		assertNull("Role role should be null", r.getRole());
	}
}
