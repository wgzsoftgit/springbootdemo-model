package com.demomodel.utils.StringUtils;

import org.springframework.util.StringUtils;

public class UtilsDemo {

	public static void main(String[] args) {
		text();
	}
	public static void text() {
		

String packageName = "tttt,;yyyy;oooo,xxxxx";
String packageName1="";
String[] PackageArray = null;
boolean hasLength = StringUtils.hasLength(packageName1);  //判断String类型是否有值
System.err.println(hasLength);
if (org.springframework.util.StringUtils.hasLength(packageName)) {
	//按  ,  ；分隔字符串
   PackageArray = org.springframework.util.StringUtils.tokenizeToStringArray(packageName, ",; \t\n");
}
for (String str : PackageArray) {
   System.out.println(str);
}
	}
}
