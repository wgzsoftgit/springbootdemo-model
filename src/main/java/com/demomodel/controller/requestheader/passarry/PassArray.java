package com.demomodel.controller.requestheader.passarry;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("PassArray")
public class PassArray {
	
	/**测试成功  POST  @RequestBody接收数组String[]   data:JSON.stringify(["1","2"]),contentType: 'application/json;charset=UTF-8',
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
	 * @param checkboxValue
	 * @throws IOException
	 */
	@RequestMapping(value={"/updtaControlState"},method = RequestMethod.POST)
		@ResponseBody  
		public  void updtaControlState(@RequestBody String[] checkboxValue) throws IOException {
			System.err.println("-----------22222-----------------"+Arrays.asList(checkboxValue));
				 
		} 
}

