package com.netbuilder.DBConnector;

public class MongoDataTest {

	public static void main(String [] args) {
		MongoPull mp = new MongoPull();
		
		mp.find("Address", "idAddress","0.0", "","");
	}
}