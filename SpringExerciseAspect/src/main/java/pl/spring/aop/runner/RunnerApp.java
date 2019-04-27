package pl.spring.aop.runner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.spring.aop.config.ConfigApp;
import pl.spring.aop.service.TaskService;

public class RunnerApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
		TaskService bean = context.getBean(TaskService.class);
		bean.getAllTasks();
		bean.getTask(22);
		
		context.close();
	}

}
