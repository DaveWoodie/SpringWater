/**
 * @author Freshwater
 * @date 23/10/2015
 */
package com.netbuilder.loaders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.netbuilder.connections.MongoPull;
import com.netbuilder.connections.MongoPush;
import com.netbuilder.connections.SQLDBConnector;
import com.netbuilder.entities.Item;

public class ItemLoader 
{
	private MongoPull mongoPull;
	private MongoPush mongoPush;
	private SQLDBConnector SQL;
	
	public ItemLoader()
	{
		mongoPull = new MongoPull();
		mongoPush = new MongoPush();
		SQL = new SQLDBConnector();
	}
	
	public ArrayList<Item> loadItemByID(int itemID)
	{
		ArrayList<Item> itemArray = mongoPull.getItemAsArrayList(itemID);
		return itemArray;
	}
	
	public void setDiscontinueStatus(int itemID, boolean bool)
	{
		mongoPush.setContinuedStateForItem(itemID, bool);
	}
	
	public void addItem(Item itemToAdd)
	{
		mongoPush.addItem(itemToAdd);
	}
	
	/**
	 * Method that pulls the item categories from SQL
	 * @return returns an ArrayList containing a list of item category names 
	 */
	public ArrayList<String> getCategoryList()
	{
		ArrayList<String> categoryList = new ArrayList<String>();
		try 
		{
			SQL.openCon();
			ResultSet rs = SQL.queryDB("SELECT categoryName FROM category");
			
			while(rs.next())
			{
				categoryList.add(rs.getString("categoryName"));
			}
			
			rs.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SQL.closeCon();
		}
		
		return categoryList;
	}
	
	public ArrayList<Item> loadAllCurrentItems() 
	{
		return mongoPull.getAllCurrentItems();
	}

	public ArrayList<Item> loadAllItems() 
	{
		return mongoPull.getAllItems();
	}

}
