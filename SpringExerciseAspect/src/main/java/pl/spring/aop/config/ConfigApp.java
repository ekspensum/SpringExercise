package pl.spring.aop.config;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan({"pl.spring.aop.model", "pl.spring.aop.service", "pl.spring.aop.aspects"})
@PropertySource("classpath:/pl/spring/aop/config/database.properties")
@EnableTransactionManagement
//@EnableAspectJAutoProxy //this annotation can be instead of aopconfig.xml with <aop:aspectj-autoproxy /> like below 
//@EnableAspectJAutoProxy(proxyTargetClass=true)
@ImportResource(locations="/pl/spring/aop/config/aopconfig.xml")
public class ConfigApp {

	@Autowired
	private Environment env;
	
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
	
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(basicDataSource());
        entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManager.setPackagesToScan("pl.spring.aop.model");
 
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
}
