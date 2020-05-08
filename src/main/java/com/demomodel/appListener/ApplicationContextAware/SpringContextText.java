package com.demomodel.appListener.ApplicationContextAware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demomodel.appListener.getservlet.GetContextText;


@RestController 
@RequestMapping("SpringContextText")
public class SpringContextText {
	@Autowired
    SpringBeanTool springBeanTool;
	
	@RequestMapping("SpringcontextGet")
	public void contextGet() {
		//自定义工具类获取 bean
	GetContextText userService1 = springBeanTool.getBean("getContextText", GetContextText.class);
	System.out.println(userService1.sa);
	}
}
