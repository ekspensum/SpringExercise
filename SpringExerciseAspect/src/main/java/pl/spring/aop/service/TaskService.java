package pl.spring.aop.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import pl.spring.aop.model.Task;
import pl.spring.aop.model.TaskRepository;


@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	@Autowired
	private Validator validator;

	public void addTask(String subject, LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd) {		
		Task task = new Task().New()
				.withId(0)
				.withSubject(subject)
				.startOn(dateTimeStart)
				.endOn(dateTimeEnd)
				.build();
		
		Errors errors = new BindException(task, "task");
		validator.validate(task, errors);
		
		for(FieldError fieldError : errors.getFieldErrors())
			System.out.println(fieldError.getCode()+"."+fieldError.getObjectName()+"."+fieldError.getField());
		
		repository.saveTask(task);
	}

	public void getTask(int idTask) {
		repository.readTask(idTask);
	}
	
	public void getAllTasks() {		
		for(Task task: repository.readAllTasks())
			System.out.println(task.toString());
	}
}
