package com.demomodel.filter.views;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.demomodel.filter.handlerInterceptor.ReqInterceptor;

@Configuration
public class WebConfig  implements WebMvcConfigurer{

   
	 @Bean
	    public InternalResourceViewResolver htmlViewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setPrefix("/WEB-INF/templates/view/");
	        viewResolver.setViewClass(HandleResourceViewExists.class); //设置检查器
	        viewResolver.setSuffix(".html"); 
	        viewResolver.setOrder(0);
	        viewResolver.setContentType("text/html;charset=UTF-8");
	        return viewResolver;
	    }
	 
	    @Bean
	    public InternalResourceViewResolver viewResolver() {
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setViewClass(HandleResourceViewExists.class); //设置检查器
	        viewResolver.setPrefix("/WEB-INF/view/");
	        viewResolver.setSuffix(".jsp");
	        viewResolver.setOrder(0);
	        viewResolver.setContentType("text/html;charset=UTF-8");
	        return viewResolver;
	    }
	//https://blog.csdn.net/qq_29611427/java/article/details/88867549
	    @Override
	    public void configureViewResolvers(ViewResolverRegistry registry) {
	     //   super.configureViewResolvers(registry);
	        registry.viewResolver(htmlViewResolver());
	        registry.viewResolver(viewResolver());
//	        registry.jsp("/jsp/",".jsp");
		}
	    
	    
  
    //------------------------------------------
    /**
     * 配置请求视图映射
     */
//    @Bean
//    public InternalResourceViewResolver resourceViewResolver()
//    {
//        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//        //请求视图文件的前缀地址
//        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
//        //请求视图文件的后缀    
//        internalResourceViewResolver.setSuffix(".jsp");
//        internalResourceViewResolver.setOrder(1);
//        return internalResourceViewResolver;
//    }
 
    /**
     * 视图配置
     */
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//     //   super.configureViewResolvers(registry);
//        registry.viewResolver(resourceViewResolver());
////        registry.jsp("/jsp/",".jsp");
//	}
//----------------------------------------------------
    
    
    
    

}
//https://blog.csdn.net/She_lock/java/article/details/86241685