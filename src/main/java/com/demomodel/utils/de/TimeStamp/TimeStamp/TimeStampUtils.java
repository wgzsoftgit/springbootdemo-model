package com.demomodel.utils.de.TimeStamp.TimeStamp;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
/**
 * 截取当前时间时分秒 转成整型
 * @author zbj
 *
 */
public class TimeStampUtils {
	public static Long parsingLong(Double time) {
		String[] timeString = time.toString().split("E");
		String dateString = timeString[0].replace(".", "");
		return dateString.length() == 13 ? Long.valueOf(dateString) : Long.valueOf(dateString + "0");
	}

	public static String transferLongToDate(Long millSec) {
		String dateFormat = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date = new Date(millSec);
		return sdf.format(date);
	}
	
	public static String transferHourToDate(Long millSec) {
		String dateFormat = "HH:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date = new Date(millSec);
		return sdf.format(date);
	}
	
	public static Long transferDateToLong(String time) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse(time);
		return date.getTime();
	}

	public static String transferLongToDateAccurateHour(Long millSec) {
		String dateFormat = "yyyy-MM-dd/HH";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date = new Date(millSec);
		return sdf.format(date);
	}
	
	public static String dateToString(Date date) {
		SimpleDateFormat  sf = new SimpleDateFormat("yyyy-MM-dd");
		return sf.format(date);
	}

	
	static class Testysw {

		public static void main(String[] args) {
			Date date = new Date();
			String strDateBegin = "17101328";
			String q = strDateBegin.substring(1,3);
			String strDateEnd = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
			String strDate = sdf.format(date); // 2016-12-16 11:53:54
			// 截取当前时间时分秒 转成整型
			int tempDate = Integer
					.parseInt(strDate.substring(11, 13) + strDate.substring(14, 16) + strDate.substring(17, 19));
			// 截取开始时间时分秒 转成整型
			int tempDateBegin = Integer.parseInt(
					strDateBegin.substring(0, 2) + strDateBegin.substring(3, 5) + strDateBegin.substring(6, 8));
			// 截取结束时间时分秒 转成整型
			/*int tempDateEnd = Integer
					.parseInt(strDateEnd.substring(0, 2) + strDateEnd.substring(3, 5) + strDateEnd.substring(6, 8));*/
			System.out.println(strDate);
			System.out.println("截取当前时间时分秒 转成整型"+tempDate);
			System.out.println(tempDateBegin);
            System.out.println("截取2位"+q);
			/*if ((tempDate >= tempDateBegin && tempDate <= tempDateEnd)) {
				return true;
			} else {
				return false;
			}*/
		}
	}
}
