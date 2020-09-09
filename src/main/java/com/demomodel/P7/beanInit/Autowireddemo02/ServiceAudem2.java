package com.demomodel.P7.beanInit.Autowireddemo02;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 @1：注入IService类型的所有bean
@2：注入一个map
 * @author wgz
 * @date 创建时间：2020年8月19日 下午7:58:46
 */
@Component
public class ServiceAudem2 {
 
    @Autowired
    private List<IService> services;
 
    @Autowired
    private Map<String, IService> serviceMap;
 
    @Override
    public String toString() {
        return "Service2{\n" +
                "services=" + services +
                ", \n serviceMap=" + serviceMap +
                '}';
    }
}