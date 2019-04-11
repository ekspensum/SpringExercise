package pl.spring.exercise.autowired.runner;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.spring.exercise.autowired.config.ConfigApp;
import pl.spring.exercise.autowired.config.TaskConfig;
import pl.spring.exercise.autowired.service.SecondTaskService;
import pl.spring.exercise.autowired.service.TaskService;
import pl.spring.exercise.autowired.model.Task;

public class RunnerClassAutowired {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
		TaskService taskService = context.getBean(TaskService.class);
		List<Task> list1 = taskService.findCurrentToDoList();
		System.out.println(list1);
		
		@SuppressWarnings("resource")
		ApplicationContext context2 = new ClassPathXmlApplicationContext("/pl/spring/exercise/autowired/config/app-context.xml");
		TaskService bean = context2.getBean(TaskService.class);
		List<Task> list2 = bean.findCurrentToDoList();
		System.out.println(list2);
		
		List<Task> findCurrentToDoListArray0 = taskService.findCurrentToDoListArray(0);
		System.out.println(findCurrentToDoListArray0);
		List<Task> findCurrentToDoListArray1 = taskService.findCurrentToDoListArray(1);
		System.out.println(findCurrentToDoListArray1);
		List<Task> findCurrentToDoListArray2 = taskService.findCurrentToDoListArray(2);
		System.out.println(findCurrentToDoListArray2);
		
		System.out.println(bean.getServiceId());
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TaskConfig.class);
		SecondTaskService bean2 = applicationContext.getBean(SecondTaskService.class);
		System.out.println(bean2.findCurrentToDoList());
	}

}
