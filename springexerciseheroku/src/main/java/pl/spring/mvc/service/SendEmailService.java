package pl.spring.mvc.service;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource(value="/static/properties/mail.properties")
public class SendEmailService {
	
	@Autowired
	private Environment env;
	
	private String mailFrom;
    private Properties props;
    private Session session;
    private MimeMessage msg;
    private String username;
    private String password;

    private void setEmailProperties() {
    	mailFrom = env.getProperty("mailFrom");
        props = new Properties();
        props.put("mail.smtp.auth", env.getProperty("mail.smtp.auth"));
        props.put("mail.smtp.starttls.enable", env.getProperty("mail.smtp.starttls.enable"));
        props.put("mail.smtp.host", env.getProperty("mail.smtp.host"));
        props.put("mail.smtp.ssl.trust", env.getProperty("mail.smtp.ssl.trust"));
        props.put("mail.smtp.port", env.getProperty("mail.smtp.port"));
        username = env.getProperty("mail_user");
        password = env.getProperty("mail_password");
	    session = Session.getInstance(props, new Authenticator() {
	    	@Override
	    	protected PasswordAuthentication getPasswordAuthentication() {
		    	// TODO Auto-generated method stub
		    	return new PasswordAuthentication(username, password);
	    }
		});
	    msg = new MimeMessage(session);
	}

    public boolean sendEmail(String mailTo, String mailSubject, String mailText, String replyMail) {		
    	try {
    		setEmailProperties();
			msg.setFrom(new InternetAddress(mailFrom));
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
    
    public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}
}
