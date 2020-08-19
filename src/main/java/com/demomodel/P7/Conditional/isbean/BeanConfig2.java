package com.demomodel.P7.Conditional.isbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
//配置类2
@Configuration
public class BeanConfig2 {

	 @Conditional(OnMissingBeanCondition.class)//@1 @1：方法之前使用了条件判断
	    @Bean
	    public IService service2() {
	        return new Service2();
	    }
}
