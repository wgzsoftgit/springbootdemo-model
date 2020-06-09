package com.demomodel.configure.PageHelper;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

@Configuration
public class PageHelperConfig {
	
   @Bean
   public PageHelper pageHelper(){
       PageHelper pageHelper = new PageHelper();
       Properties properties = new Properties();
       // 设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用
       properties.setProperty("offsetAsPageNum","true");
       // 查询总条数
       properties.setProperty("rowBoundsWithCount","true");
       /**
        * 配置合理分页，如果为turn,pageNum<1会查询第一页，
        * 如果pageNum>pages会查询最后一页,为false则返回空
        */
       properties.setProperty("reasonable","true");
       // 数据库方言
       properties.setProperty("dialect","mysql");   
       pageHelper.setProperties(properties);
       return pageHelper;
   }
 
}
//https://blog.csdn.net/amosjob/java/article/details/82747733