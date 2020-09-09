package com.demomodel.P7.beanInit.Primary.functiondemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
/**
 通过@Bean定义上面3个类型的bean
 @1：这个bean被标注为主要的候选者
 * @author wgz
 * @date 创建时间：2020年8月20日 下午5:14:30
 */
@Configuration
public class MainConfig13 {
 
    @Bean
    public IService service1() {
        return new ServiceAudev1();
    }
 
    @Bean
    @Primary //@1
    public IService service2() {
        return new ServiceAudev2();
    }
 
    @Bean
    public InjectService injectService() {
        return new InjectService();
    }
}