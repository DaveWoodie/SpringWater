/**
 * @author jforster
 * @date 23/10/15
 */
package com.netbuilder.loaders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.netbuilder.connections.SQLDBConnector;
import com.netbuilder.entities.Supplier;

/**
 * Class to construct database queries and load data into entities for the java app
 * @author jforster
 *
 */
public class SupplierLoader {
	final String tableName = " FROM supplier";
	final String listQuery = "SELECT *";
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
	 * @param input the name of the supplier to search for
	 * @return the ArrayList of suppliers created from the query
	 */
	public ArrayList<Supplier> getSupplierListByName(String input) {
		sql = listQuery + tableName + " WHERE supplierName = '" + input + "'";
		constructResult();
		return supplierList;
	}

}
