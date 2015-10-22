/**
 * 
 * @author chrisjwwalker
 * @date 22/10/2015
 * 
 */

package com.netbuilder.logic;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class EncryptPassword {

	private MessageDigest crypt;
	
	public EncryptPassword() {
		
	}
	
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
