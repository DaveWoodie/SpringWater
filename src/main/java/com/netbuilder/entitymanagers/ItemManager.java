/**
 * @author chrisjwwalker
 * @date 07/10/2015
 */

package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.Item;

/**
 * Entity manager containing CRUD methods for the Item entity
 */
public interface ItemManager {
	
	// CREATE
	public void persistItem(Item item);
	public void persistItem(ArrayList<Item> item);
	
	// READ
	public Item findByName(String name);
	public ArrayList<Item> getNames();
	
	// UPDATE
	public void updateItem(Item item);
	
	// DELETE
	public void removeItem(Item item);
}
