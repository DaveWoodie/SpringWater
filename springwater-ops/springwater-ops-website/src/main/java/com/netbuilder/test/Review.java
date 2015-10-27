package com.netbuilder.test;
/**
 * 
 * @author Chris Boucher
 * @date 23/10/2015
 *
 */
public class Review {

	private String author;
	private int rating;
	private String body;

	public Review(String author, int rating, String body) {
		this.author = author;
		this.rating = rating;
		this.body = body;
	}

	public String getAuthor() {
		return author;
	}

	public int getRating() {
		return rating;
	}

	public String getBody() {
		return body;
	}
}
