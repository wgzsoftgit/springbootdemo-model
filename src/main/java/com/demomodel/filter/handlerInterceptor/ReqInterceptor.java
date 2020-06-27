package com.demomodel.filter.handlerInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**  需要配置到 WebMvcConfigurer
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
     //在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制、权限校验等处理   
    	System.out.println("com.demomodel.filter.handlerInterceptor.ReqInterceptor"+"Interceptor preHandler method is running !");
       //不处理   return super.preHandle(request, response, handler);
  
      System.err.println("request请求地址path[{}] uri[{}]"+request.getServletPath()+request.getRequestURI());
		//request.getHeader(String) 从请求头中获取数据
		//从请求头中获取用户token（登陆凭证根据业务而定）
//		Long userId= getUserId(request.getHeader("H-User-Token"));
//		if (userId != null && checkAuth(userId,request.getRequestURI())){
//			return true;
//		}
//		//这里的异常是我自定义的异常，系统抛出异常后框架捕获异常然后转为统一的格式返回给前端， 其实这里也可以返回false
//	//	throw new FastRuntimeException(20001,"No access");
//		return false;
//https://blog.csdn.net/zhibo_lv/java/article/details/81699360
      
      return true;
    
    }
    /**
	 * 根据token获取用户ID
	 * @param userToken
	 * @return
	 */
	private Long getUserId(String userToken){
		Long userId = null;
		return userId;
	}

	/**
	 * 校验用户访问权限
	 * @param userId
	 * @param requestURI
	 * @return
	 */
	private boolean checkAuth(Long userId,String requestURI){
		return true;
	}
//://blog.csdn.net/zhibo_lv/java/article/details/81699360
    
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    //在业务处理器处理请求执行完成后，生成视图之前执行。后处理（调用了Service并返回ModelAndView，但未进行页面渲染），有机会修改ModelAndView  
    	System.err.println("com.demomodel.filter.handlerInterceptor.ReqInterceptor"+"Interceptor postHandler method is running !");
        super.postHandle(request, response, handler, modelAndView);
  
    
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.err.println("com.demomodel.filter.handlerInterceptor.ReqInterceptor"+"Interceptor afterCompletion method is running !");
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
   // 	在DispatcherServlet完全处理完请求后被调用，可用于清理资源等。返回处理（已经渲染了页面）  
    	System.err.println("com.demomodel.filter.handlerInterceptor.ReqInterceptor"+"Interceptor afterConcurrentHandlingStarted method is running !");
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
//：https://blog.csdn.net/She_lock/java/article/details/86241685