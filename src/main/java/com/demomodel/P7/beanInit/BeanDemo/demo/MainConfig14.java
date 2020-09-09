package com.demomodel.P7.beanInit.BeanDemo.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 //上面代码中通过@Bean定义了3个bean

//Service3中需要用到Service1和Service2，注意@1和@2直接调用当前方法获取另外2个bean，注入到service3中
@Configuration
public class MainConfig14 {
    @Bean
    public Service1 service1() {
        return new Service1();
    }
 
    @Bean
    public Service2 service2() {
        return new Service2();
    }
 
    @Bean
    public Service3 service3() {
        Service3 service3 = new Service3(); //@0
        service3.setService1(this.service1()); //@1
        service3.setService2(this.service2()); //@2
        return service3;
    }
}