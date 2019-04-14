package pl.spring.exercise.javaconfig.runner;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.spring.exercise.javaconfig.config.ConfigApp;
import pl.spring.exercise.javaconfig.model.Task;
import pl.spring.exercise.javaconfig.service.TaskService;

public class RunnerClassJavaConfig {

        public static void main(String[] args) {

                @SuppressWarnings("resource")
                ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
                TaskService taskService = context.getBean(TaskService.class);

                List<Task> toDoList = taskService.findCurrentToDoList();
                System.out.println("First approach "+toDoList);

                List<Task> toDoListArray0 = taskService.findCurrentToDoListArray(0);
                System.out.println("Second approach 0 "+toDoListArray0);

                List<Task> toDoListArray1 = taskService.findCurrentToDoListArray(1);
                System.out.println("Second approach 1 "+toDoListArray1);

                List<Task> toDoListArray2 = taskService.findCurrentToDoListArray(2);
                System.out.println("Second approach 2 "+toDoListArray2);

                List<Task> toDoListOtherStrategy = taskService.getOtherStrategy().creteToDoListOtherStrategy();
                System.out.println(toDoListOtherStrategy);
        }

}

