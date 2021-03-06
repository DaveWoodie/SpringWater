/**
 * @author jforster
 * @date 23/10/15
 */
package com.netbuilder.loaders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.netbuilder.connections.SQLDBConnector;
import com.netbuilder.entities.Item;
import com.netbuilder.entities.Supplier;

/**
 * Class to construct database queries and load data into entities for the java app
 * @author jforster
 *
 */
public class SupplierLoader {
	final String tableName = " FROM supplier";
	final String listQuery = "SELECT *";
	final String insertQuery = "INSERT INTO `nbgardensdata`.`supplier` (`";
	final String collumnsWTE = "supplierName`, `telephoneNumber`, `email`, `idAddress`) VALUES ('";
	final String collumnsWT = "supplierName`, `telephoneNumber`, `idAddress`) VALUES ('";
	final String collumnsWE = "supplierName`, `email`, `idAddress`) VALUES ('";
	ArrayList<Supplier> supplierList = new ArrayList<Supplier>();
	String sql;
	private SQLDBConnector sqlDB = new SQLDBConnector();
	
	/**
	 * Method to execute constructed query and load data into objects
	 */
	private void constructResult() {
		supplierList.clear();
		try {
			sqlDB.openCon();
			ResultSet rs = sqlDB.queryDB(sql);
			while (rs.next()) {
				Supplier s = new Supplier(rs.getString("supplierName"), rs.getInt("idAddress"));
				s.setEmail(rs.getString("email"));
				s.setTelephone(rs.getString("telephoneNumber"));
				s.setSupplierID(rs.getInt("idSupplier"));
				int av = averageDelivery(s.getSupplierID());
				s.setAverageDeliveryTime(av);
				supplierList.add(s);
			}
			rs.close();
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
	}
	
	/**
	 * Method to construct the sql query to retrieve suppliers by id
	 * @param id of the supplier to search for
	 * @return the ArrayList of suppliers created from the query
	 */
	public ArrayList<Supplier> getSupplierListByID(int id){
		sql = listQuery + tableName + " WHERE idSupplier = " + id;
		constructResult();
		return supplierList;
	}

	/**
	 * @author abutcher
	 * Method to construct the SQLquery to retrieve all suppliers
	 * @return the ArrayList of suppliers created from the query
	 */
	public ArrayList<Supplier> getSupplierList() {
		sql = listQuery + tableName;
		constructResult();
		return supplierList;
	}

	/**
	 * @author abutcher
	 * Method to construct the SQLquery to retrieve suppliers by name
	 * @param name of the supplier to search for
	 * @return the ArrayList of suppliers created from the query
	 */
	public ArrayList<Supplier> getSupplierListByName(String name) {
		sql = listQuery + tableName + " WHERE supplierName = '" + name + "'";
		constructResult();
		return supplierList;
	}

	/**
	 * @author abutcher
	 * Method to construct the SQLquery to calculate average 
	 * @param id of the supplier to calculate average
	 * @return an int of average days
	 */
	private int averageDelivery(int id) {
		int avg = 0;
		sql =  "SELECT AVG(DATEDIFF(dateexpected,dateplaced)) FROM purchaseorder where idSupplier = " + id; 
		sqlDB.openCon();
		try {
			ResultSet rs = sqlDB.queryDB(sql);
			rs.next();
			avg = rs.getInt("AVG(DATEDIFF(dateexpected,dateplaced))");
//			System.out.println(avg);
		} 
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		sqlDB.closeCon();
		return avg;
	}
	
	/**
	 * @author abutcher
	 * Method to construct the SQLquery to retrieve suppliers by name
	 * @param input the name of the supplier to search for
	 * @return the ArrayList of suppliers created from the query
	 */
	public ArrayList<Supplier> getSupplierListByProductID(int id) {
		int sID = 0;
		ItemLoader il = new ItemLoader();
		ArrayList<Item> item = new ArrayList<Item>();
		item = il.loadItemByID(id);
		sID = item.get(0).getIdSupplier();
		return getSupplierListByID(sID);
	}

	public void newSupplier(Supplier newSupplier) {
		if (!newSupplier.getEmail().isEmpty() && !newSupplier.getTelephone().isEmpty()) {
			sql = insertQuery + collumnsWTE + newSupplier.getSupplierName() +"', '"+ newSupplier.getTelephone() +"', '"+ newSupplier.getEmail()+"', '"+ newSupplier.getAddressID()+"')";
		}else if(!newSupplier.getEmail().isEmpty()) {
			sql = insertQuery + collumnsWE + newSupplier.getSupplierName() +"', '"+ newSupplier.getEmail()+"', '"+ newSupplier.getAddressID()+"')";
		}else {
			sql = insertQuery + collumnsWT + newSupplier.getSupplierName() +"', '"+ newSupplier.getTelephone() +"', '"+ newSupplier.getAddressID()+"')";
		}

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
