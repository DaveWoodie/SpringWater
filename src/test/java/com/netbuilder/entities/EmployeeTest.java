/**
 * author@ Freshwater
 * date@ 07/10/2015
 */

package com.netbuilder.entities;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeTest {
	
	static Role roleNotNull;
	
	@BeforeClass
	public static void setUpRoleBeforeClass(){
		
		//Set up not null Role to test Employee class
		roleNotNull = new Role(0, "test");
	}
	
	@Test
	public void testGetEmployeeID(){
		
		Employee e = new Employee(0, roleNotNull);
		
		assertEquals("Employee ID should be 0", 0, e.getID());
	}
	
	@Test
	public void testSetEmployeeID(){
		
		Employee e = new Employee(0, roleNotNull);
		
		e.setID(1);
		assertEquals("Employee ID should return 1", 1, e.getID());
	}
	
	@Test
	public void testToCheckNotNullValueInEmployee(){
		
		Employee e = new Employee(0, roleNotNull);
		
		//Testing if employee values are not null
		assertNotNull(roleNotNull);
		assertNotNull(e.getID());
	}
}
