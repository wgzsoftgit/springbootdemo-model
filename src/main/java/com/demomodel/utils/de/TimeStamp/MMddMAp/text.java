package com.demomodel.utils.de.TimeStamp.MMddMAp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;


/**
 * 最近30天的日期   用于折现图
 * @author wgz
 * @date 创建时间：2020年10月28日 上午8:58:26
 */
public class text {

	public Map<String, SingCheckInRoom> selectByhotelCode(String hotelCode) throws ParseException {
//		Map<String, SingCheckInRoom> map=new LinkedHashMap<>();
		/**  mysql 最近30天
		 *      select DATE_FORMAT(s.check_in_date,'%m-%d') AS  checkdate , 
   count(s.check_in_date) as total_count , y.single_room_count
   from sing_person_occupancy s  
   left join 
  (
		select hotel_code,checkdate,
    count(*) as single_room_count
    from (select rowkey, hotel_code, DATE_FORMAT(check_in_date,'%m-%d') AS  checkdate
   from sing_person_occupancy 
   where check_in_date &gt;= DATE_SUB(now(),INTERVAL 30 DAY)  and check_in_date &lt; DATE_FORMAT(now(),'%y-%m-%d %H:%i:%s')
     group by rowkey, hotel_code, checkdate 
      having count(rowkey) = 1
    ) c
    where hotel_code = #{hotelCode}
     group by hotel_code, c.checkdate
  ) y on y.hotel_code = s.hotel_code and y.checkdate = DATE_FORMAT(s.check_in_date,'%m-%d')
   
   WHERE s.hotel_code=#{hotelCode}
   and s.check_in_date &gt;= DATE_SUB(now(),INTERVAL 30 DAY)  and s.check_in_date &lt; DATE_FORMAT(now(),'%y-%m-%d %H:%i:%s')
   GROUP BY  checkdate desc 
		 */
	 List<SingCheckInRoom> lists= null;  //singPersonOccupancyMapper.selectByhotelCode(hotelCode);
	 System.out.println("数组"+lists);
	 SimpleDateFormat sdf = new SimpleDateFormat("MM-dd", Locale.ENGLISH);
		String endDate = sdf.format(new Date());
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(calendar.DATE, -30);
		Date d=calendar.getTime();
		String startday=sdf.format(d);
		Map<String, SingCheckInRoom> map = getDates(startday,endDate);
		for(String key:map.keySet()){
			for (SingCheckInRoom singCheckInRoom : lists) {
				if(StringUtils.isNotBlank(singCheckInRoom.getCheckdate())){
					map.put(singCheckInRoom.getCheckdate(),new SingCheckInRoom(singCheckInRoom.getCheckdate(),singCheckInRoom.getTotalCount(),singCheckInRoom.getTotalCount()));
				}
			}
		}
		
		
		return map;
	}
	
	public static Map<String, SingCheckInRoom> getDates(String startDate,String endDate) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat("MM-dd");
		Map<String, SingCheckInRoom> map = new LinkedHashMap<>();
//		List<String> list=new ArrayList<>();
		Date date_start=format.parse(startDate);
		Date date_end=format.parse(endDate);
		Date date=date_start;
		Calendar calendar=Calendar.getInstance();
		
		while (date.getTime() <= date_end.getTime()) {
			String checkInDate = format.format(date);
			map.put(checkInDate, new SingCheckInRoom(checkInDate,0,0));
//			list.add(format.format(date));
			calendar.setTime(date);
			calendar.add(Calendar.DATE, 1);//增加一天
		  date=calendar.getTime();
		}
		return map;
	}
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd", Locale.ENGLISH);
		String endDate = sdf.format(new Date());
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(calendar.DATE, -30);
		Date d=calendar.getTime();
		String startday=sdf.format(d);
		System.out.println(startday+endDate);
		Map<String, SingCheckInRoom> map = getDates(startday,endDate);
		System.out.println(map );
	 
	}
}
