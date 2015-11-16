/**
 * @author dwoodward
 * @date 27/10/2015
 */

package com.netbuilder.loaders;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.netbuilder.connections.SQLDBConnector;

public class WebLoginLoader {
	
	private SQLDBConnector SQL = new SQLDBConnector();
	private ResultSet rSet;
	
//	public WebLoginLoader() {
//	}
	
	public String[] getLoginByEmail(String email) {
		
		String[] login = new String[2];
		
		SQL.openCon();
		
		try {
			rSet = SQL.queryDB("SELECT email FROM user WHERE email = '" + email + "'");
			rSet.first();
			login[0] = rSet.getString(1);
			
			rSet = SQL.queryDB("SELECT password FROM user WHERE email = '" + email + "'");
			rSet.first();
			login[1] = rSet.getString(1);
		}
		catch(SQLException e) {
			System.out.println("Email does not exist in the database.");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			SQL.closeCon();
		}
		return login;
	}
	
	public int getUserId(String email) {
		
		int i = 0;
		
		try {
			rSet = SQL.queryDB("SELECT idUser FROM user WHERE email = '" + email + "'");
			rSet.first();
			i = rSet.getInt(1);
		}
		catch(SQLException e) {
			System.out.println("Email does not exist in the database.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			SQL.closeCon();
		}
		
		return i;
	}

}
