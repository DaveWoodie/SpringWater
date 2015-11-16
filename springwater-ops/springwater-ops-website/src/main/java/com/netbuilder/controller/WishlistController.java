package com.netbuilder.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.netbuilder.test.Item;
import com.netbuilder.test.ItemDatabase;
import com.netbuilder.test.User;
import com.netbuilder.test.Wishlist;
import com.netbuilder.test.WishlistDatabase;

/**
 * 
 * @author Chris Boucher
 * @date 27/10/2015
 *
 */
@Controller
public class WishlistController {

	@RequestMapping(value = "/wishlist", method = RequestMethod.GET)
	public String getWishlist(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			model.addAttribute("wishlist",
					WishlistDatabase.getUserWishlistItems(user));
			model.addAttribute("wishlistSize", WishlistDatabase
					.getUserWishlistItems(user).size());
			return "wishlist";
		} else {
			return "errorPage";
		}
	}

	@RequestMapping("/removewishline")
	public String removeItem(@RequestParam("itemid") String id, Model model,
			HttpSession session) {
		if (session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			Item item = ItemDatabase.searchID(id);
			WishlistDatabase.removeWishline(new Wishlist(user, item));
			ArrayList<Item> wishlist = WishlistDatabase
					.getUserWishlistItems(user);
			session.setAttribute("wishlist", wishlist);
			model.addAttribute("wishlistSize", WishlistDatabase
					.getUserWishlistItems(user).size());
		}
		return "redirect:wishlist";
	}

	@RequestMapping("/addwishline")
	public String addItem(@RequestParam("itemid") String id, Model model,
			HttpSession session) {
		if (session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			Item item = ItemDatabase.searchID(id);
			if (user != null && item != null) {
				if (!WishlistDatabase.itemExists(new Wishlist(user, item))) {
					WishlistDatabase.addWishline(user, item);
				}
			}
			ArrayList<Item> wishlist = WishlistDatabase
					.getUserWishlistItems(user);
			session.setAttribute("wishlist", wishlist);
			model.addAttribute("wishlistSize", WishlistDatabase
					.getUserWishlistItems(user).size());
			return "redirect:wishlist";
		}
		return "redirect:loginregister";
	}
}
