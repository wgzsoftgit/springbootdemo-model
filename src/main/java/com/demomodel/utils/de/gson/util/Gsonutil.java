package com.demomodel.utils.de.gson.util;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Gsonutil {

	/**
	 * post请求数据 json格式转化成
	 * @param request  HttpServletRequest
	 * @throws IOException
	 */
	public static void jsonToObject(HttpServletRequest request) throws IOException {
		BufferedReader reader = request.getReader();// request.getReader();
		// 读取json数据
		StringBuffer buffer = new StringBuffer();
		String s;
		while ((s = reader.readLine()) != null) {
			buffer.append(s);
		}

		String json = buffer.toString();
		System.out.println("json:" + json);

		// json解析器，解析json数据
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(json);
		// json属于对象类型时
		if (element.isJsonObject()) {
			JsonObject object = element.getAsJsonObject(); // 转化为对象

			// 1. value为string时，取出string
			String sex = object.get("sex").getAsString();
			System.out.println("sex:" + sex);

			// 2. value为array时，取出array
			JsonArray hobbies = object.getAsJsonArray("hobby"); //
			for (int i = 0; i < hobbies.size(); i++) {
				String hobby = hobbies.get(i).getAsString();
				System.out.println("hobby:" + hobby);
			}

			// 3. value为object时，取出object
			JsonObject introduce = object.getAsJsonObject("introduce");
			String name = introduce.get("name").getAsString();
			int age = introduce.get("age").getAsInt();
			System.out.println("name:" + name + ";age:" + age);
		}
	}
}