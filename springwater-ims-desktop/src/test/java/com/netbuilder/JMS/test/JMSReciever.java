package com.netbuilder.JMS.test;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

@Component
public class JMSReciever 
{
	/**
	 * Get a copy of the application context
	 */
	@Autowired
	ConfigurableApplicationContext context;
	
	@JmsListener(destination="destination", containerFactory = "myJMSContainerFactory")
	public void recieveMessage(String Message)
	{
		System.out.println("Received < " + Message + " >");
		context.close();
		FileSystemUtils.deleteRecursively(new File("file name"));
	}
	
}
	

