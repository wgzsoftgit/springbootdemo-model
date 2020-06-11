package com.demomodel.configure.doubledatasource.config3;


import javax.sql.DataSource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;


/**
 * Mybatis-plus 主数据源ds1配置
 * 多数据源配置依赖数据源配置
 *  配置 map和xml   即dao层
 * @see  DataSourceConfig
 */
@Configuration
@MapperScan(basePackages ="com.demomodel.configure.doubledatasource.textdoubledatasource.master.map", sqlSessionTemplateRef  = "ds1SqlSessionTemplate")
public class MybatisPlusConfig4ds1 {

    //主数据源 ds1数据源  
    @Primary
    @Bean("ds1SqlSessionFactory")
    public SqlSessionFactory ds1SqlSessionFactory(@Qualifier("ds1DataSource") DataSource dataSource) throws Exception {
    	MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        configuration.setJdbcTypeForNull(JdbcType.NULL);  
        sqlSessionFactory.setConfiguration(configuration);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().
                        getResources("classpath*:com/demomodel/configure/doubledatasource/textdoubledatasource/master/map/*.xml"));
        sqlSessionFactory.setPlugins(new Interceptor[]{
                new PaginationInterceptor(),
                new PerformanceInterceptor()
//                        .setFormat(true),
        });
//        sqlSessionFactory.setGlobalConfig(new GlobalConfig().setBanner(false));
        return sqlSessionFactory.getObject();
    //	return null;
    }

    @Primary
    @Bean(name = "ds1TransactionManager")
    public DataSourceTransactionManager ds1TransactionManager(@Qualifier("ds1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "ds1SqlSessionTemplate")
    public SqlSessionTemplate ds1SqlSessionTemplate(@Qualifier("ds1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
    /**
     * 通过自动扫描，发现MyBatis Mapper接口
     * @return  Mapper扫描器  参考com.demomodel.configure.doubledatasource.config3.RootConfig
     */
	// 修改后的
//	 @Bean
//	  public  MapperScannerConfigurer mapperScannerConfigurer() {
//	         MapperScannerConfigurer configurer = new MapperScannerConfigurer();
//	         // 1.设置使用的会话工厂
//	         configurer.setSqlSessionFactoryBeanName("ds1SqlSessionFactory");
//	         // 2.配置扫描的映射接口
//	         configurer.setBasePackage("cn.mgy.mapper");
//	         // 3.指定组件类型
//	         configurer.setAnnotationClass(Mapper.class);//configurer.setAnnotationClass(Repository.class);
//	         return configurer;
//	     }

    /**  配置事务管理器
     * 向spring容器注入PlatformTransactionManager事务管理器他是一个接口类需要通过
     * 他的实现类DataSourceTransactionManager获取到实例
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
	public PlatformTransactionManager platformTransactionManager(@Qualifier("ds1DataSource") DataSource dataSource) throws Exception {
		
		return new DataSourceTransactionManager(dataSource);
		
	}
//https://blog.csdn.net/weixin_41865602/java/article/details/89786610
}
