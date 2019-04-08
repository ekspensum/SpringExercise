package pl.spring.exercise.javaconfig.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import pl.spring.exercise.javaconfig.service.DefaultToDoListStrategy;
import pl.spring.exercise.javaconfig.service.EisenhowerToDoListStrategy;
import pl.spring.exercise.javaconfig.service.RandomToDoListStrategy;
import pl.spring.exercise.javaconfig.service.TaskService;
import pl.spring.exercise.javaconfig.service.ToDoListStrategy;

@Configuration
public class ConfigApp {

        @Bean
        public TaskService taskService() {
                return new TaskService();
        }

        @Bean
        public TaskService taskService(ToDoListStrategy doListStrategy) {
                return new TaskService(doListStrategy);
        }

        @Bean
        @Order(1)
//      @Qualifier
        public ToDoListStrategy eisenhowerToDoListStrategy() {
                return new EisenhowerToDoListStrategy();
        }

        @Bean
        @Order(2)
//      @Qualifier
        public ToDoListStrategy defaultToDoListStrategy() {
                return new DefaultToDoListStrategy();
        }

        @Bean
        @Order(3)
        @Qualifier
        public ToDoListStrategy randomToDoListStrategy() {
                return new RandomToDoListStrategy();
        }

        @Bean
        public TaskService taskService(ToDoListStrategy[] doListStrategy) {
                return new TaskService(doListStrategy);
        }

        @Bean
        @Qualifier("array")
        public ToDoListStrategy[] doListStrategies() {
                ToDoListStrategy [] array = new ToDoListStrategy[3];
                array[0] = new DefaultToDoListStrategy();
                array[1] = new RandomToDoListStrategy();
                array[2] = new EisenhowerToDoListStrategy();
                return array;
        }
}

