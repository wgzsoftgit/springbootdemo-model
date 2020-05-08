package com.demomodel.filter.handlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * l拦截器实现
 * //SpringMvc请求处理的执行过程
Interceptor preHandler method is running !
Controller is running !
Interceptor postHandler method is running !
Interceptor afterCompletion method is running !
 */
public class ReqInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Interceptor preHandler method is running !");
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Interceptor postHandler method is running !");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Interceptor afterCompletion method is running !");
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Interceptor afterConcurrentHandlingStarted method is running !");
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
//：https://blog.csdn.net/She_lock/java/article/details/86241685