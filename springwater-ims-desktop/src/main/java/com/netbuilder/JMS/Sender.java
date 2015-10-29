/**
 * @author jforster
 * @date 27/10/15
 */
package com.netbuilder.JMS;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import entities.MessageContent;


/**
 * Class to create the JMS link and send a message containing any object
 * @author jforster
 *
 */
public class Sender{
	
	private final String boardName = "IMS.OUT";
	
	/**
	 * Method to create the parameters for sending an object to the system Backend
	 * @param toSend object that needs to be sent
	 */
	public void sendMessage(MessageContent toSend) {
		try {
            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://10.50.15.25:8081");

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue(boardName);

            // Create a MessageProducer from the Session to the Topic or Queue
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            // Create a messages
            ObjectMessage message = session.createObjectMessage((Serializable) toSend);

            // Tell the producer to send the message
            System.out.println("Sending Message...");
            producer.send(message);

            // Clean up
            session.close();
            connection.close();
        }
        catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
	}

}
