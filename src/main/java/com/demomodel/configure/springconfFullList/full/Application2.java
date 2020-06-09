package com.demomodel.configure.springconfFullList.full;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demomodel.bean.User;

public class Application2 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);

        // 配置类情况
        System.out.println(context.getBean(FullConfig.class).getClass());
        System.out.println(context.getBean(FullConfig.InnerConfig.class).getClass());

        String[] beanNames = context.getBeanNamesForType(User.class);
        for (String beanName : beanNames) {
            User user = context.getBean(beanName, User.class);
            System.out.println("beanName:" + beanName);
            System.out.println("com.demomodel.configure.springconfFullList.full.Application2"+user.getClass());
            System.out.println("com.demomodel.configure.springconfFullList.full.Application2"+user);
            System.out.println("------------------------");
        }
    }
}
//https://blog.csdn.net/f641385712/java/article/details/106127418