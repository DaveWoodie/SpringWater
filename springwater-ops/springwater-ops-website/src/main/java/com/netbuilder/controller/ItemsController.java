//package com.netbuilder.controller;
//
//import java.util.ArrayList;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.HandlerMapping;
//
//import com.netbuilder.test.ItemDatabase;
//
//@Controller
//public class ItemsController {
//
//	
//	@RequestMapping(value = "/items", method = RequestMethod.GET)
//	public String itemTest(Model model) {
//		
//		model.addAttribute("itemList",ItemDatabase.itemList);
//		return "items";
//	}
//	
//	@RequestMapping(value = "/items*", method = RequestMethod.GET)
//	public String itemsFiltered(HttpServletRequest request, Model model) {
//
//		// Get current URL and compare to database
//		String url = (String) request
//				.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
//		url.contains("s");
//		return "items";
//	}
//}
