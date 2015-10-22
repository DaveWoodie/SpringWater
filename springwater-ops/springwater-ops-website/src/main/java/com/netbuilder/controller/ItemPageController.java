package com.netbuilder.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;

import com.netbuilder.test.Item;
import com.netbuilder.test.ItemDatabase;

@Controller
public class ItemPageController {
	
	private ArrayList<Item> itemList = ItemDatabase.itemList;

	@RequestMapping(value = "/itempage+*", method = RequestMethod.GET)
	public String getItem(HttpServletRequest request, Model model) {
		String url = (String) request
				.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		for(Item item : itemList)
		{
			if(new String("/itempage+" + item.getItemName()).equals(url))
			{
				model.addAttribute("item",item);
			}
		}
		return "itemPage";
	}
}
