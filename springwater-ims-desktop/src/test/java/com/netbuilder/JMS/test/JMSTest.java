package com.netbuilder.JMS.test;

import com.netbuilder.connections.MongoPull;
import com.netbuilder.entities.Item;
import com.netbuilder.logic.PurchaseOrderLogic;

public class JMSTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PurchaseOrderLogic pOLogic = new PurchaseOrderLogic();
		MongoPull mPull = new MongoPull();
		Item item = mPull.getItem(1);
		pOLogic.addItemToPurchaseOrder(item, 5);
	}
}
