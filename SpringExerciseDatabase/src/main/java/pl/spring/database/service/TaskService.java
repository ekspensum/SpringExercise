package pl.spring.database.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.spring.database.model.Task;

@Service
public class TaskService {
	
	@Autowired
	@RepositoryQualifier(type=RepositoryType.JDBC)
	private TaskRepository repository;

	public void addTask(String subject, LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd) {		
		Task task = new Task().New()
				.withId(0)
				.withSubject(subject)
				.startOn(dateTimeStart)
				.endOn(dateTimeEnd)
				.build();
		repository.saveTask(task);
	}

	public void addTaskSeconApproach(String subject, LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd) {
		Map<String, Object> propertiesMap = new Task().newPropertiesMap()
				.withId(0)
				.withSubject(subject)
				.startOn(dateTimeStart)
				.endOn(dateTimeEnd)
				.build();
		repository.saveTaskSeconApproach(propertiesMap);		
	}
	
	public void getTask(int idTask) {
		repository.readTask(idTask);
	}
	
	public void getAllTasks() {		
		for(Task task: repository.readAllTasks())
			System.out.println(task.toString());
	}
}
