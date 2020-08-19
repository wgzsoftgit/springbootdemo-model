package com.demomodel.P7.Conditional;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig4 {
	//阻止bean的注册
	@Conditional(MyCondition1.class) // @1
	@Bean
	public String name() {
		return "路人甲Java";
	}

	@Bean
	public String address() {
		return "上海市";
	}
}
