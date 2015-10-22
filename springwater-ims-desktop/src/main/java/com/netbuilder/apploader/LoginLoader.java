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
		System.out.println("Connection to SQL DB Opened");
		
		try 
		{
			rSet = SQL.queryDB("SELECT idUser FROM nbgardensdata.user;");
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
		System.out.println("Connection to SQL DB Closed");
				
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
		System.out.println("Connection to SQL DB Opened");
		
		try 
		{
			rSet = SQL.queryDB("SELECT password FROM nbgardensdata.user;");
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
		System.out.println("Connection to SQL DB Closed");
		
		return Passwords;
	}
}
