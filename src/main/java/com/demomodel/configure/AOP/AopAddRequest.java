package com.demomodel.configure.AOP;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("AopAddRequest")
public class AopAddRequest {
	@RequestTimes(count = 3, time = 60000)
	    @RequestMapping("hello.do")
	    public String hello(String username, HttpServletRequest request) {
	        System.out.println(request.getAttribute("ifovertimes"));
	        if (request.getAttribute("ifovertimes").equals("false")) {
	            System.out.println(username);
	            return "hello redis_springboot_mybatis_mysql";
	        }
	        return "HTTP请求超出设定的限制";
	    }
	//https://blog.csdn.net/tuesdayma/java/article/details/79704238
}

