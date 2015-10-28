package com.netbuilder.controller;

import java.util.ArrayList;

import com.netbuilder.test.Item;
import com.netbuilder.test.ItemDatabase;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author Chris Boucher
 * @date 23/10/2015
 *
 */
@Controller
@RequestMapping("items")
public class ItemsController {

	@RequestMapping(method = RequestMethod.GET)
	public String itemsFiltered(
			@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "colour", required = false) String colour,
			@RequestParam(value = "featured", required = false) String featured,
			@RequestParam(value = "mostpopular", required = false) String mostPopular,
			@RequestParam(value = "wishlist", required = false) String wishlist,
			Model model) {
		ArrayList<Item> resultList = new ArrayList<Item>();
		
		//Change this once database connection exists
		String userID = "001";
		boolean searchCategory = false;
		boolean searchNameKey = false;
		boolean searchColour = false;
		if (category != null) {
			searchCategory = true;
		}
		if (search != null) {
			searchNameKey = true;
		}
		if (colour != null) {
			searchColour = true;
		}
		resultList = ItemDatabase.multiSearch(searchCategory, category,
				searchNameKey, search, searchColour, colour);
		if (featured != null) {
			resultList = ItemDatabase.featured();
		}
		if (mostPopular != null) {
			resultList = ItemDatabase.mostPopular();
		}
		if (wishlist != null) {
			resultList = ItemDatabase.wishlist(userID);
		}
		model.addAttribute("itemList", resultList);
		return "items";
	}
}
