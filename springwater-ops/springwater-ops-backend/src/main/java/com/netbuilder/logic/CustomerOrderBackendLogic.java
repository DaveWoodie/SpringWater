package com.netbuilder.logic;

import java.util.ArrayList;

import connections.MongoPull;
import connections.MongoPush;
import loaders.CustomerOrderLineLoader;
import entities.CustomerOrder;
import entities.CustomerOrderLine;
import entities.Item;

public class CustomerOrderBackendLogic {
	
	public void customerOrderPlaced(CustomerOrder cO) {
		CustomerOrderLineLoader cOLLoader = new CustomerOrderLineLoader();
		MongoPull mPull = new MongoPull();
		MongoPush mPush = new MongoPush();
		ArrayList<CustomerOrderLine> cOLList = new ArrayList<CustomerOrderLine>();
		Item item = null;
		cOLList = cOLLoader.getCustomerOrderLineByOrderID(cO.getCustomerOrderID());
		for (int i = 0; i < cOLList.size(); i++) {
			item = mPull.getItem(cOLList.get(i).getItemID());
			item.setStock(item.getStock() - cOLList.get(i).getQuantity());
			mPush.updateItem(item);
			//Once order is placed update purchase orders
			PurchaseOrderBackendLogic pOBL = new PurchaseOrderBackendLogic();
			pOBL.calculateOrderQuantity(item);
		}
		
	}
}
