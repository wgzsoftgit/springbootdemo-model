package com.demomodel.P7.beanInit.Autowireddem01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 /**
  * Service2中依赖于Service1，有2个构造方法
@1：无参构造器
@2：有参构造器，可以通过这个传入依赖的Service1
@3：重写了toString方法，一会打印测试的时候方便查看
  * @author wgz
  * @date 创建时间：2020年8月19日 上午11:29:42
  */
@Component
public class ServiceAude2 {
    private ServiceAude1 service1;
 
    public ServiceAude2() { //@1   默认
        System.out.println(this.getClass() + "无参构造器");
    }
    //@Autowired
    public ServiceAude2(ServiceAude1 service1) { //@2
        System.out.println(this.getClass() + "有参构造器");
        this.service1 = service1;
    }
 
    @Override
    public String toString() { //@2
        return "Service2{" +
                "service1=" + service1 +
                '}';
    }
}