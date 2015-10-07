/**
 * @author dwoodward
 * @date 07/10/2015
 */

package com.netbuilder.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

//	private int i = 1;
	private String pas = "p";
	private String fore = "f";
	private String sur = "s";
	private String em = "e";
	private boolean b = true;
	
	@Test
	public void testGetEmployee() {
		User u = new User(pas, fore, sur, em, b);
		assertTrue(u.getIsEmployee());
	}
	
	@Test
	public void testGetID() {
		User u = new User(pas, fore, sur, em, b);
		assertEquals("Should return 0", 0, u.getUserID());
	}
	
	@Test
	public void testGetPwd() { 
		User u = new User(pas, fore, sur, em, b);
		assertTrue(u.getUserPwd().equals("p"));
	}
	
	@Test
	public void testGetFore() { 
		User u = new User(pas, fore, sur, em, b);
		assertTrue(u.getUserFore().equals("f"));
	}
	
	@Test
	public void testGetSur() { 
		User u = new User(pas, fore, sur, em, b);
		assertTrue(u.getUserSurn().equals("s"));
	}
	
	@Test
	public void testGetEma() { 
		User u = new User(pas, fore, sur, em, b);
		assertTrue(u.getUserEmail().equals("e"));
	}
	
	@Test
	public void testSetPwd() { 
		User u = new User(pas, fore, sur, em, b);
		u.setPwd("pp");
		assertTrue(u.getUserPwd().equals("pp"));
	}
	
	@Test
	public void testSetFore() { 
		User u = new User(pas, fore, sur, em, b);
		u.setForeName("ff");
		assertTrue(u.getUserFore().equals("ff"));
	}
	
	@Test
	public void testSetSur() { 
		User u = new User(pas, fore, sur, em, b);
		u.setSurnName("ss");
		assertTrue(u.getUserSurn().equals("ss"));
	}
	
	@Test
	public void testSetEma() { 
		User u = new User(pas, fore, sur, em, b);
		u.setEmail("ee");
		assertTrue(u.getUserEmail().equals("ee"));
	}
	

}
