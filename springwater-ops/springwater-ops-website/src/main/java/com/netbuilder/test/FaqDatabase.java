package com.netbuilder.test;

import java.util.ArrayList;

/**
 * 
 * @author Chris Boucher
 * @date 27/10/2015
 *
 */
public class FaqDatabase {

	private static ArrayList<Faq> faqList = new ArrayList<Faq>();
	
	/**
	 * Fills the list with dummy data
	 */
	public static void fillDatabase() {
		faqList.add(new Faq("Who are NBGardens?","NBGardens are a traditional catalogue based company from the North-West of England. NBGardens sell garden "
				+ "products to our registered customers via phone, mail, and online. NB Gardens specialise in gnomes, gnome accessories "
				+ "and garden ornaments and we pride ourselves on the speed and quality of our services to our expanding customer base."));
		faqList.add(new Faq("What is the returns policy?","The returns policy is a hassle free way to return anything, so you can return any item "
				+ "to us within 28 days of receiving your original order, including sale items."));
		faqList.add(new Faq("I'm having technical difficulties","If you're having problems accessing our website, we suggest that you have the latest "
				+ "version of your operating system provider e.g. Windows, OSX etc."));
		faqList.add(new Faq("I have received an incorrect item in my order.","We want to sort out any issue with incorrect items straightaway. Please contact our Customer "
				+ "Care team with the order number amd the incorrect item's name and number."));
		faqList.add(new Faq("Have you received my returned items?","As soon as your return has been received and checked by our warehouse, we'll email "
				+ "you to let you know."));
	}
	
	public static ArrayList<Faq> getFaqList() {
		return faqList;
	}

}
