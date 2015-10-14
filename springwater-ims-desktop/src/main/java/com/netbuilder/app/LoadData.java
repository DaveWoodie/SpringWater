package com.netbuilder.app;

import java.util.ArrayList;

public class LoadData {
	
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
	
}
