package com.netbuilder.apploader;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.netbuilder.DBConnector.SQLDBConnector;

public class LoginLoader 
{
	private SQLDBConnector SQL = new SQLDBConnector();
	private ResultSet rSet;
	
	public ArrayList<Integer> getUsers()
	{
		ArrayList<Integer> Users = new ArrayList<Integer>();
		int Rows;
		
		SQL.openCon();
		System.out.println("Connection to SQL DB opened");
		
		try 
		{
			rSet = SQL.queryDB("SELECT idUser FROM nbgardensdata.user;");
			
			rSet.last();
			Rows = rSet.getRow();
			
			System.out.println("LoginLoader " + Rows);
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		
		for(int i = 0; i < 2; i++)
		{
			
		}
			
		SQL.closeCon();
		System.out.println("Connection to SQL DB Closed");
				
		return Users;
	}
	
	public String getPasswords()
	{
		String Password = null;
		
		SQL.openCon();
		SQL.closeCon();
		
		return Password;
	}
}
