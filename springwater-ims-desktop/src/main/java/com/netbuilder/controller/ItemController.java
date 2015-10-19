package com.netbuilder.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.netbuilder.entities.Item;
import com.netbuilder.entityrepository.ItemRepository;

public class ItemController {
	private ArrayList<Item> items;
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