package com.demomodel.P7.Conditional.ConfigurationCondition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig2f {
    @Bean
    public String name() {
        return "路人甲Java";
    }
}