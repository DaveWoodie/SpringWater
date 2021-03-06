/**
 * @author dwoodward
 * @date 29/10/2015
 * 
 * Class to convert between the item type the website uses and the item type the IMS uses.
 */

package com.netbuilder.service;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Random;
import com.netbuilder.entities.Review;

//import entities.Review;

public class ItemConverter {
	
	private com.netbuilder.test.Item webItem;
//	private entities.Item entItem;
	
	private Random r = new Random();
	
	public ItemConverter() {
	
	}
	
	public com.netbuilder.test.Item convertToWebItem(com.netbuilder.entities.Item i) {
		
		String name = i.getItemName();
		float price = i.getPrice();
		
		String imageLoc = "img/" + i.getImageLocation();
		
		int starRating = 1 + r.nextInt(4);
		
		String description = i.getDescription();
		
		String id = "" + i.getIdItem();
		
		String category = i.getAttribute("Category");
		
		String keyword = i.getAttribute("Keyword");
		System.out.println(keyword);

		String colour = i.getAttribute("Color");
		
		
		webItem = new com.netbuilder.test.Item(id, name, price, imageLoc, starRating, description, category, keyword, colour);
		
		ArrayList<Review> revs = i.getReviews();
		for(Review r : revs) {
			webItem.addReview(r.getAuthor(), r.getRating(), r.getBody());
		}
		return webItem;
	}
	
//	public entities.Item convertToJavaItem(com.netbuilder.test.Item i){
//	
//		int id = Integer.parseInt(i.getItemID().trim());
//		String name = i.getItemName();
//		float price = i.getPrice();
//		String itemLoc = i.getImageLocation();
//		int rating  = i.getRating();
//		String descrip = i.getDescription();
//		
//		ArrayList<Review> rev = i.getReviews();
//		
//		entItem = new entities.Item(name, descrip, price, cost, int stock, String imageLocation, boolean discontinued, boolean isPorousware, int idSupplier, int salesRate, int pSalesRate, ArrayList<Review> reviews);
//		return entItem;
//	}
}
