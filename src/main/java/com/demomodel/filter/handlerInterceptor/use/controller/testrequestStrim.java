package com.demomodel.filter.handlerInterceptor.use.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demomodel.utils.httpHelp.file.HttpHelper;



/**
 * request.getInputStream();  的多次消费测试 --------ok
 * 解决方案 com.demomodel.utils.httpHelp.file.HttpServletRequestReplacedFilter
 * @author wgz
 * @date 创建时间：2020年5月29日 下午5:56:48
 */
@RestController
@RequestMapping("/testrequestStrim")
   public class testrequestStrim {
	@RequestMapping(value="filterAuthorsrequest",produces="application/json;charset=UTF-8")
	public String testreuest( HttpServletRequest request) throws IOException {
		System.err.println("&&&"+HttpHelper.getBodyString(request));
		return "ok2";
		
	}
}
