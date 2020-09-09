package com.demomodel.P7.beanInit.AutowireInterface;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**

 * @author wgz
 * @date 创建时间：2020年8月19日 下午2:24:02
 */
public class DemoText {

/**
  mainConfig5->com.demomodel.P7.beanInit.AutowireInterface.MainConfig5@66ea810
service0->com.demomodel.P7.beanInit.AutowireInterface.Service0@5dafbe45
service1->com.demomodel.P7.beanInit.AutowireInterface.Service1@2254127a
service2->Service2{service1=com.demomodel.P7.beanInit.AutowireInterface.Service1@2254127a}
注意最后一行，service2中的service1被注入了bean：service1
 */
@Test
public void test5() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig5.class);
    for (String beanName : context.getBeanDefinitionNames()) {
        System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
    }
}
}
