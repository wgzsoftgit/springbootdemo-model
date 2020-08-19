package com.demomodel.interfaceDesign.shejimodel.delifelse.orderService.strategy.HandlerTypeANDAbstractHandler.toSpring;

import java.util.HashMap;
import java.util.Map;

import org.apache.curator.shaded.com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import com.demomodel.interfaceDesign.shejimodel.delifelse.orderService.strategy.HandlerTypeANDAbstractHandler.HandlerType;
import com.demomodel.utils.springcontextbeanutils.ClassScaner;

@Component
public class HandlerProcessor implements BeanFactoryPostProcessor {

	private static final String HANDLER_PACKAGE = "com.demomodel.interfaceDesign.shejimodel.delifelse.orderService.strategy.HandlerTypeANDAbstractHandler";
	/**
	 * 扫描@HandlerType 初始化MandlerContext 将其注册到Spring容器
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		 Map<String, Class> handlerMap = Maps.newHashMapWithExpectedSize(3);
	      //&& 工具类                         自定义注解
		 ClassScaner.scan(HANDLER_PACKAGE, HandlerType.class).forEach(clazz -> {
	            String type = clazz.getAnnotation(HandlerType.class).value();
	            handlerMap.put(type, clazz);
	        });
	        HandlerContext context = new HandlerContext(handlerMap);
	        beanFactory.registerSingleton(HandlerContext.class.getName(), context);	
	}

}
