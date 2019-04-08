package pl.spring.exercise.autowired.service;

import java.util.List;

import pl.spring.exercise.autowired.model.Task;

public interface ToDoListStrategy {

        public List<Task> creteToDoList();
}
