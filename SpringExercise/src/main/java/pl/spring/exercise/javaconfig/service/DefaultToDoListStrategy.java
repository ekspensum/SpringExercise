package pl.spring.exercise.javaconfig.service;

import java.util.ArrayList;
import java.util.List;

import pl.spring.exercise.javaconfig.model.Task;

public class DefaultToDoListStrategy implements ToDoListStrategy {

        public List<Task> creteToDoList(){
                List<Task> toDoList = new ArrayList<Task>();
                toDoList.add(new Task(1L));
                toDoList.add(new Task(2L));
                toDoList.add(new Task(3L));
                return toDoList;
        }
}

