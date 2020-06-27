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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;

/**
 * Mybatis-plus ds2数据源配置
 * 多数据源配置依赖数据源配置
 *  配置 map和xml   即dao层
 * @see  DataSourceConfig
 */
//@Configuration
//@MapperScan(basePackages ="com.demomodel.query.quartzdemo.dao", sqlSessionTemplateRef  = "ds2SqlSessionTemplateQuart")
public class MybatisPlusConfig4ds2Quart{

    //ds2数据源
    @Bean("ds2SqlSessionFactoryQuart")
    public SqlSessionFactory ds2SqlSessionFactoryQuart(@Qualifier("ds2DataSourceQuart") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        sqlSessionFactory.setConfiguration(configuration);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources("classpath*:com/demomodel/query/quartzdemo/dao/*.xml"));
        sqlSessionFactory.setPlugins(new Interceptor[]{
                new PaginationInterceptor(),
//                new PerformanceInterceptor()
//                        .setFormat(true),
        });
//        sqlSessionFactory.setGlobalConfig(new GlobalConfig().setBanner(false));
       return sqlSessionFactory.getObject();
  //  return sqlSessionFactory;
    }

    @Bean(name = "ds2TransactionManagerQuart")
    public DataSourceTransactionManager ds2TransactionManagerQuart(@Qualifier("ds2DataSourceQuart") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "ds2SqlSessionTemplateQuart")
    public SqlSessionTemplate ds2SqlSessionTemplateQuart(@Qualifier("ds2SqlSessionFactoryQuart") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

	 @Bean
	  public  MapperScannerConfigurer mapperScannerConfigurer() {
	         MapperScannerConfigurer configurer = new MapperScannerConfigurer();
	         // 1.设置使用的会话工厂
	         configurer.setSqlSessionFactoryBeanName("ds2SqlSessionFactoryQuart");
	         // 2.配置扫描的映射接口
	         configurer.setBasePackage("com.demomodel.query.quartzdemo.dao.*");
	         // 3.指定组件类型
	         configurer.setAnnotationClass(Mapper.class);//configurer.setAnnotationClass(Repository.class);
	         return configurer;
	     }
}