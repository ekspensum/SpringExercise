package pl.spring.exercise.xmlconfig.service;

import java.util.ArrayList;
import java.util.List;

import pl.spring.exercise.xmlconfig.model.Task;

public class SecondToDoListStrategy implements ToDoListStrategy {

        public List<Task> creteToDoList() {
                List<Task> list = new ArrayList<Task>();
                list.add(new Task(10));
                list.add(new Task(20));
                list.add(new Task(30));
                return list;
        }

}
