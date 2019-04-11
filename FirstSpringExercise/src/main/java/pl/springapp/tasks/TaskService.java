package pl.springapp.tasks;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@SomeService("nazwa serwisu")
@Component
public class TaskService {
	
	@Value("taskService#1")
	private String taskService;
	
	public String getServiceId() {
		return taskService;
	}

	public void setTaskService(String taskService) {
		this.taskService = taskService;
	}
	
	
}
