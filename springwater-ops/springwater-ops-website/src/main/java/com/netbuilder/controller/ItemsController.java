package com.netbuilder.controller;

import java.util.ArrayList;

import com.netbuilder.test.Item;
import com.netbuilder.test.ItemDatabase;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemsController {

	private ArrayList<Item> itemList = ItemDatabase.itemList;
	
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public String itemTest(Model model) {
		
		model.addAttribute("itemList",itemList);
		return "items";
	}
}
