/**
 * @author jforster
 * @date 20/10/2015
 */
package com.netbuilder.apploader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.netbuilder.DBConnector.SQLDBConnector;
import com.netbuilder.entities.Employee;
import com.netbuilder.entities.PurchaseOrder;
import com.netbuilder.entities.PurchaseOrderStatus;
import com.netbuilder.entities.Role;
import com.netbuilder.entities.Supplier;
import com.netbuilder.entities.User;

/**
 * Class to construct database queries and load data into entities for the java app
 * @author jforster
 *
 */
public class PurchaseOrderLoader {
	
	final String tableName = " FROM purchaseorder";
	final String listQuery = "SELECT purchaseorder.*, purchaseorderstatus.*, supplier.*, employee.*, user.*";
	final String tableJoins = " LEFT JOIN purchaseorderstatus ON purchaseorder.idPurchaseOrderStatus = purchaseorderstatus.idPurchaseOrderStatus LEFT JOIN supplier ON purchaseorder.idSupplier = supplier.idSupplier LEFT JOIN employee ON purchaseorder.idUser = employee.idEmployee LEFT JOIN user ON purchaseorder.idUser = user.idUser";
	private String sql;
	private SQLDBConnector sqlDB;
	ArrayList<PurchaseOrder> purchaseOrderList;
	
	/**
	 * Method to execute constructed query and load data into objects
	 */
	public void constructResult() {
		purchaseOrderList.clear();
		try {
			ResultSet rs = sqlDB.queryDB(sql);
			while (rs.next()) {
				PurchaseOrderStatus pOS = new PurchaseOrderStatus(rs.getString("purchaseorderstatus.status"));
				
				Supplier supplier = new Supplier(rs.getString("supplier.supplierName"), rs.getInt("supplier.idAddress"));
				Role role = new Role(rs.getString("role.roleName"));
				User user = new User(rs.getString("user.password"), rs.getString("user.forename"), rs.getString("user.surname"), rs.getString("user.email"), rs.getBoolean("user.isEmployee"));
				user.setUserID(rs.getInt("user.idUser"));
				Employee employee = new Employee(user, role);
				PurchaseOrder pO = new PurchaseOrder(rs.getDate("purchaseorder.datePlaced"), employee, pOS, supplier);
				pO.setIDPurchaseOrder(rs.getInt("purchaseorder.idPurchaseOrder"));
				pO.setDateExpected(rs.getDate("purchaseorder.dateExpected"));
				purchaseOrderList.add(pO);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();		
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {}
	}
	
	/**
	 * Method to construct the sql query to retrieve all purchase orders
	 * @return the ArrayList of purchase orders created from the query
	 */
	public ArrayList<PurchaseOrder> getPurchaseOrderList() {
		sql = listQuery + tableName + tableJoins;
		constructResult();
		return purchaseOrderList;
	}
	
	/**
	 * Method to construct the sql query to retrieve all purchase orders with a given ID (should be one)
	 * @param i Integer of the ID to search for
	 * @return the ArrayList containing the single purchase order expected from the query
	 */
	public ArrayList<PurchaseOrder> getPurchaseOrderByID(int i) {
		sql = listQuery + tableName + tableJoins + " WHERE idPurchaseOrder = " + i;
		constructResult();
		return purchaseOrderList;
	}
	
	/**
	 * Method to construct the sql query to retrieve all purchase orders with a given status
	 * @param status String to search for
	 * @return the ArrayList of purchase orders created from the query
	 */
	public ArrayList<PurchaseOrder> getPurchaseOrderListByStatus(String status) {
		sql = listQuery + tableName + tableJoins + " WHERE status = '" + status +"'";
		constructResult();
		return purchaseOrderList;
	}
	
	/**
	 * Method to construct the sql query to retrieve all purchase orders to a given supplier
	 * @param supplierName String name of the supplier being searched by
	 * @return the ArrayList of purchase orders created from the query
	 */
	public ArrayList<PurchaseOrder> getPurchaseOrderListBySupplier(String supplierName) {
		sql = listQuery + tableName + tableJoins + " WHERE supplierName LIKE '%" + supplierName + "%'";
		constructResult();
		return purchaseOrderList;
	}
	
	/**
	 * Method to extract purchase order list from orderline query by item
	 * @param i integer of the item id to search by
	 * @return the ArrayList of purchase orders created from the query
	 */
	public ArrayList<PurchaseOrder> getPurchaseOrderListByItem(int i) {
		//TODO connect to purchase orderline loader to retrieve purchase orders
		//TODO pull purchase orders into list from orderline loader query result
		return purchaseOrderList;
	}
}

