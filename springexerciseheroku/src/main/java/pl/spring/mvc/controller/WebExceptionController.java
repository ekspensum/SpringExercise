package pl.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PropertySource(value = "classpath:/messages.properties")
public class WebExceptionController {

	@Autowired
	private Environment env;
	
	@RequestMapping(path = "/40333333")
	public String get403(Model model) {
		model.addAttribute("exeption", env.getProperty("accessDenied"));
		return "handleError";
	}
}
