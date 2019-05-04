package pl.spring.mvc.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.spring.mvc.dao.TaskRepository;
import pl.spring.mvc.model.Task;


@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public void addTask(Task task) {
		taskRepository.saveTask(task);
	}
	
	public List<Task> getAllTasks(){
		return taskRepository.readAllTasks();
	}

}
