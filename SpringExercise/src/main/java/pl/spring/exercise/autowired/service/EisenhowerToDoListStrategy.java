package pl.spring.exercise.autowired.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import pl.spring.exercise.autowired.config.ToDoListQualifier;
import pl.spring.exercise.autowired.config.ToDoListType;
import pl.spring.exercise.autowired.model.Task;

@Service
@ToDoListQualifier(strategy=ToDoListType.EISENHOWER)
@Order(2)
public class EisenhowerToDoListStrategy implements ToDoListStrategy {

        public List<Task> creteToDoList() {
                List<Task> toDoList = new ArrayList<Task>();
                toDoList.add(new Task(3000));
                toDoList.add(new Task(2000));
                toDoList.add(new Task(1000));
                return toDoList;
        }

}

