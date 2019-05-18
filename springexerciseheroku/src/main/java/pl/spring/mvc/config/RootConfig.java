package pl.spring.mvc.config;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="pl.spring.mvc")
//@PropertySource(value="/static/properties/database.properties")
@EnableTransactionManagement
public class RootConfig {
	
//	@Autowired
//	private Environment env;
//	
//	/**
//	 * With connection pool
//	 */
//	@Bean
//	public BasicDataSource dataSource() {
//		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setUrl(env.getProperty("url"));
//		dataSource.setDriverClassName(env.getProperty("driver"));
//		dataSource.setUsername(env.getProperty("db_user"));
//		dataSource.setPassword(env.getProperty("db_password"));
////		if 0 then no limits
//		dataSource.setMaxOpenPreparedStatements(0);
////		pool waiting to infinity: -1
//		dataSource.setMaxWait(3000);
////		if 0 then no limits
//		dataSource.setMaxActive(10);
//		return dataSource;
//	}

    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
    
	/**
	 * Below is alternative approach with JPA/Hibernate  
	 * @throws URISyntaxException 
	 */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws URISyntaxException {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource());
        entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManager.setPackagesToScan("pl.spring.mvc.entity");
 
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        jpaProperties.setProperty("hibernate.show_sql", "false");
        jpaProperties.setProperty("hibernate.format_sql", "false");
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        jpaProperties.setProperty("jadira.usertype.autoRegisterUserTypes", "true");
 
        entityManager.setJpaProperties(jpaProperties);
 
        return entityManager;
    }
	
	   @Bean
	   public PlatformTransactionManager transactionManager() throws URISyntaxException{
	      JpaTransactionManager transactionManager = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
	      return transactionManager;
	   }

}
