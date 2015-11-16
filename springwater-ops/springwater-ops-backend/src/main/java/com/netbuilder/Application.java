/**
 * @author jforster
 * @date 27/10/15
 */

package com.netbuilder;

import org.apache.activemq.broker.BrokerService;
import com.netbuilder.jms.Listener;


/**
 * Class to run the JMS communication server hub
 * @author jforster
 *
 */
public class Application {
	
	/**
	 * Method to run the broker server and start up the listeners for the IMS and the WebApp
	 * @param args
	 */
	public static void main(String[] args){
		BrokerService broker = new BrokerService();
		 
		// configure the broker
		try {
			broker.addConnector("tcp://10.50.15.30:8081");
			broker.start();
			
			//configure IMS listener
			Listener listenerIMS = new Listener ("IMS.OUT");
			listenerIMS.consumer.setMessageListener(listenerIMS);
			
			//configure WebApp listener
			Listener listenerWeb = new Listener ("WEB.OUT");
			listenerWeb.consumer.setMessageListener(listenerWeb);
			
			//configure WOTS listener
			Listener listenerWOTS = new Listener ("WOTS.OUT");
			listenerWOTS.consumer.setMessageListener(listenerWOTS);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}