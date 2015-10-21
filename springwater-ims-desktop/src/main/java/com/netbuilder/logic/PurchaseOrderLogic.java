package com.netbuilder.logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.netbuilder.apploader.PurchaseOrderLoader;
import com.netbuilder.entities.PurchaseOrder;

public class PurchaseOrderLogic {
	
	Object [][] purchaseOrderList;
	PurchaseOrderLoader pOLoader;
	DateFormat df = new SimpleDateFormat("dd/MM/yy");
	
	public Object [][] fetchPurchaseOrders() {
		ArrayList<PurchaseOrder> pOList = new ArrayList<PurchaseOrder>(pOLoader.getPurchaseOrderList());
		float total = 3160;
		//TODO connect to OrderLineLoader and ItemLoader to calculate price
		purchaseOrderList = new Object [pOList.size()][4];
		for (int i = 0; i < pOList.size(); i++) {
			purchaseOrderList[i][0] = pOList.get(i).getIDPurchaseOrder();
			purchaseOrderList[i][1] = df.format(pOList.get(i).getDatePlaced()); 
			purchaseOrderList[i][2] = pOList.get(i).getPurchaseOrderStatus().getPurchOrderStatus(); 
			purchaseOrderList[i][3] = pOList.get(i).getSupplier().getSupplierName();
			purchaseOrderList[i][4] = "£" + total;
		}
		return null;
	}
}
