package com.demomodel.utils.de.http.fengzhuang.config;

import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.demomodel.utils.de.http.fengzhuang.KeepLogin;
import com.demomodel.utils.de.http.fengzhuang.Login;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
//@Component("Autothorization")
//@Configuration
public class Autothorization implements ServletContextAware {

	@Value("${ip}")
	private String ip;
	@Value("${port}")
	private Integer port;
	@Value("${userName}")
	private String userName;
	@Value("${password}")
	private String password;
	
	@Autowired
	private KeepLogin KeepLoginService;
	@Override
	public void setServletContext(ServletContext servletContext) {
		Gson gson=new Gson();
		try {
			Map<String, Object> map=gson.fromJson(Login.login(ip, port, userName, password), new TypeToken<Map<String, Object>>(){}.getType());
		   String token =(String) map.get("token");
		   servletContext.setAttribute("token", token);  //上下文中绑定token  存入
		   KeepLoginService.keepAlive(ip, port, token);
		 System.err.println("authorzed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
