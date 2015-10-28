package com.netbuilder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import entities.Item;
import entityrepository.ItemRepository;


/**
 * retrieves Item information from the common project to populate GUI fields
 * @author tstacey
 * @date 19/10/2015
 */

/**
 * Modified to de-couple the set of controllers.
 * @author dwoodward
 *
 */
public class ItemController {
	
	private List<Item> items;
	private Item singleItem;
	
	/**
	 * Magic of spring.
	 */
	@Autowired
	ItemRepository itemRepository;
	ArrayList<Item> itemList;

	/**
	 * Method to get all items within the 
	 * @return
	 */
	public List<Item> getItems() {
		items = itemRepository.findAll();
		return items;
	}
	
	public Item getSingItem(int itemID) {
		singleItem = itemRepository.findByItemID(itemID);
		return singleItem;
	}
	
	public List<Item> getItemsBySalesRate(double salesRate) {
		items = itemRepository.findBySalesRate(salesRate);
		return items;
	}

}