/**
 * @author jforster
 * @date 20/10/2015
 */
package loaders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connections.SQLDBConnector;
import entities.Employee;
import entities.Item;
import entities.PurchaseOrder;
import entities.PurchaseOrderStatus;
import entities.Role;
import entities.Supplier;
import entities.User;

/**
 * Class to construct database queries and load data into entities for the java app
 * @author jforster
 *
 */
public class PurchaseOrderLoader {
	
	final String tableName = " FROM purchaseorder";
	final String listQuery = "SELECT purchaseorder.*, purchaseorderstatus.*, supplier.*, employee.*, user.*, role.*";
	final String tableJoins = " LEFT JOIN purchaseorderstatus ON purchaseorder.idPurchaseOrderStatus = purchaseorderstatus.idPurchaseOrderStatus LEFT JOIN supplier ON purchaseorder.idSupplier = supplier.idSupplier LEFT JOIN employee ON purchaseorder.idEmployee = employee.idEmployee LEFT JOIN user ON purchaseorder.idEmployee = user.idUser LEFT JOIN role ON employee.idRole = role.idRole";
	final String orderBy = " ORDER BY purchaseorder.datePlaced DESC";
	final String orderByAsc = " ORDER BY purchaseorder.datePlaced ASC";
	private String sql;
	private SQLDBConnector sqlDB = new SQLDBConnector();
	ArrayList<PurchaseOrder> purchaseOrderList = new ArrayList<PurchaseOrder>();
	
	/**
	 * Method to execute constructed query and load data into objects
	 */
	private void constructResult() {
		purchaseOrderList.clear();
		try {
			sqlDB.openCon();
			ResultSet rs = sqlDB.queryDB(sql);
			while (rs.next()) {
				PurchaseOrderStatus pOS = new PurchaseOrderStatus(rs.getString("purchaseorderstatus.status"));
				pOS.setPurchOrderID(rs.getInt("purchaseorderstatus.idPurchaseOrderStatus"));
				Supplier supplier = new Supplier(rs.getString("supplier.supplierName"), rs.getInt("supplier.idAddress"));
				supplier.setSupplierID(rs.getInt("supplier.idSupplier"));
				Role role = new Role(rs.getString("role.Role"));
				User user = new User(rs.getString("user.password"), rs.getString("user.forename"), rs.getString("user.surname"), rs.getString("user.email"), rs.getBoolean("user.isEmployee"));
				user.setUserID(rs.getInt("user.idUser"));
				Employee employee = new Employee(user, role);
				PurchaseOrder pO = new PurchaseOrder(pOS, supplier);
				pO.setDatePlaced(rs.getDate("purchaseorder.datePlaced"));
				pO.setEmployee(employee);
				pO.setIDPurchaseOrder(rs.getInt("purchaseorder.idPurchaseOrder"));
				pO.setDateExpected(rs.getDate("purchaseorder.dateExpected"));
				purchaseOrderList.add(pO);
			}
			rs.close();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			sqlDB.closeCon();
		}
	}
	
	/**
	 * Method to construct the sql query to retrieve all purchase orders
	 * @return the ArrayList of purchase orders created from the query
	 */
	public ArrayList<PurchaseOrder> getPurchaseOrderList() {
		sql = listQuery + tableName + tableJoins + orderBy;
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
//		System.out.println(purchaseOrderList.get(0).getPurchaseOrderStatus().getStatusID());
		return purchaseOrderList;
	}
	
	/**
	 * Method to construct the sql query to retrieve all purchase orders with a given status
	 * @param status String to search for
	 * @return the ArrayList of purchase orders created from the query
	 */
	public ArrayList<PurchaseOrder> getPurchaseOrderListByStatus(String status) {
		sql = listQuery + tableName + tableJoins + " WHERE status = '" + status +"'" + orderBy;
		constructResult();
		return purchaseOrderList;
	}
	
	/**
	 * Method to construct the sql query to retrieve all purchase orders to a given supplier
	 * @param supplierName String name of the supplier being searched by
	 * @return the ArrayList of purchase orders created from the query
	 */
	public ArrayList<PurchaseOrder> getPurchaseOrderListBySupplier(String supplierName) {
		sql = listQuery + tableName + tableJoins + " WHERE supplierName LIKE '%" + supplierName + "%'" + orderBy;
		constructResult();
		return purchaseOrderList;
	}
	
	/**
	 * Method to extract purchase order list from orderline query by item
	 * @param i integer of the item id to search by
	 * @return the ArrayList of purchase orders created from the query
	 */
	public ArrayList<PurchaseOrder> getPurchaseOrderListByItem(int i) {
		PurchaseOrderLineLoader pOLLoader = new PurchaseOrderLineLoader();
		ArrayList<Integer> purchaseOrderIDs = new ArrayList<Integer>();
		purchaseOrderIDs = pOLLoader.getPurchaseOrderLineByProduct(i);
		sql = listQuery + tableName + tableJoins;
		for (int j = 0; j < purchaseOrderIDs.size(); j++) {
			if (j == 0) {
				sql = sql + " WHERE idPurchaseOrder = " + purchaseOrderIDs.get(j);
			}
			else {
				sql = sql + " OR idPurchaseOrder = " + purchaseOrderIDs.get(j);
			}
		}
		sql = sql + orderByAsc;
		constructResult();
		return purchaseOrderList;
	}
	
	/**
	 * Method to construct the sql query to retrieve all purchase orders placed on a given date
	 * @param date of order placement
	 * @return the Arraylist of purchase orders created from the query
	 */
	public ArrayList<PurchaseOrder> getPurchaseOrderListByDate(java.util.Date date) {
		java.sql.Date queryDate = new java.sql.Date(date.getTime());
		sql = listQuery + tableName + tableJoins + " WHERE datePlaced = '" + queryDate + "'";
		constructResult();
		return purchaseOrderList;
	}
	
	public ArrayList<PurchaseOrder> getPurchaseOrderListByItemValid(Item item) {
		sql = listQuery + tableName + tableJoins + " WHERE supplier.idSupplier = " + item.getIdSupplier() + " AND purchaseorderstatus.idPurchaseOrderStatus = 1";
		constructResult();
		return purchaseOrderList;
	}
	
	/**
	 * Method to construct the sql query to update a purchase order entry in the database and execute it
	 * @param pO the purchase order object to be updated
	 */
	public void setPurchaseOrder(PurchaseOrder pO){
		java.sql.Date dateExpected = null;
		java.sql.Date datePlaced = null;
		try {
			datePlaced = new java.sql.Date(pO.getDatePlaced().getTime());
		}
		catch (NullPointerException nPE) {
			datePlaced = null;
		}
		try {
			dateExpected = new java.sql.Date(pO.getDateExpected().getTime());
		}
		catch (NullPointerException nPE) {
			dateExpected = null;
		}
		String dateToPass;
		if (dateExpected == null) {
			dateToPass = "null";
		}
		else {
			dateToPass = "'" + dateExpected + "'";
		}
		
		String datePlacedString;
		if (datePlaced == null) {
			datePlacedString = "null";
		}
		else {
			datePlacedString = "'" + datePlaced + "'";
		}
		
		sql = "UPDATE purchaseOrder SET datePlaced = " + datePlacedString + ", dateExpected = " + dateToPass + ", idEmployee = " + pO.getEmployee().getUser().getUserID() + ", idPurchaseOrderStatus = " + pO.getPurchaseOrderStatus().getStatusID() + ", idSupplier = " + pO.getSupplier().getSupplierID() + " WHERE idPurchaseOrder = " + pO.getIDPurchaseOrder();
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
	 * Method to construct the sql query to create a purchase order entry in the database and execute it
	 * @param pO the purchase order object to be created
	 */
	public Integer createPurchaseOrder (PurchaseOrder pO) {
//		System.out.println("Reached create purchase order");
//		System.out.println(pO.getPurchaseOrderStatus().getStatusID());
//		System.out.println(pO.getSupplier().getSupplierID());
		sql = "INSERT INTO purchaseOrder (idPurchaseOrderStatus, idSupplier) VALUE (" + pO.getPurchaseOrderStatus().getStatusID() + ", " + pO.getSupplier().getSupplierID() + ")";
		sqlDB.openCon();
		Integer newID = null;
		try {
			sqlDB.updateDB(sql);
			ResultSet rs = sqlDB.queryDB("SELECT MAX(idPurchaseOrder) AS ID FROM purchaseorder");
			rs.next();
			newID = rs.getInt("ID");
		} 
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
		sqlDB.closeCon();
		}
		return newID;
	}
}

