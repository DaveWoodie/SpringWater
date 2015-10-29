package com.netbuilder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netbuilder.session.Basket;
import com.netbuilder.test.ItemDatabase;
import com.netbuilder.test.Item;
import com.netbuilder.test.ItemLine;

@Controller
public class BasketController {

	@RequestMapping("/addtobasket")
	public String addToBasket(@RequestParam("itemid") String id,
			HttpSession session) {
		Item requestedItem = ItemDatabase.searchID(id);
		if (requestedItem != null) {
			if (session.getAttribute("basket") == null) {
				session.setAttribute("basket", new Basket());
			}
			Basket basket = (Basket) session.getAttribute("basket");
			if (basket.itemExists(requestedItem)) {
				basket.getItemLine(requestedItem).setQuantity(1);
			} else {
				basket.addItemLine(requestedItem);
			}
			session.setAttribute("basket", basket);
			return "redirect:basket";

		}
		return "errorPage";
	}

	@RequestMapping("/basket")
	public String viewBasket(Model model, HttpSession session) {
		if (session.getAttribute("basket") == null) {
			session.setAttribute("basket", new Basket());
		}
		Basket basket = (Basket) session.getAttribute("basket");
		model.addAttribute("basket", basket);
		return "basket";
	}

	@RequestMapping("/editquantity")
	public String editBasket(@RequestParam("itemid") String id,
			@RequestParam("quantity") int quantity, Model model,
			HttpSession session) {
		if (session.getAttribute("basket") == null) {
			session.setAttribute("basket", new Basket());
		}
		Basket basket = (Basket) session.getAttribute("basket");
		Item item = ItemDatabase.searchID(id);
		if (item != null) {
			basket.getItemLine(item).setQuantity(quantity);
			if (basket.getItemLine(item).getQuantity() == 0) {
				basket.removeItemLine(basket.getItemLine(item));
			}
		}
		session.setAttribute("basket", basket);
		return "redirect:basket";
	}

	@RequestMapping("/removeitem")
	public String editBasket(@RequestParam("itemid") String id, Model model,
			HttpSession session) {
		if (session.getAttribute("basket") == null) {
			session.setAttribute("basket", new Basket());
		}
		Basket basket = (Basket) session.getAttribute("basket");
		Item item = ItemDatabase.searchID(id);
		if (item != null) {
			ItemLine line = basket.getItemLine(item);
			if (line != null) {
				basket.removeItemLine(line);
			}
		}
		session.setAttribute("basket", basket);
		return "redirect:basket";
	}
	
	@RequestMapping("/orderconfirm")
	public String editBasket(Model model, HttpSession session) {
		if (session.getAttribute("basket") == null) {
			return "errorPage";
		}
		Basket basket = (Basket) session.getAttribute("basket");
		model.addAttribute("basket", basket);
		return "orderConfirm";
	}
}
