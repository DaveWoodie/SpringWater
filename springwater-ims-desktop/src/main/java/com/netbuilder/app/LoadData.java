package com.netbuilder.app;

import java.util.ArrayList;

public class LoadData {
	
	public Object[][] fetchPurchaseOrders() {
		
		String[][] purchaseOrderList = {{"1", "10/05/2015", "COMPLETED", "GnomeBuilder"},
								{"2", "17/05/2015", "DELIVERED", "GnomeBuilder"},
								{"3", "17/05/2015", "AVAILABLE", "GA Inc"},
								{"4", "17/05/2015", "AVAILABLE", "Garden World"},
								{"5", "24/05/2015", "AVAILABLE", "GnomeBuilder"},
								{"6", "24/05/2015", "AVAILABLE", "Lawn Society Suppliers"}};
		
		return purchaseOrderList;
		
	}
}
