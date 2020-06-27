package com.demomodel.filter.handlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 支持跨域
 * @author wgz
 * @date 创建时间：2020年5月29日 下午9:09:22
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {

    

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
System.err.println("********************"+"com.demomodel.filter.handlerInterceptor.SessionInterceptor");
        String origin = request.getHeader("Origin");
        if (StringUtils.hasText(origin)) { //跨域支持
            response.addHeader("Access-Control-Allow-Origin", origin);
        }
		//......
       return super.preHandle(request, response, handler);
    }
}
//https://blog.csdn.net/She_lock/java/article/details/86241685