package com.netbuilder.JMS;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

public class Sender{
	//Injects resources for a connection factory, queue, and topic
			@Resource(lookup = "jms/ConnectionFactory")
			private static ConnectionFactory connectionFactory;
			@Resource(lookup = "jms/Queue")private static Queue queue;
			@Resource(lookup = "jms/Topic")private static Topic topic;
			
	public void Main (String [] args) {
		
	
		//Retrieves and verifies command-line arguments that specify the destination type and the number of arguments
		final int NUM_MSGS;
		String destType = args[0];
		System.out.println("Destination type is " + destType);
		if ( ! ( destType.equals("queue") || destType.equals("topic") ) ) { 
		    System.out.println("Argument must be 'queue' or " + "'topic'");
		    System.exit(1);
		}
		if (args.length == 2){ 
		    NUM_MSGS = (new Integer(args[1])).intValue();
		} 
		else { 
		    NUM_MSGS = 1;
		}
		
		//Assigns either the queue or the topic to a destination object, based on the specified destination type
		
		Destination dest = null;
		try { 
		    if (destType.equals("queue")) { 
		        dest = (Destination) queue; 
		    } else { 
		        dest = (Destination) topic; 
		    }
		} 
		catch (Exception e) {
		    System.err.println("Error setting destination: " + e.toString()); 
		    e.printStackTrace(); 
		    System.exit(1);
		}
		
		//Creates a Connection and a Session
		Connection connection = null;
		try {
			connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//Creates a MessageProducer and a TextMessage
			MessageProducer producer = session.createProducer(dest);
			TextMessage message = session.createTextMessage();
			
			//Sends one or more messages to the destination
			for (int i = 0; i < NUM_MSGS; i++) { 
			    message.setText("This is message " + (i + 1) + " from producer"); 
			    System.out.println("Sending message: " + message.getText()); 
			    producer.send(message);
			}
			
			//Sends an empty control message to indicate the end of the message stream
			producer.send(session.createMessage());
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 finally { 
			    if (connection != null) { 
			        try { connection.close(); } 
			        catch (JMSException e) { } 
			    }
			}
		
	}
}
