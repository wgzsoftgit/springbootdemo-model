package com.demomodel.filter.handlerInterceptor.use.filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.demomodel.filter.handlerInterceptor.use.annotation.UserAuthenticate;
import com.demomodel.filter.handlerInterceptor.use.handler.HeaderCons;
import com.demomodel.utils.httpHelp.HttpHelper;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;


public class TestFilter extends HandlerInterceptorAdapter {
	private final Logger logger = LoggerFactory.getLogger(TestFilter.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("request请求地址path[{}] uri[{}]", request.getServletPath(),request.getRequestURI());
	//拦截器和controller同时获取request.getInputStream();  报 Stream closed错误
		System.err.println("拦截器"+HttpHelper.getBodyString(request));
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		// 查看请求是否有@UserAuthenticate注解           ---------------自定义注解
		UserAuthenticate userAuthenticate = method.getAnnotation(UserAuthenticate.class);//&&   查看请求是否有@UserAuthenticate注解
		//如果没有加注解则userAuthenticate为null
		if (Objects.nonNull(userAuthenticate)) {
			Long userId= getUserId(request); //&& 同
			//userAuthenticate.permission()取出permission判断是否需要校验权限
			if (userId == null || (userAuthenticate.permission() && !checkAuth(userId,request.getRequestURI()))){
				//throw new FastRuntimeException(20001,"No access");
				return false;
			}
		}  
		return true;
	}

	/**
	 * 根据token获取用户ID
	 * @param request
	 * @return
	 */
	private Long getUserId(HttpServletRequest request){
		//添加业务逻辑根据token获取用户UserId
		String header = request.getHeader("H-User-Token");
		Long userId = 1L;
		String userMobile = "18888888888";
	//拦截修改request的请求参数    不传参数 这里会改变HttpServletRequest
		request.setAttribute(HeaderCons.USER_ID,userId);
		request.setAttribute(HeaderCons.USER_MOBILE,userMobile);
		return userId;
	}

	/**
	 * 校验用户访问权限
	 * @param userId
	 * @param requestURI
	 * @return
	 */
	private boolean checkAuth(Long userId,String requestURI){
		System.err.println("com.demomodel.filter.handlerInterceptor.use.filter.TestFilter校验用户访问权限"+userId+requestURI);
		//添加业务逻辑根据UserId获取用户的权限组然后校验访问权限
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {}
}
//https://blog.csdn.net/zhibo_lv/java/article/details/81738940