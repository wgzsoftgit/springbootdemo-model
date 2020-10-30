package com.demomodel.utils.de.TimeStamp.utcAndcst;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author 王睿
 * @date 2019-01-24 14:32
 */
public class TimeFormat {

    public static void main(String[] args) throws ParseException {
        String text = "2019-01-03T08:26:15.503162206Z";
        text = "2020-10-29T09:59:15Z";
        Date date = parseUTCText(text);
        System.out.println(date);
        getCurrentUtcTime();
    }

    //获取UTC格式时间
    public static void getCurrentUtcTime() {
        Date l_datetime = new Date();
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        TimeZone l_timezone = TimeZone.getTimeZone("GMT-0");
        formatter.setTimeZone(l_timezone);
        String l_utc_date = formatter.format(l_datetime);
        System.out.println(l_utc_date + " (Local)");
}
    /**
     * @param text 时间字符串，格式支持两种
     *             1、不包含毫秒值，如"2019-01-03T08:26:15Z"；
     *             2、支持任意位数的毫秒值：2019-01-03T08:26:15.503162206Z；
     *             转换出来的Date类型精度知道毫秒位
     * @return
     * @throws ParseException
     */
    public static Date parseUTCText(String text) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        if (text.indexOf(".") > -1) {
            String prefix = text.substring(0, text.indexOf("."));
            String suffix = text.substring(text.indexOf("."));
            if (suffix.length() >= 5) {
                suffix = suffix.substring(0, 4) + "Z";
            } else {
                int len = 5 - suffix.length();
                String temp = "";
                temp += suffix.substring(0, suffix.length() - 1);
                for (int i = 0; i < len; i++) {
                    temp += "0";
                }
                suffix = temp + "Z";
            }
            text = prefix + suffix;
        } else {
            text = text.substring(0, text.length() - 1) + ".000Z";
        }
        System.err.println(text);
        Date date = sdf.parse(text);
        return date;
    }

}