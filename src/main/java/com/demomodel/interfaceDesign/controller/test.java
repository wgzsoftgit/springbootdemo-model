package com.demomodel.interfaceDesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demomodel.interfaceDesign.getContent;
import com.demomodel.interfaceDesign.interfaces.PersonAnnotationService;
import com.demomodel.interfaceDesign.interfaces.PersonZxyCoding;

@RestController
public class test {
	//@Autowired
	//private PersonService personService;
	
	@Autowired
	private PersonZxyCoding personZxyCoding;
 
	@RequestMapping("/text")
	public String index() {
		//第一种方式获取有关的实现类
		//接口
		PersonAnnotationService annotationService=personZxyCoding;
		annotationService.testPrint();
		
		//第二种方式获取有关的实现类                          getContent工具类
		//获取map中存储的对象 根据key即personInfo进行区分       来获取对象
		PersonAnnotationService personService=(PersonAnnotationService) getContent.getPersonbeanmap.get("PersonCoding2Serviceimpl+config.personInfoCoding");
		personService.testPrint();
		return "Hellow my friend.  my name is Spring BOOT";
		
	}
//https://blog.csdn.net/zxysshgood/java/article/details/78399980
}
