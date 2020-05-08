package com.demomodel.utils.de.gson.util.maptojson;

import java.util.HashMap;
import java.util.Map;

import com.demomodel.utils.de.gson.util.maptojson.bean.U;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;


public class GsonJsonWhithMap {
	public static void main(String[] args) {

		Map<String, Object> map = new HashMap<>();
		map.put("code", 1);
		map.put("msg", "aaaaaaaaaaaaa");
		U u = new U("name", "123", 12);

		map.put("u", u);

		String json = new Gson().toJson(map);
		System.out.println("1 "+json);

		Map<String, Object> fromJsonMap = new Gson().fromJson(json, new TypeToken<Map<String, Object>>() {
		}.getType());

		System.out.println("2 "+fromJsonMap);
		Object of=fromJsonMap.get("u");
		System.out.println("3 "+of);
		U uf=(U)of;//强制转换会报异常
		System.out.println("4 "+uf);  //强制转换会报异常
	}

}
