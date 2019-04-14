package pl.spring.database.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import pl.spring.database.model.Task;

@Configuration
@ComponentScan("pl.spring.database.service")
@ImportResource(value="classpath:/pl/spring/database/config/beans.xml")
//@PropertySource(value="classpath:/pl/spring/database/config/database.properties")
public class ConfigApp {

/**
 * Below is alternative for use bean DataSource from bean.xml and datasource.properties files. With them are need annotation @ImportResource and @PropertySource like above
 */
//	@Autowired
//	public Environment env;
//	
//	@Bean
//	public DataSource mysqlDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();	
//		dataSource.setUrl(env.getProperty("url"));
//		dataSource.setDriverClassName(env.getProperty("driver"));
//		dataSource.setUsername(env.getProperty("user"));
//		dataSource.setPassword(env.getProperty("password"));
//		return dataSource;
//	}

}
