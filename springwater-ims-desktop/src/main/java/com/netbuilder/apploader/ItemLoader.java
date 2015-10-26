/**
 * @author Freshwater
 * @date 23/10/2015
 */
package com.netbuilder.apploader;

import java.util.ArrayList;

import com.netbuilder.DBConnector.MongoPull;
import com.netbuilder.entities.Item;

public class ItemLoader 
{
	private MongoPull mongoPull;
	private ArrayList<Item> itemArray;
	
	public ItemLoader()
	{
		mongoPull = new MongoPull();
	}
	
	public ArrayList<Item> loadItemByID(int itemID)
	{
		itemArray = mongoPull.getItemInf(itemID);
		return itemArray;
	}
}
