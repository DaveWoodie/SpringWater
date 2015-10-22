package com.netbuilder.DBConnector;

import java.util.ArrayList;
import java.util.List;

public class MongoDataTest {

	public static void main(String [] args) {
		MongoPull mp = new MongoPull();
		
		List<String> vals = mp.getAddress(3);
		
		for(String val : vals) {
			System.out.println(val);
		}
		
		//System.out.println(mp.canItBeParsed("Chris"));
	}
}
