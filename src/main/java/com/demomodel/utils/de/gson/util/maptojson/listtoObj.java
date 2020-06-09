package com.demomodel.utils.de.gson.util.maptojson;

import java.lang.reflect.Type;
import java.util.List;

import com.demomodel.bean.result.Result;
import com.demomodel.utils.de.gson.util.maptojson.bean.MyEntry;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
//数组 json
//json  直接转list<String>  或者转数组
public class listtoObj {
	public static void main(String[] args) {
		String json2 = "[\"apple\", \"pear\", \"banana\"]";
		stringTolist(json2);
		stringToArray(json2);
	}
	
	public static void stringTolist(String json2) {
		Gson gson2 = new Gson();
		List<String> fruitList = gson2.fromJson(json2, new TypeToken<List<String>>() {
		}.getType());
		for (String string : fruitList) {
			System.err.println("List<String>"+string);  //apple     pear    banana
		}
	}
	public static void stringToArray(String json2) {
		Gson gson2 = new Gson();
		// 传入的java类型是String[].class
		String[] fruits = gson2.fromJson(json2, String[].class);  
		for (String string : fruits) {
			System.err.println("String[]"+string);  //apple   pear    banana
		}
	}
	public static void jsonToobj(String typeJson1) {
		Gson typeGson1 = new Gson();
         // 动态生成所需的java类的类型
	Type type1 = new TypeToken<Result<MyEntry>>(){}.getType();
		// 动态生成java对象
		Result<MyEntry> result1 = typeGson1.fromJson(typeJson1, type1);
		System.out.println(result1);
	}
	
}
