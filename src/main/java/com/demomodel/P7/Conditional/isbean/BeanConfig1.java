package com.demomodel.P7.Conditional.isbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
//配置类1
@Configuration
public class BeanConfig1 {

	@Conditional(OnMissingBeanCondition.class) //@1 @1：方法之前使用了条件判断
    @Bean
    public IService service1() {
        return new Service1();
    }
}
