package com.demomodel.P7.Conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
 /**
  * @1：使用了自定义的条件类
@2：通过@Bean标注这name这个方法，如果这个配置类成功解析，会将name方法的返回值作为bean注册到spring容器
  * @author wgz
  * @date 创建时间：2020年7月19日 下午4:15:12
  */
//阻止配置类的处理
@Conditional(MyCondition1.class) //@1
@Configuration
public class MainConfig3{
   @Bean
 public String name() { //@1
	   return"路人甲Java";
}
}