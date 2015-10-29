package email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public EmailService() {

	}


	/* 
	 * Send HTML mail (simple) 
	 */
	public static void Send(
			final String username, 
			final String password, 
			final String firstName,
			final String lastName,
			final String email,
			final String phone) throws AddressException, MessagingException {

		String line1 = firstName + " " + lastName + "<br>";
		String line2 = "Contact Details: " + email + " Phone: " + phone + "<br>";
		
		
		String messageBody = line1 + line2;
		
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "false");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("chrisofski@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("chrisofski@gmail.com"));
			message.setSubject("Order from" + firstName + " " + lastName + " @ " + email);
			message.setText(messageBody);
			
			Transport.send(message);
			
			System.out.println("Done");
			
		} catch(MessagingException e) {
			throw new RuntimeException(e);
		}	
	}
}