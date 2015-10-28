////Author: Callum Cooper
////Date: 27/10/2015
////Description: Controller for the basket.
////Last Modified: 27/10/2015
//
//package com.netbuilder.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.netbuilder.test.BasketDatabase;
//
//@Controller
//@RequestMapping("/basket")
//public class BasketController {
//	
//	@RequestMapping(method=RequestMethod.GET)
//	public String getBasket(Model model) {
//		String userID = "001";
//		model.addAttribute("basket", BasketDatabase.basket(userID));
//		return "basket";
//	}
//}
