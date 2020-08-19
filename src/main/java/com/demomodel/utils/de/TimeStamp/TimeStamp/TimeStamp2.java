package com.demomodel.utils.de.TimeStamp.TimeStamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStamp2 {
	public static void main(String[] args) {
		
	}
	
//	/**
//	  * 10位13位时间戳转String 格式（2018-10-15 16:03:27） 日期
//     * @param timestamp
//     * @param simpleDateFormatType 时间戳类型
//     	 * @return
//	 */
    public static String numberDateFormat(String timestamp,String  simpleDateFormatType){
        SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormatType);//要转换的时间格式 yyyy-MM-dd HH:mm:ss
        String date = null;
        if (timestamp.length() == 13){
            date = sdf.format(Long.parseLong(timestamp));
        }else{
            date = sdf.format(Long.parseLong(timestamp)*1000);
        }
        return date;
    }
//https://blog.csdn.net/a985548426/article/details/83060818

    /**
        *  10位13位时间戳转Date
        * @param timestamp 参数时间戳
        * @param simpleDateFormatType 时间戳类型（"yyyy-MM-dd HH:mm:ss"）
        * @return
        */
       public static Date numberDateFormatToDate(String timestamp,String  simpleDateFormatType){
           SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormatType);//要转换的时间格式
           Date date = null;
           try {
               if (timestamp.length() == 13){
                   date = sdf.parse(sdf.format(Long.parseLong(timestamp)));
               }else{
                   date = sdf.parse(sdf.format(Long.parseLong(timestamp)*1000));
               }
           } catch (ParseException e) {
               e.printStackTrace();
           }
           return date;
       }

/**
     * Date转10位13位时间戳
     * @param date  参数date
     * @param n     需要转换成几位时间戳
     * @return
     */
    public static String numberDateFormatToDate(Date date,int n){
        String result = null;
        if (n == 13){
             result = String.valueOf(date.getTime());
        }else {
             result = String.valueOf(date.getTime()/1000);
        }
        return  result;
    }

}