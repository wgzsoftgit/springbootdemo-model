package com.demomodel.utils.httpHelp.httpclient.baseHttpclient.getAndPost;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
/**
 * 设置表单的entity对象         方式二种
 * @author wgz
 * @date 创建时间：2020年7月10日 下午11:35:22
 */
public class BasePostAndParameterFirst2 {
	public static void main(String[] args) throws URISyntaxException, UnsupportedEncodingException  {
		//HttpClient 对象
				CloseableHttpClient httpClient = HttpClients.createDefault();
				//设置HttpPost   和url
				HttpPost httpPost=new HttpPost("http://www.baidu.com");
			
				
				//设置请求地址 https://www.baidu.com/s?wd=%E4%B8%96%E7%BA%AA%E4%BD%B3%E7%BC%98
				//        支持key,  value
				List<NameValuePair> params=new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("wd", "java"));
				UrlEncodedFormEntity formEntity=new UrlEncodedFormEntity(params,"utf8");
				//设置表单的entity对象到post请求中
				httpPost.setEntity(formEntity);
				
				
				
			//方式二  通用支持get post put delete  HttpPost 都继承HttpRequestBase
		//参考  com.demomodel.utils.de.http.fengzhuang.util.HttpTestUtils
		//age=23      可以是json字符串
				httpPost.addHeader("content-type", "application/json");//添加消息头
				httpPost.addHeader("X-Subject-Token", "token-session2132");
				httpPost.setEntity(new StringEntity("age=23", "UTF-8"));
				
				
				
				CloseableHttpResponse response = null;
				try {
					//发起请求
					response = httpClient.execute(httpPost);
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
