package com.demomodel.controller.doubleview;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * 主要配置多视图实现的视图解析器相关bean实例
 *
 * http://www.it399.com/
 *
 * 其实关键点在于两个：
 * 1、配置order属性
 * 2、配置viewnames属性
 *
 * 注意：
 * return new ModelAndView("jsps/index");//或者return "jsps/index"
 * 对应 /WEB-INF/jsps/index.jsp
 * ==========================
 * 同理：
 * return "thymeleaf/index";//或者return “thymeleaf/index”
 * 对应 /WEB-INF/thymeleaf/index.html
 *
 *
 */


    @Configuration//用来定义 DispatcherServlet 应用上下文中的 bean
    @EnableWebMvc
    @ComponentScan("com")
    public class ViewResolverConfiguration extends WebMvcConfigurerAdapter {
        @Bean
        public ViewResolver viewResolver() {
            InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//            resolver.setPrefix("/WEB-INF/");
//            resolver.setSuffix(".jsp");
//            resolver.setViewNames("jsps/*");
            resolver.setPrefix("/webapp");
            resolver.setSuffix(".jsp");
            resolver.setViewNames("*");
            resolver.setOrder(2);
            return resolver;
        }
//支持html    thymeleaf模板
        @Bean
        public ITemplateResolver templateResolver() {
            SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
            templateResolver.setTemplateMode("HTML5");
            templateResolver.setPrefix("/templates/");
            templateResolver.setSuffix(".html");
            templateResolver.setCharacterEncoding("utf-8");
            templateResolver.setCacheable(false);// #开发配置为false,避免修改模板还要重启服务器
            return templateResolver;
        }
//        ###ThymeLeaf配置
//        spring:
//          thymeleaf:
//            #模板的模式，支持 HTML, XML TEXT JAVASCRIPT
//            mode: HTML5
//            #编码 可不用配置
//            encoding: UTF-8
//            #内容类别,可不用配置
//            content-type: text/html
//            #开发配置为false,避免修改模板还要重启服务器
//            cache: false
//            #配置模板路径，默认是templates，可以不用配置
//            prefix: classpath:/templates
// https://blog.csdn.net/weixin_39723544/java/article/details/82721279
//        #thymelea模板配置
//        spring.thymeleaf.prefix=classpath:/templates/
//        spring.thymeleaf.suffix=.html
//        spring.thymeleaf.mode=HTML5
//        spring.thymeleaf.encoding=UTF-8
//        #热部署文件，页面不产生缓存，及时更新
//        spring.thymeleaf.cache=false
//        spring.resources.chain.strategy.content.enabled=true
//        spring.resources.chain.strategy.content.paths=/**
//支持
        @Bean
        public SpringTemplateEngine templateEngine() {
            SpringTemplateEngine templateEngine = new SpringTemplateEngine();
            templateEngine.setTemplateResolver(templateResolver());
            // templateEngine
            return templateEngine;
        }
//支持vue
//        @Bean
//        public ThymeleafViewResolver viewResolverThymeLeaf() {
//            ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//            viewResolver.setTemplateEngine(templateEngine());
//            viewResolver.setCharacterEncoding("utf-8");
//            viewResolver.setOrder(1);
//            //viewResolver.setViewNames(new String[]{"thyme/*"});
//            viewResolver.setViewNames(new String[]{"thymeleaf/*","vue/*"});
//            return viewResolver;
//        }

        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
            configurer.enable();
        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            super.addResourceHandlers(registry);
        }
    }



//https://blog.csdn.net/e_Inch_Photo/java/article/details/80201272