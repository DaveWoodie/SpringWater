/**
 * @author Freshwater
 * @date 23/10/2015
 */
package com.netbuilder.loaders;

import java.util.ArrayList;

import com.netbuilder.connections.MongoPull;
import com.netbuilder.connections.MongoPush;
import com.netbuilder.entities.Item;

public class ItemLoader 
{
	private MongoPull mongoPull;
	private MongoPush mongoPush;
	
	public ItemLoader()
	{
		mongoPull = new MongoPull();
		mongoPush = new MongoPush();
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
	
	public ArrayList<Item> loadAllCurrentItems() 
	{
		return mongoPull.getAllCurrentItems();
	}
}
