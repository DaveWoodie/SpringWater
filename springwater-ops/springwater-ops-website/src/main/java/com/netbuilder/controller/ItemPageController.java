package com.netbuilder.controller;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.netbuilder.test.*;

import entities.Review;
/**
 * 
 * @author Chris Boucher
 * @date 23/10/2015
 *
 */
@Controller
@RequestMapping("/itempage")
public class ItemPageController {

	@RequestMapping(method = RequestMethod.GET)
	public String getItem(@RequestParam(value = "itemid", required = false) String itemID,
			Model model) {
		
		Item result = ItemDatabase.searchID(itemID);
		
		// IF the item exists
		if(result != null) {
			
			// Get related Items
			ArrayList<Item> resultList = ItemDatabase.searchKeyword(result.getKeyword());
			ArrayList<Item> relatedList = new ArrayList<Item>();
			int deleteIndex = 0;
			for(Item item : resultList)	{
				if(item.getItemID().equals(result.getItemID()))	{
					deleteIndex = resultList.indexOf(item);
				}
			}
			resultList.remove(deleteIndex);
			Random rand = new Random();
			int index = rand.nextInt(resultList.size());
			relatedList.add(resultList.get(index));
			index = rand.nextInt(resultList.size());
			relatedList.add(resultList.get(index));
			index = rand.nextInt(resultList.size());
			relatedList.add(resultList.get(index));
			index = rand.nextInt(resultList.size());
			relatedList.add(resultList.get(index));
			
			// Get the reviews for the item
			ArrayList<Review> reviewList = result.getReviews();
			
			// Add the data to the web page
			model.addAttribute("item", result);
			model.addAttribute("relatedList", relatedList);
			model.addAttribute("reviewList", reviewList);
			return "itemPage";
		}
		
		// Return an error page
		else
		{
			return "errorPage";
		}
	}
}
