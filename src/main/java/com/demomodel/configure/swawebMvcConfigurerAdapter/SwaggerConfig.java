package com.demomodel.configure.swawebMvcConfigurerAdapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//访问方式 http://localhost:8080/sxxl-dashboard/swagger-ui.html
@Configuration //声明该类为配置类
@EnableSwagger2 //声明启动Swagger2
//@EnableWebMvc //声明启动mvc
public class SwaggerConfig{
    @Bean
    public Docket customDocket() {
    	//// .apis(RequestHandlerSelectors.basePackage("com.demo.controller"))
    	return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(apiInfo());
  
    }
    @Bean
    public RequestMappingInfoHandlerMapping requestMapping(){
        return new RequestMappingHandlerMapping();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("***工程  API接口")//文档说明
                .version("1.0.0")//文档版本说明
                .build();
    }
}
