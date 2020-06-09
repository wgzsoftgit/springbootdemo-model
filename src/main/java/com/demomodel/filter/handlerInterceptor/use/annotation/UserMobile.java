package com.demomodel.filter.handlerInterceptor.use.annotation;
import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserMobile {
}
//https://blog.csdn.net/zhibo_lv/java/article/details/81738940