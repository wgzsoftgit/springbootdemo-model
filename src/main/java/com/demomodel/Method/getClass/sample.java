package com.demomodel.Method.getClass;
public class sample{
  public static void main(String[] args){
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