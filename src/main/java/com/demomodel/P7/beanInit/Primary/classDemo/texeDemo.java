package com.demomodel.P7.beanInit.Primary.classDemo;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class texeDemo {

@Test
public void test12() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig12.class);
    for (String beanName : context.getBeanDefinitionNames()) {
        System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
    }
}
}
