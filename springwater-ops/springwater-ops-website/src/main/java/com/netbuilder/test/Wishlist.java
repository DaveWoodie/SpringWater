package com.netbuilder.test;

public class Wishlist {
	private Item item;
	private User user;
	
	public Wishlist(User user, Item item) {
		this.item = item;
		this.user = user;
	}
	
	public Item getItem() {
		return item;
	}
	
	public User getUser() {
		return user;
	}
}
