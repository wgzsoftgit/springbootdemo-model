package com.demomodel.utils.httpHelp.httpclient.baseHttpclient.getAndPost;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class BaseGetFirst {
	public static void main(String[] args)  {
		//HttpClient 对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//设置HttpGet   和url
		HttpGet httpGet=new HttpGet("http://www.baidu.com");
		CloseableHttpResponse response = null;
		try {
			//发起请求
			response = httpClient.execute(httpGet);
			//解析响应
			if(response.getStatusLine().getStatusCode()==200) {
				  HttpEntity entity = response.getEntity();
				  String string = EntityUtils.toString(entity, "utf8");
				  System.err.println(string);
			  }
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(response !=null) {
					response.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		  
	
	  
	}
	
	
	
	public static Map<String, Object> getAccessToken() {
		Map<String, Object> map = null;
		StringBuffer url = new StringBuffer("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential");
		url.append("&appid=");//appid设置
		url.append("APPID");
		url.append("&secret=");//secret设置
		url.append("APPSecret");
		try {
	        HttpClient client =HttpClientBuilder.create().build();//构建一个Client
	        HttpGet get = new HttpGet(url.toString());    //构建一个GET请求
	        HttpResponse response = client.execute(get);//提交GET请求
	        HttpEntity result = response.getEntity();//拿到返回的HttpResponse的"实体"
	        String content = EntityUtils.toString(result);   
	        JSONObject res = JSONObject.fromObject(content);//把信息封装为json
		    //把信息封装到map
		
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return map;
	}
}
