/**
 * @author Freshwater
 * @date 21/10/2015
 */

package com.netbuilder.apploader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.netbuilder.DBConnector.SQLDBConnector;

/**
 * Class to load all the data affiliated with a user login from the SQL Database
 */

public class LoginLoader 
{
	private SQLDBConnector SQL = new SQLDBConnector();
	private ResultSet rSet;
	
	public String[] getNameByID(String userID)
	{
		String[] name = new String[2];
		
		SQL.openCon();
		
		try
		{
			rSet = SQL.queryDB("SELECT forename FROM user WHERE idUser = " + userID);
			rSet.first();
			name[0] = rSet.getString(1);
			
			rSet = SQL.queryDB("SELECT surname FROM user WHERE idUser = " + userID);
			rSet.first();
			name[1] = rSet.getString(1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		SQL.closeCon();
		
		return name;
	}
	
	/**
	 * Method to get all the user IDs from the SQL Database
	 * 
	 * @return Returns an ArrayList containing all user names on the SQL Database
	 */
	public ArrayList<Integer> getUsers()
	{
		ArrayList<Integer> Users = new ArrayList<Integer>();
		int Rows = 0;
		
		SQL.openCon();
		
		try 
		{
			rSet = SQL.queryDB("SELECT idUser FROM nbgardensdata.user WHERE isEmployee = 1;");
			rSet.last();
			Rows = rSet.getRow();
			rSet.first();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		for(int i = 0; i < Rows; i++)
		{
			try
			{
				Users.add(rSet.getInt(1));
				rSet.next();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
			
		SQL.closeCon();
				
		return Users;
	}
	
	/**
	 * Method to get all the user passwords on the SQL database
	 * 
	 * @return Returns an ArrayList containing all the user passwords on the SQL database
	 */
	public ArrayList<String> getPasswords()
	{
		ArrayList<String> Passwords = new ArrayList<String>();
		int Rows = 0;
		
		SQL.openCon();
		
		try 
		{
			rSet = SQL.queryDB("SELECT password FROM nbgardensdata.user WHERE isEmployee = 1;");
			rSet.last();
			Rows = rSet.getRow();
			rSet.first();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		for(int i = 0; i < Rows; i++)
		{
			try
			{
				Passwords.add(rSet.getString(1));
				rSet.next();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		SQL.closeCon();
		
		return Passwords;
	}
}
