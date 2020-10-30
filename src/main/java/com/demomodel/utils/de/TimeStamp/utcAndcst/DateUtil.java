package com.demomodel.utils.de.TimeStamp.utcAndcst;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;



/**
 * 前言：需要做时区转换，知道北京为UTC+8，东京为UTC+9，世界标准时间为UTC，所以下面的代码是只需要知道时区是+8还是+9还是0就可以了，
 * 不需要使用"CTT"、 "Asia/Shanghai"这种形式。
 * @author wgz
 * @date 创建时间：2020年10月28日 下午3:51:55
 */
public class DateUtil {
	public static void main(String[] args) {
		 String result = DateUtil.timeZoneTransfer("2018-07-03 15:43", "yyyy-MM-dd HH:mm", "+8", "0");
	        Assert.assertEquals("转换错误", "2018-07-03 07:43", result);

	        result = DateUtil.timeZoneTransfer("2018-07-03 15:43", "yyyy-MM-dd HH:mm", "+9", "0");
	        Assert.assertEquals("转换错误", "2018-07-03 06:43", result);

	        result = DateUtil.timeZoneTransfer("2018-07-03 15:43", "yyyy-MM-dd HH:mm", "-1", "0");
	        Assert.assertEquals("转换错误", "2018-07-03 16:43", result);

	        result = DateUtil.timeZoneTransfer("2018-07-03 15:43", "yyyy-MM-dd HH:mm", "+8", "+9");
	        Assert.assertEquals("转换错误", "2018-07-03 16:43", result);

	        result = DateUtil.timeZoneTransfer("2018-07-03 15:43", "yyyy-MM-dd HH:mm", "+0", "+8");
	        Assert.assertEquals("转换错误", "2018-07-03 23:43", result);

	        result = DateUtil.timeZoneTransfer("2018-07-03 15:43", "yyyy-MM-dd HH:mm", "+0", "0");
	        Assert.assertEquals("转换错误", "2018-07-03 15:43", result);
	}
	public void testTimeZoneTransfer(){
       
    }
	/**
     * 时区转换
     * @param time 时间字符串
     * @param pattern 格式 "yyyy-MM-dd HH:mm"
     * @param nowTimeZone eg:+8，0，+9，-1 等等
     * @param targetTimeZone 同nowTimeZone
     * @return
     */
    public static String timeZoneTransfer(String time, String pattern, String nowTimeZone, String targetTimeZone) {
        if(StringUtils.isBlank(time)){
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT" + nowTimeZone));
        Date date;
        try {
            date = simpleDateFormat.parse(time);
        } catch (Exception e) {
       
            return "";
        }
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT" + targetTimeZone));
        return simpleDateFormat.format(date);
    }
}
