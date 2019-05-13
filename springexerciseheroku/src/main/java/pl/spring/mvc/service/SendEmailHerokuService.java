package pl.spring.mvc.service;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

//import com.sendgrid.Content;
//import com.sendgrid.Email;
//import com.sendgrid.Mail;
//import com.sendgrid.Method;
//import com.sendgrid.Request;
//import com.sendgrid.Response;
//import com.sendgrid.SendGrid;

@Service
@PropertySource(value="/static/properties/mail.properties")
//@Primary
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
	
	@Override
	public boolean sendEmail(Environment env, String mailTo, String mailSubject, String mailText, String replyMail, byte[] attachment, String fileName) {
		
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost(env.getProperty("mail.smtp.host"));
		javaMailSender.setPort(Integer.valueOf(env.getProperty("mail.smtp.port")));
		javaMailSender.setUsername(System.getenv("GMAIL_ID"));
		javaMailSender.setPassword(System.getenv("GMAIL_PASSWORD"));

		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable", env.getProperty("mail.smtp.starttls.enable"));
		javaMailProperties.put("mail.smtp.auth", env.getProperty("mail.smtp.auth"));
		javaMailProperties.put("mail.transport.protocol", env.getProperty("mail.transport.protocol"));
//		javaMailProperties.put("mail.debug", env.getProperty("mail.debug"));

		javaMailSender.setJavaMailProperties(javaMailProperties);
		
		MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setSubject(mailSubject);
                helper.setFrom(replyMail);
                helper.setTo(mailTo);
                helper.setText(mailText);
                helper.addAttachment(fileName, new ByteArrayResource(attachment));
			}
		};
		try {
			javaMailSender.send(messagePreparator);
		} catch (MailException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
