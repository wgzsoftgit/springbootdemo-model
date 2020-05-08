package com.demomodel.configure.webMvcConfigurationSupport;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//配置本地目录为映射文件
@Configuration

@EnableWebMvc

@ComponentScan(basePackages = "com.demomodel", useDefaultFilters = false, includeFilters = {

		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = { Controller.class })

})
public class MvcConfig extends WebMvcConfigurationSupport {

//	@Bean
//	public ViewResolver viewResolver() {
//
//		InternalResourceViewResol verviewResolver = new InternalResourceViewResolver();
//
//		viewResolver.setPrefix("/WEB-INF/jsp/");
//
//		viewResolver.setSuffix(".jsp");
//
//		return viewResolver;
//
//	}

	@Override

	protected void addResourceHandlers(ResourceHandlerRegistry registry) {

	//	registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/resources/");
//		String os = System.getProperty("os.name");
//
//		   if (os.toLowerCase().startsWith("win")) {  //如果是Windows系统
//		      registry.addResourceHandler("/smallapple/**")
//		            // /apple/**表示在磁盘apple目录下的所有资源会被解析为以下的路径
//		            .addResourceLocations("file:G:/itemsource/smallapple/") //媒体资源
//		            .addResourceLocations("classpath:/META-INF/resources/");  //swagger2页面
//		   } else {  //linux 和mac
//		      registry.addResourceHandler("/smallapple/**")
//		            .addResourceLocations("file:/resources/smallapple/")   //媒体资源
//		            .addResourceLocations("classpath:/META-INF/resources/");  //swagger2页面;
//		   }
		//https://blog.csdn.net/ajklaclk/java/article/details/80804137
	}

}