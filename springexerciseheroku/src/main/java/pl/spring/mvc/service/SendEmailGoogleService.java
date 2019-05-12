package pl.spring.mvc.service;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource(value="/static/properties/mail.properties")
//@Primary
public class SendEmailGoogleService implements SendEmail {
	
    public boolean sendEmail(Environment env, String mailTo, String mailSubject, String mailText, String replyMail) {	
    	
    	Properties props = new Properties();
        props.put("mail.smtp.auth", env.getProperty("mail.smtp.auth"));
        props.put("mail.smtp.starttls.enable", env.getProperty("mail.smtp.starttls.enable"));
        props.put("mail.smtp.host", env.getProperty("mail.smtp.host"));
        props.put("mail.smtp.ssl.trust", env.getProperty("mail.smtp.ssl.trust"));
        props.put("mail.smtp.port", env.getProperty("mail.smtp.port"));

        Session session = Session.getInstance(props, new Authenticator() {
	    	@Override
	    	protected PasswordAuthentication getPasswordAuthentication() {
		    	return new PasswordAuthentication(env.getProperty("mail_user"), env.getProperty("mail_password"));
	    }
		});
        
        MimeMessage msg = new MimeMessage(session);
    	try {
    		msg.setFrom(new InternetAddress(env.getProperty("mailFrom")));
			msg.setRecipients(Message.RecipientType.TO, mailTo);
			msg.setSubject(mailSubject);
			msg.setText(mailText, "UTF-8", "html");
			Address[] replyAddress = InternetAddress.parse(replyMail);
			msg.setReplyTo(replyAddress);
			msg.setSender(new InternetAddress(replyMail));
			Transport.send(msg);
			return true;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;   	
    }

}
