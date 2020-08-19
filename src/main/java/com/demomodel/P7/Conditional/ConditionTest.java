package com.demomodel.P7.Conditional;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demomodel.P7.Conditional.ConditionDesc.MainConfig5;
import com.demomodel.P7.Conditional.ConditionDesc.asc.MainConfig6;
import com.demomodel.P7.Conditional.ConfigurationCondition.MainConfig7;
import com.demomodel.P7.Conditional.ConfigurationCondition.panduan.MainConfig71;
import com.demomodel.P7.Conditional.EnvCondition.MainConfig2;
import com.demomodel.P7.Conditional.EnvCondition.ProdBeanConfig;
import com.demomodel.P7.Conditional.isbean.IService;
import com.demomodel.P7.Conditional.isbean.MainConfig1;

public class ConditionTest {

	@Test
	public void test3() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig3.class);
		Map<String, String> serviceMap = context.getBeansOfType(String.class);
		serviceMap.forEach((beanName, bean) -> {
			System.err.println(00000000000000000);
			System.err.println(String.format("%s->%s", beanName, bean));
		});
	}
//可以看到容器中只有一个address被注册了，而name这个bean没有被注册
	@Test
	public void test4() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig4.class);
		Map<String, String> serviceMap = context.getBeansOfType(String.class);
		serviceMap.forEach((beanName, bean) -> {
			System.out.println(String.format("%s->%s", beanName, bean));
		});
	}

	
	//可以看出容器中只有一个IService类型的bean。
    //可以将@Bean标注的2个方法上面的@Conditional去掉，再运行会输出
	@Test
	public void test1(){
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MainConfig1.class);
	Map<String,IService> serviceMap=context.getBeansOfType(IService.class);
	serviceMap.forEach((beanName,bean)->{
	System.out.println(String.format("%s->%s",beanName,bean));
	});
	}
	
//修改一下EnvCondition的代码，切换到生产环境：
//EnvConditional.Env curEnv = EnvConditional.Env.PROD;
@Test
public void test2() {
	AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(MainConfig2.class);
  System.out.println(context.getBean("name"));
}
//https://blog.csdn.net/likun557/article/details/105108901
	
/**
 * 是因为spring解析整个配置类的过程中，有好几个地方都会执行条件判断。

咱们只用关注前3行，可以看出输出的属性和@Conditional中value值的顺序是一样的
 */
@Test
public void test5() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig5.class);
}

//指定顺序
@Test
public void test6() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig6.class);
}

//上面从容器中获取String类型的bean，然后输出。
@Test
public void test7() {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig7.class);
	context.getBeansOfType(String.class).forEach((beanName, bean) -> {
 System.out.println(String.format("%s->%s", beanName, bean));
   });
}
@Test
public void test71() {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig71.class);
	context.getBeansOfType(String.class).forEach((beanName, bean) -> {
 System.out.println(String.format("%s->%s", beanName, bean));
   });
}
}
