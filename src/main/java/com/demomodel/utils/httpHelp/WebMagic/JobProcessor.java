package com.demomodel.utils.httpHelp.WebMagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.Scheduler;

public class JobProcessor implements PageProcessor {

	//解析页面   Resultltems 相当于一个map
	@Override
	public void process(Page page) {
		System.err.println(page.toString());
		
		page.putField("div01", page.getHtml().css("div.dw_page .p_wp .p_in ul li a").links().all());
		
		
		//解析返回的数据page, 并且把解析的结果放到ResultItems中  
		//css选择器     css==.$(selector)
		page.putField("div", page.getHtml().css("div.pm-footer-2018  h5").all());
		
		//Xpath  和正则表达式     .代表所有     *代表一个或者多个  9$以9结尾    .*9$
		page.putField("div2", page.getHtml().xpath("//div[@class=pm-footer-2018]/div/ul/li/h5").regex(".*保障.*").all());
	   
		//返回结果  get() 返回一条String类型的结果       toString()返回一条String类型的结果      ALL()返回所有结果
		page.putField("div3", page.getHtml().css("div.pm-footer-2018  h5").get());
		page.putField("div4", page.getHtml().css("div.pm-footer-2018  h5").toString());
		page.putField("div5", page.getHtml().css("div.pm-footer-2018  h5").all());
	
		page.putField("url5", page.getHtml().css("div#navitems-2014>ul >li  a").links().all());
		
		
		//获取链接
		page.addTargetRequests(page.getHtml().css("div#navitems-2014>ul >li  a").links().regex(".*43KQGFpu7JT8QYk4jHQJD9rZn1hE/index.html$").all());
		page.putField("div7", page.getHtml().css("div#extra-nav>ul>li a").get());
		
		page.addTargetRequest("https://pro.jd.com/mall/active/43KQGFpu7JT8QYk4jHQJD9rZn1hE/index.html");

	}
	//爬虫设置
private Site site=Site.me()

.setCycleRetryTimes(3000)
    
    .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:53.0) Gecko/20100101 Firefox/53.0")
    .setCharset("gb2312") //设置编码utf-8   Big5-HKSCS
//    .setTimeOut(10000) //设置超时时间
//    .setRetrySleepTime(30000) //设置重试的间隔时间
//    .setRetryTimes(3)  //设置重试次数
//    //.setDomain(domain)  //设置域名后，addcookie才可生效
//   // .addCookie(name, value)
//    //.addHeader(key, value) //设置请求头
    
     ;

//.setDomain("www.osarticle.net")
//.addCookie("Hm_lpvt_a411c4d1664dd70048ee98afe7b28f0b","1517311293")
//.addCookie("Hm_lvt_a411c4d1664dd70048ee98afe7b28f0b","1517280323,1517294024,1517297596,1517311257")
//.addCookie("_user_behavior_","cdf35554-44e4-4361-a13c-f86711da2cdc")
//.addCookie("aliyungf_tc","AQAAAByVsEM3IAcAxuwvakgCPvGmrNjp")
//.addHeader("Accept","*/*")
//.addHeader("Accept-Encoding","gzip, deflate, br")
//.addHeader("Accept-Language","zh-CN,zh;q=0.8")
//.addHeader("Connection","keep-alive")
//.addHeader("Content-Length","0")
//.addHeader("Host","www.oschina.net")
//.addHeader("Origin","https://www.oschina.net")
//.addHeader("Referer","https://www.oschina.net/blog")
//.addHeader("User-Agent","Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3095.5 Mobile Safari/537.36")
//.addHeader("X-Requested-With","XMLHttpRequest");
	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}
	//https://jobs.51job.com/yantai/123118653.html?s=01&t=0
	//https://search.51job.com/list/000000,000000,0000,01%252C32,9,99,java,2,2.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=
	//https://search.51job.com/list/000000,000000,0000,01%252C32,9,99,java,2,3.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=
	public static void main(String[] args) {
		Spider thread = Spider.create(new JobProcessor())  //创建spider
		       .addUrl("https://search.51job.com/list/000000,000000,0000,01%252C32,9,99,java,2,3.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=")   //https://auction.jd.com/home.html
		       //.addPipeline(new FilePipeline("D:\\text\\result")) //输出数据到文件
		       .thread(5)  //表示5个线程处理
//// 设置布隆过滤器去重操作（默认使用HashSet来进行去重，占用内存较大；使用BloomFilter来进行去重，占用内存较小，但是可能漏抓页面）
		       .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(100000)))
		       ;  //.start() 异步启动
		Scheduler scheduler = thread.getScheduler();
		thread.run();
	}

}
