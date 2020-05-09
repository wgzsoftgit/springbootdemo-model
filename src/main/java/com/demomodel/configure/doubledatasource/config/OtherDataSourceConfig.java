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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//		entityManagerFactoryRef="entityManagerFactoryOther",
//		transactionManagerRef="transactionManagerOther",
//	    basePackages={"com.demomodel.configure.doubledatasource.textdoubledatasource.secondary"})//指定了Repository的位置也就是map层接口的位置
public class OtherDataSourceConfig {
 
	@Autowired
	@Qualifier("otherDataSource")
	private DataSource otherDataSource;
	
	@Autowired
	private JpaProperties jpaProperties;
	
	@Bean(name="entityManagerOther")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder){
		return entityManagerFactoryBean(builder).getObject().createEntityManager();
	}
	
	@Bean(name="entityManagerFactoryOther")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder){
		return builder
				.dataSource(otherDataSource)
				//&&   getProperties()
				.properties(getProperties())
				//还通过packages属性指定了各自实体类的位置。这样，数据源配置清楚了，剩下就是各自数据源对应的实体和dao,service编码
				.//设置实体类所在位置
				packages("com.demomodel.configure.doubledatasource.textdoubledatasource.secondary")
				.persistenceUnit("otherPersistentUnit")
				.build();
	}
	
	public Map<String, String> getProperties(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("format_sql", "true");
		map.put("max_fetch_depth", "1");
		//map.put("dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
		//懒加载的配置
//		map.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
//		map.put("hibernate.enable_lazy_load_no_trans", "true");
		return map;
	}
	
	@Bean(name="transactionManagerOther")
	public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder){
		return new JpaTransactionManager(entityManagerFactoryBean(builder).getObject());
	}
}
//https://blog.csdn.net/feinifi/java/article/details/96750566