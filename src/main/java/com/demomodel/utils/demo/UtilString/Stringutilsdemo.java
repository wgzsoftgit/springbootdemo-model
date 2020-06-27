package com.demomodel.utils.demo.UtilString;

import java.sql.Timestamp;

public class Stringutilsdemo {
public static void main(String[] args) {
	//1.03 转化 103
	System.out.println(String.format("%.0f", Float.valueOf("1.03")*100));
	//转化成百分比
	System.out.println("百分比"+String.format("%.0f", Float.valueOf("0.03")*100)+'%');
	String currentPage="22";
	int current = Integer.parseInt(currentPage);  //
	System.err.println(current);//String  ==》int
	
	
	String str="saSdsa saSNF .dsa";
	System.err.println("String的长度"+str.length());  //12  字符串长度
	System.err.println("转小写"+str.toLowerCase());  //sasdsa sasnf 转小写
	System.err.println("转大写"+str.toUpperCase());//SASDSA SASNF 
	 System.out.println("比较字符串"+"sa".compareTo("saSdsa")); //-4
	 System.out.println("比较字符串"+"saSdsa".compareTo("sa")); //4
	 System.out.println("比较字符串"+"saSdsa".compareTo("saSdsa")); //0
	 System.out.println("比较字符串"+"saSdsawssw".compareTo("saSdsa"));  //4
	 System.err.println(".存在的位置"+str.indexOf(".")); //13
	 System.err.println("该方法是判断字符串中是否有子字符串"+str.contains("sa"));//true //该方法是判断字符串中是否有子字符串。如果有则返回true，如果没有则返回false。
    String[] tokens = str.toLowerCase().split("\\W+");
    for (String token : tokens) {
        if (token.length() > 0) {
            System.err.println("分隔后"+token);  
           
        }
    }
    System.err.println("时间"+new Timestamp(System.currentTimeMillis()));
}

}
