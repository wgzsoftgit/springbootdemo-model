package com.demomodel.P7.beanInit.Resource.ResourceDemo01;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

public class Textdemo {

	@Test
	public void test7() {
		CommonAnnotationBeanPostProcessor cc;//处理@Resource
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig7.class);
		for (String beanName : context.getBeanDefinitionNames()) {
			System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
		}
	}

}
