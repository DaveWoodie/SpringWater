package com.netbuilder.session;

import java.util.ArrayList;

import com.netbuilder.test.Item;

/**
 * 
 * @author ccooper
 * @date 28/10/2015
 *
 */

public class OrderConfirm {
	
	// Create an item list
	private ArrayList<Item> itemList;
	
	// Class constructor
	public OrderConfirm() {
		
		// Initialise attributes
		this.itemList = new ArrayList<Item>();
	}
	
	// ACCESSORS
	public ArrayList<Item> getItemList() {
		return this.itemList;
	}
	
	public void addItem(Item item) {
		this.itemList.add(item);
	}
	
	public int getSize() {
		return this.itemList.size();
	}
}
