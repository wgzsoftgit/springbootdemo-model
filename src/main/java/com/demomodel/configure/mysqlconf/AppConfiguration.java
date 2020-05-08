package com.demomodel.configure.mysqlconf;

import javax.sql.DataSource;

//import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.druid.pool.DruidDataSource;

//com.alibaba  druid的数据源

//@Configuration
//@EnableWebMvc 
//@PropertySource({"classpath:db.properties","classpath:config.properties","classpath:log4j.properties"})
//@ComponentScan(basePackages = "com.bayee")
//@Import({ WebInitializer.class, DispatcherConfig.class, ThymeleafConfig.class,SlaveDatasourceConfig.class})
public class AppConfiguration {
	
	@Autowired
	private Environment env;  
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
       return new PropertySourcesPlaceholderConfigurer();
    }


	@Bean
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		dataSource.setDefaultAutoCommit(true);
		return dataSource;
	}
//：https://blog.csdn.net/pengjunlee/java/article/details/80081231
	
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

//	import org.apache.commons.dbcp.BasicDataSource的数据源
//	@Bean
//	public BasicDataSource dataSource() {
//		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
//		dataSource.setUrl(env.getProperty("jdbc.url"));
//		dataSource.setUsername(env.getProperty("jdbc.username"));
//		dataSource.setPassword(env.getProperty("jdbc.password"));
//		dataSource.setDefaultAutoCommit(true);
//		return dataSource;
//	}
//	展示层有三大典型技术，分别是JSP、freemaker和velocity
//	源代码生成：Velocity 可以被用来生成 Java 代码、SQL 或者 PostScript。
//	自动 Email：很多软件的用户注册、密码提醒或者报表都是使用 Velocity 来自动生成的
//	@Bean
//	public VelocityEngine velocityEngine() throws VelocityException, IOException {
//		VelocityEngineFactoryBean velocityEngine = new VelocityEngineFactoryBean();
//		Map<String, Object> velocityPropertiesMap = new HashMap<String, Object>();
//		velocityPropertiesMap.put("resource.loader", "class");
//		velocityPropertiesMap.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
//		velocityEngine.setVelocityPropertiesMap(velocityPropertiesMap);
//		return velocityEngine.createVelocityEngine();
//	}
	
//	@Bean
//    public AccountMapper accountMapper() throws Exception {
//      SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
//      return sessionTemplate.getMapper(AccountMapper.class);
//    }
//	
	
	
}
