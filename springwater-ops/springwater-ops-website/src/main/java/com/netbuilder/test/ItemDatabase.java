package com.netbuilder.test;

import java.util.ArrayList;

public class ItemDatabase {

	static public ArrayList<Item> itemList;

	static public void fillDatabase() {
		itemList = new ArrayList<Item>();
		itemList.add(new Item(
				"Carbon Digging Spade",
				14.99f,
				"img/spearjackson.jpg",
				3,
				"Forged from heat-treated carbon steel for extra strength. Epoxy-coated head for improved resistance to rust, scratches, humidity and alkalines in the soil. With soft-grip, forward tilt handle giving the ideal digging angle."));
		itemList.add(new Item(
				"Neverbend Square Shovel",
				29.99f,
				"img/neverbend.jpg",
				2,
				"Square, open socket shovel. Hammer finish epoxy coated head for improved resistance to rust, scratches, humidity and alkalines in the soil. Weatherproofed hardwood shaft for greater durability. Supergrip handle - forward tilt gives the ideal digging angle. Treaded for more comfortable digging."));
		itemList.add(new Item("Happy Gnome", 11.99f, "img/happygnome.jpg", 4,
				"Beautifully hand decorated Standing Gnome Statuary for your yard or garden"));
		itemList.add(new Item(
				"Gnome With Mushroom",
				12.99f,
				"img/mushroomgnome.jpg",
				5,
				"Add color, spice and life to your outdoors with these cast stone resin gnome statuaries. These sturdy statuaries boast hues of blue, green and red. Made of Polyresin. Whimsical Gnome figures. Skillfully crafted to be balanced and durable."));
		itemList.add(new Item(
				"Gnome With Lantern",
				15.99f,
				"img/lanterngnome.jpg",
				4,
				"This wonderfully detailed garden gnome statue carries a lantern with an LED light. Made of cold cast resin, the gnome measures 17 inches tall, 8 inches wide and 6 inches deep. The lantern itself is 2 1/4 inches in diameter, 5 inches tall. He`s hand-painted, and shows great detail. The lantern runs on a pair of AA Batteries (not included). This statue makes a wonderful gift for any gnome collector."));
		itemList.add(new Item(
				"Gnome With Wheelbarrow",
				21.99f,
				"img/wheelbarrowgnome.jpg",
				4,
				"Our garden gnome is ready for his farmyard chores and he's even brought his trusty wheelbarrow to assist! Endowed with an oversized, pointed red gnome hat, this unique garden gnome statue promises to lend his magic to home or garden. Lovingly sculpted, then intricately cast in quality designer resin, this Design Toscano exclusive garden gnome sculpture is hand-painted one piece at a time exclusively by Toscano skilled gnome artisans. "));
		itemList.add(new Item("Gnome Triple Pack", 4.99f,
				"img/threegnomes.jpg", 5, "This set of 3 garden gnomes... Hear no evil... See no evil... Speak no evil garden gnomes are ready to be placed in your garden!  They are approx. 6 inches tall, made of polyresin, which is resistant to weather. Can be placed inside or for outside use! They are adorable, colorful, reds, greens and blues!  Just plain cute!!!"));
		itemList.add(new Item("Creepy Gnome", 3.99f, "img/creepygnome.jpg", 0, "I don't know what's in that moonshine, but it keeps him up all night. All the better to keep watch over your yard. "));
	}
}
