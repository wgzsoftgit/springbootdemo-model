package com.demomodel.P7.beanInit.Primary.classDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@1：容器中IService类型的bean有2个，但是service2为主要的候选者，所以此处会注入service2
@Component
public class InjectService1 {
 
    @Autowired
    private IService1 service1; //@1
 
    @Override
    public String toString() {
        return "InjectService{" +
                "service1=" + service1 +
                '}';
    }
}