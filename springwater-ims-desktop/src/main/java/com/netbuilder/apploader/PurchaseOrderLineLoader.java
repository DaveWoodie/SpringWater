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
	private SQLDBConnector sqlDB = new SQLDBConnector();
	ArrayList<PurchaseOrderLine> purchaseOrderItemList = new ArrayList<PurchaseOrderLine>();
	ArrayList<Item> itemList;
	PurchaseOrder purchaseOrder;
	
	/**
	 * Method to executed constructed sql query and load data into objects
	 */
	private void constructResult() {
		 purchaseOrderItemList.clear();
		try {
			sqlDB.openCon();
			ResultSet rs = sqlDB.queryDB(sql);
			while (rs.next()) {
				PurchaseOrderLine pOL = new PurchaseOrderLine(rs.getInt("Quantity"), rs.getInt("idItem"), purchaseOrder);
				purchaseOrderItemList.add(pOL);
			}
			rs.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlDB.closeCon();
		}
	}
	
	/**
	 * Method to construct the SQL query to retrieve all purchase order lines by order ID 
	 * @param id of the Purchase Order to search for
	 * @return the ArrayList of purchase orderlines created from the query
	 */
	public ArrayList<PurchaseOrderLine> getPurchaseOrderLineByOrderID(int id) {
		sql = listQuery + tableName + " WHERE idPurchaseOrder = " + id;
		PurchaseOrderLoader pOL = new PurchaseOrderLoader();
		ArrayList<PurchaseOrder> pOList = pOL.getPurchaseOrderByID(id);
		if (!pOList.isEmpty()) {
			purchaseOrder = pOList.get(0);
			constructResult();
			return purchaseOrderItemList;
		}
		return null;
		
	}
	
	/**
	 * Method to construct the SQL query to retrieve all purchase order lines by item ID
	 * @param id of the Item to search for
	 * @return the ArrayList of purchase orderlines created from the query
	 */
	public ArrayList<PurchaseOrderLine> getPurchaseOrderLineByProduct(int id) {
		sql = listQuery + tableName + " WHERE idItem = " + id;
		//TODO pull item from mongoDB
		constructResult();
		return purchaseOrderItemList;
	}
}


