package com.demomodel.P7.Conditional.EnvCondition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnvConditional(EnvConditional.Env.TEST)//@1
public class  TestBeanConfig{
	@Bean
	public String name() {
		return "我是测试环境!";
		}
	}
