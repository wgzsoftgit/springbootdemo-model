package com.demomodel.P7.beanInit.Autowireddem01;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
 /**
  * main方法中启动容器，加载MainConfig0配置类，然后输出容器中所有的bean
  * @author wgz
  * @date 创建时间：2020年8月19日 上午11:33:36
  */
public class InjectTest {
 
	/**
class com.javacode2018.lesson001.demo26.test0.Service2无参构造器
service1->com.javacode2018.lesson001.demo26.test0.Service1@4a94ee4
service2->Service2{service1=null}
输出中可以看出调用了Service2的无参构造器，service2中的service1为null
	 */
	//默认调用  Service2的无参构造器
	//在Service2有参有参构造器上面加上@Autowired注解，如下：
//service2->Service2{service1=com.javacode2018.lesson001.demo26.test0.Service1@4ec4f3a0}
    @Test
    public void test0() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig0.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
        }
    }
 
}