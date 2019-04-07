package pl.spring.exercise.javaconfig.service;

import java.util.ArrayList;
import java.util.List;

import pl.spring.exercise.javaconfig.model.Task;

public class EisenhowerToDoListStrategy implements ToDoListStrategy {

        public List<Task> creteToDoList() {
                List<Task> toDoList = new ArrayList<Task>();
                toDoList.add(new Task(3000L));
                toDoList.add(new Task(2000L));
                toDoList.add(new Task(1000L));
                return toDoList;
        }

}

