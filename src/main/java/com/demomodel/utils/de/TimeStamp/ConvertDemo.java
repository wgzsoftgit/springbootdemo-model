package com.demomodel.utils.de.TimeStamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDemo {

/**
* 日期转换成字符串
* @param date
* @return str
*/
public static String DateToStr(Date date) {

 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 String str = format.format(date);
 return str;
}

/**
* 字符串转换成日期
* @param str
* @return date
*/
public static Date StrToDate(String str) {

 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 Date date = null;
 try {
 date = format.parse(str);
 } catch (ParseException e) {
 e.printStackTrace();
 }
 return date;
}

public static void main(String[] args) {

 Date date = new Date();
 System.out.println("日期转字符串：" + ConvertDemo.DateToStr(date));
 System.out.println("字符串转日期：" + ConvertDemo.StrToDate(ConvertDemo.DateToStr(date)));

}

}
//https://blog.csdn.net/yrryyff/java/article/details/83546656