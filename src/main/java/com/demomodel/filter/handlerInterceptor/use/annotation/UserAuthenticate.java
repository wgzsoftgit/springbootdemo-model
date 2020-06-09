package com.demomodel.filter.handlerInterceptor.use.annotation;
import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@NameBinding
public @interface UserAuthenticate
{
	/**
	 * 是否需要校验访问权限 默认不校验
	 *
	 * @return
	 */
	boolean permission() default false;

}
//://blog.csdn.net/zhibo_lv/java/article/details/81738940