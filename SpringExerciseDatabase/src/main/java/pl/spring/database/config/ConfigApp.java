package pl.spring.database.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import pl.spring.database.model.Task;

@Configuration
@ComponentScan("pl.spring.database.service")
@ImportResource(value="classpath:/pl/spring/database/config/beans.xml")
public class ConfigApp {

//	below is alternative for use bean DataSource from bean.xml file
//	@Bean
//	public DataSource mysqlDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();	
//		dataSource.setUrl("jdbc:mysql://localhost:3306/taskmanager?serverTimezone=Europe/Warsaw");
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUsername("andrzej");
//		dataSource.setPassword("1234");
//		return dataSource;
//	}

}
