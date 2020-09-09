package com.demomodel.P7.beanInit.BeanDemo.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @0：这个地方是关键，方法上标注了@Bean，并且方法中是有参数的，
 spring调用这个方法创建bean的时候，会将参数中的两个参数注入进来。
注入对象的查找逻辑可以参考上面@Autowired标注方法时查找候选者的逻辑。
 * @author wgz
 * @date 创建时间：2020年8月20日 下午8:03:29
 */
@Configuration
public class MainConfig15 {
    @Bean
    public Service1 service1() {
        return new Service1();
    }
 
    @Bean
    public Service2 service2() {
        return new Service2();
    }
 
    @Bean
    public Service3 service3(Service1 s1, Service2 s2) { //@0
        Service3 service3 = new Service3();
        service3.setService1(s1); //@1
        service3.setService2(s2); //@2
        return service3;
    }
    
 //@0：方法由2个参数，第二个参数上标注了@Autowired(required = false)，
 //说明第二个参数候选者不是必须的，找不到会注入一个null对象；第一个参数候选者是必须的，找不到会抛出异常
    
//@Bean
//public Service3 service3_0(Service1 s1, @Autowired(required = false) Service2 s2) { //@0
//    Service3 service3 = new Service3();
//    service3.setService1(s1); //@1
//    service3.setService2(s2); //@2
//    return service3;
//}
}