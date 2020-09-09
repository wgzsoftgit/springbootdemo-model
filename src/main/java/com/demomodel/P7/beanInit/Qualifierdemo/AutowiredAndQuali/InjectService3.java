package com.demomodel.P7.beanInit.Qualifierdemo.AutowiredAndQuali;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
//@1：方法上标注了@Autowired注解，说明会被注入依赖，2个参数上分别使用了限定符来指定具体需要注入哪个bean
@Component
public class InjectService3 {
 
    private IService s1;
    private IService s2;
 
    @Autowired
    public void injectBean(@Qualifier("servicequ1") IService s1, @Qualifier("servicequ2") IService s2) { //@1
        this.s1 = s1;
        this.s2 = s2;
    }
 
    @Override
    public String toString() {
        return "InjectService{" +
                "s1=" + s1 +
                ", s2=" + s2 +
                '}';
    }
}