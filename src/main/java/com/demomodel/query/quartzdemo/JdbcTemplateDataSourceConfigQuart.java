package com.demomodel.query.quartzdemo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate多数据源配置
 * 依赖于数据源配置
 *
 * @see DataSourceConfig
 */
@Configuration
public class JdbcTemplateDataSourceConfigQuart {


    //JdbcTemplate第二个ds2数据源  
    @Bean(name = "ds2JdbcTemplateQuart")
    public JdbcTemplate ds2JdbcTemplateQuart(@Qualifier("ds2DataSourceQuart") DataSource dataSource) {
        return new JdbcTemplate(dataSource);  
    }
}
//https://www.jianshu.com/p/dfd5ae340011