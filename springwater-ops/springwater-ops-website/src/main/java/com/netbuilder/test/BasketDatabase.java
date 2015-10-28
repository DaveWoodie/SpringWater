package com.netbuilder.test;

import java.util.ArrayList;

/**
 * 
 * @author Callum Cooper
 * @date 27/10/2015
 * @description Dummy database for items held in the basket
 * @LastModified 27/10/2015
 *
 */

public class BasketDatabase {
	
	// Basket Database Attributes
	static public ArrayList<Item> itemList;

	static public void fillDatabase() {
		itemList = new ArrayList<Item>();
		itemList.add(new Item(
				"0001",
				"Carbon Digging Spade",
				14.99f,
				"img/spearjackson.jpg",
				3,
				"Forged from heat-treated carbon steel for extra strength. Epoxy-coated head for improved resistance to rust, scratches, humidity and alkalines in the soil. With soft-grip, forward tilt handle giving the ideal digging angle.",
				"Tool", "Spade", "Grey"));
		itemList.get(0)
				.addReview(
						"gn0m3luvv3r",
						3,
						"I was told that the Spear & Jackson Carbon Digging Spade would be microwave safe, but it turns out it does not fit in my microwave at all! Unless you have an industrial microwave, this may not be the spade for you");
		itemList.get(0)
				.addReview("iGARDEN", 2,
						"It's alright but at the end of the day it's just a spade really...");
		itemList.get(0).addReview("xXspearjacksonXx", 5,
				"WOW. BRILLIANT. BEST SPADE EVER.");
		itemList.add(new Item(
				"0002",
				"Neverbend Square Shovel",
				29.99f,
				"img/neverbend.jpg",
				4,
				"Square, open socket shovel. Hammer finish epoxy coated head for improved resistance to rust, scratches, humidity and alkalines in the soil. Weatherproofed hardwood shaft for greater durability. Supergrip handle - forward tilt gives the ideal digging angle. Treaded for more comfortable digging.",
				"Tool", "Spade", "Grey"));
		itemList.get(1).addReview("spadeyboiii", 0,
				"It's not so hip to be square with this poorly crafted spade");
		itemList.get(1).addReview("luvmeshrubs", 0,
				"The worst spade I have ever purchased.");
		itemList.get(1).addReview("luvmeshrubs", 0, "Not good at all.");
		itemList.get(1).addReview("xXspearjacksonXx", 5,
				"WOW. BRILLIANT. BEST SPADE EVER.");
		itemList.get(1).addReview("xXspearjackson2Xx", 5,
				"WOW. BRILLIANT. BEST SPADE EVER.");
		itemList.get(1).addReview("xXspearjackson3Xx", 5,
				"WOW. BRILLIANT. BEST SPADE EVER.");
		itemList.get(1).addReview("xXspearjackson4Xx", 5,
				"WOW. BRILLIANT. BEST SPADE EVER.");
		itemList.get(1).addReview("xXspearjackson5Xx", 5,
				"WOW. BRILLIANT. BEST SPADE EVER.");
		itemList.get(1).addReview("xXspearjackson6Xx", 5,
				"WOW. BRILLIANT. BEST SPADE EVER.");
		itemList.add(new Item(
				"0003",
				"Happy Gnome",
				11.99f,
				"img/happygnome.jpg",
				4,
				"Beautifully hand decorated Standing Gnome Statuary for your yard or garden",
				"Gnome", "Gnome", "Green"));
		itemList.get(2).addReview("gn0meconnoisseur", 4,
				"I give this gnome a 4/5");
		itemList.get(2).addReview("iLUVGNOMEZ", 4, "Smashing gnome lads.");
		itemList.add(new Item(
				"0004",
				"Gnome With Mushroom",
				12.99f,
				"img/mushroomgnome.jpg",
				5,
				"Add color, spice and life to your outdoors with these cast stone resin gnome statuaries. These sturdy statuaries boast hues of blue, green and red. Made of Polyresin. Whimsical Gnome figures. Skillfully crafted to be balanced and durable.",
				"Gnome", "Gnome", "Green"));
		itemList.get(3).addReview("gn0meconnoisseur", 5,
				"I give this gnome a 5/5");
		itemList.get(3).addReview("gnometorious", 5, "I love a good mushroom!");
		itemList.add(new Item(
				"0005",
				"Gnome With Lantern",
				15.99f,
				"img/lanterngnome.jpg",
				4,
				"This wonderfully detailed garden gnome statue carries a lantern with an LED light. Made of cold cast resin, the gnome measures 17 inches tall, 8 inches wide and 6 inches deep. The lantern itself is 2 1/4 inches in diameter, 5 inches tall. He`s hand-painted, and shows great detail. The lantern runs on a pair of AA Batteries (not included). This statue makes a wonderful gift for any gnome collector.",
				"Gnome", "Gnome", "Blue"));
		itemList.get(4).addReview("gn0meconnoisseur", 4,
				"I give this gnome a 4/5");
		itemList.get(4).addReview("gardenblitz", 4, "4 stars.");
		itemList.add(new Item(
				"0006",
				"Gnome With Wheelbarrow",
				21.99f,
				"img/wheelbarrowgnome.jpg",
				4,
				"Our garden gnome is ready for his farmyard chores and he's even brought his trusty wheelbarrow to assist! Endowed with an oversized, pointed red gnome hat, this unique garden gnome statue promises to lend his magic to home or garden. Lovingly sculpted, then intricately cast in quality designer resin, this Design Toscano exclusive garden gnome sculpture is hand-painted one piece at a time exclusively by Toscano skilled gnome artisans. ",
				"Gnome", "Gnome", "Blue"));
		itemList.get(5).addReview("gn0meconnoisseur", 3,
				"I give this gnome a 3/5");
		itemList.get(5).addReview("wheelbarrowKING", 4, "Wheely good");
		itemList.get(5).addReview("johnwheelbarrowman", 5,
				"Another top gnome to add to my wheelbarrow gnome collection.");
		itemList.add(new Item(
				"0007",
				"Gnome Triple Pack",
				4.99f,
				"img/threegnomes.jpg",
				5,
				"This set of 3 garden gnomes... Hear no evil... See no evil... Speak no evil garden gnomes are ready to be placed in your garden!  They are approx. 6 inches tall, made of polyresin, which is resistant to weather. Can be placed inside or for outside use! They are adorable, colorful, reds, greens and blues!  Just plain cute!!!",
				"Gnome", "Gnome", "Red"));
		itemList.get(6).addReview("gn0meconnoisseur", 4,
				"I give this gnome a 5/5");
		itemList.get(6).addReview("gnorman", 5,
				"Three cheeky chaps, what could go wrong?!");
		itemList.get(6).addReview("pondLAD", 3,
				"I lost one of my gnomes in the pond.");
		itemList.add(new Item(
				"0008",
				"Creepy Gnome",
				3.99f,
				"img/creepygnome.jpg",
				0,
				"I don't know what's in that moonshine, but it keeps him up all night. All the better to keep watch over your yard. ",
				"Gnome", "Gnome", "Green"));
		itemList.get(7).addReview("gn0meconnoisseur", 0,
				"I give this gnome a 0/5");
		itemList.get(7).addReview("sp00kyGn0m3", 0, "What the hell is this?!!");
		itemList.add(new Item("0009", "Large Brown Pot", 8.99f,
				"img/pot01.jpg", 5,
				"A large brown pot made of only the finest clay.", "Pottery",
				"Pot", "Red"));
		itemList.get(8).addReview("pottymouth", 5, "Just what I needed!");
		itemList.get(8).addReview("potsRus", 5, "Top pot for a top lad.");
		itemList.add(new Item("0010", "Large Striped Pot", 8.99f,
				"img/pot02.JPG", 5,
				"A large striped pot made of only the finest clay.", "Pottery",
				"Pot", "Red"));
		itemList.get(9).addReview("potsmouth", 5, "Just what I needed!");
		itemList.get(9).addReview("XxxxxxxPOTxxxxxxX", 5,
				"Top pot for a top lad.");
		itemList.add(new Item(
				"0011",
				"Jacuzzi 5000",
				4999.99f,
				"img/jacuzzi01.png",
				5,
				"Contains a special button that allows the user to charge their phone using the bubbles. Only works once per jacuzzi.",
				"Furniture", "Jacuzzi", "White"));
		itemList.get(10).addReview("fam0uslastw0rdz", 5,
				"I think I will try the phone charger tonight. Wish me luck.");
		itemList.add(new Item(
				"0012",
				"Jacuzzi 5001",
				8999.99f,
				"img/jacuzzi02.jpg",
				0,
				"This superior quality hot tub is ideal for 6-7 people great for parties or just relaxing in the full length lounger position and is the ultimate entertainment tub with cool features like the corner Ice Bucket there are no other hot tubs available on the market that compares with the amount of features and the quality offered by this fantastic spa.",
				"Furniture", "Jacuzzi", "Grey"));
		itemList.get(11).addReview("loveAgoodDuck", 0,
				"Doesn't come with a rubber duck. 0/5");
	}

	static public Item searchID(String search) {
		for (Item item : itemList) {
			if (item.getItemID().equals(search)) {
				return item;
			}
		}
		return null;
	}

	static public ArrayList<Item> searchKeyword(String search) {
		ArrayList<Item> resultList = new ArrayList<Item>();
		for (Item item : itemList) {
			if (item.getKeyword().equals(search)) {
				resultList.add(item);
			}
		}
		return resultList;
	}

	static public ArrayList<Item> searchCategory(String search) {
		ArrayList<Item> resultList = new ArrayList<Item>();
		for (Item item : itemList) {
			if (item.getCategory().equals(search)) {
				resultList.add(item);
			}
		}
		return resultList;
	}

	static public ArrayList<Item> multiSearch(boolean searchCategory,
			String category, boolean searchNameKey, String nameKey,
			boolean searchColour, String colour) {
		ArrayList<Item> resultList = new ArrayList<Item>();
		for (Item item : itemList) {
			boolean addCat = true;
			boolean addNameKey = true;
			boolean addColour = true;
			if (searchCategory) {
				if (item.getCategory().equals(category)) {
					addCat = true;
				} else {
					addCat = false;
				}
			}
			if (searchNameKey) {
				if (item.getItemName().toLowerCase().contains(nameKey.toLowerCase())
						|| item.getKeyword().toLowerCase().contains(nameKey.toLowerCase())) {
					addNameKey = true;
				} else {
					addNameKey = false;
				}
			}
			if (searchColour) {
				if (item.getColour().contains(colour)) {
					addColour = true;
				} else {
					addColour = false;
				}
			}
			if (addCat && addNameKey && addColour) {
				resultList.add(item);
			}
		}
		return resultList;
	}
	
	static public ArrayList<Item> mostPopular() {
		// Query sales data
		ArrayList<Item> popularList = new ArrayList<Item>();
		popularList.add(itemList.get(0));
		popularList.add(itemList.get(2));
		popularList.add(itemList.get(4));
		popularList.add(itemList.get(6));
		popularList.add(itemList.get(8));
		popularList.add(itemList.get(10));
		return popularList;
	}
	
	static public ArrayList<Item> featured() {
		// Query featured data
		ArrayList<Item> featuredList = new ArrayList<Item>();
		featuredList.add(itemList.get(1));
		featuredList.add(itemList.get(3));
		featuredList.add(itemList.get(5));
		featuredList.add(itemList.get(7));
		featuredList.add(itemList.get(9));
		featuredList.add(itemList.get(11));
		return featuredList;
	}
	
	static public ArrayList<Item> basket(String userID) {
		// Query featured data
		ArrayList<Item> basket = new ArrayList<Item>();
		basket.add(itemList.get(2));
		basket.add(itemList.get(5));
		basket.add(itemList.get(6));
		basket.add(itemList.get(9));
		basket.add(itemList.get(1));
		basket.add(itemList.get(3));
		return basket;
	}
}