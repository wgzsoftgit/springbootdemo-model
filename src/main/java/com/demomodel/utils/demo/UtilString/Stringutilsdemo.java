package com.demomodel.utils.demo.UtilString;

import java.sql.Timestamp;

public class Stringutilsdemo {
public static void main(String[] args) {
	String str="saSdsa saSNF .dsa";
	System.err.println("String的长度"+str.length());  //12
	System.err.println("转小写"+str.toLowerCase());  //sasdsa sasnf
	System.err.println("转大写"+str.toUpperCase());//SASDSA SASNF
	 System.out.println("比较字符串"+"sa".compareTo("saSdsa")); //-4
	 System.out.println("比较字符串"+"saSdsa".compareTo("sa")); //4
	 System.out.println("比较字符串"+"saSdsa".compareTo("saSdsa")); //0
	 System.out.println("比较字符串"+"saSdsawssw".compareTo("saSdsa"));  //4
	 System.err.println(str.indexOf(".")); //13
	 System.err.println(str.contains("sa"));//true //该方法是判断字符串中是否有子字符串。如果有则返回true，如果没有则返回false。
    String[] tokens = str.toLowerCase().split("\\W+");
    for (String token : tokens) {
        if (token.length() > 0) {
            System.err.println("分隔后"+token);  
           
        }
    }
    System.err.println(new Timestamp(System.currentTimeMillis()));
}

}
