package com.demomodel.filter.handlerInterceptor.use.filter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.demomodel.filter.handlerInterceptor.use.annotation.UserId;
import com.demomodel.filter.handlerInterceptor.use.annotation.UserMobile;
import com.demomodel.filter.handlerInterceptor.use.handler.UserIdMethodArgumentResolver;
import com.demomodel.filter.handlerInterceptor.use.handler.UserMobileMethodArgumentResolver;

import java.util.List;

/**
 * 配置拦截器
 *自定义  更改请求的参数拦截     启动 配置自定义  2步  
 * @author wgz
 * @date 创建时间：2020年5月27日 下午10:21:21
 */
//@Configuration
public class FilterAutoConfiguration {

//
//    @Configuration    
//    @ConditionalOnWebApplication
//    @ConditionalOnClass({UserId.class, UserMobile.class})//多个用逗号隔开   有这个注解就拦截获取request
    protected static class ArgumentResolverAutoConfiguration extends WebMvcConfigurerAdapter {
        protected ArgumentResolverAutoConfiguration() {
        	System.err.println("com.demomodel.filter.handlerInterceptor.use.filter.FilterAutoConfiguration");
        }

        public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        //可添加多个                                         &&
            argumentResolvers.add(new UserIdMethodArgumentResolver()); //&&
            argumentResolvers.add(new UserMobileMethodArgumentResolver()); //&&
        }
    }
}
//：https://blog.csdn.net/zhibo_lv/java/article/details/81738940