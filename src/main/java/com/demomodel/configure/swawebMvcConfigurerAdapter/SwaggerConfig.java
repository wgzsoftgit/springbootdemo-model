package com.demomodel.configure.swawebMvcConfigurerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
import java.util.ArrayList;
import java.util.List;
 
/**
 * 用@Configuration注解该类，等价于XML中配置beans；
 * 用@Bean标注方法等价于XML中配置bean。
 * Application.class 加上注解@EnableSwagger2 表示开启Swagger,也可以通过
 * 配置文件设置是否开启swagger2
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demomodel"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("SpringBoot整合Swagger")
                        .description("SpringBoot整合Swagger，详细信息......")
                        .version("9.0")
                        .termsOfServiceUrl("http://localhost:9093/swagger-ui.html")
                        .contact(new Contact("啊啊啊啊","blog.csdn.net","aaa@gmail.com"))
                        .license("The Apache License")
                        .licenseUrl("http://www.baidu.com")
                        .build());
    }
//https://blog.csdn.net/u012702547/java/article/details/88775298
 
    /**
     * .apis(RequestHandlerSelectors.basePackage("所需扫描的controller下的所有包")
     * @return
     */
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.demomodel"))
//                .paths(PathSelectors.any())
//                .build();
//    }
// 
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("springboot利用swagger2构建api文档")
//                .description("简单优雅的restful风格，http://blog.csdn.net/saytime")
//                .version("1.0")
//                .build();
//    }
// 
//    private List<ResponseMessage> customerResponseMessage() {
//        List<ResponseMessage> list = new ArrayList<>();
//        list.add(new ResponseMessageBuilder().code(200).message("请求成功").build());
//        list.add(new ResponseMessageBuilder().code(201).message("资源创建成功").build());
//        list.add(new ResponseMessageBuilder().code(204).message("服务器成功处理了请求，但不需要返回任何实体内容").build());
//        list.add(new ResponseMessageBuilder().code(400).message("请求失败,具体查看返回业务状态码与对应消息").build());
//        list.add(new ResponseMessageBuilder().code(401).message("请求失败,未经过身份认证").build());
//        list.add(new ResponseMessageBuilder().code(405).message("请求方法不支持").build());
//        list.add(new ResponseMessageBuilder().code(415).message("请求媒体类型不支持").build());
//        list.add(new ResponseMessageBuilder().code(500).message("服务器遇到了一个未曾预料的状况,导致了它无法完成对请求的处理").build());
//        list.add(new ResponseMessageBuilder().code(503).message("服务器当前无法处理请求,这个状况是临时的，并且将在一段时间以后恢复").build());
//        return list;
//    }
}