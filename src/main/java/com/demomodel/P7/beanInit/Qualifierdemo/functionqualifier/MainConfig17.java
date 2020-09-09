package com.demomodel.P7.beanInit.Qualifierdemo.functionqualifier;

import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demomodel.P7.beanInit.Qualifierdemo.functionqualifier.IService;
import com.demomodel.P7.beanInit.Qualifierdemo.functionqualifier.InjectService;


@Configuration
public class MainConfig17 {
 
    @Bean
    @Qualifier("tag1") //@1
    public Servicefu1 service1() {
        return new Servicefu1();
    }
 
    @Bean
    @Qualifier("tag1") //@2
    public Servicefu2 service2() {
        return new Servicefu2();
    }
 
    @Bean
    @Qualifier("tag2") //@3
    public Servicefu3 service3() {
        return new Servicefu3();
    }
 
    @Bean
    public InjectService injectService(@Qualifier("tag1") Map<String, IService> map1) { //@4
        InjectService injectService = new InjectService();
        injectService.setServiceMap1(map1);
        return injectService;
    }
}