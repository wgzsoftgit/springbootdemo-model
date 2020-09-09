package com.demomodel.P7.beanInit.Primary.classDemo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//Service2上面使用了@Primary，表示这是个主要的候选者
@Component
@Primary
public class ServiceAudec2 implements IService1 {
}