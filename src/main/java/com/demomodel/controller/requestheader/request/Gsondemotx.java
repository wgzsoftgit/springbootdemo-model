package com.demomodel.controller.requestheader.request;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demomodel.bean.master.ImplicitTerrorists;

@Controller
@RequestMapping("gsondemo2")
public class Gsondemotx {

	/**
	 * 前端 测试成功    POST  HttpServletRequest接收数据
	 * var data_json = { "sex": '男', "hobby":["baskte","tennis"],
	 * "introduce": { "name":"tom", "age":23 } }; data: JSON.stringify(data_json),
	 * $.ajax({ 
	 * type : "POST", 
	 * url : "http://localhost:9090/gsondemo/jsonToObject",
	 * dataType: "json", //预期服务器返回的数据类型 
	 * data: JSON.stringify(data_json),
	 * contentType: "application/json", 
	 * success : function(jsonData) {},
	 *  error : function(errorMsg) {} });
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "jsonToObject2", method = RequestMethod.POST)
	public void jsonToObject(HttpServletRequest request) throws IOException {
		System.err.println("11111111111s");
		Gsonutil.jsonToObject(request); // request.getReader(); 获取内容
	}

	// 测试成功   POST  不用注解 后端用对象接收对象        data：{"id": 11,} 前端传json 
	// @ResponseBody在spring项目中需要自己引入 返回map类型
//	<!-- json 支持RequestBody-->
//
//	<dependency>
//
//	<groupId>com.fasterxml.jackson.core</groupId>
//
//	<artifactId>jackson-databind</artifactId>
//
//	<version>2.7.3</version>
//
//	</dependency>
//
//	<dependency>
//
//	<groupId>com.fasterxml.jackson.core</groupId>
//
//	<artifactId>jackson-annotations</artifactId>
//
//	<version>2.7.3</version>
//
//	</dependency>
//	var data_json =  {
//		    "id": 11,
//		    "creationDate": "2018-10-08 15:22:22",
//		    "districtCode": "baskte",
//		    "name": "tom",
//		    "idCard": "saa",
//		    "personType": "",
//		    "isResident": 22,
//		    "gendar": 21,
//		    "monitorStatus": "布控",
//		    "alertStatus": "ass",
//		    "similarPercent": 221.2,
//		    "faceImgUrl": "da",
//		    "deviceId": "sb",
//		    "imgUrl": "ds"
//		};
//	$.ajax({
//  type : "POST",
//  url :  "http://localhost:9090/gsondemo2/queryTerrorists2",
//  dataType: "json", //预期服务器返回的数据类型
//   data: data_json,
//  success : function(jsonData) {  
//  	console.log(jsonData);
//  },
//  error : function(errorMsg) { }
//
//});
	@RequestMapping(value = { "/queryTerrorists2" })
	@ResponseBody
	public Map queryTerrorists2(ImplicitTerrorists implicitTerrorists) {
		System.err.println("-----------1222221-----------------" + implicitTerrorists.toString());
		Map map = new HashMap();
		map.put("sa", "123");
		return map;
	}
	
	/**POST      @RequestBody接收 bean   通过JSON.stringify()转换成json字符串
	 *  data: JSON.stringify(data_json) 请求contentType:'application/json;charset=utf-8',   
	 * var data_json =  {
		    "id": 11,
		    "creationDate": "2018-10-08 15:22:22",
		    "districtCode": "baskte",
		    "name": "tom",
		    "idCard": "saa",
		    "personType": "",
		    "isResident": 22,
		    "gendar": 21,
		    "monitorStatus": "布控",
		    "alertStatus": "ass",
		    "similarPercent": 221.2,
		    "faceImgUrl": "da",
	        "deviceId": "sb",
		    "imgUrl": "ds"
		};
	$.ajax({
  type : "POST",  
  url :  "http://localhost:9090/gsondemo2/queryTerrorists3",
  dataType: "json", //预期服务器返回的数据类型
  contentType : 'application/json;charset=utf-8',
 // headers : {'Content-Type' : 'application/json;charset=utf-8'},
  data: JSON.stringify(data_json),
  success : function(jsonData) {  
  	console.log(jsonData);
  },
  error : function(errorMsg) { }

});
	 * @param date1
	 * @return
	 */

	@RequestMapping(value = { "/queryTerrorists3" })
	@ResponseBody
	public Map queryTerrorists3(@RequestBody ImplicitTerrorists date1) {
		System.err.println("-----------1222221-----------------" + date1.toString());
		Map map = new HashMap();
		map.put("sa", "123");
		return map;
	}
	
	
	/**POST @RequestBody 接收 Map<String, Object>   data: JSON.stringify(data_json), contentType : 'application/json;charset=utf-8',
	 *  var data_json =  {
			    "id": 11,
			    "creationDate": "2018-10-08 15:22:22",
			    "districtCode": "baskte",
			    "name": "tom",
			};
		$.ajax({
	  type : "POST",  
	  url :  "http://localhost:9090/gsondemo2/queryTerrorists33",
	  dataType: "json", //预期服务器返回的数据类型
	  //contentType : 'application/json;charset=utf-8',
	  headers : {'Content-Type' : 'application/json;charset=utf-8'},
	  data: JSON.stringify(data_json),
	  success : function(jsonData) {  
	  	console.log(jsonData);
	  },
	  error : function(errorMsg) { }

	});
	 * @param map
	 */
	
	@RequestMapping("/queryTerrorists33")
	@ResponseBody
	public void updateUser(@RequestBody Map<String, Object> map){
		
		System.err.println("-----------1222223-----------------" + map.toString());
	}
	
	/**   POST/get 请求     @RequestParam("startdt")  data: {"startdt": 'sa',} contentType : 'application/x-www-form-urlencoded;charset=UTF-8',
	 * 无论是POST请求还是GET请求都是可以通过@RequestParam这种方式成功获取参数，
	 * 但是如果设置为“application/json;charset=utf-8”，会报上述错误
	 * 报一个String parameter “xxx” is not present的错误。
	 * ajax传JSON时设置的contenttype 如果是application/json或者text/json时，
	 
	 * JAVA中request.getParameter("")怎么也接收不到数据。这是因为，Tomcat的HttpServletRequest类的实现类
	 * 为org.apache.catalina.connector.Request（实际上是org.apache.coyote.Request）。
	 * @RequestParam 底层是通过request.getParameter方式获得参数的，也就是说，
	 * @RequestParam 和request.getParameter是同一回事。因为使用request.getParameter()方式获取参数，
	 * 可以处理get 方式中queryString的值，也可以处理post方式中 body data的值，所以，
	 * @RequestParam可以处理get 方式中queryString的值，也可以处理post方式中 body data的值。
	 * @RequestParam用来处理Content-Type: 为 application/x-www-form-urlencoded编码的内容，
	 * 提交方式GET、POST。
	 * 
	 * 
	 * 
	 * 前端请求传Json对象则后端使用@RequestParam；
                   前端请求传Json对象的字符串则后端使用@RequestBody。
$.ajax({
  type : "POST",  //GET  都可以接收
  url :  "http://localhost:9090/gsondemo2/queryTerrorists4",
  dataType: "json", //预期服务器返回的数据类型
  //headers:{'Content-Type' : 'application/json;charset=utf-8'},
  contentType : 'application/x-www-form-urlencoded;charset=UTF-8',
  data: {
      "startdt": 'sa',
      "enddt": 'sb',
      "provinceName": 'sc'
  },
  success : function(jsonData) {  
  	console.log(jsonData);
  },
  error : function(errorMsg) { }

});
	 * @param implicitTerrorists
	 * @return
	 */
	@RequestMapping(value = { "/queryTerrorists4" })
	@ResponseBody
	public Map queryTerrorists4(@RequestParam("startdt") String date1) {
		System.err.println("-----------1222221-----------------" + date1);
		Map map = new HashMap();
		map.put("sa", "123");
		return map;
	}
	
	
	
}
