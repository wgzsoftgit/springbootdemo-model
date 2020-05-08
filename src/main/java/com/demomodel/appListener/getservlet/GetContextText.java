package com.demomodel.appListener.getservlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

@RestController
@RequestMapping("contextGetText")
public class GetContextText {
	public String sa="特效图";
	@Autowired
    private ServletContext servletContext;
	@Autowired
    WebApplicationContext webApplicationConnect;
	//方案一
	@RequestMapping("contextGet")
	public void contextGet() {
	System.out.println(servletContext.getAttribute("token"));
	System.out.println(servletContext.getAttribute("uploadDir"));
	System.out.println("上下文"+servletContext.getAttribute("ctx"));
	}
	//方案二
	@RequestMapping("contextGet2")
	public void contextGet2(HttpServletRequest request) {
		ServletContext sc = request.getServletContext();
	System.out.println("测试2"+sc.getAttribute("token"));
	System.out.println("测试2"+sc.getAttribute("uploadDir"));
	}
	//方案三
	@RequestMapping("contextGet3")
	public void contextGet3() {
		//在SpringBoot中，通过ContextLoader获取的方法
		//目前失效。
		//  WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		// ServletContext servletContext = webApplicationContext.getServletContext();
		
		//可以通过自动注入   WebApplicationContext 
		ServletContext servletContext = webApplicationConnect.getServletContext();
	System.out.println("测试2"+servletContext.getAttribute("token"));
	System.out.println("测试2"+servletContext.getAttribute("uploadDir"));
	}
	
}
