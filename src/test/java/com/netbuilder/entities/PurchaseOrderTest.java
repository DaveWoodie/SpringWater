package com.netbuilder.entities;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class PurchaseOrderTest {
	
	Date dP = new Date();
	Role r = new Role(1, "Employee");
	Employee e = new Employee(1, r);
	PurchaseOrderStatus pOS = new PurchaseOrderStatus();
	Address a = new Address();
	Supplier s = new Supplier("NBSupplier", a);
	
	@Test
	public void getIDPurchaseOrderTest() {
		PurchaseOrder pO = new PurchaseOrder(dP, e, pOS, s);
		assertEquals("The ID should be 0", 0, pO.getIDPurchaseOrder());
	}
	
	@Test
	public void getDatePlacedTest() {
		PurchaseOrder pO = new PurchaseOrder(dP, e, pOS, s);
		assertEquals("The two dates should be identical", dP, pO.getDatePlaced());
	}
	
	@Test
	public void getDateExpectedTest() {
		PurchaseOrder pO = new PurchaseOrder(dP, e, pOS, s);
		assertNull(pO.getDateExpected());
	}
	
	@Test
	public void getEmployeeTest() {
		PurchaseOrder pO = new PurchaseOrder(dP, e, pOS, s);
		assertEquals("The two Employees should be identical", e, pO.getEmployee());
	}
	
	@Test
	public void getPurchaseOrderStatusTest() {
		PurchaseOrder pO = new PurchaseOrder(dP, e, pOS, s);
		assertEquals("The two statuses should be identical", pOS, pO.getPurchaseOrderStatus());
	}
	
	@Test
	public void getSupplierTest() {
		PurchaseOrder pO = new PurchaseOrder(dP, e, pOS, s);
		assertEquals("The two suppliers should be identical", s, pO.getSupplier());
	}
	
	@Test
	public void setDateExpectedTest() {
		
		PurchaseOrder pO = new PurchaseOrder();
		Date dE = new Date();
		pO.setDateExpected(dE);
		Date dR = pO.getDateExpected();
		assertEquals("The two dates should be identical", dE, dR);
	}
	
	@Test
	public void setEmployeeTest() {
		
		PurchaseOrder pO = new PurchaseOrder();
		Role r = new Role(1, "Employee");
		Employee e = new Employee(1, r);
		pO.setEmployee(e);
		assertEquals("The two employees should be identical", e, pO.getEmployee());
	}
	
	@Test
	public void setPurchaseOrderStatusTest() {
		PurchaseOrder pO = new PurchaseOrder();
		PurchaseOrderStatus pOS = new PurchaseOrderStatus();
		pO.setPurchaseOrderStatus(pOS);
		assertEquals("The order statuses should be identical", pOS, pO.getPurchaseOrderStatus());
	}
	
}

