package com.netbuilder.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @date 08/10/2015
 * @author tstacey
 *
 */
public class DummyData {
	
	private ArrayList<Address> addresses = new ArrayList<Address>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<CustomerOrder> custOrders = new ArrayList<CustomerOrder>();
	private ArrayList<CustomerOrderLine> custOrderLines = new ArrayList<CustomerOrderLine>();
	private ArrayList<CustomerOrderStatus> custOrderStatuses = new ArrayList<CustomerOrderStatus>();
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<PaymentDetails> payments = new ArrayList<PaymentDetails>();
	private ArrayList<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
	private ArrayList<PurchaseOrderLine> purchaseOrderLines = new ArrayList<PurchaseOrderLine>();
	private ArrayList<PurchaseOrderStatus> purchaseOrderStatuses = new ArrayList<PurchaseOrderStatus>();
	private ArrayList<Role> roles = new ArrayList<Role>();
	private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<WishListLine> wishListLines = new ArrayList<WishListLine>();
	
	private SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	public DummyData() {
		initialSetup();
	}

	
	private void initialSetup() {
				
		setUpBaseEntities();

		// CUSTOMER ORDER
		addCustomerOrders();
	}

	
	private void setUpBaseEntities() {
		// ADDRESSES
		addresses.add(new Address("NETbuilder LTD", "5th Floor, Anchorage 1", "Manchester", "Lancs", "M50 3YJ"));
		addresses.add(new Address("16 Maple View", "Lovelyside", "Upper Slaughter", "Gloucestershire", "GL54 2JB"));
		

		addCustomers();
		addCustomerOrderStatuses();
		
		
	}
	
	private Date makeDate(String dateString) {
		try {
			Date d = dFormat.parse(dateString);
			return d;
		} catch (ParseException e) {
			throw new Error(e);
		}
	}
	
	private void addCustomers() {

		Date dob = makeDate("11-01-1990");
		customers.add(new Customer(5000, "07958046028", dob));
		
		dob = makeDate("15-06-1965");
		customers.add(new Customer(5000, "01612248935", dob));
		
	}
	
	private void addCustomerOrderStatuses() {
		custOrderStatuses.add(new CustomerOrderStatus("Placed"));
		custOrderStatuses.add(new CustomerOrderStatus("Claimed"));
		custOrderStatuses.add(new CustomerOrderStatus("Picked"));
		custOrderStatuses.add(new CustomerOrderStatus("Packed"));
		custOrderStatuses.add(new CustomerOrderStatus("Awaiting Dispatch"));
		custOrderStatuses.add(new CustomerOrderStatus("Out for delivery"));
		custOrderStatuses.add(new CustomerOrderStatus("Cancelled"));
	}
	
	// TODO - finish once component entities have been created
	private void addCustomerOrders() {
		Date datePlaced = makeDate("01/10/2015");
	}
}















































