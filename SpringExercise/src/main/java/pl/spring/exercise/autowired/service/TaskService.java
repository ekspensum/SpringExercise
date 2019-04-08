package pl.spring.exercise.autowired.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pl.spring.exercise.autowired.model.Task;

@Service
public class TaskService {

	@Autowired
	@Qualifier("default")
	private ToDoListStrategy doListStrategy;

	@Autowired
	private ToDoListStrategy[] doListStrategyArray;

	public TaskService() {
		super();
	}

//    @Autowired
	public TaskService(ToDoListStrategy doListStrategy) {
		super();
		this.doListStrategy = doListStrategy;
	}

//    @Autowired
	public TaskService(ToDoListStrategy[] doListStrategyArray) {
		super();
		this.doListStrategyArray = doListStrategyArray;
	}

	public List<Task> findCurrentToDoList() {
		return doListStrategy.creteToDoList();
	}

//	@Autowired
//	@Qualifier("default")
	public void setDoListStrategy(ToDoListStrategy doListStrategy) {
		this.doListStrategy = doListStrategy;
	}

	public List<Task> findCurrentToDoListArray(int idStrategy) {
		return doListStrategyArray[idStrategy].creteToDoList();
	}

	@Autowired
	public void setDoListStrategyArray(ToDoListStrategy[] doListStrategyArray) {
		this.doListStrategyArray = doListStrategyArray;
	}

}
