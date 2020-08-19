package com.demomodel.P7.Conditional.isbean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//总配置类
@Configuration
@Import({BeanConfig1.class,BeanConfig2.class}) //@1  @1：通过@Import将其他2个配置类导入
public class MainConfig1 {

}
