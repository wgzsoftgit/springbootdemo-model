package com.demomodel.utils.de.json.gson.util.maptojson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demomodel.utils.de.json.gson.util.maptojson.bean.U;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;


public class GsonJsonWhithMap {
	public static void main(String[] args) {

		Map<String, Object> map = new HashMap<>();
		map.put("code", 1);
		map.put("msg", "aaaaaaaaaaaaa");
		U u = new U("name", "123", 12);
		U u2 = new U("name2", "1232", 122);
   List<U> list= new ArrayList<U>();
//   list.add(u);
   list.add(u2);
map.put("u", u);

		String json = new Gson().toJson(map);
		System.out.println("1 "+json);  //{"msg":"aaaaaaaaaaaaa","code":1,"u":{"name":"name","pwd":"123","age":12}}

		Map<String, Object> fromJsonMap = new Gson().fromJson(json, new TypeToken<Map<String, Object>>() {
		}.getType());

	
		
		
		System.out.println("2 "+fromJsonMap); //{msg=aaaaaaaaaaaaa, code=1.0, u={name=name, pwd=123, age=12.0}}
		Object of=fromJsonMap.get("u");//{name=name, pwd=123, age=12.0}
		System.out.println("3 "+of);//
		
		U uf=(U)of;//强制转换会报异常
		System.out.println("4 "+uf);  //强制转换会报异常
	}

}
