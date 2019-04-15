package pl.spring.database.service;

import java.util.List;
import java.util.Map;

import pl.spring.database.model.Task;

public interface TaskRepository {

	void saveTask(Task task);

	void saveTaskSeconApproach(Map<String, Object> propertiesMap);

	void readTask(int idTask);

	List<Task> readAllTasks();

}