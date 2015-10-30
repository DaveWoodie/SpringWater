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

public class CustomerOrderLineLoader {
	
	final String tableName = " FROM customerorderline";
	final String listQuery = "SELECT *";
	private String sql;
	private SQLDBConnector sqlDB = new SQLDBConnector();
	ArrayList<CustomerOrderLine> cOLList = new ArrayList<CustomerOrderLine>();
	ArrayList<Item> itemList;
	CustomerOrder customerOrder;
	
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
	
	public ArrayList<CustomerOrderLine> getCustomerOrderLineByOrderID(int id) {
		sql = listQuery + tableName + " WHERE idPurchaseOrder = " + id;
		CustomerOrderLoader cOL = new CustomerOrderLoader();
		constructResult();
		return cOLList;
	}
}
