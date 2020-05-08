package com.demomodel.utils.de.gson;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demomodel.controller.requestheader.request.Gsonutil;


@WebServlet("/RequestDemo")
  public class RequestDemo extends HttpServlet {
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  System.err.println("11111111111s");
    	    Gsonutil.jsonToObject(request);
    	    
    		System.err.println("--获取POST--"+request.getMethod());//获取Method

  		System.err.println("--获取class org.apache.catalina.connector.RequestFacade--"+request.getClass());

  		System.err.println("--获取3HTTP/1.1--"+request.getProtocol());//获取HTTP-Version

  		System.err.println("--获取40:0:0:0:0:0:0:1--"+request.getLocalAddr());;//获取Request-URI

      	  //演示获取请求头数据
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
//      host----localhost:9090
//      connection----keep-alive
//      cache-control----max-age=0
//      upgrade-insecure-requests----1
//      user-agent----Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36
//      sec-fetch-dest----document
//      accept----text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
//      sec-fetch-site----none
//      sec-fetch-mode----navigate
//      sec-fetch-user----?1
//      accept-encoding----gzip, deflate, br
//      accept-language----zh-CN,zh;q=0.9
//      谷歌。。。。
//      null
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  this.doPost(request,response);
                 
                 
     }
 }
