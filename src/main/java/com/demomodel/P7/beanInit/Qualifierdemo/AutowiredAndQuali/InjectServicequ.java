package com.demomodel.P7.beanInit.Qualifierdemo.AutowiredAndQuali;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class InjectServicequ {
 
    private IService s1;
    private IService s2;
 
    @Autowired
    @Qualifier("servicequ2")
    public void setS1(IService s1) {
        this.s1 = s1;
    }
 
    @Autowired
    @Qualifier("servicequ2")
    public void setS2(IService s2) {
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