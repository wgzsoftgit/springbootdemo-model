package com.demomodel.utils.httpHelp.httpclient.baseHttpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

public class HttpPoolText {

	public static void main(String[] args) {
		//创建连接池管理器
		PoolingHttpClientConnectionManager cm=new PoolingHttpClientConnectionManager();
		//设置最大连接数
		cm.setMaxTotal(100);
		
		//设置每个主机的最大连接数
		cm.setDefaultMaxPerRoute(10);
		doGet(cm);
	}

	private static void doGet(PoolingHttpClientConnectionManager cm) {
		//不是每次创建新的httpClient,而是从连接池中获取HttpClient对象
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
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
					//不能自己关闭,而是连接池自己管理
					//	httpClient.close();
					
				}
				
		
	}
}
