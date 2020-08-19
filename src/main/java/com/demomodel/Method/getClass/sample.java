package com.demomodel.Method.getClass;

import javax.servlet.ServletContext;

public class sample{
  public static void main(String[] args){
	 //web项目获取路径         
//	  ServletContext servletContext;
//	  String realPath = servletContext.getRealPath("/");  //D:\workspace-eclipse\tspringbootdemo\
	
//   若获取src/main/resources/conf  //需要 	realPath+"WEB-INF/classes/conf"  测试ok
	  
	  
    //得到类的简写名称
    System.out.println(sample.class.getSimpleName());//sample
 
   //得到对象的全路径
   System.out.println(sample.class);//class com.demomodel.Method.getClass.sample
 
   //得到对象的类模板示例，也就是Class
   System.out.println(sample.class.getClass());//class java.lang.Class
 
   //得到Class类的名称
   System.out.println(sample.class.getClass().getName());//java.lang.Class
 } 
}