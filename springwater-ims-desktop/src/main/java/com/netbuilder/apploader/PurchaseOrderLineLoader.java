/**
 * @author jforster
 * @date 21/10/15
 */
package com.netbuilder.apploader;

import java.sql.ResultSet;
import java.sql.SQLException;
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
	PurchaseOrder purchaseOrder;
	
	public void constructResult() {
		purchaseOrderItemList.clear();
		try {
			ResultSet rs = sqlDB.queryDB(sql);
			while (rs.next()) {
				PurchaseOrderLine pOL = new PurchaseOrderLine(rs.getInt("idQuantity"), rs.getInt("idItem"), purchaseOrder);
				purchaseOrderItemList.add(pOL);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<PurchaseOrderLine> getPurchaseOrderLineByOrderID(PurchaseOrder pO) {
		sql = listQuery + tableName + " WHERE idPurchaseOrder = " + pO.getIDPurchaseOrder();
		purchaseOrder = pO;
		constructResult();
		return purchaseOrderItemList;
	}
	
	public ArrayList<PurchaseOrderLine> getPurchaseOrderLineByProduct(Item item) {
		sql = listQuery + tableName + " WHERE idItem = " + item.getIdItem();
		constructResult();
		return purchaseOrderItemList;
	}
}


