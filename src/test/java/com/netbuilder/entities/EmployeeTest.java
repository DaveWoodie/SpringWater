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
	public void testSetRoleConstructor(){
		
		Employee e = new Employee(roleNotNull);
		
		//Testing if employee values are not null
		assertSame("Employee role should be same as constructor rolw", roleNotNull, e.getRole());
	}
}
