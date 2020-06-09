package com.demomodel.configure.springconfFullList.full;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demomodel.configure.springconfFullList.ConfigurationAndBean.Userc;

@Configuration
public class FullConfig {

    @Bean
    public Userc user() {
        Userc user = new Userc();
        user.setName("A哥-lite");
        user.setAge(18);
        return user;
    }


    @Bean
    protected Userc user2() {
        Userc user = new Userc();
        user.setName("A哥-lite2");
        user.setAge(18);

        // 模拟依赖于user实例  看看是否是同一实例
        System.out.println("com.demomodel.configure.springconfFullList.full.FullConfig"+System.identityHashCode(user()));
        System.out.println("com.demomodel.configure.springconfFullList.full.FullConfig"+System.identityHashCode(user()));
  
        return user;
    }

    public static class InnerConfig {

        @Bean
        // private final Userc userInner() { // 只在lite模式下才好使
        public Userc userInner() {
            Userc user = new Userc();
            user.setName("A哥-lite-inner");
            user.setAge(18);
            return user;
        }
    }
}
//https://blog.csdn.net/f641385712/java/article/details/106127418