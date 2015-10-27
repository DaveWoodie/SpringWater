/**
 * @author jforster
 * @date 27/10/15
 */
package com.netbuilder.JMS;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Class to generate listeners for the other components of the application
 * @author jforster
 *
 */
public class Listener implements MessageListener{
	
	private final String boardName;
	public MessageConsumer consumer;
	
	/**
	 * Method to create the listener based on target component of the application
	 * @param targetSystem string board identifier for messages from the component
	 */
	public Listener (String targetSystem) {
		
		boardName = targetSystem;
		
		try {
			 
            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:8081");

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue(boardName);

            // Create a MessageConsumer from the Session to the Topic or Queue
            consumer = session.createConsumer(destination);
		}
		catch (Exception e) {
			
		}
	}
	
	/**
	 * Method to manage the response on receiving a message via listener
	 */
	@Override
	public void onMessage(Message message) {
		// TODO handle message type
		
	}

}