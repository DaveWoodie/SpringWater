package com.netbuilder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netbuilder.test.ItemDatabase;
/**
 * 
 * @author Chris Boucher
 * @date 27/10/2015
 *
 */
@Controller
@RequestMapping("/wishlist")
public class WishlistController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String getWishlist(Model model) {
		String userID = "001";
		model.addAttribute("wishlist",ItemDatabase.wishlist(userID));
		return "wishlist";
	}
}
