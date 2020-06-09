package com.demomodel.configure.doubledatasource.textdoubledatasource.aop.xianliu;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
    @Documented
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RateLimit {
        double limitNum() default 20;  //默认每秒放入桶中的token
    }
//https://blog.csdn.net/qq_39816039/java/article/details/83988517