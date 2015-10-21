package com.netbuilder.controller;

import java.util.ArrayList;
import java.util.List;

import com.netbuilder.entities.Item;
import com.netbuilder.entityrepository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemsController {

	private List<Item> items;

	@Autowired
	ItemRepository itemRepository;

	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public String greetingForm(Model model) {
		items = new ArrayList<Item>();
		items = itemRepository.findAll();
		System.out.println("hello");
		System.out.println(items.size());

		model.addAttribute("itemList", items);
		return "items";
	}
}
