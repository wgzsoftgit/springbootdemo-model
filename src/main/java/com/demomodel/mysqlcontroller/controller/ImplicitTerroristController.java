package com.demomodel.mysqlcontroller.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demomodel.bean.master.ImplicitTerrorists;
import com.demomodel.bean.result.Result;
import com.demomodel.mysqlcontroller.service.ImplicitTerroristsServic;


/**
 * @author wgz
 * @date 创建时间：2020年4月20日 下午9:09:00 
 */
//http://localhost:8080/sxxl-analysis/implicitTerrorists/index
@Controller
@RequestMapping(value={"/implicitTerrorists2"})
public class ImplicitTerroristController {

	@Autowired
	ImplicitTerroristsServic implicitTerroristsService;	
	
	//多视图配置 p配置于 com.demomodel.filter.views.WebConfig
	@RequestMapping(value={"/index2"}) //WEB-INF/view/index.jsp
	public String implicitTerrorists(Model model) {return "index";}
	@RequestMapping(value={"/index1"}) //WEB-INF/templates/view/indexs.html
	public String implicitTerrori(Model model) {return "indexs";}
	   
	/**
	 * //	var data_json =  {
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
//  url :  "http://localhost:9090/implicitTerrorists2/queryTerrorists2",
//  dataType: "json", //预期服务器返回的数据类型
//   data: data_json,
//  success : function(jsonData) {  
//  	console.log(jsonData);
//  },
//  error : function(errorMsg) { }
//
//});
	 * 根据对象动态查询	    接受的对象
	 * @param implicitTerrorists
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value={"/queryTerrorists2"})
	@ResponseBody  
	public Result<List<ImplicitTerrorists>> queryTerrorists( ImplicitTerrorists implicitTerrorists) throws IOException {
		System.err.println("-----------1111111111-----------------");	
		System.err.println(implicitTerrorists.toString());
	 List<ImplicitTerrorists> list=	implicitTerroristsService.selectByTypeCondition(implicitTerrorists);
	 Result<List<ImplicitTerrorists>> result = Result.success(list);
	 return result;
	}    
	
	
	
	
	/**  implicitTerrorists2/updtaControlState2
	 * 测试成功  POST  @RequestBody接收数组String[]   data:JSON.stringify(["1","2"]),contentType: 'application/json;charset=UTF-8',
	 * var checkboxValue= new Array();
	 * checkboxValue.push(1);
	 * checkboxValue.push(2);
	 *   $.ajax({
	 *  	 type : "POST",
        	 url :  "/sxxl-analysis/PassArray/updtaControlState",
  	         dataType: "json", //预期服务器返回的数据类型
             data:JSON.stringify(checkboxValue),
             contentType: 'application/json;charset=UTF-8',
             success : function(jsonData) {   },
             error : function(errorMsg) { }
			});
	*/
	@RequestMapping(value={"/updtaControlState2"},method = RequestMethod.POST)
	@ResponseBody  //接收数组
	public  void updtaControlState(@RequestBody String[] checkboxValue) throws IOException {
		System.err.println("-----------22222-----------------"+Arrays.asList(checkboxValue));
		implicitTerroristsService.updaControlStatesByarray(checkboxValue);	 
	} 
	
	
}
