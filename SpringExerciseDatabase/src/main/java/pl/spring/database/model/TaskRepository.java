package pl.spring.database.model;

import java.util.List;
import java.util.Map;

public interface TaskRepository {

	void saveTask(Task task);

	void saveTaskSecondApproach(Map<String, Object> propertiesMap);

	void readTask(int idTask);

	List<Task> readAllTasks();

}