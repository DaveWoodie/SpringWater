/**
 * @author jforster
 * @date 30/10/2015
 */
package com.netbuilder.logic;

import java.util.ArrayList;

import connections.MongoPull;
import connections.MongoPush;
import loaders.CustomerOrderLineLoader;
import entities.CustomerOrder;
import entities.CustomerOrderLine;
import entities.Item;

/**
 * Class to handle business logic for handling customer orders
 * @author jforster
 *
 */
public class CustomerOrderBackendLogic {
	
	/**
	 * Method to update stock levels when a customer order arrives and modify purchase orders to take into account new stock
	 * @param cO customer order that has arrived
	 */
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
