package com.demomodel.filter.views;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.demomodel.filter.handlerInterceptor.ReqInterceptor;
/**
 * 配置多视图   测试ok
 * 自动选择html还是jsp
 * @author wgz
 * @date 创建时间：2020年5月28日 下午4:38:25
 */
//@Configuration
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
	 /**
	     * @Description: 注册jsp视图解析器
	     */
	    @Bean
	    public InternalResourceViewResolver viewResolver() {
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setViewClass(HandleResourceViewExists.class); //设置检查器
	        viewResolver.setPrefix("/WEB-INF/view/");//配置放置jsp文件夹
	        viewResolver.setSuffix(".jsp");
	        viewResolver.setOrder(0);
	        viewResolver.setContentType("text/html;charset=UTF-8");
	        return viewResolver;
	    }
	    @Override
	    public void configureViewResolvers(ViewResolverRegistry registry) {
	     //   super.configureViewResolvers(registry);
	        registry.viewResolver(htmlViewResolver());
	        registry.viewResolver(viewResolver());
//	        registry.jsp("/jsp/",".jsp");  
		}
//----------------------Thymeleaf--------------------
	

	    /**
	     * @Description: 注册html视图解析器
	     */
	    @Bean
	    public ITemplateResolver templateResolver() {
	        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
	        templateResolver.setTemplateMode("HTML");
	        templateResolver.setPrefix("classpath:/templates/");
	        templateResolver.setSuffix(".html");
	        templateResolver.setCharacterEncoding("utf-8");
	        templateResolver.setCacheable(false);
	        return templateResolver;
	    }
	    
	    /**
	     * @Description: 将自定义tml视图解析器添加到模板引擎并主持到ioc
	     */
	    @Bean
	    public SpringTemplateEngine templateEngine() {
	        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	        templateEngine.setTemplateResolver(templateResolver());
	        return templateEngine;
	    }
	    /**
	     * @Description: Thymeleaf视图解析器配置
	     */
	    @Bean
	    public ThymeleafViewResolver viewResolverThymeLeaf() {
	        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	        viewResolver.setTemplateEngine(templateEngine());
	        viewResolver.setCharacterEncoding("utf-8");
	        viewResolver.setViewNames(new String[]{"thymeleaf"});
	        viewResolver.setOrder(1);
	        return viewResolver;
	    }
//https://blog.csdn.net/KyrellLupin/java/article/details/90074192
		@Override
		public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
			 configurer.enable();
		}
	    
		
	//https://blog.csdn.net/KyrellLupin/java/article/details/90074192
	    
	//https://blog.csdn.net/qq_29611427/java/article/details/88867549

    
	    
  
   
    
//https://blog.csdn.net/ykzhen2015/java/article/details/70669861
    
    

}
//https://blog.csdn.net/She_lock/java/article/details/86241685