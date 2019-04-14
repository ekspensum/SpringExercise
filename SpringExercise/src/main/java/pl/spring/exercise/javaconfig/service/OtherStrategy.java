package pl.spring.exercise.javaconfig.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import pl.spring.exercise.javaconfig.model.Task;

@PropertySource("classpath:/pl/spring/exercise/javaconfig/config/some.properties")
public class OtherStrategy {

	@Autowired
	Environment env;

	public List<Task> creteToDoListOtherStrategy() {
		List<Task> toDoList = new ArrayList<Task>();
		toDoList.add(new Task(env.getProperty("number", Long.class)));
		toDoList.add(new Task(env.getProperty("number2", Long.class)));
		toDoList.add(new Task(3333L));
		return toDoList;
	}

}
