package pl.spring.exercise.javaconfig.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.core.annotation.Order;

import pl.spring.exercise.javaconfig.model.Task;

@Order(3)
public class RandomToDoListStrategy implements ToDoListStrategy {

        public List<Task> creteToDoList() {
                Random rand = new Random();
                List<Task> toDoList = new ArrayList<Task>();
                toDoList.add(new Task((long) rand.nextInt(100)));
                toDoList.add(new Task((long) rand.nextInt(200)));
                toDoList.add(new Task((long) rand.nextInt(300)));
                return toDoList;
        }

}
