package com.demomodel.utils.de.feginClient.text;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
//,
//fallback = CardFeignClientFallback.class,
//configuration = FeignClientConfiguration.class
@FeignClient(name = "sxxl-analysis",
url = "http://localhost:8080/"
)          //指定被调用应用的名字（启动应用时像注册中心注册的名字）
public interface MemberApifeign {

    @RequestMapping("/devicesManager2")  //  把member项目中被调用的接口摘抄过来
     public String getMember(); 
}
//https://blog.csdn.net/weixin_38809962/java/article/details/80354878