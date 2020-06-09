package com.demomodel.utils.demo.filedown;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.UnknownHostException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class UrlDownFile {
	
	/* 
	下载文件 
	@param urlsrc 网页地址  
	@param outPath 文件输出路径 
	*/  
	@SuppressWarnings({ "resource" })  
	public static void DownLoadPages(String urlsrc, String outpath) throws UnknownHostException  
	{  
		// 输入流   
		InputStream in = null;  
		// 文件输出流  
		FileOutputStream out = null;  
		try{   
			HttpParams httpParams = new BasicHttpParams();  
			HttpConnectionParams.setConnectionTimeout(httpParams,5000); //设置连接超时为5秒  
			HttpClient client = new DefaultHttpClient(httpParams); // 生成一个http客户端发送请求对象  
			HttpGet httpget1 = new HttpGet(urlsrc); //对查询页面get  
			HttpResponse httpResponse1 = client.execute(httpget1); // 发送请求并等待响应  
			// 判断网络连接是否成功  
			System.out.println("状态码："+httpResponse1.getStatusLine().getStatusCode());  
			if (httpResponse1.getStatusLine().getStatusCode() != 200)  
				System.out.println("网络错误异常！!!!");  
			else  
				System.out.println("网络连接成功!!!");  
			httpget1.abort(); //关闭get  
			HttpGet httpget2 = new HttpGet(urlsrc); //对下载链接get实现下载  http://....../download? DownloadFileName=All=true
			HttpResponse httpResponse2 = client.execute(httpget2);  
			HttpEntity entity = httpResponse2.getEntity(); // 获取响应里面的内容  
			in = entity.getContent(); // 得到服务气端发回的响应的内容（都在一个流里面）  
			out = new FileOutputStream(new File(outpath));   
			byte[] b = new byte[1024];   
			int len = 0;   
			while((len=in.read(b))!= -1){   
				out.write(b,0,len);   
			}   
			in.close();   
			out.close();    
			}catch(Exception e){    
				e.printStackTrace();  
			}  
		System.out.println("download, success!!");    
		}  
		
	public static void main(String[] args) throws Exception {  
		//https://cdn.jsdelivr.net/npm/echarts/dist/echarts.min.js
		//https://www.echartsjs.com/zh/dist/echarts-gl.js
		String urlsrc="https://cdn.jsdelivr.net/npm/echarts/dist/echarts.min.js"; //要访问的链接  
		String outPath="D:\\echarts.min.js"; //本地路径  
		DownLoadPages(urlsrc,outPath);  
	}  
	

}

