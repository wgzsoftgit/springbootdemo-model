package com.demomodel;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

//,"com.demomodel.configure.doubledatasource.textdoubledatasource.map"
@MapperScan({"com.demomodel.mysqlcontroller.mapper","com.demomodel.configure.doubledatasource.textdoubledatasource.master.map","com.demomodel.configure.doubledatasource.textdoubledatasource.secondary.map"}) //扫描的mapper
@SpringBootApplication
@ServletComponentScan
public class WebApplication {

	
	
	public static void main(String[] args) {
			
		SpringApplication.run(WebApplication.class, args);
	}
}