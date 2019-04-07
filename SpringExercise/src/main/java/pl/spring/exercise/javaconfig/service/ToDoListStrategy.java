package pl.spring.exercise.javaconfig.service;

import java.util.List;

import pl.spring.exercise.javaconfig.model.Task;

public interface ToDoListStrategy {

        public List<Task> creteToDoList();
}
