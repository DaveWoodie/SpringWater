package com.netbuilder.app;

import java.util.ArrayList;

public class LoadData {
	
	Object[][] inventoryList;
	
	public Object[][] fetchPurchaseOrders() {
		
		Object[][] purchaseOrderList = {{1, "10/05/2015", "COMPLETED", "GnomeBuilder", "£3160"},
								{2, "17/05/2015", "DELIVERED", "GnomeBuilder", "£3160"},
								{3, "17/05/2015", "AVAILABLE", "GA Inc", "£3160"},
								{4, "17/05/2015", "AVAILABLE", "Garden World", "£3160"},
								{5, "24/05/2015", "AVAILABLE", "GnomeBuilder", "£3160"},
								{6, "24/05/2015", "AVAILABLE", "Lawn Society Suppliers", "£3160"}};
		
		return purchaseOrderList;
		
	}
	
	public ArrayList<Object[]> fetchPurchaseOrderList()
	{
		ArrayList<Object[]> purchaseOrderList = new ArrayList<Object[]>();
		
		for(int i = 1; i < fetchPurchaseOrders().length; i++)
		{
			purchaseOrderList.add((Object[]) fetchPurchaseOrders()[i]);
		}
				
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
	
	public Object[][] fetchStockList() {
		
		Object[][] stockItemList = {{1, "Regular Gnome", 10, 40},
									{2, "Mushroom Gnome", 50, 20},
									{3, "Lamp Gnome", 80, 150},
									{4, "Wheelbarrow Gnome", 75, 40},
									{5, "No Evil Gnomes", 50, 80},
									{6, "Creepy Gnome", 40, 10},
									{7, "Large Hoe", 4, 25},
									{8, "Long Hoe", 25, 10},
									{9, "Light Jacuzzi", 15, 5},
									{10, "Darkwood Jacuzzi", 1, 20},
									{11, "Blue Step Jacuzzi", 20, 25},
									{12, "Round Jacuzzi", 0, 5},
									{13, "Plain Pot", 20, 90},
									{14, "Patterned Pot", 50, 30},
									{15, "Orange Pot", 60, 45}};
	
		return stockItemList;
		
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
		
		Object[][] inventoryList = {{1, "Regular Gnome", 10, "1A", "gnome.jpg", "£10"},
									{2, "Mushroom Gnome", 50, "4B", "gnome02.jpg", "£14" },
									{3, "Lamp Gnome", 80, "7D", "gnome03.jpg", "£15"},
									{4, "Wheelbarrow Gnome", 75, "4A", "gnome04.jpg", "£20"},
									{5, "No Evil Gnomes", 50, "9A", "gnome05.jpg", "£50"},
									{6, "Creepy Gnome", 40, "1F", "gnome06.jpg", "£5"},
									{7, "Large Hoe", 4, "5A", "hoe01.jpg", "£25"},
									{8, "Long Hoe", 25, "5B", "hoe2.jpg", "£30"},
									{9, "Light Jacuzzi", 15, "6A", "jacuzzi01.png", "£200"},
									{10, "Darkwood Jacuzzi", 1, "6B", "jacuzzi02.jpg", "£300"},
									{11, "Blue Step Jacuzzi", 20, "6C", "jacuzzi03.jpg", "£500"},
									{12, "Round Jacuzzi", 0, "6D", "jacuzzi04.png", "£1000"},
									{13, "Plain Pot", 20, "8C", "pot01.jpg", "£2"},
									{14, "Patterned Pot", 50, "9D", "pot02.jpg", "£5"},
									{15, "Orange Pot", 60, "3C", "pot03.jpg", "£3"}};
		
		return inventoryList;
	}
	
	public Object[][] fetchIndividualPurchaseOrder() {
		
		Object[][] purchaseOrderLine = {{1, "Regular Gnome", 50, 0, "£200"},
										{2, "Mushroom Gnome", 250, 0, "£2000"},
										{3, "Lamp Gnome", 120, 10, "£960"}};
		
		return purchaseOrderLine;
	}
	
	public Object[][] fetchSupplierProducts() {
		
		Object[][] supplierProductList = {{1, "Regular Gnome"},
							{2, "Mushroom Gnome"},
							{3, "Lamp Gnome"}};
		
		return supplierProductList;
	}
	
	public Object[] fetchSupplierDetails() {
		
		Object [] supplierDetails = {59, "NB Road", "", "Gnome City", "Gnomes", "GN0 M3S", "placeholder.png", 3};
		
		return supplierDetails;
	}
}
