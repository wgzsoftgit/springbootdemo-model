package com.demomodel.utils.httpHelp.httpclient.baseHttpclient.getAndPost;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

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
}
