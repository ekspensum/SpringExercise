package pl.spring.exercise.xmlconfig.runner;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.spring.exercise.xmlconfig.model.Task;
import pl.spring.exercise.xmlconfig.service.TaskService;

public class RunnerClassXmlConfig {

        public static void main(String[] args) {

                @SuppressWarnings("resource")
                ApplicationContext context = new ClassPathXmlApplicationContext("/pl/spring/exercise/xmlconfig/beans.xml");
                TaskService bean = context.getBean(TaskService.class);

                List<Task> list0 = bean.findCurrentToDoList(0);
                System.out.println(list0);
                List<Task> list1 = bean.findCurrentToDoList(1);
                System.out.println(list1);
                List<Task> list2 = bean.findCurrentToDoList(2);
                System.out.println(list2);
        }

}
