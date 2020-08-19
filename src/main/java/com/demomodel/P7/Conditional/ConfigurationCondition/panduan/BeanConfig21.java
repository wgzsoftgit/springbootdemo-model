package com.demomodel.P7.Conditional.ConfigurationCondition.panduan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Conditional(MyCondition1.class)

//当容器中有Service这种类型的bean的时候，BeanConfig2才生效。
@Conditional(MyConfigurationCondition1.class)
public class BeanConfig21 {
    @Bean
    public String name() {
        return "路人甲Java";
    }
}
/**
此时name这个bean被输出了。

可以再试试将BeanConfig1中service方法上面的@Bean去掉，此时Service就不会被注册到容器，再运行一下test7，会发现没有输出了，此时BeanConfig2会失效。

判断bean存不存在的问题，通常会使用ConfigurationCondition这个接口，阶段为：REGISTER_BEAN，这样可以确保条件判断是在bean注册阶段执行的。

对springboot比较熟悉的，它里面有很多@Conditionxxx这样的注解，可以去看一下这些注解，很多都实现了ConfigurationCondition接口。
————————————————
版权声明：本文为CSDN博主「路人甲Java」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/likun557/article/details/105108901
*/