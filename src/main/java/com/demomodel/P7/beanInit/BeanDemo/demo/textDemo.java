package com.demomodel.P7.beanInit.BeanDemo.demo;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class textDemo {

@Test
public void test14() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig14.class);
    for (String beanName : context.getBeanDefinitionNames()) {
        System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
    }
}

@Test
public void test15() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig15.class);
    for (String beanName : context.getBeanDefinitionNames()) {
        System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
    }
}


}
