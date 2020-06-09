package com.demomodel.configure.doubledatasource.config2;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;//这个也能执行成功
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;




//import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;//需要依赖mybatis-plus



/**
 * Mybatis主数据源ds1配置
 * 多数据源配置依赖数据源配置
 配置 map和xml   即dao层
 * @see  DataSourceConfig
 */
//@Configuration
//@MapperScan(basePackages ="com.demomodel.configure.doubledatasource.textdoubledatasource.master.map", sqlSessionTemplateRef  = "ds1SqlSessionTemplate")
public class MybatisPlusConfig4ds1 {

    //主数据源 ds1数据源
//    @Primary
//    @Bean("ds1SqlSessionFactory")
    public SqlSessionFactory ds1SqlSessionFactory(@Qualifier("ds1DataSource") DataSource dataSource) throws Exception {
    	SqlSessionFactoryBean  sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().
                        getResources("classpath*:com/demomodel/configure/doubledatasource/textdoubledatasource/master/map/*.xml"));  
     //单个引入mapper
     //sqlSessionFactory.getObject().getConfiguration().addMapper(VehicleDrivingTableMapper.class);
     // 配置mybatis的config文件(我目前用不上)
     // sqlSessionFactoryBean.setConfigLocation("mybatis-config.xml"); 
        return sqlSessionFactory.getObject();
    }

//    @Primary
//    @Bean(name = "ds1TransactionManager")
    public DataSourceTransactionManager ds1TransactionManager(@Qualifier("ds1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

//    @Primary
//    @Bean(name = "ds1SqlSessionTemplate")
    public SqlSessionTemplate ds1SqlSessionTemplate(@Qualifier("ds1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}