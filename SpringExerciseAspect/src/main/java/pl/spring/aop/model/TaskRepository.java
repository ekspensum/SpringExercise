package pl.spring.aop.model;

import java.util.List;

public interface TaskRepository {

	public void saveTask(Task task);

	public void readTask(int idTask);

	public List<Task> readAllTasks();

}