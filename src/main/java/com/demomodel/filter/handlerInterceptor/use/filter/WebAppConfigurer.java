package com.demomodel.filter.handlerInterceptor.use.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//启动就加载拦截配置   1步
//@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个，这里选择拦截所有请求地址，进入后判断是否有加注解即可
            registry.addInterceptor(new TestFilter()).addPathPatterns("/**");
    }
}
//如果不需要使用UserId和UserMobile这两个注解到这里已经结束了。
//不过为了方便业务层的使用直接获取用户的id、mobile等信息我这里就加上了
//https://blog.csdn.net/zhibo_lv/java/article/details/81738940