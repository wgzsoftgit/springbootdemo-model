package com.demomodel.configure.springconfFullList.ConfigurationAndBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Application1 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig1.class);

        Userc user = context.getBean(Userc.class);
        System.out.println("com.demomodel.configure.springconfFullList.ConfigurationAndBean.Application1"+user.getClass());
        System.out.println("com.demomodel.configure.springconfFullList.ConfigurationAndBean.Application1"+user);
    }
}
//
//：https://blog.csdn.net/f641385712/java/article/details/106127418