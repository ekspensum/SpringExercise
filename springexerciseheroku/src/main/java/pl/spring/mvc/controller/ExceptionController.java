package pl.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
@PropertySource(value="classpath:/messages.properties")
public class ExceptionController {
	
	@Autowired
	private Environment env;

	@ExceptionHandler(Exception.class)
	public String handleException(Model model) {
		model.addAttribute("exception", "Wystapił wyjątek");
		return "handleError";
	}
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public String handleMaxUploadSizeExceededException(Model model) {
		model.addAttribute("msgExceedSizeFile", env.getProperty("msgExceedSizeFile"));
		return "handleError";
	}
}
