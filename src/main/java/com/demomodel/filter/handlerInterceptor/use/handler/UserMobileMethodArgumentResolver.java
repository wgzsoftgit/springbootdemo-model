package com.demomodel.filter.handlerInterceptor.use.handler;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.demomodel.filter.handlerInterceptor.use.annotation.UserMobile;

import javax.servlet.http.HttpServletRequest;

/**
 * 添加如下类即可取出我们在拦截器中进去的值
 * @author wgz
 * @date 创建时间：2020年5月28日 下午3:55:04
 */
public class UserMobileMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(UserMobile.class); //&&
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        return servletRequest.getAttribute(HeaderCons.USER_MOBILE); //&&
    }
}
//https://blog.csdn.net/zhibo_lv/java/article/details/81738940