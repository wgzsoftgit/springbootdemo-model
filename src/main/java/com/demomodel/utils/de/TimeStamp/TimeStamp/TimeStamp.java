package com.demomodel.utils.de.TimeStamp.TimeStamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 时间戳转换时间操作  13位的
 * @author zbj
 *
 */
public class TimeStamp {
	public static void main(String[] args) throws ParseException {
		
		//        ------------------------13位
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(new Date())); //2020-04-16
		System.out.println("将时间转换为时间戳"+dateToStamp2(sdf.format(new Date())));//1586966400000 String
		SimpleDateFormat sdfw = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//  这个和数据库一样
		System.out.println(sdfw.format(new Date())); //2020-04-16 10:51:11
		System.out.println("将时间转换为时间戳"+dateToStamp(sdfw.format(new Date())));//1586966400000 String
		
		long timeStamp = System.currentTimeMillis();  
		System.err.println("时间戳"+timeStamp); //1587027139353   13位
		//这个是你要转成后的时间的格式
		SimpleDateFormat sdff=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 时间戳转换成时间
		String sd = sdff.format(new Date(timeStamp));   
		System.out.println("sd:"+sd);//打印出你要的时间 2020-04-16 16:52:19
		System.out.println("13位 将时间转换为时间戳 yyyy-MM-dd HH:mm:ss"+dateToStamp(sd)); //1587027139000
	
		//-------------------10位
		 long timeStampSec = System.currentTimeMillis()/1000;
	        String timestamps = String.format("%010d", timeStampSec);
	        System.err.println("10位的时间戳 "+timestamps);
		System.out.println("10位 将 13位 时间戳转换为时间戳（10位 ） yyyy-MM-dd HH:mm:ss  ||"+timestampToDate(Long.valueOf(timestamps)));
		
	}
	/**
	 * 时间戳转时间(10位时间戳)    yyyy-MM-dd HH:mm:ss
	 * @param time
	 * @return
	 */
	public static String timestampToDate(long time) {
	    String dateTime;
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    long timeLong = Long.valueOf(time);
	    
	    dateTime = simpleDateFormat.format(new Date(timeLong * 1000L));
	    return dateTime;
	}
	//https://blog.csdn.net/qq_28483283/article/details/80583197
	/**
	 * 将时间转换为时间戳             yyyy-MM-dd HH:mm:ss
	 * @param String   "2020-04-05 12:00:00"
	 * @return String  1586966400000  13位时间戳
	 * @throws ParseException
	 */
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
   
    /** 
     * 将时间转换为时间戳    yyyy-MM-dd
     * @param String   "2020-04-16"  /"2020-04-16 10:51:11"
     * @return String  都返回 "1586966400000"
     * @throws ParseException
     */
    public static String dateToStamp2(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//yyyy-MM-dd HH:mm:ss
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
  
    /**
     * 将时间戳转换为时间    yyyy-MM-dd HH:mm:ss
     * @param String
     * @return String
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
   
    /**
     * 将时间戳转换为时间          yyyy-MM-dd
     * @param String
     * @return String
     */
    public static String stampToDate2(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
//https://blog.csdn.net/weixin_43440301/java/article/details/84105224
}
