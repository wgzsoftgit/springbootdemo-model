package com.demomodel.configure.AOP;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("AopAddRequest")
public class AopAddRequestController {
	//http://localhost:9093/AopAddRequest/hello.do?username='sa'
	@RequestTimes(count = 3, time = 60000)
	    @RequestMapping("hello.do")
	    public String hello(String username, HttpServletRequest request) {
	        System.out.println(request.getAttribute("ifovertimes"));
	        if (request.getAttribute("ifovertimes").equals("false")) {
	            System.out.println("com.demomodel.configure.AOP.AopAddRequest"+username);
	            return "hello redis_springboot_mybatis_mysql";
	        }
	        return "HTTP请求超出设定的限制";
	    }
	//https://blog.csdn.net/tuesdayma/java/article/details/79704238
}

