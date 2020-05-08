package com.demomodel.filter.handlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



@Component
public class SessionInterceptor extends HandlerInterceptorAdapter {

    

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String origin = request.getHeader("Origin");
        if (StringUtils.hasText(origin)) { //跨域支持
            response.addHeader("Access-Control-Allow-Origin", origin);
        }
		//......
       return super.preHandle(request, response, handler);
    }
}
//https://blog.csdn.net/She_lock/java/article/details/86241685