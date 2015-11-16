package com.netbuilder.logic;

import java.util.ArrayList;

import connections.MongoPull;
import entities.Item;

public class StockReportLogic {
	
	private int NUMBER_OF_COLUMNS = 4;
	private MongoPull pull = new MongoPull();
	
	
	public Object[][] fetchStockList() {
		
		ArrayList<Item> items = this.getAllItems();
		Object[][] itemsObj = this.createObjectArrayFromItems(items);
		
		return itemsObj;
	}
	
	public Object[][] fetchFastMovingList() {
		
		ArrayList<Item> items = this.getFastMovingItems();
		Object[][] itemsObj = this.createObjectArrayFromItems(items);
		
		return itemsObj;
	}
	
	private Object[][] createObjectArrayFromItems(ArrayList<Item> items) {
		int numberOfItems = items.size();
		Object[][] itemsObj = new Object[numberOfItems][NUMBER_OF_COLUMNS];
		for(int i = 0; i < numberOfItems; i++) {
			Item item = items.get(i);
			itemsObj[i][0] = item.getIdItem();
			itemsObj[i][1] = item.getItemName();
			itemsObj[i][2] = item.getStock();
			itemsObj[i][3] = item.getSalesRate();
		}
		return itemsObj;
		
	}
	

	private ArrayList<Item> getAllItems() {
		ArrayList<Item> items = pull.getAllCurrentItems();
		return items;
	}
	
	private ArrayList<Item> getFastMovingItems() {
		ArrayList<Item> items = pull.getAllCurrentItems();
		ArrayList<Item> fastMovingItems = new ArrayList<Item>();
		
		for(Item item : items) {
			if(item.getSalesRate() - item.getpSalesRate() > item.getpSalesRate()/2 ||
					item.getpSalesRate() - item.getSalesRate() > item.getpSalesRate()/2) {
				fastMovingItems.add(item);
			}
		}
		
		return fastMovingItems;
	}
	
	
}
