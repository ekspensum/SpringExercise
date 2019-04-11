package pl.spring.exercise.xmlconfig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import pl.spring.exercise.xmlconfig.model.Task;

public class TaskService {

	@Value("${taskService.default}")
	private String serviceId;
	
	private ToDoListStrategy doListStrategy;

	private List<ToDoListStrategy> doListStrategies;

	public TaskService() {
		super();
	}

	public TaskService(ToDoListStrategy doListStrategy) {
		super();
		this.doListStrategy = doListStrategy;
	}

	public TaskService(List<ToDoListStrategy> doListStrategies) {
		super();
		this.doListStrategies = doListStrategies;
	}

	public void setDoListStrategies(List<ToDoListStrategy> doListStrategies) {
		this.doListStrategies = doListStrategies;
	}

	public List<Task> findCurrentToDoList(int idStrategy) {
		return doListStrategies.get(idStrategy).creteToDoList();
	}

	public List<Task> getListStrtegy() {
		return doListStrategy.creteToDoList();
	}

	public void setDoListStrategy(ToDoListStrategy doListStrategy) {
		this.doListStrategy = doListStrategy;
	}

	public String getServiceId() {
		return serviceId;
	}
}
