package com.netbuilder.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.netbuilder.entities.Item;
import com.netbuilder.entityrepository.ItemRepository;


/**
 * retrieves ITem information from the common project to populate GUI fields
 * @author tstacey
 * @date 19/10/2015
 */
public class ItemController {
	
	
	private ArrayList<Item> items;
	private Item singleItem;
	
	
	@Autowired
	ItemRepository itemRepository;
	
	public void getItems() {
		System.out.println("Hey!");
		items = (ArrayList<Item>) itemRepository.findAll();
		for (Item item : items) {
			System.out.println(item.getItemName());
		}
	}
	
}