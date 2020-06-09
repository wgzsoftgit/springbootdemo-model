package com.demomodel.filter.core.corsConfig;
import org.springframework.context.annotation.Configuration; 

import org.springframework.web.servlet.config.annotation.CorsRegistry; 

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter; 

 
//不管用
@Configuration 
public class CorsConfig2 extends WebMvcConfigurerAdapter { 
    @Override 

    public void addCorsMappings(CorsRegistry registry) { 

        registry.addMapping("/**") 
                 .allowedOrigins("*") 

                .allowCredentials(true) 

                .allowedMethods("GET", "POST", "DELETE", "PUT") 

                .maxAge(3600); 

    } 

 

}