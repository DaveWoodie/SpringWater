package com.netbuilder.JMS.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsReceiver 
{
	@Autowired
	ConfigurableApplicationContext context;
	
	@JmsListener(destination="destination", containerFactory = "jmsListenerContainerFactory")
	public void recieveMessage(String Message)
	{
		System.out.println("Received < " + Message + " >");
		context.close();
	}
	
}
	

