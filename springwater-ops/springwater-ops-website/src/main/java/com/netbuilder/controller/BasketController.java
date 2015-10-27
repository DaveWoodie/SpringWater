//Author: Callum Cooper
//Date: 27/10/2015
//Description: Controller for the basket.
//Last Modified: 27/10/2015

package com.netbuilder.controller;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;

import com.netbuilder.test.Item;
import com.netbuilder.test.ItemDatabase;
import com.netbuilder.test.Review;

@Controller
public class BasketController {
	
	@RequestMapping(value = "/basketpage+*", method = RequestMethod.GET)
	public String getItemInBasket(HttpServletRequest request, Model model) {
		
		// Get current URL and compare to database
		String url = (String) request
				.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String search = url.replace("/basketpage+", "");
		Item result = ItemDatabase.searchID(search);
		
		// IF the item exists
				if(result != null) {
					
					// Get related Items
					ArrayList<Item> resultList = ItemDatabase.searchKeyword(result.getKeyword());
					ArrayList<Item> relatedList = new ArrayList<Item>();
					int deleteIndex = 0;
					for(Item item : resultList)
					{
						if(item.getItemID().equals(result.getItemID()))
						{
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
