package pl.spring.exercise.xmlconfig.service;

import java.util.ArrayList;
import java.util.List;

import pl.spring.exercise.xmlconfig.model.Task;

public class ThirdToDoListStrategy implements ToDoListStrategy {

        public List<Task> creteToDoList() {
                List<Task> list = new ArrayList<Task>();
                list.add(new Task(100));
                list.add(new Task(200));
                list.add(new Task(300));
                return list;
        }

}

