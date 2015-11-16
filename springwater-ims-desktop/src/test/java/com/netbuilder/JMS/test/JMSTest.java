package com.netbuilder.JMS.test;

import java.util.ArrayList;

import loaders.PurchaseOrderLoader;
import connections.MongoPull;
import entities.Item;
import entities.MessageContent;
import entities.PurchaseOrder;

import com.netbuilder.JMS.Sender;
import com.netbuilder.logic.PurchaseOrderLogic;

public class JMSTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PurchaseOrderLoader pOLoader = new PurchaseOrderLoader();
		ArrayList<PurchaseOrder> pOLList = new ArrayList<PurchaseOrder>();
		pOLList = pOLoader.getPurchaseOrderByID(2);
		PurchaseOrder pO = pOLList.get(0);
		ArrayList<Object> toSend = new ArrayList<Object>();
		toSend.add(pO);
		toSend.add(2);
		Sender sender = new Sender();
		MessageContent messageContent = new MessageContent(toSend, "receivePurchaseOrder");
		sender.sendMessage(messageContent);
		
//		MongoPull mP = new MongoPull();
//		Item item = mP.getItem(1);
//		PurchaseOrderLogic purchaseOrderLogic = new PurchaseOrderLogic();
//		purchaseOrderLogic.addItemToPurchaseOrder(item, 5);
	}
}
