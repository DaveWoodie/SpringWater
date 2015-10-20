package com.netbuilder.apploader;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.netbuilder.entities.PurchaseOrder;
import com.netbuilder.entities.PurchaseOrderStatus;

public class PurchaseOrderLoader {
	
	final String tableName = " FROM purchaseorder";
	final String listQuery = "SELECT purchaseorder.*, purchaseorderstatus.*, supplier.*, employee.*, user.*";
	final String tableJoins = " LEFT JOIN purchaseorderstatus ON purchaseorder.idPurchaseOrderStatus = purchaseorderstatus.idPurchaseOrderStatus LEFT JOIN supplier ON purchaseorder.idSupplier = supplier.idSupplier LEFT JOIN employee ON purchaseorder.idUser = employee.idEmployee LEFT JOIN user ON purchaseorder.idUser = user.idUser";
	private String sql;
	private SQLDBConnector sqlDB;
	
	public ArrayList<PurchaseOrder> getPurchaseOrderList() {
		sql = listQuery + tableName + tableJoins;
		ResultSet rs = sqlDB.queryDB(sql);
		while (rs.next()) {
			PurchaseOrderStatus pOS = new PurchaseOrderStatus(rs.getInt("purchaseorderstatus.idPurchaseOrderStatus"), rs.getString("purchaseorderstatus.status"));
		}		
	}
	
	public ArrayList<PurchaseOrder> getPurchaseOrderListByStatus(String status) {
		sql = listQuery + tableName + tableJoins + " WHERE status = '" + status +"'";
		return null;
	}
	
}

