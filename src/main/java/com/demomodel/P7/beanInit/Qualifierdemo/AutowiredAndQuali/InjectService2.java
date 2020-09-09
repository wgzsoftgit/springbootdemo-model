package com.demomodel.P7.beanInit.Qualifierdemo.AutowiredAndQuali;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
 /**
  * @1：这里限定符的值为service2，容器中IService类型的bean有2个[service1和service2]，
  * 当类上没有标注@Qualifier注解的时候，可以理解为：bean的名称就是限定符的值，所以@1这里会匹配到service2
  * @author wgz
  * @date 创建时间：2020年8月20日 下午4:33:46
  */
@Component
public class InjectService2 {
    @Autowired
    @Qualifier("servicequ2") //@1
    private IService service;
 
    @Override
    public String toString() {
        return "InjectService{" +
                "service=" + service +
                '}';
    }
}