package com.demomodel.P7.beanInit.Qualifierdemo.functionqualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
 
import java.util.Map;
/**
 * @1：限定符的值为tag1，此时会将类上限定符为tag1的所有bean注入进来

@2：限定符的值为tag2，此时会将类上限定符为tag2的所有bean注入进来 
 * @author wgz
 * @date 创建时间：2020年8月20日 下午4:23:57
 */
@Component
public class InjectService {
    @Autowired
    @Qualifier("tag1") //@1
    private Map<String, IService> serviceMap1;
 
    @Autowired
    @Qualifier("tag2") //@2
    private Map<String, IService> serviceMap2;
 
    @Override
    public String toString() {
        return "InjectService{" +
                "serviceMap1=" + serviceMap1 +
                ", serviceMap2=" + serviceMap2 +
                '}';
    }

	public void setServiceMap1(Map<String, IService> map1) {
		this.serviceMap1 = map1;
	}
    
    
}