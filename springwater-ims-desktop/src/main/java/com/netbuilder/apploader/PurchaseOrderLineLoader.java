/**
 * @author jforster
 * @date 21/10/15
 */
package com.netbuilder.apploader;

import java.sql.ResultSet;
import java.util.ArrayList;





import com.netbuilder.DBConnector.SQLDBConnector;
import com.netbuilder.entities.Item;
import com.netbuilder.entities.PurchaseOrder;
import com.netbuilder.entities.PurchaseOrderLine;

/**
 * Class to construct database queries and load data into entities for the java app
 * @author jforster
 *
 */
public class PurchaseOrderLineLoader {

	final String tableName = " FROM purchaseorderline";
	final String listQuery = "SELECT *";
	private String sql;
	private SQLDBConnector sqlDB;
	ArrayList<PurchaseOrderLine> purchaseOrderItemList;
	ArrayList<Item> itemList;
	
	public void constructResult(PurchaseOrder pO) {
		purchaseOrderItemList.clear();
		ResultSet rs = sqlDB.queryDB(sql);
		while (rs.next()) {
			PurchaseOrderLine pOL = new PurchaseOrderLine(rs.getInt("idQuantity", rs.getInt("idItem"), pO));
			purchaseOrderItemList.add(pOL);
		}
	}
	public ArrayList<PurchaseOrderLine> getPurchaseOrderLineByOrderID(PurchaseOrder pO) {
		sql = listQuery + tableName + "WHERE idPurchaseOrder = " + pO.getIDPurchaseOrder();
		constructResult(pO);
		return purchaseOrderItemList;
	}
}


