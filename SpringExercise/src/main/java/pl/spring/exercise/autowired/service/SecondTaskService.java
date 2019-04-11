package pl.spring.exercise.autowired.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import pl.spring.exercise.autowired.model.Task;

public class SecondTaskService {

	@Autowired
	@Qualifier("random")
	private ToDoListStrategy doListStrategy;
	
	public List<Task> findCurrentToDoList() {
		return doListStrategy.creteToDoList();
	}
}
