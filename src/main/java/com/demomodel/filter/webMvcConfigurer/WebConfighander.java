package com.demomodel.filter.webMvcConfigurer;

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
import com.demomodel.JwtToken.demo.ValidateLoginInterceptor;
import com.demomodel.filter.handlerInterceptor.ReqInterceptor;

//@Configuration
public class WebConfighander implements WebMvcConfigurer {

    /**
     * 添加类型转换器和格式化器
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //registry.addFormatterForFieldType(LocalDate.class, new USLocalDateFormatter());
    }
    
    /**   
     * 跨域支持
     * 如果还是不能解决问题，那你就需要想办法获取到请求的request和response对象处理一把，
     * 比如通过编写filter在response对象中添加响应头：
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")  //浏览器允许所有的域访问 / 注意 * 不能满足带有cookie的访问,Origin 必须是全匹配
                .allowCredentials(true)   // 允许带cookie访问
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                 .allowedHeaders("token")
                .maxAge(3600);
    }
    /**
     * 添加静态资源--过滤swagger-api (开源的在线API文档)
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //过滤swagger
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/swagger-resources/**")
                .addResourceLocations("classpath:/META-INF/resources/swagger-resources/");

        registry.addResourceHandler("/swagger/**")
                .addResourceLocations("classpath:/META-INF/resources/swagger*");

        registry.addResourceHandler("/v2/api-docs/**")
                .addResourceLocations("classpath:/META-INF/resources/v2/api-docs/");

    }
    
	/**
	 * 配置拦截器 
	 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	//配置拦截器   需要一个实现HandlerInterceptor接口的拦截器实例，   && 
       // registry.addInterceptor(new ReqInterceptor()).addPathPatterns("/**");
        
        registry.addInterceptor(new ValidateLoginInterceptor()).addPathPatterns("/**");
    }
    /**
     * 视图控制器配置
     * 这一个配置在之前是经常被使用到的，最经常用到的就是"/"、"/index"路径请求时不通过@RequestMapping配置，
     * 而是直接通过配置文件映射指定请求路径到指定View页面，当然也是在请求目标页面时不需要做什么数据处理才可以这样使用
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
      //  super.addViewControllers(registry);
        registry.addViewController("/").setViewName("/index");
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
    
    
    /**
     * 配置消息转换器--这里我用的是alibaba 开源的 fastjson
     * //将javabean转化成json字符串
String jsonStr = JSON.toJSONString(Bean bean);
//将json字符串转化成对应的javabean
Bean bean = JSON.parseObject(jsonStr, Bean.class);
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //1.需要定义一个convert转换消息的对象;
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //2.添加fastJson的配置信息，比如：是否要格式化返回的json数据;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,//是否需要格式化
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteDateUseDateFormat);
        //3处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        //4.在convert中添加配置信息.
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        //5.将convert添加到converters当中.
        converters.add(fastJsonHttpMessageConverter);
    }

    

}
//https://blog.csdn.net/She_lock/java/article/details/86241685