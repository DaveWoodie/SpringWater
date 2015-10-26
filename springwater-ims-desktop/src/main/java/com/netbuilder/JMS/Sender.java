package com.netbuilder.JMS;

import java.io.File;

import javax.faces.application.Application;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.FileSystemUtils;

@SpringBootApplication
@EnableJms
public class Sender {
	
	@Bean JmsListenerContainerFactory<?>
	myJmsContainerFactory(ConnectionFactory cF) {
	SimpleJmsListenerContainerFactory f = new
	SimpleJmsListenerContainerFactory();
	 f.setConnectionFactory(cF);
	 return f;
	}

	public static void main(String[] args) {
		//clean out any previous data from run
		FileSystemUtils.deleteRecursively(new File("activemq-data"));
		
		//launch application
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		//send message
		MessageCreator mC = new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("ping!");
			}
			
		};
		
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		System.out.println("Sending a new message");
		jmsTemplate.send("mailbox-destination", mC);
	}
	
}
