package pl.spring.exercise.javaconfig.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import pl.spring.exercise.javaconfig.service.DefaultToDoListStrategy;
import pl.spring.exercise.javaconfig.service.EisenhowerToDoListStrategy;
import pl.spring.exercise.javaconfig.service.OtherStrategy;
import pl.spring.exercise.javaconfig.service.RandomToDoListStrategy;
import pl.spring.exercise.javaconfig.service.TaskService;
import pl.spring.exercise.javaconfig.service.ToDoListStrategy;

@Configuration
@PropertySource("classpath:/pl/spring/exercise/javaconfig/config/some.properties")
public class ConfigApp {
	
	@Autowired
	Environment env;
	
	@Bean
	public OtherStrategy otherStrategy() {
		return new OtherStrategy();
	}

	@Bean
	public TaskService taskService() {
		return new TaskService();
	}

	@Bean
//	@Qualifier
	public ToDoListStrategy eisenhowerToDoListStrategy() {
		return new EisenhowerToDoListStrategy();
	}

	@Bean
//	@Qualifier
	public ToDoListStrategy defaultToDoListStrategy() {
		return new DefaultToDoListStrategy();
	}

	@Bean
	@Qualifier("first approach")
//	@Qualifier
	public ToDoListStrategy randomToDoListStrategy() {
		System.out.println("Property number: "+env.getProperty("number"));
		System.out.println("Property number: "+env.getProperty("number2"));
		return new RandomToDoListStrategy();
	}

}
