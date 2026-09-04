package com.mahashunya.DbOneConfig;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		                                        entityManagerFactoryRef = "schema1EMF",
		                                        transactionManagerRef = "schema1TxMg",
		                                        basePackages = "com.mahashunya.repo.prod")
public class Schema1DBConfig {
  //datasource
	@Primary
	@Bean
	@ConfigurationProperties(prefix="schema1.datasource")
	public DataSource schema1DataSource() {
		return  DataSourceBuilder.create().build();
	}
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean  schema1EMF(
			                         EntityManagerFactoryBuilder  builder) {
		
		HashMap<String, Object> props = new HashMap<>();
		  props.put("hibernate.hbm2ddl.auto", "create");
		  props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"); 
		  
		  return builder.dataSource(schema1DataSource())
				                    .packages("com.mahashunya.model.prod")
				                    .properties(props)
				                    .build();
	}
	@Bean
	@Primary
	public PlatformTransactionManager  schema1TxMg(@Qualifier("schema1EMF") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
