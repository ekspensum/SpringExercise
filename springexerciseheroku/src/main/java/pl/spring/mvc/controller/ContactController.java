package pl.spring.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.spring.mvc.service.EmailContactService;
import pl.spring.mvc.service.SendEmailService;

@Controller
@PropertySource(value="/static/properties/prompt.properties")
public class ContactController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private EmailContactService emailContactService;
	
	@Autowired
	private SendEmailService sendEmailService;

	@RequestMapping(path="/contact")
	public String showContactPage(Model model) {
		model.addAttribute("emailContactService", emailContactService);
		model.addAttribute("messagePrompt", env.getProperty("messageContactForm"));
		model.addAttribute("subjectPrompt", env.getProperty("subjectContactForm"));
		model.addAttribute("replyMailPrompt", env.getProperty("replyMailContactForm"));
		return "contact";	
	}
	
	@RequestMapping(path="/contact", method=RequestMethod.POST)
	public String sendMessage(@Valid EmailContactService emailContactService, BindingResult result, Model model) {
		String mailText = "<font color='blue' size='3'>"
				+ emailContactService.getMessage()
				+ "<br><br><br>"
				+ "Adres e-mail nadawcy: "+emailContactService.getReplyMail() + "\n"
				+ "</font><br><br>";
		if(!result.hasErrors()) {
			if(sendEmailService.sendEmail("testjava55@gmail.com", emailContactService.getSubject(), mailText, emailContactService.getReplyMail())) {
				model.addAttribute("alert","YES");
			} else {
				model.addAttribute("alert", "NO");
			}
		}
		return "contact";
	}
}
