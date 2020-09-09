package com.demomodel.controller.lazyHtmldemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("lazyHtmldemo")
public class lazyHtmldemo {
	@RequestMapping("index")
	public String index() {
		  return "lazyhtml/lazyHtmldemo";  
	}
	@RequestMapping("index2")   //推荐   页面只加载一次
	public String index2()throws Exception {
		
		
		  return "lazyhtml/lazyHtmldemo2";  
	}
}
