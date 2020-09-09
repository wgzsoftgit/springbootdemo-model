package com.demomodel.P7.beanInit.Primary.functiondemo;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class textDemo {


@Test
public void test13() {
	//注意最后一行，service1注入的是service2这个bean
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig13.class);
    for (String beanName : context.getBeanDefinitionNames()) {
        System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
    }
}
}
