package com.netbuilder.controller;

import java.util.ArrayList;

import com.netbuilder.test.Item;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemsController {

	private ArrayList<Item> itemList;
	
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public String itemTest(Model model) {
		itemList = new ArrayList<Item>();
		itemList.add(new Item("itemName", 10.00f, "img/hoe01.jpg", 3));
		itemList.add(new Item("itemName2", 11.00f, "img/hoe2.jpg", 2));
		itemList.add(new Item("itemName3", 12.00f, "img/gnome.jpg", 4));
		itemList.add(new Item("itemName4", 13.00f, "img/gnome02.jpg", 5));
		model.addAttribute("itemList",itemList);
		return "items";
	}
}
