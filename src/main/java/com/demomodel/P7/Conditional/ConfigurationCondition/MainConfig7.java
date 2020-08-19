package com.demomodel.P7.Conditional.ConfigurationCondition;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({BeanConfig1f.class, BeanConfig2f.class})
public class MainConfig7 {
}