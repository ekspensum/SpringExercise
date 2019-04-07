package pl.spring.exercise.xmlconfig.service;

import java.util.ArrayList;
import java.util.List;

import pl.spring.exercise.xmlconfig.model.Task;

public class FirstToDoListStrategy implements ToDoListStrategy {

        public List<Task> creteToDoList() {
                List<Task> list = new ArrayList<Task>();
                list.add(new Task(1));
                list.add(new Task(2));
                list.add(new Task(3));
                return list;
        }

}

