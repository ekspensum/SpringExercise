package pl.spring.exercise.autowired.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import pl.spring.exercise.autowired.model.Task;



@Service
@Order(1)
public class RandomToDoListStrategy implements ToDoListStrategy {

        public List<Task> creteToDoList() {
                Random rand = new Random();
                List<Task> toDoList = new ArrayList<Task>();
                toDoList.add(new Task(rand.nextInt(100)));
                toDoList.add(new Task(rand.nextInt(200)));
                toDoList.add(new Task(rand.nextInt(300)));
                return toDoList;
        }

}
