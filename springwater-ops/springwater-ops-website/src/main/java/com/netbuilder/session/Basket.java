package com.netbuilder.session;

import java.util.ArrayList;


import com.netbuilder.test.Item;

public class Basket {
	private ArrayList<Item> itemList;

	public Basket() {
		this.itemList = new ArrayList<Item>();
	}
	
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
