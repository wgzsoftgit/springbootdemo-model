package com.demomodel.P7.beanInit.TBean;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demomodel.P7.beanInit.TBean.TService.OrderService;
import com.demomodel.P7.beanInit.TBean.TService.UserServiceTs;


public class textDemo {

@Test
public void test18() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig18.class);
    System.out.println(context.getBean(UserServiceTs.class).getDao());
    System.out.println(context.getBean(OrderService.class).getDao());
}
}
