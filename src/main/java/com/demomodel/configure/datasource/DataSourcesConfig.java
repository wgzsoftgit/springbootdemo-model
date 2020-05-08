package com.demomodel.configure.datasource;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
/**
 * ，定义数据源，并且注明一个主数据源，一个从数据源
 * @author wgz
 * @date 创建时间：2020年4月24日 上午10:38:02
 */
//@Configuration
public class DataSourcesConfig {
    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.primary")
    public DataSource primaryDataSource() {
        System.out.println("primary db built");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        System.out.println("secondary db built");
        return DataSourceBuilder.create().build();
    }
}
//https://blog.csdn.net/qq_41690306/java/article/details/79304501