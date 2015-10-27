package com.netbuilder.test;

import java.util.ArrayList;
/**
 * 
 * @author Chris Boucher
 * @date 20/10/2015
 *
 */
public class Item {
	private String itemName;
	private float price;
	private String imageLocation;
	private int rating;
	private String description;
	private String itemID;
	private String keyword;
	private ArrayList<Review> reviews;
	private String category;
	private String colour;

	public Item(String itemID, String itemName, float price,
			String imageLocation, int rating, String description,
			String category, String keyword, String colour) {
		this.itemName = itemName;
		this.price = price;
		this.imageLocation = imageLocation;
		this.rating = rating;
		this.description = description;
		this.itemID = itemID;
		this.category = category;
		this.keyword = keyword;
		this.colour = colour;
		reviews = new ArrayList<Review>();
	}

	public String getItemName() {
		return itemName;
	}

	public String getPrice() {
		return String.valueOf(price);
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public int getRating() {
		return rating;
	}

	public String getDescription() {
		return description;
	}

	public String getItemID() {
		return itemID;
	}

	public String getKeyword() {
		return keyword;
	}

	public void addReview(String author, int rating, String body) {
		reviews.add(new Review(author, rating, body));
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public String getCategory() {
		return category;
	}
	
	public String getColour() {
		return colour;
	}
}
