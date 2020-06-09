package com.demomodel.configure.mysqlconf;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


//@Component
public class AppConfigurationBasicDataSource {
	
	@Autowired
	private Environment env;  
	 
	@Bean 
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
       return new PropertySourcesPlaceholderConfigurer();
    }

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		//对象连接池中的连接数量配置,可选的
		dataSource.setInitialSize(10);//初始化的连接数
		dataSource.setMaxActive(8);//最大连接数量
		dataSource.setMaxIdle(5);//最大空闲数 
		dataSource.setMinIdle(1);//最小空闲
		dataSource.setDefaultAutoCommit(true);
		return dataSource;
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(dataSource());
		return txManager;
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver commonsMultipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(6000000); //6mb
		return commonsMultipartResolver;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
//		sqlSessionFactory.getObject().getConfiguration().addMapper(AccountMapper.class);
		return sqlSessionFactory.getObject();
	}
	
	@Bean
	public VelocityEngine velocityEngine() throws VelocityException, IOException {
		VelocityEngineFactoryBean velocityEngine = new VelocityEngineFactoryBean();
		Map<String, Object> velocityPropertiesMap = new HashMap<String, Object>();
		velocityPropertiesMap.put("resource.loader", "class");
		velocityPropertiesMap.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		velocityEngine.setVelocityPropertiesMap(velocityPropertiesMap);
		return velocityEngine.createVelocityEngine();
	}
	
//	@Bean
//    public AccountMapper accountMapper() throws Exception {
//      SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
//      return sessionTemplate.getMapper(AccountMapper.class);
//    }
//	

}
