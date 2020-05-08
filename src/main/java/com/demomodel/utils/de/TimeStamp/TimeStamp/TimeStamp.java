package com.demomodel.utils.de.TimeStamp.TimeStamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 时间戳转换时间操作
 * @author zbj
 *
 */
public class TimeStamp {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(new Date())); //2020-04-16
		System.out.println("将时间转换为时间戳"+dateToStamp2(sdf.format(new Date())));//1586966400000 String
		SimpleDateFormat sdfw = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdfw.format(new Date())); //2020-04-16
		System.out.println("将时间转换为时间戳"+dateToStamp2(sdfw.format(new Date())));//1586966400000 String
		
		long timeStamp = System.currentTimeMillis();  
		System.err.println("时间戳"+timeStamp); //1587027139353
		//这个是你要转成后的时间的格式
		SimpleDateFormat sdff=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 时间戳转换成时间
		String sd = sdff.format(new Date(timeStamp));   
		System.out.println(sd);//打印出你要的时间 2020-04-16 16:52:19
		System.out.println(dateToStamp(sd)); //1587027139000
		
	}
	 
	/**
	 * 将时间转换为时间戳
	 * @param String
	 * @return String
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
     * 将时间转换为时间戳
     * @param String
     * @return String
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
     * 将时间戳转换为时间
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
     * 将时间戳转换为时间
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
