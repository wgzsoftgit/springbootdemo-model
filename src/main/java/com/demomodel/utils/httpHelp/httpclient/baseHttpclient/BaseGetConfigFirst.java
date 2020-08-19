package com.demomodel.utils.httpHelp.httpclient.baseHttpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
/**
 *    配置请求信息的时间设置
 * @author wgz
 * @date 创建时间：2020年7月8日 下午11:37:04
 */
public class BaseGetConfigFirst {
	public static void main(String[] args)  {
		//HttpClient 对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//设置HttpGet   和url0
		HttpGet httpGet=new HttpGet("http://www.baidu.com");
		
		//配置请求信息
		RequestConfig config=RequestConfig.custom().setConnectTimeout(1000)//创建连接的最长时间，单位毫秒
				.setConnectionRequestTimeout(500)  //设置获取连接的最长时间，单位毫秒
				.setSocketTimeout(10*1000) //设置数据传输的最长时间，单位毫秒
				.build();
	//	给请求设置请求信息
		httpGet.setConfig(config);
		
		
		
		
		
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
