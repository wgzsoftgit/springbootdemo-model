package com.demomodel.P7.beanInit.AutowireInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 @1：标注了@Autowired注解，需要注入类型为IService类型的bean，满足这种类型的有2个：service0和service1

按照上面介绍的候选者查找过程，最后会注入和字段名称一样的bean，即：service1
概括为：先按类型找，然后按名称找
 * @author wgz
 * @date 创建时间：2020年8月19日 下午2:21:57
 */
@Component
public class ServiceAuto2 {
    @Autowired
    private IService serviceAuto1; //@1
 
    @Override
    public String toString() {
        return "Service2{" +
                "service1=" + serviceAuto1 +
                '}';
    }
}