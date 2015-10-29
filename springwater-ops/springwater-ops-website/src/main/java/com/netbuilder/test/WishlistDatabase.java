package com.netbuilder.test;

import java.util.ArrayList;

public class WishlistDatabase {
	static public ArrayList<Wishlist> wishlistList;

	static public void fillDatabase() {
		wishlistList = new ArrayList<Wishlist>();
		wishlistList.add(new Wishlist(UserDatabase.userList.get(0),
				ItemDatabase.itemList.get(0)));
		wishlistList.add(new Wishlist(UserDatabase.userList.get(0),
				ItemDatabase.itemList.get(3)));
		wishlistList.add(new Wishlist(UserDatabase.userList.get(0),
				ItemDatabase.itemList.get(4)));
		wishlistList.add(new Wishlist(UserDatabase.userList.get(0),
				ItemDatabase.itemList.get(5)));
	}

	static public ArrayList<Item> getUserWishlistItems(User user) {
		ArrayList<Item> results = new ArrayList<Item>();
		for (Wishlist wishlist : wishlistList) {
			if (wishlist.getUser().equals(user)) {
				results.add(wishlist.getItem());
			}
		}
		return results;
	}

	static public void removeWishline(Wishlist wishlist) {
		Wishlist toDelete = null;
		for (Wishlist listItem : wishlistList) {
			if (listItem.getUser().getCustomerID() == wishlist.getUser()
					.getCustomerID()
					&& listItem.getItem().getItemID()
							.equals(wishlist.getItem().getItemID())) {
				toDelete = listItem;
			}
		}
		wishlistList.remove(toDelete);
	}
	
	static public void addWishline(User user, Item item) {
		wishlistList.add(new Wishlist(user,item));
	}
	
	static public boolean itemExists(Wishlist wishlist) {
		for (Wishlist listItem : wishlistList) {
			if (listItem.getUser().getCustomerID() == wishlist.getUser()
					.getCustomerID()
					&& listItem.getItem().getItemID()
							.equals(wishlist.getItem().getItemID())) {
				return true;
			}
		}
		return false;
	}
}
