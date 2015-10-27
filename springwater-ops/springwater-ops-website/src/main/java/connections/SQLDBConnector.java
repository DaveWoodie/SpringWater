package connections;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class SQLDBConnector {

	private Object o;
	private List<Object> l;
	
	static final String IP = "10.50.15.25";
	static final String databaseURL = "jdbc:mysql://" + IP + ":3306/nbgardensdata";
	static final String userName = "root";
	static final String passWord = "password";
	
	private Connection con = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	
	/**
	 * Not sure if a constructor is even needed but here is one anyway.
	 */
	public SQLDBConnector() { 	
	}
	
	/**
	 * Method to open the connection to the database.
	 */
	public void openCon() {
		try {
			con = (Connection) DriverManager.getConnection(databaseURL, userName, passWord);
		} catch (SQLException se) {
			se.printStackTrace();;
		} catch (Exception e) {
			throw new Error(e);
		}
	}
	
	/**
	 * Method to close the connection to the database.
	 */
	public void closeCon() {
		
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			 if (con != null) {
				 con.close();
			 }
		 } catch (SQLException se) {
			 se.printStackTrace();
		 }
	}

	/**
	 * Method to query an entry or multiple entries in the database. 
	 * 
	 * @param sql : The statement as prepared by the loader class to query the database. 
	 */
	public ResultSet queryDB (String sql) throws Exception {
		stmt = (Statement) con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
	
	/**
	 * Method to update an entry or multiple entries in the database.
	 * 
	 * @param sql : The statement as prepared by the loader class to update the database.
	 * @throws Exception
	 */
	public void updateDB (String sql) throws Exception {
		stmt = (Statement) con.createStatement();
		stmt.executeUpdate(sql);
	}
}
