package com.demomodel.appListener.getservlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.mybatis.generator.config.PropertyHolder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
//@Component
public class Setservletdemo implements ServletContextAware {
	 private static ServletContext servletContext;
	    private static String uploadDir;
	
	//获取token存入ServletContext
	@Override
	public void setServletContext(ServletContext servletContext) {
		Setservletdemo.servletContext = servletContext;
        servletContext.setAttribute("uploadDir", uploadDir);
		servletContext.setAttribute("token", "sadssdd");
	}

	//其他地方调用servletContext获取token
	private static void getServletContextTokenPro() {
		WebApplicationContext  webApplicationContext=ContextLoader.getCurrentWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		servletContext.getAttribute("token");
	}
	//获取  调用httpclient  存token
	 private static void tokenPro() {
	        Properties pro=new Properties();
	        pro.setProperty("token","");
	        try {
	            File file=new File("src/main/resources/token.properties");
	            OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream(file));
	            pro.store(writer,"setToken");
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 //从配置文件(/application.properties)给属性赋值，其中upload.dir 配置文件在项目根路径，里面定义了upload.dir才能赋值成功，否则初始化事值为null
	    @Value("${upload.dir}")
	    public void setUploadDir(String uploadDir) {
	    	Setservletdemo.uploadDir = uploadDir;
	    }
	
	 
}
