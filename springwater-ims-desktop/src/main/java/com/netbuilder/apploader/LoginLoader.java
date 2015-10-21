package com.netbuilder.apploader;

import com.netbuilder.DBConnector.SQLDBConnector;

public class LoginLoader 
{
	private SQLDBConnector SQL;
	
	public LoginLoader()
	{
		
	}
	
	public boolean checkLogin(int userID, String Password)
	{
		SQL.openCon();
		SQL.closeCon();
		return true;
	}
}
