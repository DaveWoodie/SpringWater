package com.netbuilder.JMS;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;


public class Receiver implements MessageListener{
	
	public MessageConsumer consumer;
	private final String boardName = "IMS.IN";
	
	public Receiver() {
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
	
	@Override
	public void onMessage(Message message) {
		// TODO Handle inbound message types
		
	}

}
