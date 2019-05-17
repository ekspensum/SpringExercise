package pl.spring.mvc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.resource.transaction.spi.TransactionCoordinatorOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import pl.spring.mvc.model.Task;
import pl.spring.mvc.service.TaskService;

@Controller
@PropertySource(value="/static/properties/prompt.properties")
public class TaskController {

	@Autowired
	private Environment env;
	
	@Autowired
	private TaskService taskService;

	@RequestMapping(path = "/taskForm", method = RequestMethod.GET)
	public String showTaskForm(Model model) { 
		model.addAttribute("task", new Task());
		model.addAttribute("dateTimePrompt", env.getProperty("dateTimePrompt"));
		return "taskForm";
	}

	@RequestMapping(path = "/taskForm", method = RequestMethod.POST)
	public String processTask(@Valid Task task, BindingResult result, @RequestParam("image") MultipartFile file, Model model) {
		try {
			if (!result.hasErrors()) {
				task.setImage(file.getBytes());
				if (taskService.addTask(task)) {
					model.addAttribute("alert","YES");
				} else {
					model.addAttribute("alert", "NO");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "taskForm";
	}

	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}

//	@Override //implements HandlerExceptionResolver
//	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
//			Exception ex) {
////		It's working but after exceeds limit inputs form is cleaning  
//	    ModelAndView modelAndView = new ModelAndView("error");
//	    if (ex instanceof MaxUploadSizeExceededException) {
////	    	modelAndView.addObject(new Task());
//	        modelAndView.getModel().put("msgAddFile", "File size exceeds limit = 100000 B!");
//	    }
//	    return modelAndView;
//	}

}
