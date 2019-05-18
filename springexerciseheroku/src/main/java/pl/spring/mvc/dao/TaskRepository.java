package pl.spring.mvc.dao;

import java.util.List;

import pl.spring.mvc.entity.Task;

public interface TaskRepository {

	public boolean saveTask(Task task);
	public List<Task> readAllTasks();
}
