package com.demomodel.utils.de.gson;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demomodel.controller.requestheader.request.Gsonutil;

@Controller
@RequestMapping("gsondemo")
public class Gsondemo {

	/**前端
	 * var data_json =  {
        "sex": '男',
        "hobby":["baskte","tennis"],
        "introduce": {
            "name":"tom",
            "age":23
        }
    };
     data: JSON.stringify(data_json),
     $.ajax({  type : "POST",
                url :  "http://localhost:9090/gsondemo/jsonToObject",
                dataType: "json", //预期服务器返回的数据类型
                 data: JSON.stringify(data_json),
                 contentType: "application/json",
                success : function(jsonData) {},
                error : function(errorMsg) {} });
	 * @throws IOException 
	 */
	@RequestMapping("jsonToObject")
	public void jsonToObject(HttpServletRequest request) throws IOException {
		System.err.println("com.demomodel.utils.de.gson.Gsondemo"+"11111111111s");	
	    Gsonutil.jsonToObject(request);  //request.getReader(); 获取内容
	} 
}
