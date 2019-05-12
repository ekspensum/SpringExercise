package pl.spring.mvc.service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Service;

@Service
public class EmailContactService {

	@Size(min=2, max=30)
	@Pattern(regexp="^[^|'\":%^#~}{\\]\\[;=<>`]*$")
	private String subject;
	
	@Size(min=2, max=200)
	@Pattern(regexp="^[^|'\":%^#~}{\\]\\[;=<>`]*$")
	private String message;
	
	@Email
	@NotEmpty
	private String replyMail;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getReplyMail() {
		return replyMail;
	}
	public void setReplyMail(String replyMail) {
		this.replyMail = replyMail;
	}

}
