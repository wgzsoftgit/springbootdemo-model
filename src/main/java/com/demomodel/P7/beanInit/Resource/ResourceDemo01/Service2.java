package com.demomodel.P7.beanInit.Resource.ResourceDemo01;

import org.springframework.stereotype.Component;
 
import javax.annotation.Resource;
 //@1：字段名称为service1，按照字段名称查找bean，会找到Service1
@Component
public class Service2 {
 
    @Resource
    private IService service1;//@1
 
    @Override
    public String toString() {
        return "Service2{" +
                "service1=" + service1 +
                '}';
    }
}