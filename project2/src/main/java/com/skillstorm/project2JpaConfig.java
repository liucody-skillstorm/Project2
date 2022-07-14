package com.skillstorm;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;;

@Configuration
@ComponentScan
@PropertySource("classpath:owner.properties")
@EnableJpaRepositories //allows it to scan for our repositories
@EnableTransactionManagement //need this to be able to use transactions
public class project2JpaConfig {

	/*
	 * Data Source
	 * Transaction Manager
	 * Exception Translation Post Processor
	 * Entity Manager Factory
	 */
	
	//todo: add com.skillstorm.repository files
	//todo: after schema finished add classes to com.skillstorm.beans
	//todo: add query methods into Project2Service as well as repository
	
	String url = "url";

	String user = "user";

	String password = "password";

	String driver = "com.mysql.cj.jdbc.Driver";
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(project2JpaConfig.class);
		// Project2Service service = context.getBean(Project2Service.class);
		// System.out.println(service.findAll());
		// System.out.println(service.add(new Asdcasc("Jane Pickles", "Grey", "Hot Dogs", 38)));
	}
	
	@Bean
	public DataSource datasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user, password);
		dataSource.setDriverClassName(driver);
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(datasource());
	}
	
	//entity manager - SessionFactory
	//essentially setting up everything we setupo for your hibernate session factory but in Java vs xml
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();
		emfBean.setDataSource(datasource());
		emfBean.setPackagesToScan("com.skillstorm.beans"); //where does it look for my @Entity classes
		
		//need to tell it what the underlying ORM provider is
		JpaVendorAdapter hibernate = new HibernateJpaVendorAdapter();
		emfBean.setJpaVendorAdapter(hibernate);
		
		//hibernate properties
		Properties props = new Properties();
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		emfBean.setJpaProperties(props);
		
		return emfBean;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		//need those so exceptions can be processed properly
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
}
