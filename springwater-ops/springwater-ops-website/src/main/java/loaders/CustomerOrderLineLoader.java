/**
 * @author jforster
 * @date 30/10/2015
 */
package loaders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connections.SQLDBConnector;
import entities.CustomerOrder;
import entities.CustomerOrderLine;
import entities.Item;
import entities.PurchaseOrder;
import entities.PurchaseOrderLine;

/**
 * Class to load customer order lines from the database
 * @author jforster
 *
 */
public class CustomerOrderLineLoader {
	
	final String tableName = " FROM customerorderline";
	final String listQuery = "SELECT *";
	private String sql;
	private SQLDBConnector sqlDB = new SQLDBConnector();
	ArrayList<CustomerOrderLine> cOLList = new ArrayList<CustomerOrderLine>();
	ArrayList<Item> itemList;
	CustomerOrder customerOrder;
	
	/**
	 * Method to create the ArrayList of customer order lines from an SQL query
	 */
	private void constructResult() {
		cOLList.clear();
		try {
			sqlDB.openCon();
			ResultSet rs = sqlDB.queryDB(sql);
			while (rs.next()) {
				CustomerOrderLine cOL = new CustomerOrderLine(rs.getInt("Quantity"), rs.getInt("idItem"), customerOrder);
				cOLList.add(cOL);
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
	 * Method to construct a SQL query to locate all customer order lines with a specified order id
	 * @param id customer order id to search by
	 * @return the ArrayList of customer order lines that match the search id
	 */
	public ArrayList<CustomerOrderLine> getCustomerOrderLineByOrderID(int id) {
		sql = listQuery + tableName + " WHERE idPurchaseOrder = " + id;
		CustomerOrderLoader cOL = new CustomerOrderLoader();
		constructResult();
		return cOLList;
	}
}
