package com.netbuilder.test;

public class Item 
{
	private String itemName;
	private float price;
	private String imageLocation;
	private int rating;
	
	public Item(String itemName, float price, String imageLocation, int rating)
	{
		this.itemName = itemName;
		this.price = price;
		this.imageLocation = imageLocation;
		this.rating = rating;
	}
	
	public String getItemName()
	{
		return itemName;
	}
	
	public String getPrice()
	{
		return String.valueOf(price);
	}
	
	public String getImageLocation()
	{
		return imageLocation;
	}
	
	public int getRating()
	{
		return rating;
	}
}
