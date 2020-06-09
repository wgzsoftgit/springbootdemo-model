package com.demomodel.utils.de.http.fengzhuang.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
/**
 * ip  port  getToken  可以直接在子类用
 * @author wgz
 * @date 创建时间：2020年5月26日 下午3:25:26
 */
@Controller
public class BaseController {

	@Value("${ip}")
	public String ip;
	@Value("${port}")
	public int port;
	
	public  String getToken() {
		WebApplicationContext webApplicationContext=ContextLoader.getCurrentWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		return (String) servletContext.getAttribute("token");   //上下文中绑定token   获取token
	}
	
}
