package com.demomodel.utils.de.feginClient.text.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demomodel.utils.de.feginClient.text.MemberApifeign;

@RestController
@RequestMapping("feginText2")
public class feginText {
	@Autowired
	private MemberApifeign memberApifeign;//把2.2编写的接口注入进来
	       @RequestMapping("/getorder")
	        public String getOrder() {
	      
	        String result =memberApifeign.getMember()  ;//调用2.2 中编写的接口
	    
	        return result;
	    }
}

