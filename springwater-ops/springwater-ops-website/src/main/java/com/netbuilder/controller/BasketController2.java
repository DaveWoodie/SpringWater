package com.netbuilder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netbuilder.session.Basket;
import com.netbuilder.test.ItemDatabase;
import com.netbuilder.test.Item;

@Controller
public class BasketController2 {

	@RequestMapping("/addtobasket")
	public String addToBasket(@RequestParam("itemid") String id, HttpSession session) {
		Item requestedItem = ItemDatabase.searchID(id);
		if (requestedItem != null) {
			if(session.getAttribute("basket") == null)
			{
				session.setAttribute("basket", new Basket());
			}
			Basket basket = (Basket) session.getAttribute("basket");
			basket.addItem(requestedItem);
			session.setAttribute("basket", basket);
			return "redirect:basket";

		}
		return "errorPage";
	}

	@RequestMapping("/basket")
	public String viewBasket(Model model, HttpSession session) {
		if(session.getAttribute("basket") == null)
		{
			session.setAttribute("basket", new Basket());
		}
		Basket basket = (Basket) session.getAttribute("basket");
		model.addAttribute("basket", basket.getItemList());
		return "basket";
	}
}
