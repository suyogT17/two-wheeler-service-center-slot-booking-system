package com.tsc.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class FeedbackEmailService {

	public static Boolean sendEmaill(String body,String subject,String emailId)
	{
		 final String username ="" ;
		 final String password ="";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(emailId));
			message.setSubject(subject);
			//message.setText("Dear Mail Crawler,"
			//	+ "\n\n No spam to my email, please!");
			message.setContent(
		              body,
		             "text/html");

			Transport.send(message);
			System.out.println("Done");
			return true;
			

		} catch (MessagingException e) {
			return false;
			
		
		}
	}
}

