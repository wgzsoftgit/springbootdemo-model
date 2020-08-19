package com.demomodel.utils.httpHelp.WebMagic;

import java.util.List;

import org.jsoup.Jsoup;

import com.demomodel.utils.httpHelp.WebMagic.piple.SpringDate;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.Scheduler;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;
//http://127.0.0.1:9200/_analyze?analyzer=ik_smart&pretty=true
public class JobProcessor2 implements PageProcessor {

	static String url="https://search.51job.com/list/000000,000000,0000,01%252C32,9,99,java,2,1.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=";
	//static String url="https://www.xxorg.com/tools/getip/";  //测试代理服务是否生效
	int sa=0;
	//解析页面   Resultltems 相当于一个map
	@Override
	public void process(Page page) {
		//解析招聘信息  的数据page, 并且把解析的结果放到ResultItems中
		List<Selectable> list = page.getHtml().css("div#resultList div.el").nodes();
	//判断获取到的集合是否为空
		if(list.size() == 0 ) {
		//如果为空，表示这是招聘信息详情   获取招聘信息详情，保存数据
			this.saveInfo(page);
			
	}else {
		//不为空 ，表示是列表页
		for (Selectable selectable : list) {
			String jobInfoUrl = selectable.links().toString();
			System.err.println(jobInfoUrl);
			page.addTargetRequest(jobInfoUrl);
		}
		//获取下一页的url
		String bkUrl=page.getHtml().css("div.p_in li.bk").nodes().get(1).links().toString();
		System.err.println(bkUrl);
		page.addTargetRequest(bkUrl);
		sa++;
		System.err.println(sa);
	}
		
	}
	//解析页面      获取招聘信息详情，保存数据
	private void saveInfo(Page page) {
		Html html = page.getHtml();
		//拿到标签的内容
		String name = html.css("div.cn p.cname a", "text" ).toString();
		System.err.println("name"+name);
		String string = html.css("div.bmsg").nodes().get(1).toString();
		String address = Jsoup.parse(html.css("div.bmsg").nodes().get(1).toString()).text();
	System.err.println("address"+address+string);
	String info = Jsoup.parse(html.css("div.tmsg").toString()).text();
	System.err.println("info"+info);
	String jobName = html.css("div.cn h1","text").toString();
	System.err.println("jobName"+jobName);
	String jobAddress = html.css("div.cn p.ltype","text").toString();
	System.err.println("jobAddress"+jobAddress);
	String string2 = page.getUrl().toString();//招聘详情的地址
	
	//可以将获取的值给对象  对象----传到pipe去持久化到数据库
	//把结果保存起来      ------------------到实现pipeline-------------------------
	page.putField("jobInfo", "可以是对象");
	
	}
	//爬虫设置
private Site site=Site.me()
    .setCharset("gb2312") //设置编码
    .setTimeOut(10000) //设置超时时间
    .setRetrySleepTime(30000) //设置重试的间隔时间
    .setRetryTimes(3)  //设置重试次数
    //.setDomain(domain)  //设置域名后，addcookie才可生效
   // .addCookie(name, value)
    //.addHeader(key, value) //设置请求头
    
     ;
	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}
	public static void main(String[] args) {
		HttpClientDownloader httpClientDownloader=new HttpClientDownloader();
		httpClientDownloader.setProxyProvider(
				SimpleProxyProvider.from(
						new Proxy("47.107.59.14", 52941)
						));
		
		
		Spider thread = Spider.create(new JobProcessor2())  //创建spider
		     
				
				.addUrl(url)
		       //.addPipeline(new FilePipeline("D:\\text\\result")) //输出数据到文件
		       .thread(5)  //表示5个线程处理
//// 设置布隆过滤器去重操作（默认使用HashSet来进行去重，占用内存较大；使用BloomFilter来进行去重，占用内存较小，但是可能漏抓页面）
		       .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(100000)))
		      
		       
		       .setDownloader(httpClientDownloader)   //设置代理 下载器
		       
		       .addPipeline(new SpringDate())  //配置保存的结果
		       ;  //.start() 异步启动
		Scheduler scheduler = thread.getScheduler();
		thread.run();
	}

}
