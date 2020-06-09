package com.demomodel.filter.handlerInterceptor.use.controller;
import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Response;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demomodel.filter.handlerInterceptor.use.annotation.UserAuthenticate;
import com.demomodel.filter.handlerInterceptor.use.annotation.UserId;
import com.demomodel.filter.handlerInterceptor.use.annotation.UserMobile;
import com.demomodel.utils.httpHelp.HttpHelper;

/**
 * 浏览器输入地址 后台打印
userId : 1 userMobile :18888888888
 * @author wgz
 * @date 创建时间：2020年5月27日 下午9:15:59
 */
@Validated
@RestController
public class TestAuthController {  
	//localhost:9093/filterAuthors?userId=99999&userMobile="测试拦截器"
	@UserAuthenticate
	@GetMapping(value = "filterAuthors")
	public String testAuth(@UserId Long userId,@UserMobile String userMobile, HttpServletRequest request) throws IOException {
		  
		System.err.println("&&&"+HttpHelper.getBodyString(request));
		System.out.println("com.demomodel.filter.handlerInterceptor.use.controller.TestAuthController"+"userId : "+ userId + "  userMobile :" + userMobile);
		return "ok";
	}
	
}
//https://blog.csdn.net/zhibo_lv/java/article/details/81738940