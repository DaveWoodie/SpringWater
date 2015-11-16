/**
 * 
 * @author chrisjwwalker
 * @date 22/10/2015
 * 
 */

package com.netbuilder.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class EncryptPassword {

	private MessageDigest crypt;
	
	public EncryptPassword() {
		
	}

	/**
	 *
	 * Method to convert a given string into SHA1 for comparison against SHA1 password stored in MySQL database
	 *
	 * @param passwordString: Takes on a string to convert into SHA1
	 * @return returns string encrypted in SHA1
	 */
	public String checkSHA1(String passwordString){
		
		try {
			crypt = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		crypt.reset();
		try {
			crypt.update(passwordString.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String sha1 = byteToHex(crypt.digest());
		
		return sha1;
	}
	
	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		
		for(byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}
}
