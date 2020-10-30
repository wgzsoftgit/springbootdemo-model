package com.demomodel.utils.fuzhu.goShopping;

import java.util.Iterator;
import java.util.Random;

public class test1 
{
	
	
    public static void main( String[] args ) throws InterruptedException
    {
    	//Redmi K30 Pro 8GB+128GB 天际蓝
//    	myThread th1 = new myThread("A");   // 开启5个线程 等同于开启5个浏览器 实时监听
//    	myThread th2 = new myThread("B");
//    	myThread th3 = new myThread("C");
//    	myThread th4 = new myThread("D");
//    	myThread th5 = new myThread("E");
    	
//    	th1.start();
//    	th2.start();	
//    	th3.start();
//    	th4.start();
//    	th5.start();
    	//1个线程跑  10s完成登录  15s进入页面
    	
    	//5线程跑   提前1分钟完成登录
    	for (int i = 0; i < 1; i++) {
    		myThread th1 = new myThread("A"+System.currentTimeMillis()+i);  
    		th1.start();
		
		}
    		
    		
    	
	}
    	
        
}