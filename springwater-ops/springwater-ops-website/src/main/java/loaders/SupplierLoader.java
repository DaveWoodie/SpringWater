/**
 * @author jforster
 * @date 23/10/15
 */
package loaders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import connections.MongoPush;
import connections.SQLDBConnector;
import entities.Item;
import entities.Supplier;

/**
 * Class to construct database queries and load data into entities for the java app
 * @author jforster
 *
 */
public class SupplierLoader {
	final String tableName = " FROM supplier";
	final String listQuery = "SELECT *";
	final String insertQuery = "INSERT INTO `nbgardensdata`.`supplier` (`";
	final String collumnsWTE = "supplierName`, `telephoneNumber`, `email`, `idAddress`, 'image') VALUES ('";
	final String collumnsWT = "supplierName`, `telephoneNumber`, `idAddress`, `image`) VALUES ('";
	final String collumnsWE = "supplierName`, `email`, `idAddress`, 'image') VALUES ('";
	final String update = "UPDATE `nbgardensdata`.`supplier` SET `supplierName`='";
	ArrayList<Supplier> supplierList = new ArrayList<Supplier>();
	String sql;
	private SQLDBConnector sqlDB = new SQLDBConnector();
	private MongoPush push = new MongoPush(); 
	
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

	/**
	 * @author abutcher
	 * Method to send a new supplier to the database
	 * @param newSupplier to add to database
	 */
	public void newSupplier(Supplier newSupplier) {
		System.out.println(newSupplier.getImageLocation());
//		if (!newSupplier.getEmail().isEmpty() && !newSupplier.getTelephone().isEmpty()) {
//			sql = insertQuery + collumnsWTE + newSupplier.getSupplierName() +"', '"+ newSupplier.getTelephone() +"', '"+ newSupplier.getEmail()+"', '"+ newSupplier.getAddressID()+"', '"+newSupplier.getImageLocation() +"')";
//		}else if(!newSupplier.getEmail().isEmpty()) {
//			sql = insertQuery + collumnsWE + newSupplier.getSupplierName() +"', '"+ newSupplier.getEmail()+"', '"+ newSupplier.getAddressID()+"', '"+newSupplier.getImageLocation() +"')";
//		}else {
//			sql = insertQuery + collumnsWT + newSupplier.getSupplierName() +"', '"+ newSupplier.getTelephone() +"', '"+ newSupplier.getAddressID()+"', '"+newSupplier.getImageLocation() +"')";
//		}
//		sqlDB.openCon();
//		try {
//			sqlDB.updateDB(sql);
//		} 
//		catch (SQLException sqle) {
//			sqle.printStackTrace();
//			push.deleteAddressByID(newSupplier.getAddressID());
//			JFrame frame = new JFrame("Could not add supplier");
//			JOptionPane.showMessageDialog(frame, "Supplier has been updated \n SQL Error", "Warning",
//					JOptionPane.ERROR_MESSAGE);
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			push.deleteAddressByID(newSupplier.getAddressID());
//			JFrame frame = new JFrame("Could not add supplier");
//			JOptionPane.showMessageDialog(frame, "Supplier has been updated", "Warning",
//					JOptionPane.ERROR_MESSAGE);
//		}
//		sqlDB.closeCon();
		push.deleteAddressByID(newSupplier.getAddressID());
	}

	public void updateSupplier(Supplier upSP) {
		if (!upSP.getEmail().isEmpty() && !upSP.getTelephone().isEmpty()) {
		sql = update+ upSP.getSupplierName()+ "', telephoneNumber ='"+upSP.getTelephone() + "', email ='" + upSP.getEmail() +"', image ='"+upSP.getImageLocation() + "' WHERE `idSupplier`='"+upSP.getSupplierID()+"';";
		} else if (!upSP.getEmail().isEmpty()) {
			sql = update+ upSP.getSupplierName()+ "', email ='" + upSP.getEmail() +"', image ='"+upSP.getImageLocation() + "' WHERE `idSupplier`='"+upSP.getSupplierID()+"';";
		} else {
			sql = update+ upSP.getSupplierName()+ "', telephoneNumber ='"+upSP.getTelephone() + "', image ='"+upSP.getImageLocation() + "' WHERE `idSupplier`='"+upSP.getSupplierID()+"';";
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
