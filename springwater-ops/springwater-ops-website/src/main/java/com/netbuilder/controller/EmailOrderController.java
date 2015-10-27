


package com.netbuilder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netbuilder.test.ItemDatabase;


@Controller
@RequestMapping("/emailOrder")
public class EmailOrderController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String emailOrderFetch(Model model) {
		
		model.addAttribute("itemList", ItemDatabase.itemList);
		
		return "emailOrder";
	}
}
