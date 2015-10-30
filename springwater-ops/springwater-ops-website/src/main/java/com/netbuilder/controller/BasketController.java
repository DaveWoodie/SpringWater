package com.netbuilder.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netbuilder.session.Basket;
import com.netbuilder.test.ItemDatabase;
import com.netbuilder.test.Item;
import com.netbuilder.test.ItemLine;
import com.netbuilder.test.User;

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
		if (session.getAttribute("user") != null) {
			if (session.getAttribute("basket") == null) {
				session.setAttribute("basket", new Basket());
			}
			User user = (User) session.getAttribute("user");
			Basket basket = (Basket) session.getAttribute("basket");
			model.addAttribute("basket", basket);
			model.addAttribute("user", user);
			return "basket";
		}
		else
		{
			return "redirect:loginregister";
		}
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
		
		// create a order date
		DateFormat orderDateDF = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date orderDateobj = new Date();
		model.addAttribute("orderDate", orderDateDF.format(orderDateobj));
		
		// create a arrival date
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +7);
		Date todate1 = cal.getTime();
		String fromdate = orderDateDF.format(todate1);
		model.addAttribute("arrivalDate", fromdate);

		// Create a new basket
		Basket basket = (Basket) session.getAttribute("basket");
		model.addAttribute("basket", basket);
		return "orderConfirm";
	}
}
