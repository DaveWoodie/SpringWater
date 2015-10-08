package com.netbuilder.entities;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddressTest.class, CustomerOrderLineTest.class,
		CustomerOrderStatusTest.class, CustomerOrderTest.class,
		CustomerTest.class, EmployeeTest.class, ItemTest.class,
		PaymentDetailsTest.class, PurchaseOrderLineTest.class,
		PurchaseOrderStatusTest.class, PurchaseOrderTest.class, RoleTest.class,
		SupplierTest.class, UserTest.class, WishListLineTest.class })
public class AllEntityTests {

}
