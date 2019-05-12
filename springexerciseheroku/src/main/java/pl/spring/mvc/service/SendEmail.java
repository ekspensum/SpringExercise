package pl.spring.mvc.service;

import org.springframework.core.env.Environment;

public interface SendEmail {

	boolean sendEmail(Environment env, String mailTo, String mailSubject, String mailText, String replyMail);
}
