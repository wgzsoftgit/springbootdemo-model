package com.demomodel.configure.springconfFullList.ConfigurationAndBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig1 {

    @Bean
    public Userc userc(){
        Userc user = new Userc();
        user.setName("A哥");
        user.setAge(18);
        return user;
    }

}
//https://blog.csdn.net/f641385712/java/article/details/106127418