package com.demomodel.configure.doubledatasource.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//		entityManagerFactoryRef="entityManagerFactoryPrimary",
//		transactionManagerRef="transactionManagerPrimary",
//		basePackages={"com.demomodel.configure.doubledatasource.textdoubledatasource.master.map"})
public class PrimaryDataSourceConfig {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	
	@Autowired
	private JpaProperties jpaProperties;
	
	@Primary
	@Bean(name="entityManagerPrimary")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder){
		return entityManagerFactoryBean(builder).getObject().createEntityManager();
	}
	
	@Primary
	@Bean(name="entityManagerFactoryPrimary")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder){
		return builder
				.dataSource(dataSource)
				.properties(getProperties()) //&&getProperties()
				//设置实体类所在位置
				.packages("com.demomodel.configure.doubledatasource.textdoubledatasource.master.dao")
				.persistenceUnit("primaryPersistentUnit")
				.build();
	}
	
	public Map<String, String> getProperties(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("format_sql", "true");
		map.put("max_fetch_depth", "1");
		return map;
	}
	
	
	@Primary
	@Bean(name="transactionManagerPrimary")
	public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder){
		return new JpaTransactionManager(entityManagerFactoryBean(builder).getObject());
	}
}
//https://blog.csdn.net/feinifi/java/article/details/96750566