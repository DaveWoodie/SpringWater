package com.netbuilder.DBConnector;


import com.netbuilder.entities.WishList;

public class MongoDataTest {

	public static void main(String [] args) {
		MongoPull mp = new MongoPull();
		
		WishList vals = mp.getWishList(3);
		
		vals.print();
	}
}