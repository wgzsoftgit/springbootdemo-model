package com.demomodel.controller.qualifierText;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("qualifierText")
@RestController
public class qualifierText {
	//注入menuService1：
	@Autowired
    @Qualifier("menuService1")
    private IMenuService menuService;
	
	//注入menuService2：
	@Autowired
    @Qualifier("menuService2")
    private IMenuService menuService2;
	
	
	@RequestMapping("qualifierText01")
	public String ImenuText() {
		return menuService.getAllMenuList();
	}
	
	@RequestMapping("qualifierText02")
	public String ImenuText2() {
		return menuService2.getAllMenuList();
		
	}
}
