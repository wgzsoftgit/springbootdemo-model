package com.demomodel.mysqlcontroller.fenyelim;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demomodel.bean.master.FlowPeople;
import com.demomodel.bean.master.page.Pagetion;
import com.demomodel.mysqlcontroller.service.FlowPeopleService;


/**
 * 
 * @author wgz
 * @date 创建时间：2020年4月23日 下午3:08:26
 */
@Controller
@RequestMapping("flowPeopleListController")
public class FlowPeopleListController {

	@Autowired
	FlowPeopleService flowPeopleService;  

	@RequestMapping(value = { "/index" })
	public String implicitTerrorists(Model model) {
		return "views/flowPeopleList";
	}

	/**  根据条件查询 模糊查询    并分页
	 * var data_json={
	 * "starttionDate":'2010-1-2',
	 * "endtionDate":'2021-2-1',
	 * "flowName":'nama',
	 * "page":1,
	 * "pageSize":3,
	 * }
	 *  $.ajax({
         type : "POST",
         url :  "/flowPeopleListController/selectByFlowPeople",
         dataType: "json", // 预期服务器返回的数据类型
          data:data_json,
         success : function(jsonData) {  
         	 console.log("预期"+JSON.stringify(jsonData)); 
         	$("#emptyContainer").hide();
      		$("#resultContainer").addClass("result-container").show();
      		
      			$("#flowtotalcount").html(jsonData.totalCount);//查询结果条数
      			$("#flowtotalpage").html(jsonData.totalPage);//总页数
      			var arrays=jsonData.flowPeopleList;     			
        		var lengths=arrays.length;
        		addCountToTable(arrays,lengths,htmls);//数组，长度，字符串
        		flowpagination(data_json,jsonData.totalPage,5,htmls);//已经填的json数据,总页数,每页显示几条,字符串，
      		
      		
      		
         },
         error : function(errorMsg) { }
         });
	 * 根据条件查询并分页        ****不在对象里面可以用String接收
	 * 
	 * @param flowPeople
	 * @return
	 * @return
	 */
	@RequestMapping("/selectByFlowPeople")
	@ResponseBody
	public Map<String, Object> selectByFlowPeople(FlowPeople flowPeople, String page, String pageSize) {

		Map<String, Object> map = new HashMap<String, Object>();

		int totalCount = flowPeopleService.flowSelectByPage(flowPeople);//先查询出数据的总数  条件一定要一样

		Pagetion pagetion = new Pagetion();
		pagetion.setTotalCount(totalCount);
		pagetion.setPageNo(Integer.valueOf(page));
		pagetion.setPageSize(Integer.valueOf(pageSize));

		flowPeople.setPagetion(pagetion);
//传过来1     实际是0
		List<FlowPeople> selectByObject = flowPeopleService.selectByObject(flowPeople);//根据分页查询     
		map.put("flowPeopleList", selectByObject);
		map.put("totalPage", pagetion.getTotalPage());
		map.put("totalCount", totalCount);
		return map;   
	}

	
/*
 * $.ajax({
					type : "post",
					url : "/sxxl-analysis/hotels/selectCheckInRoomPage",
					dataType : "json",
					traditional : true,//json中可以传数组
					async : false,
					data : {
						"startimeStr" : startimeStr,
						"endtimeStr" : endtimeStr,
						"name" : name,
						"typeArr" : typeArr=[1,2],
						"page" : page,
						"pageSize" : pageSize
					},
					success : function(result) {},
					error : function() {
						alert("异常")
					}
				});
				
	<!-- 根据条件查询 -->
  <select id="getByParam"  parameterType="com.bayee.domain.IrregularHotel"
		resultMap="BaseResultMap">
   SELECT a.id,a.hotel_name,a.hotel_address, a.type,b.counts as counts ,a.check_out_date FROM irregular_hotel a,( SELECT count(1) as counts,s.hotel_name,s.type FROM irregular_hotel s 
     <where>
       <if test="startimeStr!=null and startimeStr!=''">
          and  s.check_in_date &gt; #{startimeStr}
        </if>
        <if test="endtimeStr!=null and endtimeStr!=''">
          and  s.check_out_date &lt; #{endtimeStr}
        </if>
         <if test="hotelName!=null and hotelName!=''">
          and  s.hotel_name LIKE CONCAT('%',#{hotelName},'%')
        </if>
//        传入数组的模式
        <if test="typeArr!=null and typeArr.length>0">
				AND s.type IN
				<foreach collection="typeArr" item="item" index="index"
					separator="," open="(" close=")">
					#{item}
				</foreach>
		</if>
     </where>
     GROUP BY  s.hotel_name, s.type
     ) b
     
     <where>
         b.hotel_name=a.hotel_name and b.type=a.type
       <if test="startimeStr!=null and startimeStr!=''">
          and  a.check_in_date &gt; #{startimeStr}
        </if>
        <if test="endtimeStr!=null and endtimeStr!=''">
          and  a.check_out_date &lt; #{endtimeStr}
        </if>
         <if test="hotelName!=null and hotelName!=''">
          and  a.hotel_name LIKE CONCAT('%',#{hotelName},'%')
        </if>
        <if test="typeArr!=null and typeArr.length>0">
				AND a.type IN
				<foreach collection="typeArr" item="item" index="index"
					separator="," open="(" close=")">
					#{item}
				</foreach>
			</if>
     </where>
     GROUP BY a.hotel_name, a.type
     LIMIT #{pagetion.begin},#{pagetion.pageSize}
  </select>
  <!-- SELECT * FROM irregular_hotel   GROUP BY hotel_name
SELECT * FROM   irregular_hotel s where s.type IN (1,2)
SELECT count(1),s.hotel_name,s.type FROM irregular_hotel s where s.type in (1,2) GROUP BY s.type 
SELECT count(1),s.hotel_name,s.type FROM irregular_hotel s where s.type in (1 , 2) GROUP BY s.hotel_name, s.type 

SELECT a.id,a.hotel_name,a.hotel_address, a.type,b.counts ,a.check_out_date  FROM irregular_hotel a,(SELECT count(1) as counts,s.hotel_name FROM irregular_hotel s where s.type in (1,2) GROUP BY  s.hotel_name, s.type  ) b WHERE b.hotel_name=a.hotel_name and a.type in (1,2) GROUP BY a.hotel_name, a.type
  -->
 <select id="totalCount" parameterType="com.bayee.domain.IrregularHotel"
		resultType="java.lang.Integer">	
   select count(*) from(  SELECT count(1) FROM irregular_hotel a,( SELECT count(1) as counts,s.hotel_name ,s.type FROM irregular_hotel s 
     <where>
       <if test="startimeStr!=null and startimeStr!=''">
          and  s.check_in_date &gt; #{startimeStr}
        </if>
        <if test="endtimeStr!=null and endtimeStr!=''">
          and  s.check_out_date &lt; #{endtimeStr}
        </if>
         <if test="hotelName!=null and hotelName!=''">
          and  s.hotel_name LIKE CONCAT('%',#{hotelName},'%')
        </if>
        <if test="typeArr!=null and typeArr.length>0">
				AND s.type IN
				<foreach collection="typeArr" item="item" index="index"
					separator="," open="(" close=")">
					#{item}
				</foreach>
		</if>
     </where>
     GROUP BY  s.hotel_name, s.type
     )b
     
     <where>
         b.hotel_name=a.hotel_name and b.type=a.type
       <if test="startimeStr!=null and startimeStr!=''">
          and  a.check_in_date &gt; #{startimeStr}
        </if>
        <if test="endtimeStr!=null and endtimeStr!=''">
          and  a.check_out_date &lt; #{endtimeStr}
        </if>
         <if test="hotelName!=null and hotelName!=''">
          and  a.hotel_name LIKE CONCAT('%',#{hotelName},'%')
        </if>
        <if test="typeArr!=null and typeArr.length>0">
				AND a.type IN
				<foreach collection="typeArr" item="item" index="index"
					separator="," open="(" close=")">
					#{item}
				</foreach>
			</if>
     </where>
    GROUP BY a.hotel_name, a.type) c
  </select>
 */
	

}
