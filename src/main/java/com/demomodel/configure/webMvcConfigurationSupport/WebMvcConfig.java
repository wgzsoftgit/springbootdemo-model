package com.demomodel.configure.webMvcConfigurationSupport;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class WebMvcConfig implements WebMvcConfigurer{
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		logger.info("addResourceHandlers");
		//将所有/static/**访问都映射到classpath:/static/目录下
		registry.addResourceHandler("/static/**")
				.addResourceLocations("classpath:/static/");
	}
}
//https://blog.csdn.net/xiaozheng12/java/article/details/100517099