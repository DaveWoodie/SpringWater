package email;

import java.security.Security;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.TemplateResolver;

import com.sun.mail.smtp.SMTPTransport;

@Service
public class EmailService {

	private JavaMailSender mailSender;
	
	private JavaMailSenderImpl jmsi = new JavaMailSenderImpl();

	private TemplateEngine templateEngine = new TemplateEngine();

	public EmailService() {

	}


	/* 
	 * Send HTML mail (simple) 
	 */
	public static void Send(final String username, final String password, String recipientEmail) throws AddressException, MessagingException {

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "false");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("chrisofski@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("chrisofski@gmail.com"));
            message.setSubject("Testing Message!");
            message.setText("Test Message!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}