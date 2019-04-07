package pl.springapp.tasks.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.springapp.tasks.ExampleService;
import pl.springapp.tasks.TaskService;

@Configuration
public class AppConfig {

        @Bean
        public TaskService taskService() {
                return new TaskService();
        }

        @Bean(name= {"exampleService", "myService"})
        public ExampleService exampleService() {
                return new ExampleService();
        }
}
