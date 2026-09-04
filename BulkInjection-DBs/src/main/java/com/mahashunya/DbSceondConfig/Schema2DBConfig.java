package com.mahashunya.DbSceondConfig;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		                                        entityManagerFactoryRef = "schema2EMF",
		                                        transactionManagerRef = "schema2TxMg",
		                                        basePackages = "com.mahashunya.repo.custm")
public class Schema2DBConfig {
  //datasource
	@Bean
	@ConfigurationProperties(prefix="schema2.datasource")
	public DataSource schema2DataSource() {
		return  DataSourceBuilder.create().build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean  schema2EMF(
			                         EntityManagerFactoryBuilder  builder) {
		
		HashMap<String, Object> props = new HashMap<>();
		  props.put("hibernate.hbm2ddl.auto", "create");
		  props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"); 
		  
		  return builder.dataSource(schema2DataSource())
				                    .packages("com.mahashunya.model.custm")
				                    .properties(props)
				                    .build();
	}
	@Bean
	public PlatformTransactionManager  schema2TxMg(@Qualifier("schema2EMF") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
