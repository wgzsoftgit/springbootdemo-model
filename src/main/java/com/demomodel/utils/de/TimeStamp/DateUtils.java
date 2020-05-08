/**
 * 
 */
package com.demomodel.utils.de.TimeStamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author shawnkuo
 *
 */
public class DateUtils {

	public final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat ( "yyyy-MM-dd" ) ;
	
	public final static SimpleDateFormat DATE_FORMAT2 = new SimpleDateFormat ( "yyyy/MM/dd" ) ;
	
	public final static SimpleDateFormat DATE_FORMAT_SIMP = new SimpleDateFormat ( "yyyyMMdd" ) ;
	
	public final static SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat ( "yyyy-MM-dd HH:mm" ) ;
	
	public final static SimpleDateFormat DATE_TIME_FORMAT2 = new SimpleDateFormat ( "yyyy/MM/dd HH:mm" ) ;
	
	public final static SimpleDateFormat DATE_TIME_FORMAT_SIMP = new SimpleDateFormat ( "MM-dd HH:mm" ) ;
	
	public final static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat ( "HH:mm" ) ;
	
	public final static SimpleDateFormat DATE_FORMAT_MONTH = new SimpleDateFormat ( "MM" ); 
	
	public final static SimpleDateFormat DATE_FORMAT_DAY = new SimpleDateFormat ( "dd" );
	/**
	 *  String --->Date
	 * @param dateStr
	 * @return Date  
	 */
	public static Date stringToDate(String dateStr) {
		try {
			return DATE_FORMAT.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}
	/**
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date toDate2(String dateStr) {
		try {
			return DATE_FORMAT2.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Date toTime(String time) {
		try {
			return TIME_FORMAT.parse(time);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Date toDateTime(String dateStr) {
		try {
			return DATE_TIME_FORMAT.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Date toDateTime2(String dateStr) {
		try {
			return DATE_TIME_FORMAT2.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static String toTimeString (Date date) {
		String dateTime = DATE_TIME_FORMAT.format(date);
		return dateTime;
	}
	
	public static String toDateTimeSimpString (Date date) {
		String dateTime = DATE_TIME_FORMAT_SIMP.format(date);
		return dateTime;
	}
	
	public static String toDateTimeString (Date date) {
		String dateTime = DATE_TIME_FORMAT.format(date);
		return dateTime;
	}
	
	public static String toDateMonthString(Date date) {
		return DATE_FORMAT_MONTH.format(date);
	}
	
	public static String toDateDayString(Date date) {
		return DATE_FORMAT_DAY.format(date);
	}
	
	public static String toDateString (String date) {
		return DATE_FORMAT.format(stringToDate(date));
	}
	
	public static String toDateIntString(Date date) {
		return DATE_FORMAT_SIMP.format(date);
	}
	
	public static String toDateString (Date date) {
		return DATE_FORMAT.format(date);
	}
	
	public static String getTimeSlot(String dateTime) {
		Date date = toDateTime(dateTime);
		return getTimeSlot(date);
	}
	
	public static String getTimeSlot(Date date) {
		if (date == null) return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int min = calendar.get(Calendar.MINUTE);
		
		String hourLabel = hour < 10 ? String.format("0%s", hour) : String.valueOf(hour);
		String minLabel = min == 0 ? "00" : String.valueOf(min);
		
		return hourLabel+":"+minLabel;
	}
	
	public static String dayOfWeekName (Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		switch(dayOfWeek) {
			case 1: 
				return "星期天";
			case 2:
				return "星期一";
			case 3:
				return "星期二";
			case 4:
				return "星期三";
			case 5:
				return "星期四";
			case 6:
				return "星期五";
			case 7:
				return "星期六";
			default:
				return "";
		}
	}
	
	public static String dayOfWeekName (String dateStr) {
		try {
			Date date = DATE_FORMAT.parse(dateStr);
			return dayOfWeekName(date);
		} catch (Exception ex) {
			return "";
		}
	}
	
	public static void main(String [] args) {
		String slot1 = "01:30";
		String slot2 = "23:47";
		System.out.println("获取当前时间的时和分"+DateUtils.getTimeSlot(new Date()));
		System.out.println("判断两个时间的先后顺序"+DateUtils.toTime(slot1).before( DateUtils.toTime(DateUtils.getTimeSlot(new Date()))));
		System.err.println("根据时间判断星期几"+dayOfWeekName(new Date()));
		System.out.println(dayOfWeekName("2020-04-30 14:04:46"));
//		14:6
//		false
//		星期四
//		星期四
	}
}
