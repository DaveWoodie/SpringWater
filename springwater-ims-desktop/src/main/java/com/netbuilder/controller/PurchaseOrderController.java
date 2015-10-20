package com.netbuilder.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.netbuilder.app.IndividualPurchaseOrderViewFrame;
import com.netbuilder.entities.Item;
import com.netbuilder.entities.PurchaseOrder;
import com.netbuilder.entityrepository.PurchaseOrderRepository;


public class PurchaseOrderController {
	
	private PurchaseOrder purchaseOrder;
	@Autowired
	PurchaseOrderRepository purchaseItemRepository;
	ArrayList<PurchaseOrder> purchaseOrderList;
	
//	public PurchaseOrder getPurchaseOrder(int id) {
//		purchaseOrder = purchaseItemRepository.findbyPurchaseOrderID(id);
//		return purchaseOrder;
//	}
//	
//	public ArrayList<PurchaseOrder> getPurchaseOrderList() {
//		purchaseOrderList = (ArrayList<PurchaseOrder>) purchaseItemRepository.findAll();
//		return purchaseOrderList;
//	}
	
	
}
