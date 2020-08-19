package com.demomodel.utils.httpHelp.httpclient.baseHttpclient.getAndPost;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
/**
 * get加参数
 * @author wgz
 * @date 创建时间：2020年7月9日 上午8:46:26
 */
public class BaseGetAndParameterFirst {
	public static void main(String[] args) throws URISyntaxException  {
		//HttpClient 对象
	CloseableHttpClient httpClient = HttpClients.createDefault();
	
	//设置请求地址 https://www.baidu.com/s?wd=%E4%B8%96%E7%BA%AA%E4%BD%B3%E7%BC%98
	//创建URIBuilder
	URIBuilder uRIBuilder=new URIBuilder("https://www.baidu.com/s");
	uRIBuilder.setParameter("wd", "%E4%B8%96%E7%BA%AA%E4%BD%B3%E7%BC%98");
	
	//设置HttpGet   和url
	HttpGet httpGet=new HttpGet(uRIBuilder.build());
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
