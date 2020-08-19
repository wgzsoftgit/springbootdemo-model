package com.demomodel.P7.Conditional.ConfigurationCondition.panduan;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.demomodel.P7.Conditional.ConfigurationCondition.BeanConfig1f;

@Configuration
@Import({BeanConfig1f.class, BeanConfig21.class})
public class MainConfig71 {
}