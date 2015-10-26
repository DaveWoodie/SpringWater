package com.netbuilder.connections;

import java.util.List;

public class MongoDataTest {

	public static void main(String [] args) {
		MongoPull mp = new MongoPull();
		
		List<String> vals = mp.getWishList(3);
		
		for(String val : vals) {
			System.out.println(val);
		}
	}
}