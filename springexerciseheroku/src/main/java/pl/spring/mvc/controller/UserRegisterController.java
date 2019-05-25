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
import org.springframework.web.bind.annotation.RequestParam;

import pl.spring.mvc.entity.User;
import pl.spring.mvc.service.UserRegisterService;

@Controller
@PropertySource(value = "classpath:/messages.properties")
public class UserRegisterController {

	@Autowired
	private UserRegisterService registerService;

	@RequestMapping(path = "/register")
	public String registration(User user, BindingResult result, Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("rolesList", registerService.getAllRoles());
		return "register";
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String register(@Valid User user, BindingResult result, @RequestParam("firstSelect") int idRole1, @RequestParam("secondSelect") int idRole2, Model model) {
		if (!result.hasErrors() && idRole1 != idRole2) {
			try {
				if (registerService.addUser(user, idRole1, idRole2)) {
					model.addAttribute("alert", "YES");
				} else {
					model.addAttribute("alert", "NO");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(idRole1 == idRole2) {
			model.addAttribute("msg", "Przyznawane role nie mogą być tkie same!");
		}
		model.addAttribute("rolesList", registerService.getAllRoles());
		return "register";
	}
}
