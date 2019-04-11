package pl.spring.exercise.autowired.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

import pl.spring.exercise.autowired.service.EisenhowerToDoListStrategy;
import pl.spring.exercise.autowired.service.SecondTaskService;

@Configuration
@ImportResource("classpath:/pl/spring/exercise/autowired/config/beans.xml")
@ComponentScan
public class TaskConfig {
	
	@Bean
	public SecondTaskService secondTaskService() {
		return new SecondTaskService();
	}
	
	@Bean
	@Scope(value=BeanDefinition.SCOPE_PROTOTYPE)
	public EisenhowerToDoListStrategy doListStrategy() {
		return new EisenhowerToDoListStrategy();
	}
}
