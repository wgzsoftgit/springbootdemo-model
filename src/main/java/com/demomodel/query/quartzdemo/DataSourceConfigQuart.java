package com.demomodel.query.quartzdemo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 多数据源配置     得到DataSource
 */
@Configuration
public class DataSourceConfigQuart {
    //第三个ds3数据源配置
    @Bean(name = "ds2DataSourcePropertiesQuart")
    @ConfigurationProperties(prefix = "spring.datasource.secondaryquart")
    public DataSourceProperties ds2DataSourcePropertiesQuart() {
        return new DataSourceProperties();
    }

    //第三个ds2数据源
    @Bean("ds2DataSourceQuart")
    public DataSource ds2DataSourceQuart(@Qualifier("ds2DataSourcePropertiesQuart") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }
   
}
//https://www.jianshu.com/p/dfd5ae340011