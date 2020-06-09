package com.demomodel.filter.handlerInterceptor.use.handler;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.demomodel.filter.handlerInterceptor.use.annotation.UserId;

import javax.servlet.http.HttpServletRequest;

/**
 * 你定义的注解来建设的取出放在request里面的值，如果有多个就再加就行了
 * 添加如下类即可取出我们在拦截器中set进去的值
 * 更改请求的参数
 * @author wgz
 * @date 创建时间：2020年5月27日 下午10:28:26
 */
public class UserIdMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(UserId.class);  //&& 
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        return servletRequest.getAttribute(HeaderCons.USER_ID); //&& 
    }
}
//：https://blog.csdn.net/zhibo_lv/java/article/details/81738940