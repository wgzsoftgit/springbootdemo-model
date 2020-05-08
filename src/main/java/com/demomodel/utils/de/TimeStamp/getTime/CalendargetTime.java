package com.demomodel.utils.de.TimeStamp.getTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CalendargetTime {
	public static void main(String[] args) {
		System.out.println(
				"时间为：\n" + getDate1() + "\n" + getDate2() + "\n" + getDate3() + "\n" + getDate4() + "\n" + getDate5());
	//2020-04-16 00:00:00
//		2020-04-16 12:00:00
//		2020-04-13 00:00:00
//		2020-04-01 00:00:00
//		2020-05-01 00:00:00
		System.out.println(getDate6(1));//2020-04-16 16:09:09
		getDA();
	}
	public static void getDA() {
		int total=0;
		int ta=0;
		for (int i=0;i<7;i++) {
			ta++;
			System.err.print("ta"+ta);
			if (ta == 6) {
				break;
			}
		}
		stop: while (total < 6) { // 之后查询车辆实时预警信息,拼接上一次返回的NextMsgId；
			total++;
        System.err.println(total);
        if(total==3) {
        	break stop;
        }
		
		}
		
	}
/**
 * 当前时间减一个小时
 * @param count
 * @return String
 */
	public static String getDate6(int count) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());//获取当前时间
		cal.set(Calendar.HOUR_OF_DAY,cal.get(Calendar.HOUR_OF_DAY)+count ); //减一个小时
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(cal.getTime());
	}
	
	/*
	 * Calendar.HOUR_OF_DAY 24小时制 Calendar.HOUR 12小时制
	 */

/**
 * 获取当天0点时间
 * @return
 */
	public static String getDate1() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);// 控制时
		cal.set(Calendar.MINUTE, 0);// 控制分
		cal.set(Calendar.SECOND, 0);// 控制秒
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(cal.getTime());
	}

/**
 * 获取当天12点时间
 * @return
 */
	public static String getDate2() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 12);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(cal.getTime());
	}

/**
 * 获取本周一0点时间
 * @return String
 */
	public static String getDate3() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(cal.getTime());
	}

/**
 * 获取本月第一天0点时间
 * @return
 */
	public static String getDate4() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(cal.getTime());
	}

	/**
	 *  获得本月最后一天24点时间
	 * @return String
	 */
	public static String getDate5() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 24);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(cal.getTime());
	}

}
//https://blog.csdn.net/qq_36932624/java/article/details/85301769