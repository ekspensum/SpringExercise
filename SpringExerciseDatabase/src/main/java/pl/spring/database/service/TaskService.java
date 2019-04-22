package pl.spring.database.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import pl.spring.database.model.Task;
import pl.spring.database.model.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	@RepositoryQualifier(type=RepositoryType.JPA)
	private TaskRepository repository;
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private MessageSource messageSource;

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
			System.out.println(messageSource.getMessage(fieldError.getCode()+"."+fieldError.getObjectName()+"."+fieldError.getField(), null, new Locale("pl")));
		
		repository.saveTask(task);
	}

	public void addTaskSecondApproach(String subject, LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd) {
		Map<String, Object> propertiesMap = new Task().newPropertiesMap()
				.withId(0)
				.withSubject(subject)
				.startOn(dateTimeStart)
				.endOn(dateTimeEnd)
				.build();
		repository.saveTaskSecondApproach(propertiesMap);		
	}
	
	public void getTask(int idTask) {
		repository.readTask(idTask);
	}
	
	public void getAllTasks() {		
		for(Task task: repository.readAllTasks())
			System.out.println(task.toString());
	}
}
