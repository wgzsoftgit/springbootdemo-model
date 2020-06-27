package com.demomodel.filter.views;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
/**
 * thymeleaf  模板html测试通过 同时支持jsp
 * @author wgz
 * @date 创建时间：2020年6月13日 下午3:36:20
 */
//@Configuration
	public class WebViewConfig implements WebMvcConfigurer {
    /**
     * @Description: 注册jsp视图解析器
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
       // resolver.setViewClass(HandleResourceViewExists.class); //设置检查器
        resolver.setPrefix("/WEB-INF/"); //配置放置jsp文件夹
        resolver.setSuffix(".jsp");
        resolver.setViewNames("jsp/*");  //重要 setViewNames 通过它识别为jsp页面引擎
        resolver.setContentType("text/html;charset=UTF-8");
        resolver.setOrder(2);
        return resolver;
    }  


    
    
    //--------------------------ok thymeleaf-----------------
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
        viewResolver.setViewNames(new String[]{"thymeleaf"});//thymeleaf模板引擎  //new String[]{"WEB-INF/templates/*"
        viewResolver.setOrder(1);
        return viewResolver; 
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    //--------------------------ok thymeleaf-----------------
    

}
//https://blog.csdn.net/KyrellLupin/java/article/details/90074192