package com.demomodel.P7.Conditional.EnvCondition;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//总配置类
@Configuration
@Import({DevBeanConfig.class,ProdBeanConfig.class, TestBeanConfig.class}) //@1  @1：通过@Import将其他2个配置类导入
public class MainConfig2 {

}