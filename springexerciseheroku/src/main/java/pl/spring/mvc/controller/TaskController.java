package pl.spring.mvc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import pl.spring.mvc.model.Task;
import pl.spring.mvc.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@RequestMapping(path = "/taskForm", method = RequestMethod.GET)
	public String showTaskForm(Model model) {
		model.addAttribute("task", new Task());
		return "taskForm";
	}
	
	@RequestMapping(path = "/taskForm", method = RequestMethod.POST)
	public String processTask(@Valid Task task, @RequestParam("image") MultipartFile file, BindingResult result) {
		result.hasErrors();
		try {
			task.setImage(file.getBytes());
			if(!result.hasErrors()) {
				taskService.addTask(task);
			}
		} catch (IOException e) {
			result.hasErrors();
			e.printStackTrace();
		}	
		return "redirect:/";
	}
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		dateFormat.setLenient(false);
//		binder.registerCustomEditor(Date.class, "dateTimeStart", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}
	

}