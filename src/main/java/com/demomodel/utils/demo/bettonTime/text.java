package com.demomodel.utils.demo.bettonTime;

public class text {
	
public static void main(String[] args) {
	long startTime = System.currentTimeMillis(); //获取开始时间
	//doSomething(); //测试的代码段
	long endTime = System.currentTimeMillis(); //获取结束时间
	System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间 毫秒
	
	long startTime1=System.nanoTime(); //获取开始时间
	//doSomeThing(); //测试的代码段
	long endTime1=System.nanoTime(); //获取结束时间
	System.out.println("程序运行时间： "+(endTime1-startTime1)+"ns");//纳秒
	
//	1小时=60分钟
//
//			1分钟=60秒
//
//			1秒=1000毫秒
//
//			1毫秒=1000微秒
//
//			1微秒=1000纳秒
//
//			1纳秒=1000皮秒
	
	
	

}
}
