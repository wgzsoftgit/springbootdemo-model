package com.demomodel.interfaceDesign.shejimodel.delifelse.orderService.strategy.HandlerTypeANDAbstractHandler;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * @author wgz
 * @date 创建时间：2020年7月21日 下午2:44:34
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandlerType {
 String value();
}
