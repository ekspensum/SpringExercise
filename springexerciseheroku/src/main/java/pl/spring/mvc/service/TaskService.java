package pl.spring.mvc.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.spring.mvc.dao.TaskRepository;
import pl.spring.mvc.entity.Task;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public boolean addTask(Task task) {
		if (taskRepository.saveTask(task)) {
			return true;
		}
		return false;
	}

	public List<Task> getAllTasks(String sortBy) {
		List<Task> readAllTasks = taskRepository.readAllTasks();
		readAllTasks.sort(new Comparator<Task>() {

			@Override
			public int compare(Task o1, Task o2) {

					if (sortBy.equals("taskNoAscending")) {
						return o1.getTaskNo().compareTo(o2.getTaskNo());
					} 
					if (sortBy.equals("taskNoDescending")) {
						return o2.getTaskNo().compareTo(o1.getTaskNo());
					} 
					if (sortBy.equals("subjectAscending")) {
						return o1.getSubject().compareTo(o2.getSubject());
					} 
					if(sortBy.equals("subjectDescending")) {
						return o2.getSubject().compareTo(o1.getSubject());
					}

				return -1;
			}
		});
		return readAllTasks;
	}
	
	public List<Task> getAllTasks() {
		List<Task> readAllTasks = taskRepository.readAllTasks();
		readAllTasks.sort(new Comparator<Task>() {

			@Override
			public int compare(Task o1, Task o2) {
				return -1;
			}
		});
		return readAllTasks;
	}
}
