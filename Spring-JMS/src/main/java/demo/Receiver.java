package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	@Autowired
	ConfigurableApplicationContext applicationContext;
	
	@JmsListener(destination="jeff", containerFactory = "jmsListenerContainerFactory")
	public void receveMyMessage(String message) {
		System.out.println("Here is your message: <" + message + ">");
		applicationContext.close();
	}
}
