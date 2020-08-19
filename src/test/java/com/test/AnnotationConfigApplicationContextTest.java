package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demomodel.WebApplication;

public class AnnotationConfigApplicationContextTest {
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext(WebApplication.class);
	
		//发布事件；
		applicationContext.publishEvent(new ApplicationEvent(new String("我发布的时间")){});
		
		//applicationContext.close();
	}
//https://blog.csdn.net/lizhiqiang1217/java/article/details/92383578
}

