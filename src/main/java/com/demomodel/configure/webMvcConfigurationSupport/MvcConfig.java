package com.demomodel.configure.webMvcConfigurationSupport;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//配置本地目录为映射文件
//@Configuration
//@EnableWebMvc
/*
 * @ComponentScan(basePackages = "com.demomodel", useDefaultFilters = false,
 * includeFilters = {
 * 
 * @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {
 * Controller.class })
 * 
 * })
 */

//@Component
public class MvcConfig implements WebMvcConfigurer  /* extends WebMvcConfigurationSupport */ {

	WebMvcConfigurerAdapter bb;
	
	/**
     * 添加静态资源文件，外部可以直接访问地址
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	System.err.println("静态文件配置");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

    }
//https://blog.csdn.net/wenxingchen/java/article/details/84139845
	

//	@Override
//
//	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//		registry.addResourceHandler("/static/**").addResourceLocations("/resources/");
//		registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/resources/");
////		String os = System.getProperty("os.name");
////
////		   if (os.toLowerCase().startsWith("win")) {  //如果是Windows系统
////		      registry.addResourceHandler("/smallapple/**")
////		            // /apple/**表示在磁盘apple目录下的所有资源会被解析为以下的路径
////		            .addResourceLocations("file:G:/itemsource/smallapple/") //媒体资源
////		            .addResourceLocations("classpath:/META-INF/resources/");  //swagger2页面
////		   } else {  //linux 和mac
////		      registry.addResourceHandler("/smallapple/**")
////		            .addResourceLocations("file:/resources/smallapple/")   //媒体资源
////		            .addResourceLocations("classpath:/META-INF/resources/");  //swagger2页面;
////		   }
//		//https://blog.csdn.net/ajklaclk/java/article/details/80804137
//	}

}