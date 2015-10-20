/**
 * Class to handle the connections to the database taking in arguments of the table name, and type of item the Retrieve.
 * @author dwoodward
 */

package com.netbuilder.DBConnector;

import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DBConnector {

	private Object o;
	private List<Object> l;
	
	static final String databaseURL = null;
	static final String userName = null;
	static final String passWord = null;
	
	private Connection con = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	
	public DBConnector() { 
		
	}
	
	public void setEntry (String sql) {
	}
	
	public Object getEntry (String sql) {
		return o;
	}
	
	public List<Object> getEntries (String sql) { 
		return l;
	}
	
	public List<Object> getEntriesByID (String table, int ID) {
		return l;
	}
}
