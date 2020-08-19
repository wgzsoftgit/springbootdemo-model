package com.demomodel.utils.de.gson.util.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


/**
 * web 请求    汉子乱码解决方案  
 * @RequestMapping(value = "/login",
 * method = RequestMethod.POST,
 * produces = "text/html;charset=UTF-8")
 * 
 * @author wgz
 * @date 创建时间：2020年7月10日 下午8:20:15
 */
public class GsonTest {

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("name", "nam1");
		map.put("age", "12");

		List list = new ArrayList();
		list.add("name");
		list.add("123");
		list.add(map);

//json格式的字符串
		String str = "[{'name':'kevin','age':25},{'name':'cissy','age':24}]";
//创建一个Gson对象
		Gson gson = new Gson();

//把java对象转换成Json字符串。   map   => json
		String jsonStr = gson.toJson(map);
		System.out.println(jsonStr);//{"name":"nam1","age":"12"}

//把集合对象转换成Json字符串    list  => json
		jsonStr = gson.toJson(list);
		System.out.println(jsonStr);//["name","123",{"name":"nam1","age":"12"}]

//创建一个JsonParser
		JsonParser parser = new JsonParser();

//通过JsonParser对象可以把json格式的字符串解析成一个JsonElement对象    str--String
		JsonElement el = parser.parse(str);

//把JsonElement对象转换成JsonObject
		JsonObject jsonObj = null;
		if (el.isJsonObject()) {
			jsonObj = el.getAsJsonObject();
			//添加元素
			jsonObj.addProperty("type","Human");
			String sex = jsonObj.get("sex").getAsString();
			System.out.println("sex:" + sex);
			JsonArray hobbies = jsonObj.getAsJsonArray("hobby"); //
			for (int i = 0; i < hobbies.size(); i++) {
				String hobby = hobbies.get(i).getAsString();
				System.out.println("hobby:" + hobby);
			}
		}

//把JsonElement对象转换成JsonArray
		JsonArray jsonArray = null;
		if (el.isJsonArray()) {
			jsonArray = el.getAsJsonArray();
		}
//遍历JsonArray对象
		MyField field = null;
		Iterator it = jsonArray.iterator();
		while (it.hasNext()) {
			JsonElement e = (JsonElement) it.next();
//JsonElement转换为JavaBean对象
			field = gson.fromJson(e, MyField.class);
			System.out.println(field.getName() + " === " + field.getAge());
		}
	}

}

class MyField {
	private String name;
	private Integer age;

	public MyField() {
	}

	public MyField(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}

//：https://blog.csdn.net/majian_1987/java/article/details/8119037