package com.jth.rest;

import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories
@EnableTransactionManagement
@PropertySource({"classpath:application.properties", "classpath:build.properties"})
public class Application extends SpringBootServletInitializer {

	@Autowired
	private ApplicationContext context;

	@Bean
	public ServletRegistrationBean servicesContext() {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.setParent(context);
		applicationContext.scan("com.jth.rest.services.controllers.*");

		DispatcherServlet dispatcherServlet = new DispatcherServlet();
		dispatcherServlet.setApplicationContext(applicationContext);

		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/services/*");
		servletRegistrationBean.setName("services");

		return servletRegistrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(new Object[] { Application.class }, args);
	}

	@Bean
	JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setGenerateDdl(true);
		adapter.setShowSql(true);
		adapter.setDatabase(Database.HSQL);
		return adapter;
	}

	@Bean
	public DataSource dataSource() {
		// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.HSQL)
			.addScript("db/sql/create-db.sql")
			.addScript("db/sql/insert-data.sql")
			.build();
		return db;
	}
	
	@Bean
	JpaDialect jpaDialect() {
		return new HibernateJpaDialect();
	}

	@Bean
	EntityManagerFactory entityManagerFactory(DataSource dataSource) throws SQLException {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource);
		bean.setJpaVendorAdapter(jpaVendorAdapter());
		bean.setJpaDialect(jpaDialect());
		bean.setPackagesToScan("com.jth.rest.restservices");
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.generate_statistics", "true");
		jpaProperties.setProperty("hibernate.transaction.flush_before_completion", "true");
		jpaProperties.setProperty("hibernate.transaction.auto_close_session", "true");
		bean.setJpaProperties(jpaProperties);
		bean.afterPropertiesSet();
		return bean.getObject();
	}

	@Bean
	PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

}
