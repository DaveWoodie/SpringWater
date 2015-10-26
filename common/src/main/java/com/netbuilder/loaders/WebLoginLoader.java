package com.netbuilder.loaders;

import java.sql.ResultSet;
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
			rSet = SQL.queryDB("SELECT email FROM user WHERE email = " + email);
			rSet.first();
			login[0] = rSet.getString(1);
			
			rSet = SQL.queryDB("SELECT password FROM user WHERE email = " + email);
			rSet.first();
			login[1] = rSet.getString(1);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			SQL.closeCon();
		}
		return login;
		
	}

}
