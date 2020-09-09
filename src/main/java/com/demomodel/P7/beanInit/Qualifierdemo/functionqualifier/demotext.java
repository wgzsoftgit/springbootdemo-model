package com.demomodel.P7.beanInit.Qualifierdemo.functionqualifier;


import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class demotext {
	@Test
	public void test8() {
	    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig8.class);
	    for (String beanName : context.getBeanDefinitionNames()) {
	        System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
	    }
	}
	
	@Test
	public void test17() {
	    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig17.class);
	    for (String beanName : context.getBeanDefinitionNames()) {
	        System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
	    }
	}
}
