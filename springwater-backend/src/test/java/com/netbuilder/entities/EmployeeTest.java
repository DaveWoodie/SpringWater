/**
 * author@ Freshwater
 * date@ 07/10/2015
 */

package com.netbuilder.entities;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeTest {
	
	private Role roleNotNull = new Role("test");
	private User u = new User("password","Al","Stock","Al.Stock@NBGardens.com", true);
	
	
	@Test
	public void testRoleInConstructor(){
		
		Employee e = new Employee(u, roleNotNull);
		
		//Testing if employee values are not null
		assertSame("Employee role should be same as constructor role", roleNotNull, e.getRole());
	}
	

	
	@Test
	public void testUserInConstructor(){
		
		Employee e = new Employee(u, roleNotNull);
		
		//Testing if employee values are not null
		assertSame("Employee user should be same as constructor user", u, e.getUser());
	}
}
