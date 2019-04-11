package pl.spring.exercise.autowired.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import pl.spring.exercise.autowired.config.ToDoListQualifier;
import pl.spring.exercise.autowired.config.ToDoListType;
import pl.spring.exercise.autowired.model.Task;

@Service
@ToDoListQualifier(strategy=ToDoListType.DEFAULT)
@Order(3)
public class DefaultToDoListStrategy implements ToDoListStrategy {

        public List<Task> creteToDoList(){
                List<Task> toDoList = new ArrayList<Task>();
                toDoList.add(new Task(1));
                toDoList.add(new Task(2));
                toDoList.add(new Task(3));
                return toDoList;
        }
}

