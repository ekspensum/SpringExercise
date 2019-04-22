package pl.spring.database.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.validator.internal.engine.ValidatorFactoryImpl;
import org.hibernate.validator.internal.engine.groups.ValidationOrderGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import pl.spring.database.model.Task;

@Configuration
@ComponentScan({"pl.spring.database.service", "pl.spring.database.model"})
//@ImportResource(value="classpath:/pl/spring/database/config/beans.xml")
@PropertySource(value="classpath:/pl/spring/database/config/database.properties")
@EnableTransactionManagement
public class ConfigApp {

	/**
	 * Below is alternative for use bean DataSource from bean.xml and datasource.properties files. With them are need annotation @ImportResource and @PropertySource like above
	 */
	@Autowired
	public Environment env;
	
//	@Bean
//	public DataSource mysqlDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();	
//		dataSource.setUrl(env.getProperty("url"));
//		dataSource.setDriverClassName(env.getProperty("driver"));
//		dataSource.setUsername(env.getProperty("user"));
//		dataSource.setPassword(env.getProperty("password"));
//		return dataSource;
//	}
	/**
	 * With connection pool
	 */
	@Bean
	public BasicDataSource basicDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(env.getProperty("url"));
		dataSource.setDriverClassName(env.getProperty("driver"));
		dataSource.setUsername(env.getProperty("user"));
		dataSource.setPassword(env.getProperty("password"));
//		if 0 then no limits
		dataSource.setMaxOpenPreparedStatements(0);
//		pool waiting to infinity: -1
		dataSource.setMaxWait(3000);
//		if 0 then no limits
		dataSource.setMaxActive(10);
		return dataSource;
	}
	
	/**
	 * Below is alternative approach with JPA/Hibernate  
	 */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(basicDataSource());
        entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManager.setPackagesToScan("pl.spring.database.model");
 
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        jpaProperties.setProperty("hibernate.show_sql", "false");
        jpaProperties.setProperty("hibernate.format_sql", "false");
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        jpaProperties.setProperty("jadira.usertype.autoRegisterUserTypes", "true");
 
        entityManager.setJpaProperties(jpaProperties);
 
        return entityManager;
    }
	
	   @Bean
	   public PlatformTransactionManager transactionManager(){
	      JpaTransactionManager transactionManager = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
	      return transactionManager;
	   }
	   
	   @Bean
	   public Validator getValidator() {
		   return new LocalValidatorFactoryBean();
	   }
	   
	   @Bean
	   public MessageSource messageSource() {
		   ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		   messageSource.setBasename("pl/spring/database/config/errormsg");
		   messageSource.setDefaultEncoding("UTF-8");
		   return messageSource;
	   }
}
