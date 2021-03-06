package com.demomodel.query.config.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demomodel.query.config.ScheduledUtil;

@RestController
@RequestMapping("/MyDynamicTask")
public class MyDynamicTask  {

    private static Logger log = LoggerFactory.getLogger(MyDynamicTask.class);
	
	  @Autowired 
	  private ScheduledUtil scheduledUtil1;
	
//MyDynamicTask?time='0/10 * * * * ?'&name='测试'&task=1
//http://localhost:9093/MyDynamicTask?time=%270/10%20*%20*%20*%20*%20?%27&name=%27%E6%B5%8B%E8%AF%95%27&task=1
    @GetMapping
    public void getCron(String time,String name,Integer task) {
        if(task==1){
            scheduledUtil1.setCron(time);
            scheduledUtil1.setName(name);
        }
    }
}
//https://blog.csdn.net/xm526489770/java/article/details/82183817