package com.demomodel.configure.doubledatasource.config2;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Mybatis  第二个ds2数据源配置
 * 多数据源配置依赖数据源配置
 *  配置 map和xml   即dao层
 * @see  DataSourceConfig
 */
//@Configuration
//@MapperScan(basePackages ="com.demomodel.configure.doubledatasource.textdoubledatasource.secondary.map", sqlSessionTemplateRef  = "ds2SqlSessionTemplate")
public class MybatisPlusConfig4ds2 {

    //ds2数据源
  //  @Bean("ds2SqlSessionFactory")
    public SqlSessionFactory ds2SqlSessionFactory(@Qualifier("ds2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources("classpath*:com/demomodel/configure/doubledatasource/textdoubledatasource/secondary/map/*.xml"));
        return sqlSessionFactory.getObject();
    }

//事务支持
   // @Bean(name = "ds2TransactionManager")
    public DataSourceTransactionManager ds2TransactionManager(@Qualifier("ds2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

 //   @Bean(name = "ds2SqlSessionTemplate")
    public SqlSessionTemplate ds2SqlSessionTemplate(@Qualifier("ds2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}