package com.netbuilder.apploader;

import java.util.ArrayList;

import com.netbuilder.entities.PurchaseOrder;

public class PurchaseOrderLoader {
	
	final String tableName = " FROM purchaseorder";
	final String listQuery = "SELECT purchaseorder.*, purchaseorderstatus.*, supplier.*, employee.*, user.*";
	final String tableJoins = " LEFT JOIN purchaseorderstatus ON purchaseorder.idPurchaseOrderStatus = purchaseorderstatus.idPurchaseOrderStatus LEFT JOIN supplier ON purchaseorder.idSupplier = supplier.idSupplier LEFT JOIN employee ON purchaseorder.idUser = employee.idEmployee LEFT JOIN user ON purchaseorder.idUser = user.idUser";
	private String sql;
	
	public ArrayList<PurchaseOrder> getPurchaseOrderList() {
		sql = listQuery + tableName + tableJoins;
		return null;
	}
	
	public ArrayList<PurchaseOrder> getPurchaseOrderListByStatus(String status) {
		sql = listQuery + tableName + tableJoins + " WHERE status = '" + status +"'";
		return null;
	}
	
}

