package pl.spring.mvc.service;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

@Service
@PropertySource(value="/static/properties/mail.properties")
@Primary
public class SendEmailHerokuService implements SendEmail {

//	@Override
//	public boolean sendEmail(Environment env, String mailTo, String mailSubject, String mailText, String replyMail) {
//	    Email from = new Email("test@example.com");
//	    String subject = "Hello World from the SendGrid Java Library!";
//	    Email to = new Email("test@example.com");
//	    Content content = new Content("text/plain", "Hello, Email!");
//	    Mail mail = new Mail(from, subject, to, content);
//
//	    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
//	    Request request = new Request();
//	    try {
//	      request.setMethod(Method.POST);
//	      request.setEndpoint("mail/send");
//	      request.setBody(mail.build());
//	      Response response = sg.api(request);
//	      System.out.println(response.getStatusCode());
//	      System.out.println(response.getBody());
//	      System.out.println(response.getHeaders());
//	    } catch (IOException ex) {
//	      try {
//			throw ex;
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    }
//		return false;
//	}
	
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
		    	return new PasswordAuthentication(System.getenv("GMAIL_ID"), System.getenv("GMAIL_PASSWORD"));
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
