package com.demomodel.P7.beanInit.Primary.functiondemo;

import org.springframework.beans.factory.annotation.Autowired;
 //使用了@Autowired，需要注入
public class InjectService {
 
    @Autowired
    private IService service1;//@1
 
    @Override
    public String toString() {
        return "InjectService{" +
                "service1=" + service1 +
                '}';
    }
}