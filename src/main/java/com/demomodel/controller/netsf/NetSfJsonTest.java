package com.demomodel.controller.netsf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demomodel.utils.de.jsonUtils.JsonUtils;

import net.sf.json.JSONObject;

@RestController
public class NetSfJsonTest {
//测试ok
	//因为GetMapping 不支持@RequestBody
	//url：localhost:8080/netjson?a=1&b=2
	//{   "name":"sqh",    "pwd":"123",    "phone":1234 }
	//{   "name":"sqh",    "pwd":"123",    "phone":1234 ,
//	"list":[{"context":"上海"},{"context":"杭州"}]
//}

    @ResponseBody
    @RequestMapping(value="/netsfjson",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject sfJsonTest(HttpServletRequest request, @RequestBody JSONObject content) {
        System.out.println("?后的内容: "+request.getQueryString());
        String name = (String)content.get("name");
        Integer phone = (Integer)content.get("phone");
        String pwd = (String)content.get("pwd");

        Map<String, Object> entries = JsonUtils.parseJSON2Map(content);  //便利解析json
      
        for(String key : entries.keySet()){

            Object value =  entries.get(key);

            System.out.println(key+":"+value);

        }
        
        JSONObject result = new JSONObject();
        result.put("errCode", 200);
        result.put("errMsg", "success");
        result.put("data", content);

        return result;
    }
}