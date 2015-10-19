package demo;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

@SpringBootApplication
@EnableJms
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		MessageCreator messageCreator = new MessageCreator() {
			@Override
			public Message createMessage(Session arg0) throws JMSException {
				return arg0.createTextMessage("Happy Birthday World!");
			}
		};
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		System.out.println("Sending a message!");
		jmsTemplate.send("jeff", messageCreator);
	}
}