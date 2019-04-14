package pl.spring.exercise.javaconfig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import pl.spring.exercise.javaconfig.model.Task;

public class TaskService {

//	@Autowired
	private ToDoListStrategy doListStrategy;

//	@Autowired
	private OtherStrategy otherStrategy;

	@Autowired
	private ToDoListStrategy[] doListStrategyArray;

	public TaskService() {
		super();
	}

	public TaskService(ToDoListStrategy doListStrategy) {
		super();
		this.doListStrategy = doListStrategy;
	}

	public TaskService(ToDoListStrategy[] doListStrategyArray) {
		super();
		this.doListStrategyArray = doListStrategyArray;
	}

	public TaskService(OtherStrategy otherStrategy) {
		super();
		this.otherStrategy = otherStrategy;
	}

	public List<Task> findCurrentToDoList() {
		return doListStrategy.creteToDoList();
	}

	@Autowired
	@Qualifier("first approach")
//	@Qualifier
	public void setDoListStrategy(ToDoListStrategy doListStrategy) {
		this.doListStrategy = doListStrategy;
	}

	public List<Task> findCurrentToDoListArray(int idStrategy) {
		return doListStrategyArray[idStrategy].creteToDoList();
	}

	public OtherStrategy getOtherStrategy() {
		return otherStrategy;
	}

	@Autowired
	public void setOtherStrategy(OtherStrategy otherStrategy) {
		this.otherStrategy = otherStrategy;
	}

//	@Autowired
	public void setDoListStrategyArray(ToDoListStrategy[] doListStrategyArray) {
		this.doListStrategyArray = doListStrategyArray;
	}

}
