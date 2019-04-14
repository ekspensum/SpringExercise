package pl.spring.database.runner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.cj.jdbc.Driver;

import pl.spring.database.config.ConfigApp;
import pl.spring.database.model.Task;
import pl.spring.database.service.TaskService;

public class RunnerClass {

	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
//		DataSource bean = context.getBean(DataSource.class);
//		Connection connection = bean.getConnection();
//		PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM task");
//		ResultSet executeQuery = prepareStatement.executeQuery();
//		executeQuery.next();
//		System.out.println(executeQuery.getString("subject"));	
		

		TaskService beanTaskService = context.getBean(TaskService.class);
//		beanTaskService.addTask("subject2", LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(5));
//		beanTaskService.addTaskSeconApproach("subjectSeconApproach", LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(13));
//		beanTaskService.getTask(6);
		beanTaskService.getAllTasks();
		
		context.close();
	}

}
