//package com.netbuilder.entities;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.HashMap;
//
///**
// * @date 08/10/2015
// * @author tstacey
// *
// */
//public class DummyData {
//
////	// Base entities (no other entities within them)
////	private ArrayList<CustomerOrderStatus> custOrderStatuses = new ArrayList<CustomerOrderStatus>();
////	private ArrayList<PurchaseOrderStatus> purchaseOrderStatuses = new ArrayList<PurchaseOrderStatus>();
////	private ArrayList<User> users = new ArrayList<User>();
////	private ArrayList<Role> roles = new ArrayList<Role>();
////
////	private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
////	private ArrayList<Item> items = new ArrayList<Item>();
////	private ArrayList<Employee> employees = new ArrayList<Employee>();
////	private ArrayList<Customer> customers = new ArrayList<Customer>();
////	private ArrayList<Address> addresses = new ArrayList<Address>();
////	private ArrayList<CustomerOrder> custOrders = new ArrayList<CustomerOrder>();
////	private ArrayList<CustomerOrderLine> custOrderLines = new ArrayList<CustomerOrderLine>();
////	private ArrayList<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
////	private ArrayList<PurchaseOrderLine> purchaseOrderLines = new ArrayList<PurchaseOrderLine>();
////	private ArrayList<WishList> wishLists = new ArrayList<WishList>();
////	
////
////	private SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
////
////	public DummyData() {
////		initialSetup();
////	}
////
////
////	private void initialSetup() {
////
////		setUpBaseEntities();
////
////		addCustomers();
////		addAddresses();
////		addSuppliers();
////		addItems();
////		addEmployees();
////		addCustomerOrders();
////		addCustomerOrderLines();
////		addPurchaseOrders();
////		addPurchaseOrderLines();
////		addWishLists();
////	}
////
////
////	private void setUpBaseEntities() {
////
////		addCustomerOrderStatuses();
////		addPurchaseOrderStatuses();
////		addRoles();
////		addUsers();
////
////
////	}
////
////	private Date makeDate(String dateString) {
////		try {
////			Date d = dFormat.parse(dateString);
////			return d;
////		} catch (ParseException e) {
////			throw new Error(e);
////		}
////	}
////
////
////
////	private void addCustomerOrderStatuses() {
////		custOrderStatuses.add(new CustomerOrderStatus("Placed"));
////		custOrderStatuses.add(new CustomerOrderStatus("Claimed"));
////		custOrderStatuses.add(new CustomerOrderStatus("Picked"));
////		custOrderStatuses.add(new CustomerOrderStatus("Packed"));
////		custOrderStatuses.add(new CustomerOrderStatus("Awaiting Dispatch"));
////		custOrderStatuses.add(new CustomerOrderStatus("Out for Delivery"));
////		custOrderStatuses.add(new CustomerOrderStatus("Cancelled"));
////	}
////
////	private void addPurchaseOrderStatuses() {
////		purchaseOrderStatuses.add(new PurchaseOrderStatus("Created"));
////		purchaseOrderStatuses.add(new PurchaseOrderStatus("Sent to Supplier"));
////		purchaseOrderStatuses.add(new PurchaseOrderStatus("Received"));
////		purchaseOrderStatuses.add(new PurchaseOrderStatus("Stored"));
////		purchaseOrderStatuses.add(new PurchaseOrderStatus("Cancelled"));
////	}
////
////	private void addRoles() {
////		roles.add(new Role("COFT Operative"));
////		roles.add(new Role("COFT Manager"));
////		roles.add(new Role("Warehouse Operative"));
////		roles.add(new Role("Inventory Manager"));
////		roles.add(new Role("Sales Operative"));
////		roles.add(new Role("Sales Manager"));
////	}
////
////	private void addUsers() {
////		users.add(new User("password","Al","Stock","Al.Stock@NBGardens.com", true));
////		users.add(new User("password","Georgina","Posslethwaite","Georgina.Posslethwaite@NBGardens.com", true));
////		users.add(new User("password","Fred","Crumbuchet","Fred.Crumbuchet@NBGardens.com", true));
////		users.add(new User("password","Jude","Law","JudeyBoy@hotmail.com", false));
////		users.add(new User("password","Jeremy","Cornstaller","JCStallz@gmail.com", false));
////		users.add(new User("password","Hannah","Applebaggsby","HannahTheSpanner@hotmail.com", false));
////		users.add(new User("password","India","Violet-Gumtree","IndiaVGums@hotmail.com", false));
////	}
////
////	private void addCustomers() {
////
////		Date dob = makeDate("11-01-1990");
////		customers.add(new Customer(users.get(4), 5000, "07958046028", dob));
////
////		dob = makeDate("15-06-1965");
////		customers.add(new Customer(users.get(3), 5000, "01612248935", dob));
////
////		dob = makeDate("24-04-1989");
////		customers.add(new Customer(users.get(6), 5000, "01527498653", dob));
////
////	}
////
////
////
////	private void addAddresses() {
////		// add customer addresses
////		addresses.add(new Address(customers.get(0), new ArrayList<String>(Arrays.asList("NETbuilder LTD", "5th Floor, Anchorage 1")), "Manchester", "Lancs", "M50 3YJ"));
////		addresses.add(new Address(customers.get(2), new ArrayList<String>(Arrays.asList("16 Maple View", "Lovelyside")), "Upper Slaughter", "Gloucestershire", "GL54 2JB"));
////
////		// add supplier addresses
////		addresses.add(new Address(new ArrayList<String>(Arrays.asList("Garden Bulk Supplies LTD", "Unit 4, Rose Trading Estate")), "Weston Super-Mare", "North Somerset", "BS23 1TT"));
////		addresses.add(new Address(new ArrayList<String>(Arrays.asList("Happening Gardens", "Telford Trading Estate")), "Telford", "Shropshire", "TF7 1QG"));
////	}
////
////	private void addSuppliers() {
////		Supplier s = new Supplier("Garden Bulk Supplies LTD", addresses.get(2));
////		s.setTelephone("01447308593");
////		s.setEmail("bulk_info@BulkSupplies.com");
////		suppliers.add(s);
////
////		Supplier s2 = new Supplier("Happening Gardens", addresses.get(3));
////		s2.setTelephone("01214459381");
////		s2.setEmail("contact_us@HappeningGardens.com");
////		suppliers.add(s2);
////	}
////
////	private void addItems() {
////		HashMap<String, String> attributes = new HashMap<String, String>();
////		attributes.put("Hat Colour", "Red");
////		attributes.put("Height", "28cm");
////		attributes.put("Width", "7cm");
////		attributes.put("Depth", "7cm");
////		attributes.put("Accessory", "Fishing Rod");
////		String desc = "It's a red gnome";
////		items.add(new Item("Red Gnome", desc, (float)12.99, 100, "Red_Gnome.png", false, 5, 6, false, suppliers.get(0), attributes));
////		
////		attributes = new HashMap<String, String>();
////		attributes.put("Hat Colour", "Blue");
////		attributes.put("Height", "28cm");
////		attributes.put("Width", "7cm");
////		attributes.put("Depth", "7cm");
////		attributes.put("Accessory", "Mushroom");
////		desc = "It's a blue gnome";
////		items.add(new Item("Blue Gnome", desc, (float)12.99, 500, "Blue_Gnome.png", false, 10, 6, false, suppliers.get(0), attributes));
////
////		attributes = new HashMap<String, String>();
////		attributes.put("Hat Colour", "Green");
////		attributes.put("Height", "28cm");
////		attributes.put("Width", "7cm");
////		attributes.put("Depth", "7cm");
////		attributes.put("Accessory", "Sacrificial Dagger of Akroth");
////		desc = "Fear him for he is the eater of souls";
////		items.add(new Item("Green Gnome", desc, (float)12.99, 30, "Green_Gnome.png", false, 4, 7, false, suppliers.get(0), attributes));
////		
////		attributes = new HashMap<String, String>();
////		attributes.put("Dial Stone", "Marble");
////		attributes.put("Height", "1.3m");
////		attributes.put("Width", "0.5m");
////		attributes.put("Depth", "0.5m");
////		desc = "Tell the time but only when it's sunny and you're outside";
////		items.add(new Item("Sundial", desc, (float)45.00, 95, "Sundial.png", false, 25, 10, false, suppliers.get(1), attributes));
////		
////		attributes = new HashMap<String, String>();
////		attributes.put("Colour", "White");
////		attributes.put("Height", "1.3m");
////		attributes.put("Width", "2.5m");
////		attributes.put("Depth", "2.5m");
////		attributes.put("Number of people", "4");
////		desc = "Useful for when you want a jacuzzi";
////		items.add(new Item("Jacuzzi", desc, (float)399.95, 20, "Jacuzzi.png", false, 2, 2, false, suppliers.get(1), attributes));
////		
////		attributes = new HashMap<String, String>();
////		attributes.put("Colour", "White");
////		attributes.put("Height", "1.9m");
////		attributes.put("Width", "0.5m");
////		attributes.put("Depth", "0.5m");
////		attributes.put("Material", "Granite");
////		desc = "Imitation Venus de Milo with sculpted base and intricate detail seems like an exact replica of the original";
////		items.add(new Item("Statue", desc, (float)75.50, 110, "Statue.png", false, 10, 12, false, suppliers.get(1), attributes));
////	}
////
////	private void addEmployees() {
////		employees.add(new Employee(users.get(0), roles.get(3)));
////		employees.add(new Employee(users.get(1), roles.get(2)));
////		employees.add(new Employee(users.get(2), roles.get(4)));
////	}
////
////
////
////	private void addCustomerOrders() {
////		Date datePlaced = makeDate("01-10-2015");
////		custOrders.add(new CustomerOrder(datePlaced, customers.get(1), custOrderStatuses.get(0), employees.get(2), false, addresses.get(0)));
////		datePlaced = makeDate("05-10-2015");
////		custOrders.add(new CustomerOrder(datePlaced, customers.get(0), custOrderStatuses.get(1), employees.get(1), false, addresses.get(1)));
////
////	}
////
////	private void addCustomerOrderLines() {
////		custOrderLines.add(new CustomerOrderLine(5, items.get(0), custOrders.get(0)));
////		custOrderLines.add(new CustomerOrderLine(1, items.get(2), custOrders.get(0)));
////		custOrderLines.add(new CustomerOrderLine(5, items.get(1), custOrders.get(0)));
////		custOrderLines.add(new CustomerOrderLine(3, items.get(5), custOrders.get(0)));
////		custOrderLines.add(new CustomerOrderLine(1, items.get(4), custOrders.get(0)));
////
////		custOrderLines.add(new CustomerOrderLine(1, items.get(3), custOrders.get(1)));
////		custOrderLines.add(new CustomerOrderLine(10, items.get(1), custOrders.get(1)));
////		custOrderLines.add(new CustomerOrderLine(3, items.get(2), custOrders.get(1)));
////		custOrderLines.add(new CustomerOrderLine(1, items.get(5), custOrders.get(1)));
////
////	}
////
////	private void addPurchaseOrders() {
////		Date d = makeDate("28-09-2015");
////		purchaseOrders.add(new PurchaseOrder(d, employees.get(0), purchaseOrderStatuses.get(1), suppliers.get(0)));
////
////		d = makeDate("08-10-2015");
////		purchaseOrders.add(new PurchaseOrder(d, employees.get(0), purchaseOrderStatuses.get(0), suppliers.get(1)));
////	}
////
////	private void addPurchaseOrderLines() {
////		purchaseOrderLines.add(new PurchaseOrderLine(200, items.get(0), purchaseOrders.get(0)));
////		purchaseOrderLines.add(new PurchaseOrderLine(250, items.get(1), purchaseOrders.get(0)));
////		purchaseOrderLines.add(new PurchaseOrderLine(180, items.get(2), purchaseOrders.get(0)));
////
////
////		purchaseOrderLines.add(new PurchaseOrderLine(50, items.get(3), purchaseOrders.get(1)));
////		purchaseOrderLines.add(new PurchaseOrderLine(15, items.get(4), purchaseOrders.get(1)));
////		purchaseOrderLines.add(new PurchaseOrderLine(100, items.get(5), purchaseOrders.get(1)));
////
////	}
////
////	private void addWishLists() {
////		ArrayList<Item> listItems = new ArrayList<Item>(Arrays.asList(items.get(0), items.get(1), items.get(4)));
////		wishLists.add(new WishList(customers.get(0), listItems));
////
////		wishLists.add(new WishList(customers.get(1)));
////
////
////		listItems = new ArrayList<Item>(Arrays.asList(items.get(2), items.get(4), items.get(5)));
////		wishLists.add(new WishList(customers.get(2), listItems));
////
////
////	}
//
//}
