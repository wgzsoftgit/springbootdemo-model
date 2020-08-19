package com.demomodel.P7.Conditional.ConfigurationCondition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig1f {
    @Bean
    public Service service() {
        return new Service();
    }
}