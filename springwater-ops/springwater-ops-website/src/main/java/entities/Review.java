package entities;

import java.io.Serializable;

/**
 * 
 * @author Chris Boucher
 * @date 23/10/2015
 *
 */
public class Review implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public void print() {
		System.out.println("Author: "+author);
		System.out.println("Rating: "+rating);
		System.out.println("Body: "+body);
	}
}
