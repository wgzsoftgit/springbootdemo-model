package com.demomodel.utils.de.TimeStamp.getData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class GetDatesBettonTest {

	public static void main(String[] args) throws ParseException {
		System.out.println(getDates("2019-06-10", "2019-06-14"));
		//1.03 转化 103
		System.out.println(String.format("%.0f", Float.valueOf("1.03")*100));

	}

/**
  * 获取两个日期之间的所有日期
  *
  * @param startDate开始日期
  * @param endDate 结束日期
  * @return List集合
 * @throws ParseException 
  */

public static List<String> getDates(String startDate, String endDate) throws ParseException {

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 List<String> list = new ArrayList<String>(); //保存日期的集合
   Date date_start = sdf.parse(startDate);
 Date date_end = sdf.parse(endDate);
 Date date =date_start;
Calendar cd = Calendar.getInstance();//用Calendar 进行日期比较判断
while (date.getTime() <= date_end.getTime()){
	System.err.println(sdf.format(date));
list.add(sdf.format(date));
cd.setTime(date);
cd.add(Calendar.DATE, 1);//增加一天 放入集合
date=cd.getTime();
}

 String strList = StringUtils.strip(list.toString(),"[]");//去掉符号[]

System.out.println(list);

System.out.println(strList);

 return list ;

}
}
//https://blog.csdn.net/YYX_2018/java/article/details/92771756