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
				pOL.setDamagedQuantity(rs.getInt("quantityDamaged"));
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
	 * Method to construct the SQL query to retrieve all purchase order IDs by item ID
	 * @param id of the Item to search for
	 * @return the ArrayList of purchase orderline IDs created from the query
	 */
	public ArrayList<Integer> getPurchaseOrderLineByProduct(int id) {
		sql = "SELECT idPurchaseOrder" + tableName + " WHERE idItem = " + id;
		ArrayList<Integer> purchaseOrderIDs = new ArrayList<Integer>();
		try{
			sqlDB.openCon();
			ResultSet rs = sqlDB.queryDB(sql);
			while (rs.next()) {
				int i = rs.getInt("idPurchaseOrder");
				purchaseOrderIDs.add(i);
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return purchaseOrderIDs;
	}
	
	/**
	 * Method to construct the sql query to update a purchase order line entry in the database and execute it
	 * @param pOL the purchase order line object to be updated
	 */
	public void setPurchaseOrderLineDamagedStock(PurchaseOrderLine pOL){
		sql = "UPDATE purchaseorderline SET quantityDamaged = " + pOL.getDamagedQuantity() + ", quantity = " + pOL.getQuantity() + "WHERE idItem = " + pOL.getItemID() + " AND idPurchaseOrder = " + pOL.getPurchaseOrder().getIDPurchaseOrder();
		sqlDB.openCon();
		try {
			sqlDB.updateDB(sql);
		} 
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		sqlDB.closeCon();
	}
	
	/**
	 * Method to construct the sql query to create a purchase order line entry in the database and execute it
	 * @param pOL
	 */
	public void createPurchaseOrderLine (PurchaseOrderLine pOL) {
		sql = "INSERT INTO purchaseorderline (idPurchaseOrder, idItem, quantity, quantityDamaged) VALUE (" + pOL.getPurchaseOrder().getIDPurchaseOrder() + ", " + pOL.getItemID() + ", " + pOL.getQuantity() + ", " +pOL.getDamagedQuantity() + ")";
		sqlDB.openCon();
		try {
			sqlDB.updateDB(sql);
		} 
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		sqlDB.closeCon();
	}
}


