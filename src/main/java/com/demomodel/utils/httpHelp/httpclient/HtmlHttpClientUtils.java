package com.demomodel.utils.httpHelp.httpclient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import us.codecraft.webmagic.downloader.HttpClientGenerator;
/**
 * demo 级爬虫   测试ok
 * @author wgz
 * @date 创建时间：2020年7月11日 下午8:50:19
 */
@Component
public class HtmlHttpClientUtils {
	
	
	public static void main(String[] args) throws IOException {
		// 1 3 5 7 9 11 (2n-1)
		// 1 2 3 4 5 6
		// 1 51 101 151  201 (n-1)*50+1
		Integer page=1;
		Integer pagesize=1;
		String url="https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&wq=%E6%89%8B%E6%9C%BA&page="+page+"&s="+pagesize+"&click=0";
		for (int i = 0; i < 5; i++) {
			page=2*i-1 ;
			pagesize=(i-1)*50+1;		
			String html = HtmlHttpClientUtils.doGetHtml(url);
			HtmlHttpClientUtils.parse(html);//解析页面
		}
	}
	
  private static void parse(String html) throws IOException {
	//解析html获取Document
	  Document doc = Jsoup.parse(html);
	  Elements select = doc.select("div#J_goodsList> ul> li");
	  for (Element element : select) {
		  String attr = element.attr("data-sku");
		Long spu=Long.parseLong(element.attr("data-sku"));
		//获取sku信息
		Elements select2 = element.select("li.ps-item");
		for (Element skuEle : select2) {
			
			//获取sku
			long sku = Long.parseLong(skuEle.select("[data-sku]").attr("data-sku"));
		
			String itemUrl="https://item.jd.com/"+sku+".html";//详情的路径
			System.err.println("详情的URL路径"+itemUrl);
			//获取商品标题
			String titileJson = HtmlHttpClientUtils.doGetHtml(itemUrl);
			String title = Jsoup.parse(titileJson).select("div.sku-name").text();
			System.err.println("获取商品的标题"+title);
			
			//获取商品的价格
			String pricejson = HtmlHttpClientUtils.doGetHtml("https://p.3.cn/prices/mgets?skuIds="+sku);
			//[{"cbf":"0","id":"J_100007090657","m":"6000.00","op":"1999.00","p":"1699.00"}]
			double asDouble = objectMapper.readTree(pricejson).get(0).get("p").asDouble();
			System.err.println("获取价格"+asDouble);
			
			
			String picUrl = "http:"+skuEle.select("img[data-sku]").first().attr("data-lazy-img");
			picUrl=picUrl.replace("/n9/", "/n1/");   //n9       替换成 n1
			System.err.println("图片路径"+picUrl);
			//下载图片
			String picName = HtmlHttpClientUtils.doGetImage(picUrl);
			System.err.println("下载的图片名字"+picName);
		}
		
	}
		
	}
private static ObjectMapper objectMapper=new ObjectMapper();
private static PoolingHttpClientConnectionManager cm;
 public HtmlHttpClientUtils() {
	 this.cm=new PoolingHttpClientConnectionManager();
		//设置最大连接数
		this.cm.setMaxTotal(100);
		//设置每个主机的最大连接数
		this.cm.setDefaultMaxPerRoute(10);
 } 
 /**
  * 根据请求下载页面数据
  * @param url
  * @return
  */
 public static String doGetHtml(String url) {
	 
		//不是每次创建新的httpClient,而是从连接池中获取HttpClient对象
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
		//设置HttpGet   和url
				HttpGet httpGet=new HttpGet(url);
				
		//	httpGet.addHeader("cookie", "shshshfpa=7bee40c4-38c8-6974-0cd6-37c535cde5b7-1586588236; shshshfpb=ay8td1lhZGVatGzq7vh0VPw%3D%3D; __jdu=1038334423; areaId=15; ipLoc-djd=15-1255-44188-0; PCSYCityID=CN_330000_330600_0; qrsc=3; unpl=V2_ZzNtbRdXSkd0WERdexsLDGILQVwRXxEXdQlPVX4fXFI3UxVcclRCFnQUR1JnGV0UZAEZWURcRhZFCEdkeBBVAWMDE1VGZxBFLV0CFSNGF1wjU00zQwBBQHcJFF0uSgwDYgcaDhFTQEJ2XBVQL0oMDDdRFAhyZ0AVRQhHZHsYXgxlARdYQVVzJXI4dmR9EFsCZwsiXHJWc1chVENQchxZBCoDE19LVUEQcAtEZHopXw%3d%3d; __jdv=76161171|baidu-pinzhuan|t_288551095_baidupinzhuan|cpc|0f3d30c8dba7459bb52f2eb5eba8ac7d_0_d18c0a3813f849b0b9c31080471faa60|1594396664082; __jda=122270672.1038334423.1584411591.1594315471.1594396664.12; __jdc=122270672; shshshfp=c6597da804dabefe80566235958d888f; rkv=V0900; 3AB9D23F7A4B3C9B=A4GH7KM22G2YMVXXCXMJL3IIGDIA7DKHAUYP3UKNA3KCSLMESPXTKMS5UHQNFERWSQJUF66HSOVO4XCJPAOTIE2FPI; shshshsID=811253fbcda4738617d2a1157f613a1a_10_1594400321012; __jdb=122270672.12.1038334423|12.1594396664; wlfstk_smdl=77msvuf1wma5n5h48al4b7q0dq4sn46v");
				httpGet.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36");
				//设置请求信息
				httpGet.setConfig(HtmlHttpClientUtils.getConfig());
				CloseableHttpResponse response = null;
				try {
					//发起请求
					response = httpClient.execute(httpGet);
					//解析响应
					if(response.getStatusLine().getStatusCode()==200) {
						  HttpEntity entity = response.getEntity();
						  String string = EntityUtils.toString(entity, "utf8");
						  System.err.println(string);  //获取到文本文件
						  return string;
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
				 return "";
	 
 }
 /**
  * 连接配置  httpGet.setConfig(HtmlHttpClientUtils.getConfig());
  * 创建连接   连接最长时间  数据传输时间   
  * @return
  */
 private static RequestConfig getConfig() {
	//配置请求信息
			RequestConfig config=RequestConfig.custom()
					.setConnectTimeout(1000)//创建连接的最长时间，单位毫秒
					.setConnectionRequestTimeout(500)  //设置获取连接的最长时间，单位毫秒
					.setSocketTimeout(10*1000) //设置数据传输的最长时间，单位毫秒
					.build();
	return config;
}
/**
 * 根据请求下载  图片
 * @param url
 * @return
 */
 public static String doGetImage(String url) {
	 
		//不是每次创建新的httpClient,而是从连接池中获取HttpClient对象
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
		//设置HttpGet   和url
				HttpGet httpGet=new HttpGet(url);
				httpGet.addHeader("cookie", "shshshfpa=7bee40c4-38c8-6974-0cd6-37c535cde5b7-1586588236; shshshfpb=ay8td1lhZGVatGzq7vh0VPw%3D%3D; __jdu=1038334423; areaId=15; ipLoc-djd=15-1255-44188-0; PCSYCityID=CN_330000_330600_0; qrsc=3; unpl=V2_ZzNtbRdXSkd0WERdexsLDGILQVwRXxEXdQlPVX4fXFI3UxVcclRCFnQUR1JnGV0UZAEZWURcRhZFCEdkeBBVAWMDE1VGZxBFLV0CFSNGF1wjU00zQwBBQHcJFF0uSgwDYgcaDhFTQEJ2XBVQL0oMDDdRFAhyZ0AVRQhHZHsYXgxlARdYQVVzJXI4dmR9EFsCZwsiXHJWc1chVENQchxZBCoDE19LVUEQcAtEZHopXw%3d%3d; __jdv=76161171|baidu-pinzhuan|t_288551095_baidupinzhuan|cpc|0f3d30c8dba7459bb52f2eb5eba8ac7d_0_d18c0a3813f849b0b9c31080471faa60|1594396664082; __jda=122270672.1038334423.1584411591.1594315471.1594396664.12; __jdc=122270672; shshshfp=c6597da804dabefe80566235958d888f; rkv=V0900; 3AB9D23F7A4B3C9B=A4GH7KM22G2YMVXXCXMJL3IIGDIA7DKHAUYP3UKNA3KCSLMESPXTKMS5UHQNFERWSQJUF66HSOVO4XCJPAOTIE2FPI; shshshsID=811253fbcda4738617d2a1157f613a1a_10_1594400321012; __jdb=122270672.12.1038334423|12.1594396664; wlfstk_smdl=77msvuf1wma5n5h48al4b7q0dq4sn46v");
				httpGet.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36");
				
				//设置请求信息
				httpGet.setConfig(HtmlHttpClientUtils.getConfig());//HtmlHttpClientUtils   -->this
				CloseableHttpResponse response = null;
				try {
					//发起请求
					response = httpClient.execute(httpGet);
					//解析响应
					if(response.getStatusLine().getStatusCode()==200) {
						if( response.getEntity() !=null) {
							//下载图片
							//获取图片的后缀
							String exName=url.substring(url.lastIndexOf("."));
							//创建图片名 ，重命名.
							String picName=UUID.randomUUID().toString()+exName;
							//下载图片
							OutputStream  outputStream=new FileOutputStream(new File("D:\\text\\image\\"+picName));
							response.getEntity().writeTo(outputStream);
							//返回图片名
							return picName;
						}
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
				 return "";
	 
}
}
