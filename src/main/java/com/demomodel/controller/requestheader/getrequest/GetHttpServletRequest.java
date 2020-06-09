package com.demomodel.controller.requestheader.getrequest;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demomodel.controller.requestheader.request.Gsonutil;
import com.demomodel.utils.cookies.CookiesUtil;
import com.demomodel.utils.de.http.HttpClientUtil;

/**
 * *前端
	 * var data_json =  {
        "sex": '男',
        "hobby":["baskte","tennis"],
        "introduce": {
            "name":"tom",
            "age":23
        }
    };
     data: JSON.stringify(data_json),
     $.ajax({  type : "POST",
                url :  "http://localhost:9090/GetHttpServletRequest/getrequestdemo",
                dataType: "json", //预期服务器返回的数据类型
                 data: JSON.stringify(data_json),
                 contentType: "application/json",
                success : function(jsonData) {},
                error : function(errorMsg) {} });
 * @author wgz
 * @date 创建时间：2020年4月22日 下午9:33:09
 */
@RestController
@RequestMapping("GetHttpServletRequest")
public class GetHttpServletRequest {
	private static Logger log = LoggerFactory.getLogger(GetHttpServletRequest.class);
	@RequestMapping("/getrequestdemo")
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
           //加入判断
		if(request.getAttribute("provinceId")!=null){
		    //执行相应的操作 例如输出
		    String provinceId=request.getAttribute("provinceId").toString();
		    System.out.println(provinceId);
		}
	//https://blog.csdn.net/zeal9s/java/article/details/85986943
		
		
		
		
		
		System.err.println("11111111111s");
	 //   Gsonutil.jsonToObject(request);  //post request获取消息的json 
	   
		System.err.println("--获取POST--"+request.getMethod() );//获取Method

		System.err.println("--获取class org.apache.catalina.connector.RequestFacade--"+request.getClass());

		System.err.println("--获取3HTTP/1.1--"+request.getProtocol());//获取HTTP-Version

		System.err.println("--获取40:0:0:0:0:0:0:1--"+request.getLocalAddr()+"|"+request.getRemoteAddr()+"|"+request.getRemotePort()+"|"+request.getRemoteHost()+"|"+request.getRemoteUser());;//获取Request-URI
		
		CookiesUtil.setCookie(response, "jian", "zhangsan", 30); //设置cookies
		String header = request.getHeader("cookie");
		//获取 
		Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) { 
            	System.err.println("com.demomodel.controller.requestheader.getrequest.GetHttpServletRequest获取的cookies"+cookie);
                if ("jian".equals(cookie.getName())) { //统一登录cookie为jian，如果存在就认证
                    log.info("cookie 存在，开始验证");
//                    HttpUtil httpUtil = new HttpUtil("http://sso.com/sso/authcookies", MediaType.GET);
                   
                    //String result = httpUtil.send(cookie.getName(), cookie.getValue());
                   // boolean authBoo  = Boolean.valueOf(result);
//                    if (authBoo) {
//                        log.info("验证通过");
//                        return new ModelAndView("public/index");
//                    }
//                    break;
                }
            }
        }
//https://blog.csdn.net/zhangjingao/java/article/details/81735041
		
		
		
		
  	  //演示获取请求头数据--------------------请求头
       //.获取所有请求头名称
       Enumeration<String> headerNames = request.getHeaderNames();
       //.遍历
       while(headerNames.hasMoreElements()){
           String name = headerNames.nextElement();
           //通过请求头的名称获取请求头的值
          String value = request.getHeader(name);
           System.out.println(name+"----"+value);
       }
       
     //演示获取请求头数据：user-agent
                String agent = request.getHeader("user-agent");
               //判度agent的浏览器版本
               if(agent.contains("Chrome")){
                  //谷歌
                  System.out.println("谷歌。。。。");
               }else if (agent.contains("Firefox")){
                   System.out.println("火狐。。。");
               }
               
             //演示获取请求头数据：referer
               String referer = request.getHeader("referer");
               System.out.println(referer);

               //防盗链
               if(referer != null){
                   if(referer.contains("/request")){
                       //正常访问
                      // System.out.println("正常访问");
                       //显示中文
                       response.setContentType("text/html;charset=utf-8");
                       response.getWriter().write("正常访问");
                   }else{
                       //盗链
                       //System.out.println("盗链");
                       response.setContentType("text/html;charset=utf-8");
                       response.getWriter().write("存在盗链，不允许访问");
                   }
               }
	   
	 }
	//postman测试数据
//  host----localhost:9090
//  connection----keep-alive
//  cache-control----max-age=0
//  upgrade-insecure-requests----1
//  user-agent----Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36
//  sec-fetch-dest----document
//  accept----text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
//  sec-fetch-site----none
//  sec-fetch-mode----navigate
//  sec-fetch-user----?1
//  accept-encoding----gzip, deflate, br
//  accept-language----zh-CN,zh;q=0.9
//  谷歌。。。。
//  null
	
	
	
//页面测试数据	
//	--获取POST--POST
//	--获取class org.apache.catalina.connector.RequestFacade--class org.apache.catalina.connector.RequestFacade
//	--获取3HTTP/1.1--HTTP/1.1
//	--获取40:0:0:0:0:0:0:1--0:0:0:0:0:0:0:1
//	host----localhost:9090
//	connection----keep-alive
//	content-length----77
//	pragma----no-cache
//	cache-control----no-cache
//	accept----application/json, text/javascript, */*; q=0.01
//	sec-fetch-dest----empty
//	user-agent----Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36
//	content-type----application/json
//	origin----http://localhost:8080
//	sec-fetch-site----same-site
//	sec-fetch-mode----cors
//	referer----http://localhost:8080/sxxl-analysis/implicitTerrorists/index
//	accept-encoding----gzip, deflate, br
//	accept-language----zh-CN,zh;q=0.9
//	谷歌。。。。
//	http://localhost:8080/sxxl-analysis/implicitTerrorists/index
	
	//iE   请求头
//	json:{"sex":"男","hobby":["baskte","tennis"],"introduce":{"name":"tom","age":23}}
//	 --获取POST--POST
//	 --获取class org.apache.catalina.connector.RequestFacade--class org.apache.catalina.connector.RequestFacade
//	 --获取3HTTP/1.1--HTTP/1.1
//	 --获取40:0:0:0:0:0:0:1--0:0:0:0:0:0:0:1
//	 sex:男
//	 hobby:baskte
//	 hobby:tennis
//	 name:tom;age:23
//	 content-type----application/json
//	 accept----application/json, text/javascript, */*; q=0.01
//	 referer----http://localhost:8080/sxxl-analysis/implicitTerrorists/index
//	 accept-language----zh-CN
//	 origin----http://localhost:8080
//	 accept-encoding----gzip, deflate
//	 user-agent----Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko
//	 host----localhost:9090
//	 content-length----77
//	 connection----Keep-Alive
//	 cache-control----no-cache
//	 http://localhost:8080/sxxl-analysis/implicitTerrorists/index

	
	//火狐
//	json:{"sex":"男","hobby":["baskte","tennis"],"introduce":{"name":"tom","age":23}}
//	 --获取POST--POST
//	 --获取class org.apache.catalina.connector.RequestFacade--class org.apache.catalina.connector.RequestFacade
//	 --获取3HTTP/1.1--HTTP/1.1
//	 --获取40:0:0:0:0:0:0:1--192.168.124.6
//	 sex:男
//	 hobby:baskte
//	 hobby:tennis
//	 name:tom;age:23
//	 host----192.168.124.6:9090
//	 user-agent----Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:75.0) Gecko/20100101 Firefox/75.0
//	 accept----application/json, text/javascript, */*; q=0.01
//	 accept-language----zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
//	 accept-encoding----gzip, deflate
//	 content-type----application/json
//	 content-length----77
//	 origin----http://192.168.124.6:8080
//	 connection----keep-alive
//	 referer----http://192.168.124.6:8080/sxxl-analysis/implicitTerrorists/index
//	 火狐。。。
//	 http://192.168.124.6:8080/sxxl-analysis/implicitTerrorists/index

}
