package com.demomodel.controller.readofyml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  测试控制器
 * @author wgz
 * @date 创建时间：2020年4月19日 下午1:47:42
 */

@RestController
public class HelloController {

// 获取.yml 文件中值  只能获取 application.yml
	@Value("${name}")
	private String name;
	@Value("${csdnUrl}")
	private String csdnUrl;	
	@Value("${content}")
	private String content;
	
	
	
	@Autowired  //配置.yml的文件配置
	private author author;

	@RequestMapping("/hello2")
	public String hello2() {
		return name + " CSDN 博客：" + csdnUrl+content;
	}

//路径映射，对应浏览器访问的地址，访问该路径则执行下面函数
	@RequestMapping("/hello")
	public String hello() {
		return "名字：" + author.getName() + " 地址：" + author.getCsdnUrl();
	}
}
//：https://blog.csdn.net/qq_40147863/article/details/84194493