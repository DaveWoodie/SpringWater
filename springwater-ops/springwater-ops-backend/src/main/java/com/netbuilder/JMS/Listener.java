/**
 * @author jforster
 * @date 27/10/15
 */
package com.netbuilder.JMS;

import java.util.ArrayList;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import entities.Item;
import entities.MessageContent;
import entities.PurchaseOrder;

import com.netbuilder.logic.PurchaseOrderBackendLogic;

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
            Destination destination = session.createTopic(boardName);

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
		ObjectMessage objectMessage = (ObjectMessage) message;
		try {
			if (objectMessage.getObject() instanceof MessageContent) {
				MessageContent messageContent = (MessageContent) objectMessage.getObject();
				if (messageContent.getMessage().equals("addItemToPurchaseOrder")) {
					System.out.println("received message");
					ArrayList<Object> object = (ArrayList<Object>) messageContent.getContents();
					PurchaseOrderBackendLogic pOBL = new PurchaseOrderBackendLogic();
					pOBL.addItemToPurchaseOrder((Item) object.get(0), (Integer) object.get(1));
				}
				else if (messageContent.getMessage().equals("calculateOrderQuantity")) {
					Item item = (Item) messageContent.getContents();
					PurchaseOrderBackendLogic pOBL = new PurchaseOrderBackendLogic();
					pOBL.calculateOrderQuantity(item);
				}
				else if (messageContent.getMessage().equals("sendPurchaseOrder")) {
					ArrayList<Object> object = (ArrayList<Object>) messageContent.getContents();
					PurchaseOrderBackendLogic pOBL = new PurchaseOrderBackendLogic();
					pOBL.sendPurchaseOrder((PurchaseOrder) object.get(0), (Integer) object.get(1));
				}
				else if (messageContent.getMessage().equals("receivePurchaseOrder")) {
					System.out.println("Received purchase order");
					ArrayList<Object> object = (ArrayList<Object>) messageContent.getContents();
					PurchaseOrderBackendLogic pOBL = new PurchaseOrderBackendLogic();
					pOBL.receivePurchaseOrder((PurchaseOrder) object.get(0), (Integer) object.get(1));
				}
				else if (messageContent.getMessage().equals("completePurchaseOrder")) {
					ArrayList<Object> object = (ArrayList<Object>) messageContent.getContents();
					PurchaseOrderBackendLogic pOBL = new PurchaseOrderBackendLogic();
					pOBL.completePurchaseOrder((PurchaseOrder) object.get(0), (Integer) object.get(1));
				}
			}
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
