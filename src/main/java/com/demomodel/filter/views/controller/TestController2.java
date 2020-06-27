package com.demomodel.filter.views.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.activerecord.Model;

@Controller
@RequestMapping("testController2")
public class TestController2 {
    

    @RequestMapping("/thymeleafindex")
    public String thymeleafindex() {
        return "view/index";  //ok  --view/index.html
    }
    @RequestMapping("/jspindex")
    public String jspindex() { 
        return "jsp/text";     //ok   --jsp/text.jsp     
    }
    @RequestMapping("/webhtml")
    public String jspindex2() {
        return "query/index";
    }

  
}
//https://blog.csdn.net/KyrellLupin/java/article/details/90074192