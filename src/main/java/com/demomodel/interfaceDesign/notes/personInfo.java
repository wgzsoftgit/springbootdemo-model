package com.demomodel.interfaceDesign.notes;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Service;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Service
public @interface personInfo {
    String personInfo() default "0";
    String value() default "";
}
//https://blog.csdn.net/zxysshgood/java/article/details/78399980