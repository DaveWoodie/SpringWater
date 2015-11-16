package com.netbuilder.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netbuilder.test.Item;
import com.netbuilder.test.ItemDatabase;
import com.netbuilder.test.User;
import com.netbuilder.test.WishlistDatabase;

/**
 * 
 * @author Chris Boucher
 * @date 27/10/2015
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		ArrayList<Item> featured = new ArrayList<Item>();
		ArrayList<Item> mostPopular = new ArrayList<Item>();
		ArrayList<Item> mostPopular1 = new ArrayList<Item>();
		ArrayList<Item> mostPopular2 = new ArrayList<Item>();
		ArrayList<Item> mostPopular3 = new ArrayList<Item>();
		ArrayList<Item> wishlist = new ArrayList<Item>();
		ArrayList<Item> wishlist1 = new ArrayList<Item>();
		ArrayList<Item> wishlist2 = new ArrayList<Item>();
		ArrayList<Item> wishlist3 = new ArrayList<Item>();
		User user = null;
		// Change later
		if (session.getAttribute("user") != null) {
			user = (User) session.getAttribute("user");
		}
		featured = ItemDatabase.featured();
		mostPopular = ItemDatabase.mostPopular();
		mostPopular1.add(mostPopular.get(0));
		mostPopular1.add(mostPopular.get(1));
		mostPopular2.add(mostPopular.get(2));
		mostPopular2.add(mostPopular.get(3));
		mostPopular3.add(mostPopular.get(4));
		mostPopular3.add(mostPopular.get(5));
		wishlist = ItemDatabase.wishlist(user);
		for(int i = 0; i < wishlist.size(); i++) {
			if(i <= 1) {
				wishlist1.add(wishlist.get(i));
			}
			else if(i > 1 && i <= 3) {
				wishlist2.add(wishlist.get(i));
			}
			else if(i > 3) {
				wishlist3.add(wishlist.get(i));
			}
		}
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", (User) session.getAttribute("user"));
			model.addAttribute("wishlistSize", WishlistDatabase
					.getUserWishlistItems((User) session.getAttribute("user"))
					.size());
		}
		model.addAttribute("featured", featured);
		model.addAttribute("mostpopular1", mostPopular1);
		model.addAttribute("mostpopular2", mostPopular2);
		model.addAttribute("mostpopular3", mostPopular3);
		model.addAttribute("wishlist1", wishlist1);
		model.addAttribute("wishlist2", wishlist2);
		model.addAttribute("wishlist3", wishlist3);
		return "index";
	}
}