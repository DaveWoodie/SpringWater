package com.netbuilder.app;

import java.util.ArrayList;

public class LoadData {
	
	Object[][] inventoryList;
	
	public Object[][] fetchPurchaseOrders() {
		
		Object[][] purchaseOrderList = {{1, "10/05/2015", "COMPLETED", "GnomeBuilder"},
								{2, "17/05/2015", "DELIVERED", "GnomeBuilder"},
								{3, "17/05/2015", "AVAILABLE", "GA Inc"},
								{4, "17/05/2015", "AVAILABLE", "Garden World"},
								{5, "24/05/2015", "AVAILABLE", "GnomeBuilder"},
								{6, "24/05/2015", "AVAILABLE", "Lawn Society Suppliers"}};
		
		return purchaseOrderList;
		
	}
	
	public Object[][] fetchSuppliers() {
		
		Object[][] supplierList = {{1, "GnomeBuilder"},
								{2, "GA Inc"},
								{3, "Garden World"},
								{4, "Lawn Society Suppliers"},
								{5, "Superior Gnomes Ltd"},
								{6, "Gnomes R' Us"}};
		
		return supplierList;
		
	}
	
	public Object[][] fetchLowStockList() {
		
		Object[][] lowStockItemList = {{1, "Regular Gnome", 10, 40},
									{7, "Large Hoe", 4, 25},
									{10, "Darkwood Jacuzzi", 1, 20},
									{12, "Round Jacuzzi", 0, 5},
									{13, "Plain Pot", 20, 90}};
	
		return lowStockItemList;
		
	}
	
	public Object[][] fetchHighSaleList() {
	
		Object[][] highSalesItemList = {{2, "Mushroom Gnome", 50, 200},
										{3, "Lamp Gnome", 80, 150},
										{5, "No Evil Gnomes", 50, 80},
										{11, "Blue Step Jacuzzi", 20, 25},
										{13, "Plain Pot", 20, 90}};
		
		return highSalesItemList;
	}
	
	public Object[][] fetchInventoryList() {
		
		Object[][] inventoryList = {{1, "Regular Gnome", 10, "1A", "gnome.jpg"},
									{2, "Mushroom Gnome", 50, "4B", "gnome02.jpg"},
									{3, "Lamp Gnome", 80, "7D", "gnome03.jpg"},
									{4, "Wheelbarrow Gnome", 75, "4A", "gnome04.jpg"},
									{5, "No Evil Gnomes", 50, "9A", "gnome05.jpg"},
									{6, "Creepy Gnome", 40, "1F", "gnome06.jpg"},
									{7, "Large Hoe", 4, "5A", "hoe01.jpg"},
									{8, "Long Hoe", 25, "5B", "hoe2.jpg"},
									{9, "Light Jacuzzi", 15, "6A", "jacuzzi01.png"},
									{10, "Darkwood Jacuzzi", 1, "6B", "jacuzzi02.jpg"},
									{11, "Blue Step Jacuzzi", 20, "6C", "jacuzzi03.jpg"},
									{12, "Round Jacuzzi", 0, "6D", "jacuzzi04.png"},
									{13, "Plain Pot", 20, "8C", "pot01.jpg"},
									{14, "Patterned Pot", 50, "9D", "pot02.jpg"},
									{15, "Orange Pot", 60, "3C", "pot03.jpg"}};
		
		return inventoryList;
	}
	
}
