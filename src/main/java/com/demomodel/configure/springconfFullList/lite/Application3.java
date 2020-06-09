package com.demomodel.configure.springconfFullList.lite;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demomodel.configure.springconfFullList.ConfigurationAndBean.Userc;

public class Application3 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig3.class);

        // 配置类情况
        System.out.println(context.getBean(LiteConfig.class).getClass());
        System.out.println(context.getBean(LiteConfig.InnerConfig.class).getClass());

        String[] beanNames = context.getBeanNamesForType(Userc.class);
        for (String beanName : beanNames) {
            Userc user = context.getBean(beanName, Userc.class);
            System.out.println("beanName:" + beanName);
            System.out.println("com.demomodel.configure.springconfFullList.lite.Application3"+user.getClass());
            System.out.println("com.demomodel.configure.springconfFullList.lite.Application3"+user);
            System.out.println("------------------------");
        }
    }
}
//https://blog.csdn.net/f641385712/java/article/details/106127418