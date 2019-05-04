package pl.spring.mvc.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	private TaskService task;


	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("dateTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
		List<Task> taskList = task.getAllTasks();
		model.addAttribute("taskList", taskList);
		return "index";
	}
	

}

