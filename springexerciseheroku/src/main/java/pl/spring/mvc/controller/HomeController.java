package pl.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.spring.mvc.model.Task;
import pl.spring.mvc.service.TaskService;

@Controller
public class HomeController {
	
	@Autowired
	private TaskService taskService;


	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) {
		List<Task> taskList = taskService.getAllTasks();
		model.addAttribute("taskList", taskList);
		return "home";
	}
	

}

