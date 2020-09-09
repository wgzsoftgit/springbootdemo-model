package com.demomodel.P7.beanInit.Qualifierdemo.AutowiredAndQuali;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class texstDemo {

@Test
public void test9() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig9.class);
    for (String beanName : context.getBeanDefinitionNames()) {
        System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
    }
}
}
