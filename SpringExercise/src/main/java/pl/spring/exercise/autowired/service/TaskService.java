package pl.spring.exercise.autowired.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import pl.spring.exercise.autowired.config.ToDoListQualifier;
import pl.spring.exercise.autowired.config.ToDoListType;
import pl.spring.exercise.autowired.model.Task;

@Service
public class TaskService {
	
//	@Value("something")
	@Value("${taskService.default}")
	private String serviceId;
	
	@Resource
	ApplicationContext context;

	@Autowired
	@ToDoListQualifier(strategy=ToDoListType.DEFAULT)
	private ToDoListStrategy doListStrategy;

	@Autowired
	private ToDoListStrategy[] doListStrategyArray;

	public TaskService() {
		super();
	}

//    @Autowired
	public TaskService(ToDoListStrategy doListStrategy) {
		super();
		this.doListStrategy = doListStrategy;
	}

//    @Autowired
	public TaskService(ToDoListStrategy[] doListStrategyArray) {
		super();
		this.doListStrategyArray = doListStrategyArray;
	}

	public List<Task> findCurrentToDoList() {
//		if sets field ApplicationContex with @Resource (above) then we can get context below without Runner class 
//		EisenhowerToDoListStrategy doListStrategy = context.getBean(EisenhowerToDoListStrategy.class);
		return doListStrategy.creteToDoList();
	}

//	@Autowired
//	@Qualifier("default")
	public void setDoListStrategy(ToDoListStrategy doListStrategy) {
		this.doListStrategy = doListStrategy;
	}

	public List<Task> findCurrentToDoListArray(int idStrategy) {
		return doListStrategyArray[idStrategy].creteToDoList();
	}

	@Autowired
	public void setDoListStrategyArray(ToDoListStrategy[] doListStrategyArray) {
		this.doListStrategyArray = doListStrategyArray;
	}

	public String getServiceId() {
		return serviceId;
	}

}
