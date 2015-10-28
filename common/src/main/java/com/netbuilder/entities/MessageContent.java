/**
 * @author jforster
 * @date 28/10/2015
 */
package com.netbuilder.entities;

import java.io.Serializable;

/**
 * Class to configure objects to be sent as a message with an identifying string
 * @author jforster
 *
 */
public class MessageContent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object contents;
	private String message;
	
	public MessageContent(Object object, String string) {
		contents = object;
		message = string;
	}
	
	public Object getContents(){
		return contents;
	}
	
	public String getMessage(){
		return message;
	}
}
