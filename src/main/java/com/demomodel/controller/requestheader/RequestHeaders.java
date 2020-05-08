package com.demomodel.controller.requestheader;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demomodel.bean.Pet;


public class RequestHeaders {
	//-----------------------------1.headers
	//Accept=application/json ：表示客户端希望接受的数据类型是json
	@RequestMapping(value = "/test/ContentType", headers = "Accept=application/json")  
	public void test1(HttpServletResponse response) throws IOException {  
	    //表示响应的内容区数据的媒体类型为json格式，且编码为utf-8(客户端应该以utf-8解码)  
	    response.setContentType("application/json;charset=utf-8");  
	    //写出响应体内容  
	    String jsonData = "{\"username\":\"zhang\", \"password\":\"123\"}";  
	    response.getWriter().write(jsonData);  
	}
	
	
	//content-type =application/json ：表示客户端发送的数据格式是json
	@RequestMapping(value = "/test/ContentType", headers = {"content-type = application/json"})  
	public void test2(@RequestBody Pet pet) throws IOException {  
	    // TODO
	}
	
	//-------------------------consumes
	
	//仅处理request Content-Type为“application/json”类型的请求
	@RequestMapping(value = "/test/produces", method = RequestMethod.POST, consumes="application/json")  
	public void test(@RequestBody Pet pet, Model model) {      
	    // TODO
	}
	
	//处理request Content-Type，定义的2种类型的请求1
	@RequestMapping(consumes = {"application/json","application/x-www-form-urlencoded"})
	public void test2(@RequestBody Pet pet, Model model) {      
	    // TODO
	}

	//处理request Content-Type中，除了以下2种类型的请求2
	@RequestMapping(consumes = {"!application/json","!application/x-www-form-urlencoded"})
	public void test3(@RequestBody Pet pet, Model model) {      
	    // TODO
	}
	
	//produces
	//返回json数据 && 字符编码为utf-8
	@RequestMapping(value = "/test/consumes", method = RequestMethod.POST, produces="application/json;charset=utf-8")    
	@ResponseBody    
	public Pet test3(@PathVariable String petId, Model model) {       
	    // TODO
		return null;
	} 

	
	//https://blog.csdn.net/weixin_43453386/article/details/83512451
}

