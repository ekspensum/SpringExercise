package pl.spring.mvc.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import pl.spring.mvc.service.EmailContactService;
import pl.spring.mvc.service.SendEmail;

@Controller
@PropertySource(value = "/static/properties/prompt.properties")
public class ContactController {

	@Autowired
	private Environment env;

	@Autowired
	private EmailContactService emailContactService;

	@Autowired
	private SendEmail sendEmail;

	@RequestMapping(path = "/contact")
	public String showContactPage(Model model) {
		model.addAttribute("emailContactService", emailContactService);
		model.addAttribute("messagePrompt", env.getProperty("messageContactForm"));
		model.addAttribute("subjectPrompt", env.getProperty("subjectContactForm"));
		model.addAttribute("replyMailPrompt", env.getProperty("replyMailContactForm"));
		return "contact";
	}

	@RequestMapping(path = "/contact", method = RequestMethod.POST)
	public String sendMessage(@Valid EmailContactService emailContactService, BindingResult result,
			@RequestParam("attachment") MultipartFile file, Model model) throws IOException {
		String mailText = emailContactService.getMessage() + "\n\n\n" + "Adres e-mail nadawcy: "
				+ emailContactService.getReplyMail() + "\n";
		if (!result.hasErrors()) {
			if (sendEmail.sendEmail(env, "testjava55@gmail.com", emailContactService.getSubject(), mailText,
					emailContactService.getReplyMail(), file.getBytes(), file.getOriginalFilename())) {
				model.addAttribute("alert", "YES");
			} else {
				model.addAttribute("alert", "NO");
			}
		}
		return "contact";
	}

	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}
}
